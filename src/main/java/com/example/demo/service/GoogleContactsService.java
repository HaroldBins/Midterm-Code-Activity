package com.example.demo.service;

import com.example.demo.model.Contact;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleContactsService {

    private List<Contact> contactList = new ArrayList<>();

    public List<Contact> getContacts(OAuth2AuthenticationToken token) {
        return contactList; // Fetch contacts from local list
    }

    public void addContact(OAuth2AuthenticationToken token, String name, String email) {
        contactList.add(new Contact(name, email));
    }

    public void updateContact(OAuth2AuthenticationToken token, String oldName, String oldEmail, String newName, String newEmail) {
        for (Contact contact : contactList) {
            if (contact.getName().equals(oldName) && contact.getEmail().equals(oldEmail)) {
                contact.setName(newName);
                contact.setEmail(newEmail);
                return;
            }
        }
    }

    public void deleteContact(OAuth2AuthenticationToken token, String name, String email) {
        contactList.removeIf(contact -> contact.getName().equals(name) && contact.getEmail().equals(email));
    }
}
