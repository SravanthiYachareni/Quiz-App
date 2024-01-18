package com.sravs.service;

import com.sravs.model.Question;
import com.sravs.model.QuestionWrapper;
import com.sravs.model.Quiz;
import com.sravs.repo.QuestionRepo;
import com.sravs.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
       List<Question> question= questionRepo.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(question);
        quizRepo.save(quiz);
        return  new ResponseEntity<>("sucess", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
       Optional<Quiz> quiz1 = quizRepo.findById(id);
       List<Question> questionfromDB=quiz1.get().getQuestions();
       List<QuestionWrapper> questonsForUser= new ArrayList<>();
       for(Question q : questionfromDB){
           QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(),q.getOption2(), q.getOption3(), q.getOption4());
           questonsForUser.add(qw);
       }
       return  new ResponseEntity<>(questonsForUser,HttpStatus.OK);

    }
}
