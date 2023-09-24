package org.launchcode.techjobsmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.launchcode.techjobsmvc.models.JobData.findAll;
import static org.launchcode.techjobsmvc.models.JobData.findByColumnAndValue;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController extends TechJobsController {

    @GetMapping(value = "")
    public String search() {
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        String term = searchTerm.trim().toLowerCase();
        if (term.isBlank() || term.equals("all")) {
            model.addAttribute("jobs", findAll());
        } else {
            model.addAttribute("jobs", findByColumnAndValue(searchType, term));
        }

        model.addAttribute("title", "Jobs With " + searchType + ": " + searchTerm);
        model.addAttribute("type", searchType);
        return "search";
    }
}
