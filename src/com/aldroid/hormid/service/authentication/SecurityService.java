package com.aldroid.hormid.service.authentication;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}