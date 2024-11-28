FROM nginx:latest

# Copy your custom Nginx configuration file into the container
COPY nginx.conf /etc/nginx/nginx.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
