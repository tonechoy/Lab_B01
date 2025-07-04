package com.fsse2506.lab_b01;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    private List<PersonData> personDataList = new ArrayList<>();

    @PostMapping("/person/create")
    public PersonData createPerson(@RequestBody PersonData personData){
        personDataList.add(personData);
        System.out.println("person add!");
        return personData;
    }

    @GetMapping("/person/all")
    public List<PersonData> getAllPeople(){
        System.out.println("printing people list...");
        return personDataList;
    }

//    @PutMapping("/person/update")
//    public ResponseEntity<PersonData> updatePerson(@RequestBody PersonData updatePersonData) {
//        for (PersonData personData : personDataList) {
//            if (personData.getHkid().equals(updatePersonData.getHkid())) {
//                personData.setFirstName(updatePersonData.getFirstName());
//                personData.setLastName(updatePersonData.getLastName());
//
//                return new ResponseEntity<>(personData, HttpStatus.OK);
//            }
//        }
//        System.out.println("id not found!");
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }

    @PutMapping("/person/update")
    public PersonData updatePerson(@RequestBody PersonData updatePersonData) {
        for (PersonData personData : personDataList) {
            if (!personData.getHkid().equals(updatePersonData.getHkid())) {
                continue;
            }
            personData.setFirstName(updatePersonData.getFirstName());
            personData.setLastName(updatePersonData.getLastName());

            System.out.println("person updated!");
            return personData;
        }
        throw new idNotFoundException(updatePersonData.getHkid());
    }

    @DeleteMapping("/person/delete")
    public PersonData deletePerson(@RequestParam String hkid) {
        for (PersonData personData : personDataList) {
            if (!personData.getHkid().equals(hkid)) {
                continue;
            }

            personDataList.remove(personData);
            System.out.println("person removed");
            return personData;
        }
        throw new idNotFoundException(hkid);
    }
}
