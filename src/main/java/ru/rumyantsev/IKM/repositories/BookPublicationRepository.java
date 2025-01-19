package ru.rumyantsev.IKM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.rumyantsev.IKM.entities.BookPublication;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPublicationRepository extends JpaRepository<BookPublication, Integer>, JpaSpecificationExecutor<BookPublication> {
}