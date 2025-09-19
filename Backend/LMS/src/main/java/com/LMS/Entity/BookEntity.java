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
@Table(name="books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length = 50)
    private String name;

    @Column(nullable=false,length = 50)
    private String author;

    @Column(nullable=false,length = 50)
    private String category;

    @Column(nullable=false,unique = true,length = 20)
    private String isbn;

    @Column(nullable=false)
    private Integer book_copies = 0;

    @CreationTimestamp
    private LocalDateTime created_at;


}
