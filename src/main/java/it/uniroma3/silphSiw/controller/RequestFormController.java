package it.uniroma3.silphSiw.controller;

import it.uniroma3.silphSiw.model.RequestForm;
import it.uniroma3.silphSiw.service.RequestFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RequestFormController {

    @Autowired
    private RequestFormService requestFormService;

    @RequestMapping("/addRequest")
    public String addRequest(Model model) {
        model.addAttribute("richiesta" , new RequestForm());
        return "addRequest.html";
    }

    @RequestMapping(value = "/allRequests")
    public String showAllRequests(Model model) {
        model.addAttribute("requests", this.requestFormService.findAllRequests());
        return "requests.html";
    }

    @RequestMapping(value="/addNewRequest", method = RequestMethod.POST)
    public String newRichiesta(@Valid @ModelAttribute("richiesta") RequestForm requestForm, Model model, BindingResult bindingResult) {

        this.requestFormService.insertForm(requestForm);

        return "index.html";

    }

    @GetMapping(value="/request/{id}")
    public String showRequest(@PathVariable("id") Long id , Model model) {

        model.addAttribute("mail", requestFormService.findById(id).getMail());
        model.addAttribute("reqDetails", requestFormService.findById(id).getReqDetails());

        return "request.html";
    }
}
