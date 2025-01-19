//package ru.rumyantsev.IKM.controller;
//
//import org.springframework.web.bind.annotation.*;
//import ru.rumyantsev.IKM.repositories.*;
//import ru.rumyantsev.IKM.entities.*;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import ru.rumyantsev.IKM.entities.*;
//import ru.rumyantsev.IKM.repositories.*;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Optional;
//
//import jakarta.validation.*;
//
//@Controller
//@AllArgsConstructor
//public class MainController {
//    private final AuthorRepository authorRepository;
//    private final BookRepository bookRepository;
//
//    public MainController() {
//    }
//
//    @GetMapping("/")
//    public String index1(Model model) {
//        return "index";
//    }
//}


//package ru.rumyantsev.IKM.controller;
//
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import ru.rumyantsev.IKM.repositories.*;
//import ru.rumyantsev.IKM.entities.Author;
//import ru.rumyantsev.IKM.entities.Book;
//
//import java.util.Comparator;
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ru.rumyantsev.IKM.entities.*;
//import ru.rumyantsev.IKM.repositories.*;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Optional;
//import jakarta.validation.*;
//
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ru.rumyantsev.IKM.entities.*;
//import ru.rumyantsev.IKM.repositories.*;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Optional;
//import jakarta.validation.*;
//import ru.rumyantsev.IKM.repositories.*;


// ВАЖНЫЙ РАБОЧИЙ ВАРИАНТ НИЖЕ

//package ru.rumyantsev.IKM.controller;
//
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import ru.rumyantsev.IKM.repositories.*;
//
//@Controller
//@AllArgsConstructor
//public class MainController {
//
//    private final AuthorRepository authorRepository;
//    private final BookRepository bookRepository;
//    private final GenreRepository genreRepository;
//    private final PublisherRepository publisherRepository;
//    private final ReviewRepository reviewRepository;
//
//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }
//}

// ВАЖНЫЙ РАБОЧИЙ ВАРИАНТ ВЫШЕ

package ru.rumyantsev.IKM.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
