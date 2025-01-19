package ru.rumyantsev.IKM.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rumyantsev.IKM.entities.Book;
import ru.rumyantsev.IKM.repositories.AuthorRepository;
import ru.rumyantsev.IKM.repositories.BookRepository;
import ru.rumyantsev.IKM.repositories.GenreRepository;
import ru.rumyantsev.IKM.repositories.BookPublicationRepository;
import ru.rumyantsev.IKM.repositories.ReviewRepository;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookPublicationRepository bookPublicationRepository;
    private final ReviewRepository reviewRepository;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        bookRepository.save(book);
        redirectAttributes.addFlashAttribute("message", "Книга успешно добавлена!");
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable("id") Integer id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "editBook";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Integer id, @ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/publications/{id}")
    public String listBookPublications(@PathVariable("id") Integer id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("publications", bookPublicationRepository.findByBookId(id));
        return "bookPublications";
    }

    @GetMapping("/reviews/{id}")
    public String listBookReviews(@PathVariable("id") Integer id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("reviews", reviewRepository.findByBookId(id));
        return "bookReviews";
    }
}
