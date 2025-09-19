package com.LMS.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length = 50)
    private String first_name;

    @Column(nullable=false,length = 50)
    private String last_name;

    @Column(nullable=false,length = 10)
    private String phone;

    @Column(nullable=false)
    private String email;

    @CreationTimestamp
    private LocalDateTime created_at;

}
