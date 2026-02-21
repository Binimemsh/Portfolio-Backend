// ContactController.java
package com.portfolio.portfolio_backend.controller;

import com.portfolio.portfolio_backend.entity.Contact;
import com.portfolio.portfolio_backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "${cors.allowed.origins}")
public class ContactController {
    
    @Autowired
    private ContactService contactService;
    
    @PostMapping
    public ResponseEntity<Contact> submitContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }
    
    @GetMapping("/messages")
    public ResponseEntity<List<Contact>> getAllMessages() {
        List<Contact> messages = contactService.getAllContacts();
        return ResponseEntity.ok(messages);
    }
}