package com.bfhl.model;

import java.util.List;

public class ResponseData {
    private boolean is_success;
    private String user_id;
    private String email;
    private String roll_number;
    private List<String> numbers;
    private List<String> alphabets;
    private List<String> highest_lowercase_alphabet;
    private boolean is_prime_found;
    private boolean file_valid;
    private String file_mime_type;
    private int file_size_kb;

    // Constructor with null-checking for parameters
    public ResponseData(boolean is_success, String user_id, String email, String roll_number,
                        List<String> numbers, List<String> alphabets, List<String> highest_lowercase_alphabet,
                        boolean is_prime_found, boolean file_valid, String file_mime_type, int file_size_kb) {
        this.is_success = is_success;
        this.user_id = (user_id != null) ? user_id : "";
        this.email = (email != null) ? email : "";
        this.roll_number = (roll_number != null) ? roll_number : "";
        this.numbers = (numbers != null) ? numbers : List.of();  // Return empty list if null
        this.alphabets = (alphabets != null) ? alphabets : List.of();  // Return empty list if null
        this.highest_lowercase_alphabet = (highest_lowercase_alphabet != null) ? highest_lowercase_alphabet : List.of();  // Return empty list if null
        this.is_prime_found = is_prime_found;
        this.file_valid = file_valid;
        this.file_mime_type = (file_mime_type != null) ? file_mime_type : "";  // Default empty string
        this.file_size_kb = file_size_kb;
    }

    // ✅ Required Getters

    public boolean isIs_success() {
        return is_success;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public List<String> getHighest_lowercase_alphabet() {
        return highest_lowercase_alphabet;
    }

    public boolean isIs_prime_found() {
        return is_prime_found;
    }

    public boolean isFile_valid() {
        return file_valid;
    }

    public String getFile_mime_type() {
        return file_mime_type;
    }

    public int getFile_size_kb() {
        return file_size_kb;
    }
}
