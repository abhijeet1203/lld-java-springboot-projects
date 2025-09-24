package com.machine.coding.lld_java_projects.TicTacToe.exception;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(String message) {
        super(message);
    }
}
