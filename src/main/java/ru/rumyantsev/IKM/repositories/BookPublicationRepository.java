package ru.rumyantsev.IKM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rumyantsev.IKM.entities.BookPublication;

import java.util.List;

public interface BookPublicationRepository extends JpaRepository<BookPublication, Integer> {
    List<BookPublication> findByBookId(Integer bookId);
}
