package com.example.address.service;

import com.example.address.dto.AddressBookDTO;
import com.example.address.model.AddressBookModel;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookModel> getAllEntries();
    AddressBookModel getEntryById(int id);
    AddressBookModel addEntry(AddressBookDTO dto);
    AddressBookModel updateEntry(int id, AddressBookDTO dto);
    void deleteEntry(int id);
}