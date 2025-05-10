package com.bfhl.controller;

import com.bfhl.model.RequestData;
import com.bfhl.model.ResponseData;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.*;
import java.util.Base64;

@CrossOrigin(origins = "*")  // This line fixes the CORS error
@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    @GetMapping
    public Map<String, Object> getOperationCode() {
        Map<String, Object> response = new HashMap<>();
        response.put("operation_code", 1);
        return response;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseData handlePost(@RequestBody RequestData request) {
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> lowerCaseAlphabets = new ArrayList<>();
        boolean isPrimeFound = false;

        // Process input data
        for (String item : request.getData()) {
            if (item.matches("\\d+")) {  // Check if it's a number
                numbers.add(item);
                int num = Integer.parseInt(item);
                if (isPrime(num)) isPrimeFound = true;
            } else if (item.matches("[a-zA-Z]")) {  // Check if it's an alphabet
                alphabets.add(item);
                if (item.matches("[a-z]")) {  // Check if it's a lowercase alphabet
                    lowerCaseAlphabets.add(item);
                }
            }
        }

        // Get the highest lowercase alphabet
        String highestLowercase = lowerCaseAlphabets.stream()
                .max(String::compareTo)
                .orElse("");

        // File processing
        boolean fileValid = false;
        String mimeType = null;
        int fileSizeKB = 0;
        try {
            if (request.getFile_b64() != null && !request.getFile_b64().isEmpty()) {
                byte[] fileBytes = Base64.getDecoder().decode(request.getFile_b64());
                fileValid = true;
                fileSizeKB = fileBytes.length / 1024;  // File size in KB

                // Try to detect the MIME type of the file
                InputStream is = new ByteArrayInputStream(fileBytes);
                mimeType = URLConnection.guessContentTypeFromStream(is);
            }
        } catch (Exception e) {
            fileValid = false;
        }

        // Prepare and return the response
        return new ResponseData(
                true,
                "juhigoyal_22032004", // Your full name and DOB format
                "juhigoyal220377@acropolis.in", // Your email
                "0827CS221118", // Your roll number
                numbers,
                alphabets,
                highestLowercase.isEmpty() ? new ArrayList<>() : Collections.singletonList(highestLowercase),
                isPrimeFound,
                fileValid,
                mimeType,
                fileSizeKB
        );
    }

    // Helper method to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
