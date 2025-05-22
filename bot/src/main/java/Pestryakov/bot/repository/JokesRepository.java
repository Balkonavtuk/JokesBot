package Pestryakov.bot.repository;

import Pestryakov.bot.model.Jokes;
import org.springframework.data.repository.CrudRepository;

public interface JokesRepository extends CrudRepository<Jokes, Long> {
}
