package ru.rumyantsev.IKM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.rumyantsev.IKM.entities.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rumyantsev.IKM.entities.*;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> , JpaSpecificationExecutor<Author> {
}