package ru.rumyantsev.IKM.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rumyantsev.IKM.entities.BookPublication;
import ru.rumyantsev.IKM.repositories.BookPublicationRepository;
import ru.rumyantsev.IKM.repositories.BookRepository;

@Controller
@RequestMapping("/bookPublications")
@AllArgsConstructor
public class BookPublicationController {

    private final BookPublicationRepository bookPublicationRepository;
    private final BookRepository bookRepository;

    @GetMapping("/add")
    public String showAddBookPublicationForm(Model model) {
        model.addAttribute("bookPublication", new BookPublication());
        model.addAttribute("books", bookRepository.findAll());
        return "addBookPublication";
    }

    @PostMapping("/add")
    public String addBookPublication(@ModelAttribute BookPublication bookPublication, RedirectAttributes redirectAttributes) {
        bookPublicationRepository.save(bookPublication);
        redirectAttributes.addFlashAttribute("message", "Издание книги успешно добавлено!");
        return "redirect:/books/publications/" + bookPublication.getBook().getId();
    }

    @GetMapping("/edit/{id}")
    public String showEditBookPublicationForm(@PathVariable("id") Integer id, Model model) {
        BookPublication bookPublication = bookPublicationRepository.findById(id).orElse(null);
        model.addAttribute("bookPublication", bookPublication);
        model.addAttribute("books", bookRepository.findAll());
        return "editBookPublication";
    }

    @PostMapping("/edit/{id}")
    public String editBookPublication(@PathVariable("id") Integer id, @ModelAttribute BookPublication bookPublication) {
        bookPublicationRepository.save(bookPublication);
        return "redirect:/books/publications/" + bookPublication.getBook().getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteBookPublication(@PathVariable("id") Integer id) {
        BookPublication bookPublication = bookPublicationRepository.findById(id).orElse(null);
        bookPublicationRepository.deleteById(id);
        return "redirect:/books/publications/" + bookPublication.getBook().getId();
    }
}
