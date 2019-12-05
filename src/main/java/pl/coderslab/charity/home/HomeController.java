package pl.coderslab.charity.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionService;
import pl.coderslab.charity.user.User;
import pl.coderslab.charity.user.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final UserServiceImpl userServiceImpl;

    public HomeController(InstitutionService institutionService, DonationService donationService,
                          UserServiceImpl userServiceImpl) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        List<Institution> institutions = institutionService.findAll();
        int quantityOfDonations = donationService.sumOfBags();
        long numberOfInstitutions = institutionService.sumOfInstitutions();
        model.addAttribute("institutions", institutions);
        model.addAttribute("quantityOfDonations", quantityOfDonations);
        model.addAttribute("numberOfInstitutions", numberOfInstitutions);

        return "index";
    }

    @GetMapping("/login")
    public String loginAction(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "login";
    }

    @RequestMapping("/register")
    public String registerAction(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }


    @PostMapping("register")
    public String registerForm(@Valid @ModelAttribute User user,
                               BindingResult result) {
        if (result.hasErrors()) {

            return "register";
        }
        userServiceImpl.saveUser(user);

        return "redirect:login";
    }
}
