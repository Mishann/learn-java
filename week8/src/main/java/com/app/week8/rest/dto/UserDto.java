package com.app.week8.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class UserDto {

    @JsonProperty("id")
    private Long userId;
    @JsonProperty("firstName")
    private String firsName;
    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("factories")
    private List<FactoryDto> factories;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<FactoryDto> getFactories() {
        return factories;
    }

    public void setFactories(List<FactoryDto> factories) {
        this.factories = factories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(userId, userDto.userId) &&
                Objects.equals(firsName, userDto.firsName) &&
                Objects.equals(lastName, userDto.lastName) &&
                Objects.equals(factories, userDto.factories);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, firsName, lastName, factories);
    }
}
