package com.example.springmvc.controller;

import com.example.springmvc.model.ContributionCancelForm;
import com.example.springmvc.model.Person;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Piotr on 28.10.2018.
 */

@Controller
@RequestMapping(value="/employer/")
public class ContributionChange {

    @RequestMapping(value = "contributionChange", method = RequestMethod.GET)
    public ModelAndView contributionChange() {
        System.out.println("weszlo");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("form", new ContributionCancelForm());
        modelAndView.setViewName("contributionChange");
        return modelAndView;
    }

    @RequestMapping(value = "contributionChange", method = RequestMethod.POST)
    public ModelAndView processContributionChange(@ModelAttribute("form") ContributionCancelForm form) {
        System.out.println("weszlo2");

        System.out.println(form.getFirstname());

        ModelAndView modelAndView = new ModelAndView();
        return new ModelAndView("contributionChange.confirm");


    }

    @RequestMapping(value = "searchByPesel2", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView searchByPesel2(@RequestParam String pesel, @RequestParam String number, Model model) {
        System.out.println("weszlo2");

        System.out.println(pesel);
        System.out.println(number);
        Person form = null;
        if(pesel.equals("1")) {
            form = new Person();
            form.setFirstname("Piotr");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject( "person", form);
        modelAndView.setViewName("orderTemplate ::" + (null != form ? "personData": "notFoundPerson"));

        return modelAndView;


    }
}
