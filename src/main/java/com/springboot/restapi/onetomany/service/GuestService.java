package com.springboot.restapi.onetomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.restapi.onetomany.model.Guest;
import com.springboot.restapi.onetomany.repository.GuestRepository;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public Page<Guest> getAllGuests(int page, int size) {
        return guestRepository.findAll(PageRequest.of(page, size));
    }

    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest getGuestById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    public Guest updateGuest(Long id, Guest guest) {
        if (guestRepository.existsById(id)) {
            guest.setId(id);
            return guestRepository.save(guest);
        }
        return null;
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
    
    public List<Guest> getAllGuestsSorted(String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        return guestRepository.findAll(sort);
    }
}

