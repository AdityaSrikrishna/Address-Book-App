package com.example.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.address.dto.AddressBookDTO;
import com.example.address.model.AddressBookModel;
import com.example.address.service.IAddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping
    public ResponseEntity<String> getAllEntries1() {
        return ResponseEntity.ok("GET - All Entries");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEntryById1(@PathVariable int id) {
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
    public ResponseEntity<String> deleteEntry1(@PathVariable int id) {
        return ResponseEntity.ok("DELETE - Entry ID " + id + " deleted");
    }
    
    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping
    public ResponseEntity<List<AddressBookModel>> getAllEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookModel> getEntryById(@PathVariable int id) {
        return ResponseEntity.ok(addressBookService.getEntryById(id));
    }

    @PostMapping
    public ResponseEntity<AddressBookModel> addEntry(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.addEntry(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> updateEntry(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.updateEntry(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable int id) {
        addressBookService.deleteEntry(id);
        return ResponseEntity.ok("Deleted entry with ID: " + id);
    }

}
