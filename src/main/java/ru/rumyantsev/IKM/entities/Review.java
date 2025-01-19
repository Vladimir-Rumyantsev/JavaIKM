package ru.rumyantsev.IKM.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;

    @Size(max = 1000)
    @Column(name = "review_text", nullable = false)
    private String reviewText;

    @Column(name = "rating", nullable = false)
    private Integer rating;
}
