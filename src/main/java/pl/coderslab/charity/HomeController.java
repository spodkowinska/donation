package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionService;

import java.util.List;


@Controller
public class HomeController {
    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    private final InstitutionService institutionService;
    private final DonationService donationService;


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

    @RequestMapping("/login")
    public String loginAction(Model model) {

        return "login";
    }

    @RequestMapping("/register")
    public String registerAction(Model model) {

        return "register";
    }
}
