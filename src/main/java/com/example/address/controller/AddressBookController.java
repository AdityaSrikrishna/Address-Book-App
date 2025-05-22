package com.example.address.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping
    public ResponseEntity<String> getAllEntries() {
        return ResponseEntity.ok("GET - All Entries");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEntryById(@PathVariable int id) {
        return ResponseEntity.ok("GET - Entry for ID: " + id);
    }

    @PostMapping
    public ResponseEntity<String> addEntry(@RequestBody String data) {
        return ResponseEntity.ok("POST - Added Entry: " + data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable int id, @RequestBody String data) {
        return ResponseEntity.ok("PUT - Updated Entry ID " + id + " with " + data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable int id) {
        return ResponseEntity.ok("DELETE - Entry ID " + id + " deleted");
    }
}
