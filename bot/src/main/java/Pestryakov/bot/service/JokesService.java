package Pestryakov.bot.service;


import Pestryakov.bot.model.JokeSaveDTO;
import Pestryakov.bot.model.Jokes;

import java.util.List;

public interface JokesService {


    public Jokes addJokes(JokeSaveDTO joke);

    public List<Jokes> getAllJokes(String title);


    public Jokes getJokesById(Long id);

    public Void editJokes(Long id, Jokes joke);

    public Void deleteJokes(Long id);
}

