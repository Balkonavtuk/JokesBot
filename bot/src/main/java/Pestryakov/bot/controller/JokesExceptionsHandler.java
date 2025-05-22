package Pestryakov.bot.controller;

import Pestryakov.bot.exceptions.ExceptionRespone;
import Pestryakov.bot.exceptions.JokesNotFoundExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JokesExceptionsHandler {

    @ExceptionHandler(JokesNotFoundExceptions.class)
    public ResponseEntity<ExceptionRespone> handleJokesNotFound (JokesNotFoundExceptions exception) {

        System.out.println("Joke not found with ID: " + exception.getId());
        return ResponseEntity.notFound().build();
    }
}
