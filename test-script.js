import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  scenarios: {
    basic_load: {
      // Basic Load Test (constant load with 100 users)
      executor: 'constant-vus',
      vus: 100,
      duration: '1m',
    },
    stress_test: {
      // Stress Test (gradually ramping up to 500 users over 5 minutes)
      executor: 'ramping-vus',
      startVUs: 50,
      stages: [
        { duration: '1m', target: 100 }, // ramp up to 200 VUs in 2 minutes
        { duration: '1m', target: 250 }, // ramp up to 500 VUs in 2 minutes
      ],
    },
    spike_test: {
      // Spike Test (spike to 1000 users suddenly for 30 seconds)
      executor: 'constant-vus',
      vus: 500,
      duration: '15s',
    },
    endurance_test: {
      // Endurance Test (sustained load for 10 minutes)
      executor: 'constant-vus',
      vus: 200,
      duration: '5m',
    },
  },
};

export default function () {
  // Define the base URL from an environment variable, with a default fallback
  let baseUrl = __ENV.BASE_URL || 'http://192.168.141.6:30080';

  // 1. GET Request - Stock Group
  let res1 = http.get(`${baseUrl}/inventory-service/stockgroup/1`);
  check(res1, {
    'Stock Group - status is 200': (r) => r.status === 200,
  });

  // 2. POST Request - Login
  let loginPayload = JSON.stringify({
    username: 'johndoe',
    password: '1234',
  });
  let loginHeaders = { 'Content-Type': 'application/json' };
  let res2 = http.post(
    `${baseUrl}/account-service/auth/login`,
    loginPayload,
    { headers: loginHeaders }
  );
  check(res2, {
    'Login - status is 200': (r) => r.status === 200,
  });

  // 3. GET Request - Stock
  let res3 = http.get(`${baseUrl}/inventory-service/stock/1`);
  check(res3, {
    'Stock - status is 200': (r) => r.status === 200,
  });
  let createPayload = JSON.stringify({
    name: 'Example Item',
    description: 'This is an example item for stock management',
    unit: 'Piece',
    manufacturer: 'Example Manufacturer',
    sellingPrice: 50.75,
    costPrice: 30.50,
    quantity: 100,
    reorderPoint: 20,
    type: 'Electronics',
    stockGroupId: 1,
  });
  let createHeaders = { 'Content-Type': 'application/json' };
  let res4 = http.post(
    `${baseUrl}/inventory-service/stock/create`,
    createPayload,
    { headers: createHeaders }
  );
  check(res4, {
    'Create Stock - status is 201': (r) => r.status === 201, // Expecting 201 Created
  });

  // Pause between iterations to simulate real user behavior
  sleep(1);
}
