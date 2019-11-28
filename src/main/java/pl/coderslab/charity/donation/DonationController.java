package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionService;

import java.util.List;

@Controller
public class DonationController {
    private CategoryService categoryService;
    private DonationService donationService;
    private InstitutionService institutionService;

    @Autowired
    public DonationController(CategoryService categoryService, DonationService donationService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @GetMapping("/form")
    public String form(Model model){
        List<Category> categories = categoryService.listOfCategories();
        List<Institution> institutions = institutionService.findAll();
        Donation donation = new Donation();
        model.addAttribute("categories", categories);
        model.addAttribute("donation", donation);
        model.addAttribute("institutions", institutions);
        return "form";
    }
//
//    @GetMapping
//    public String form2(Model model){
//        List<Category> categories = categoryService.listOfCategories();
//        Donation donation = new Donation();
//        model.addAttribute("categories", categories);
//        model.addAttribute("donation", donation);
//        return "form2";
//    }
//
//    @PostMapping
//    public String form2(@RequestParam Donation donation){
//        donationService.save(donation);
//        return "form3";
//    }
}
