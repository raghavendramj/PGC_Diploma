package com.upgrad.sevice.impl;

import com.upgrad.entity.Citizen;
import com.upgrad.repository.CitizenRepository;
import com.upgrad.sevice.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenServiceImpl implements CitizenService {


    @Autowired
    CitizenRepository citizenRepository;

    @Override
    public Citizen saveCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    @Override
    public List<Citizen> getCitizens() {
        return citizenRepository.findAll();
    }

    @Override
    public Citizen getCitizenById(Long id) {
        Optional<Citizen> optionalCitizen = citizenRepository.findById(id);

        //if(optionalCitizen.isPresent())
        //return optionalCitizen.get();
        //return null;

        return optionalCitizen.orElse(null);
    }

    @Override
    public Citizen getCitizenByFirstNameAndLastName(String firstName, String lastName) {
        return citizenRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Citizen getCitizenByEmail(String email) {
        return citizenRepository.findByEmail(email);
    }

    @Override
    public Citizen updateCitizen(Long id, Citizen citizenFromUI) {

        Optional<Citizen> optionalCitizen = citizenRepository.findById(id);
        if (optionalCitizen.isPresent()) {
            citizenRepository.save(citizenFromUI);
        }
        return null;
    }

    @Override
    public Citizen deleteCitizen(Long id) {
        Optional<Citizen> optionalCitizen = citizenRepository.findById(id);
        if (optionalCitizen.isPresent()) {
            Citizen citizen = optionalCitizen.get();
            citizenRepository.delete(citizen);
            return citizen;
        }
        return null;
    }
}
