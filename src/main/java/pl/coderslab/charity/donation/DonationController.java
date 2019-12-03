package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {

    private final CategoryService categoryService;
    private final DonationService donationService;
    private final InstitutionService institutionService;

    @Autowired
    public DonationController(CategoryService categoryService,
                              DonationService donationService,
                              InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @GetMapping("/form")
    public String form(Model model) {
        addAttributes(model);
        Donation donation = new Donation();
        model.addAttribute("donation", donation);

        return "form";
    }

    @PostMapping("/form")
    public String formPost(@Valid @ModelAttribute Donation donation,
                           BindingResult result, Model model) {

        if (result.hasErrors()) {
            addAttributes(model);

            return "form";
        }
        donationService.save(donation);

        return "form-confirmation";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        List<Category> categories = categoryService.findAll();
        List<Institution> institutions = institutionService.findAll();
        model.addAttribute("categoriesList", categories);
        model.addAttribute("institutionsList", institutions);
    }

}

