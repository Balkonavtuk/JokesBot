package Pestryakov.bot.exceptions;

import lombok.Getter;

@Getter
public class JokesNotFoundExceptions extends RuntimeException {

    private final Long id;

    public JokesNotFoundExceptions(Long id) {
        super("Jokes not found: " + id);
        this.id=id;
    }

    public Long getId() {
        return id;
    }
}
