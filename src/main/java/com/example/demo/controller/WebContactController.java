package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.service.GoogleContactsService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class WebContactController {

    private final GoogleContactsService googleContactsService;

    public WebContactController(GoogleContactsService googleContactsService) {
        this.googleContactsService = googleContactsService;
    }

    // ✅ Display Contacts Page
    @GetMapping
    public String getContacts(Model model, OAuth2AuthenticationToken token) {
        List<Contact> contacts = googleContactsService.getContacts(token);
        model.addAttribute("contacts", contacts);
        return "contacts"; // This should match contacts.html
    }

    // ✅ Fix: Add Contact
    @PostMapping("/add")
    public String addContact(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             OAuth2AuthenticationToken token) {
        if (name == null || name.trim().isEmpty()) {
            name = "No Name"; // If name is missing, prevent "Unknown" issue
        }
        googleContactsService.addContact(token, name, email);
        return "redirect:/contacts"; // Refresh the page
    }

    // ✅ Fix: Update Contact
    @PostMapping("/update")
    public String updateContact(@RequestParam("oldName") String oldName,
                                @RequestParam("oldEmail") String oldEmail,
                                @RequestParam("newName") String newName,
                                @RequestParam("newEmail") String newEmail,
                                OAuth2AuthenticationToken token) {
        googleContactsService.updateContact(token, oldName, oldEmail, newName, newEmail);
        return "redirect:/contacts";
    }

    // ✅ Fix: Delete Contact
    @PostMapping("/delete")
    public String deleteContact(@RequestParam("name") String name,
                                @RequestParam("email") String email,
                                OAuth2AuthenticationToken token) {
        googleContactsService.deleteContact(token, name, email);
        return "redirect:/contacts";
    }
}
