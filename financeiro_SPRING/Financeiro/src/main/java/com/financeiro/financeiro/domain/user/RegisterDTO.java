package com.financeiro.financeiro.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
