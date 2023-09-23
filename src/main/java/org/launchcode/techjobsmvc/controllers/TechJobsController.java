package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;

public class TechJobsController {
    private static HashMap<String, String> actionChoices = new HashMap<>() {{
        put("search", "Search");
        put("list", "List");
    }};

    private static HashMap<String, String> columnChoices = new HashMap<>() {{
        put("all", "All");
        put("employer", "Employer");
        put("location", "Location");
        put("positionType", "Position Type");
        put("coreCompetency", "Skill");
    }};

    private static HashMap<String, Object> tableChoices = new HashMap<>() {{
        put("employer", JobData.getAllEmployers());
        put("location", JobData.getAllLocations());
        put("positionType", JobData.getAllPositionTypes());
        put("coreCompetency", JobData.getAllCoreCompetency());
    }};

    public TechJobsController () {
//        actionChoices.put("search", "Search");
//        actionChoices.put("list", "List");
//        columnChoices.put("all", "All");
//        columnChoices.put("employer", "Employer");
//        columnChoices.put("location", "Location");
//        columnChoices.put("positionType", "Position Type");
//        columnChoices.put("coreCompetency", "Skill");
//        tableChoices.put("employer", JobData.getAllEmployers());
//        tableChoices.put("location", JobData.getAllLocations());
//        tableChoices.put("positionType", JobData.getAllPositionTypes());
//        tableChoices.put("coreCompetency", JobData.getAllCoreCompetency());
    }

    @ModelAttribute("actions")
    public static HashMap<String, String> getActionChoices() {
        return actionChoices;
    }

    @ModelAttribute("columns")
    public static HashMap<String, String> getColumnChoices() {
        return columnChoices;
    }

    @ModelAttribute("tableChoices")
    public static HashMap<String, Object> getTableChoices() {
        return tableChoices;
    }
}
