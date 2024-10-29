package micro.account.accountservice.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="role_entity")
@Getter
@Setter
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}

