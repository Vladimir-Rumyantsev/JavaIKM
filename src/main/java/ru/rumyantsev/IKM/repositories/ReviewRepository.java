package ru.rumyantsev.IKM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rumyantsev.IKM.entities.Review;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByBookId(Integer bookId);
}
