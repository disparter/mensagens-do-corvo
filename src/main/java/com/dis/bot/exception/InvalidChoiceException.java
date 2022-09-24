package com.dis.bot.exception;

public class InvalidChoiceException extends RuntimeException {
    private final static String MESSAGE = "Invalid choice";

    public static String getFormattedMessage() {
        return MESSAGE;
    }
}
