package com.upgrad.controller;

import com.upgrad.entity.Citizen;
import com.upgrad.sevice.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    @PostMapping
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen) {
        ResponseEntity responseEntity = new ResponseEntity(citizenService.saveCitizen(citizen), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping
    public List<Citizen> getCitizens() {
        return citizenService.getCitizens();
    }

    @GetMapping("/{citizenId}")
    public Citizen getCitizen(@PathVariable("citizenId") Long citizenId) {
        return citizenService.getCitizenById(citizenId);
    }

    @GetMapping("/search")
    public Citizen getCitizenByFirstnameAndLastname(@RequestParam String firstName, @RequestParam String lastName) {
        return citizenService.getCitizenByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/email/{emailId}")
    public Citizen getCitizenByEmailAddress(@PathVariable("emailId") String emailId) {
        return citizenService.getCitizenByEmail(emailId);
    }

    @PutMapping("/{citizenId}")
    public Citizen updateCitizen(@PathVariable("citizenId") Long citizenId, @RequestBody Citizen citizen) {
        return citizenService.updateCitizen(citizenId, citizen);
    }


    @DeleteMapping("/{citizenId}")
    public Citizen deleteCitizen(@PathVariable("citizenId") Long citizenId) {
        return citizenService.deleteCitizen(citizenId);
    }
}
