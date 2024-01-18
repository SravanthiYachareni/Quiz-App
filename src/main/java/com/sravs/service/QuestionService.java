package com.sravs.service;

import com.sravs.model.Question;
import com.sravs.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
        public List<Question> getAllByCategory (String category){
            return questionRepo.findByCategory(category);
        }
        public String addQuestion (Question question){
            questionRepo.save(question);
            return "success";
        }
    }

