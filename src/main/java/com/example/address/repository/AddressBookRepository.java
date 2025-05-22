package com.example.address.repository;

import com.example.address.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookModel, Long> {
    // Additional custom query methods can be defined here if needed
}