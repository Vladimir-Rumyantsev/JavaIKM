package ru.rumyantsev.IKM.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rumyantsev.IKM.entities.Genre;
import ru.rumyantsev.IKM.repositories.GenreRepository;

@Controller
@RequestMapping("/genres")
@AllArgsConstructor
public class GenreController {

    private final GenreRepository genreRepository;

    @GetMapping
    public String listGenres(Model model) {
        model.addAttribute("genres", genreRepository.findAll());
        return "genres";
    }

    @GetMapping("/add")
    public String showAddGenreForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "addGenre";
    }

    @PostMapping("/add")
    public String addGenre(@ModelAttribute Genre genre, RedirectAttributes redirectAttributes) {
        genreRepository.save(genre);
        redirectAttributes.addFlashAttribute("message", "Жанр успешно добавлен!");
        return "redirect:/genres";
    }

    @GetMapping("/edit/{id}")
    public String showEditGenreForm(@PathVariable("id") Integer id, Model model) {
        Genre genre = genreRepository.findById(id).orElse(null);
        model.addAttribute("genre", genre);
        return "editGenre";
    }

    @PostMapping("/edit/{id}")
    public String editGenre(@PathVariable("id") Integer id, @ModelAttribute Genre genre) {
        genreRepository.save(genre);
        return "redirect:/genres";
    }

    @GetMapping("/delete/{id}")
    public String deleteGenre(@PathVariable("id") Integer id) {
        genreRepository.deleteById(id);
        return "redirect:/genres";
    }
}
