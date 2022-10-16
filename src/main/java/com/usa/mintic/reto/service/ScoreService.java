package com.usa.mintic.reto.service;

import com.usa.mintic.reto.entities.Score;
import com.usa.mintic.reto.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return (List<Score>)scoreRepository.getAll();

    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score score){
        if(score.getIdScore()== null){
            return scoreRepository.save(score);

        }else{
            Optional<Score> element = scoreRepository.getScore(score.getIdScore());
            if(element.isEmpty()){
                return scoreRepository.save(score);

            }else{
                return score;
            }
        }

    }


    public Score update(Score score){
        if(score.getIdScore() !=null){
            Optional<Score> scoreEncontrado = getScore(score.getIdScore());
            if(!scoreEncontrado.isEmpty()){
                if(score.getMessageText() !=null){
                    scoreEncontrado.get().setMessageText(score.getMessageText());
                }
                if(score.getStars() != null){
                    scoreEncontrado.get().setStars(score.getStars());
                }

                return scoreRepository.save(scoreEncontrado.get());
            }
        }
        return score;
    }

    public boolean delete(int Id){
        Boolean res = getScore(Id).map(scoreToDelete ->{
            scoreRepository.delete(scoreToDelete);
            return true ;
        }).orElse(false);
        return res;
    }
}
