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

//    @JsonProperty("last_name")
//    private String lastName;
//
//    @JsonProperty("last_name")
//    public String getLastName() {
//        return lastName;
//    }
//
//    @JsonProperty("last_name")
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @JsonProperty("first_name")
//    private String firstName;
//
//
//    @JsonProperty("first_name")
//    public String getFirstName() {
//        return firstName;
//    }
//
//    @JsonProperty("first_name")
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    @JsonProperty("hkid_number")
//    private String hkid;
//
//    @JsonProperty("hkid_number")
//    public String getHkid() {
//        return hkid;
//    }
//
//    @JsonProperty("hkid_number")
//    public void setHkid(String hkid) {
//        this.hkid = hkid;
//    }
}
