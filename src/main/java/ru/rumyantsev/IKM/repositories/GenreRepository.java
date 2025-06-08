package ru.rumyantsev.IKM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.rumyantsev.IKM.entities.Genre;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>, JpaSpecificationExecutor<Genre> {
}
