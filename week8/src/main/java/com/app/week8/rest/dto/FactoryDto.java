package com.app.week8.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class FactoryDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("role")
    private String role;

    @JsonProperty("user")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactoryDto that = (FactoryDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(role, that.role) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, role, userId);
    }
}
