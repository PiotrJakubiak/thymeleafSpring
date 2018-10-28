package com.example.springmvc.controller;

import com.example.springmvc.model.ContributionCancelForm;
import com.example.springmvc.model.Person;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Piotr on 26.10.2018.
 */

@Controller
@RequestMapping(value="/employer/")
public class ContributionCancel {

    @RequestMapping(value = "contributionCancel", method = RequestMethod.GET)
    public ModelAndView contributionCancel() {
        System.out.println("weszlo");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("form", new ContributionCancelForm());

        modelAndView.setViewName("contributionCancel");
        return modelAndView;
    }

    @RequestMapping(value = "contributionCancel", method = RequestMethod.POST)
    public ModelAndView processContributionCancel(@ModelAttribute("form") ContributionCancelForm form) {
        System.out.println("weszlo2");

        System.out.println(form.getFirstname());

        ModelAndView modelAndView = new ModelAndView();
        return new ModelAndView("contributionCancel.confirm");


    }

    @RequestMapping(value = "searchByPesel", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView searchByPesel(@RequestParam String pesel, @RequestParam String number, Model model) {
        System.out.println("weszlo2");

        System.out.println(pesel);
        System.out.println(number);
        Person form = new Person();
        form.setFirstname("Piotr");
        form.setSurname("Testowy");


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject( "person", form);
        modelAndView.setViewName("orderTemplate ::" + (null != form ? "personData": "notFoundPerson"));

        return modelAndView;


    }
}
