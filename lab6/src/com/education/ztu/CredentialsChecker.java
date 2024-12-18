package com.education.ztu;

// Класи-користувацькі виключення
class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Invalid login!");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Invalid password!");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}

public class CredentialsChecker {
    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            // Перевірка логіну
            if (!login.matches("[A-Za-z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Login should contain only letters, digits, underscores, and be less than 20 characters.");
            }

            // Перевірка паролю
            if (!password.matches("[A-Za-z0-9_]+") || password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password should contain only letters, digits, underscores, be less than 20 characters, and match confirmPassword.");
            }

            return true; // Якщо логін та пароль коректні
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Error: " + e.getMessage());
            return false; // Неправильні дані
        }
    }

    public static void main(String[] args) {
        // Виклик методу для перевірки
        boolean isValid = checkCredentials("valid_login", "validPassword123", "validPassword123");
        System.out.println("Credentials are valid: " + isValid);
    }
}
