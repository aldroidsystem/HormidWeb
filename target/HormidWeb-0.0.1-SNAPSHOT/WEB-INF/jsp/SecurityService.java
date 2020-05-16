package com.aldroid.hormid.service.generic;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}