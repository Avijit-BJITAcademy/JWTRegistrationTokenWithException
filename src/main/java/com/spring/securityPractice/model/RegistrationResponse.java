package com.spring.securityPractice.model;


public class RegistrationResponse {
    private UserDto userDto;
    private String token;

    public RegistrationResponse(UserDto userDto, String token) {
        this.userDto = userDto;
        this.token = token;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
