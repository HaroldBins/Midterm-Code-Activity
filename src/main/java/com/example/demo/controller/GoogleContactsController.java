/*package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.service.GoogleContactsService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class GoogleContactsController {

    private final GoogleContactsService googleContactsService;

    public GoogleContactsController(GoogleContactsService googleContactsService) {
        this.googleContactsService = googleContactsService;
    }

    // Get all contacts
    @GetMapping
    public List<Contact> getContacts(OAuth2AuthenticationToken authentication) {
        return googleContactsService.getContacts(authentication);
    }

    // Create a new contact
    @PostMapping("/add")
    public String addContact(OAuth2AuthenticationToken authentication, @RequestBody Contact contact) {
        return googleContactsService.createContact(authentication, contact);
    }

    // Delete a contact
    @DeleteMapping("/delete/{id}")
    public String deleteContact(OAuth2AuthenticationToken authentication, @PathVariable String id) {
        googleContactsService.deleteContact(authentication, id);
        return "Contact deleted successfully!";
    }
}*/
