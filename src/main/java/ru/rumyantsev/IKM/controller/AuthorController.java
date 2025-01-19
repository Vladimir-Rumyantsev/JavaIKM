package ru.rumyantsev.IKM.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rumyantsev.IKM.entities.Author;
import ru.rumyantsev.IKM.repositories.AuthorRepository;

@Controller
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }

    @GetMapping("/add")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author, RedirectAttributes redirectAttributes) {
        authorRepository.save(author);
        redirectAttributes.addFlashAttribute("message", "Автор успешно добавлен!");
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showEditAuthorForm(@PathVariable("id") Integer id, Model model) {
        Author author = authorRepository.findById(id).orElse(null);
        model.addAttribute("author", author);
        return "editAuthor";
    }

    @PostMapping("/edit/{id}")
    public String editAuthor(@PathVariable("id") Integer id, @ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Integer id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }
}
