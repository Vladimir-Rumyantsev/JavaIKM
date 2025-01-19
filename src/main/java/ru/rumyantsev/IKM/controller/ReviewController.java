package ru.rumyantsev.IKM.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rumyantsev.IKM.entities.Review;
import ru.rumyantsev.IKM.repositories.BookRepository;
import ru.rumyantsev.IKM.repositories.ReviewRepository;

@Controller
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    @GetMapping("/add")
    public String showAddReviewForm(Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("books", bookRepository.findAll());
        return "addReview";
    }

    @PostMapping("/add")
    public String addReview(@ModelAttribute Review review, RedirectAttributes redirectAttributes) {
        reviewRepository.save(review);
        redirectAttributes.addFlashAttribute("message", "Отзыв успешно добавлен!");
        return "redirect:/books/reviews/" + review.getBook().getId();
    }

    @GetMapping("/edit/{id}")
    public String showEditReviewForm(@PathVariable("id") Integer id, Model model) {
        Review review = reviewRepository.findById(id).orElse(null);
        model.addAttribute("review", review);
        model.addAttribute("books", bookRepository.findAll());
        return "editReview";
    }

    @PostMapping("/edit/{id}")
    public String editReview(@PathVariable("id") Integer id, @ModelAttribute Review review) {
        reviewRepository.save(review);
        return "redirect:/books/reviews/" + review.getBook().getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable("id") Integer id) {
        Review review = reviewRepository.findById(id).orElse(null);
        reviewRepository.deleteById(id);
        return "redirect:/books/reviews/" + review.getBook().getId();
    }
}
