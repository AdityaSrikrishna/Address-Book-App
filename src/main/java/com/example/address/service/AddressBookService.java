package com.example.address.service;

import com.example.address.dto.AddressBookDTO;
import com.example.address.model.AddressBookModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AddressBookService implements IAddressBookService {

    private final List<AddressBookModel> addressBookList = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger();

    @Override
    public List<AddressBookModel> getAllEntries() {
        return addressBookList;
    }

    @Override
    public AddressBookModel getEntryById(int id) {
        return addressBookList.stream()
                .filter(entry -> entry.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public AddressBookModel addEntry(AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel();
        model.setId(idCounter.incrementAndGet());
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setPhone(dto.getPhone());
        addressBookList.add(model);
        return model;
    }

    @Override
    public AddressBookModel updateEntry(int id, AddressBookDTO dto) {
        AddressBookModel existing = getEntryById(id);
        if (existing != null) {
            existing.setName(dto.getName());
            existing.setEmail(dto.getEmail());
            existing.setPhone(dto.getPhone());
        }
        return existing;
    }

    @Override
    public void deleteEntry(int id) {
        addressBookList.removeIf(entry -> entry.getId() == id);
    }
}
