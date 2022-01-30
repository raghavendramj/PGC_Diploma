package com.upgrad.sevice;

import com.upgrad.entity.Citizen;

import java.util.List;

public interface CitizenService {

    //CREATE
    Citizen saveCitizen(Citizen citizen);

    //READ
    List<Citizen> getCitizens();
    Citizen getCitizenById(Long id);
    Citizen getCitizenByFirstNameAndLastName(String firstName, String lastName);
    Citizen getCitizenByEmail(String email);

    //UPDATE
    Citizen updateCitizen(Long id, Citizen citizen);

    //DELETE
    Citizen deleteCitizen(Long id);
}
