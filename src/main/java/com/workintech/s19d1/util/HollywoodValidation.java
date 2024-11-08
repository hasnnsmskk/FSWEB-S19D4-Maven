package com.workintech.s19d1.util;

import com.workintech.s19d1.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import java.time.LocalDate;

public class HollywoodValidation {


    public static void validateActor(String firstName, String lastName, LocalDate birthDate) {
        // Adın boş olup olmadığı kontrolü
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new ApiException("First name cannot be null or empty", HttpStatus.BAD_REQUEST);
        }

        // Soyadın boş olup olmadığı kontrolü
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new ApiException("Last name cannot be null or empty", HttpStatus.BAD_REQUEST);
        }

        // Doğum tarihinin geçmiş bir tarih olup olmadığı kontrolü
        if (birthDate == null || !birthDate.isBefore(LocalDate.now())) {
            throw new ApiException("Birth date must be in the past", HttpStatus.BAD_REQUEST);
        }
    }
}