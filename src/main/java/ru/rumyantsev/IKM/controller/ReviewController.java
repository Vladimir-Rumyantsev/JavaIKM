package ru.rumyantsev.IKM.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rumyantsev.IKM.entities.Review;
import ru.rumyantsev.IKM.repositories.ReviewRepository;

@Controller
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewController {

    private final ReviewRepository reviewRepository;

    @GetMapping
    public String listReviews(Model model) {
        model.addAttribute("reviews", reviewRepository.findAll());
        return "reviews";
    }

    @GetMapping("/add")
    public String showAddReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "addReview";
    }

    @PostMapping("/add")
    public String addReview(@ModelAttribute Review review, RedirectAttributes redirectAttributes) {
        reviewRepository.save(review);
        redirectAttributes.addFlashAttribute("message", "Отзыв успешно добавлен!");
        return "redirect:/reviews";
    }

    @GetMapping("/edit/{id}")
    public String showEditReviewForm(@PathVariable("id") Integer id, Model model) {
        Review review = reviewRepository.findById(id).orElse(null);
        model.addAttribute("review", review);
        return "editReview";
    }

    @PostMapping("/edit/{id}")
    public String editReview(@PathVariable("id") Integer id, @ModelAttribute Review review) {
        reviewRepository.save(review);
        return "redirect:/reviews";
    }

    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable("id") Integer id) {
        reviewRepository.deleteById(id);
        return "redirect:/reviews";
    }
}
