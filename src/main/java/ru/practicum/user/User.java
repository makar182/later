package ru.practicum.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String registrationDate;

    public User() {

    }
}
