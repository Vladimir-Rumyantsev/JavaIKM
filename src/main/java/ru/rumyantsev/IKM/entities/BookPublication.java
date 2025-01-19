package ru.rumyantsev.IKM.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "publishers")
public class BookPublication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publisher", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Size(max = 255)
    @Column(name = "publisher")
    private String publisher;

    @Size(max = 255)
    @Column(name = "publication_place")
    private String publicationPlace;

    @Size(max = 255)
    @Column(name = "format")
    private String format;

    @Column(name = "circulation")
    private Integer circulation;
}
