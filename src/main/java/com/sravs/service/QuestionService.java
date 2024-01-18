package com.sravs.service;

import com.sravs.model.Question;
import com.sravs.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }
        public ResponseEntity<List<Question>> getAllByCategory (String category){
            return  new ResponseEntity<>(questionRepo.findByCategory(category),HttpStatus.OK);
        }
        public ResponseEntity<String> addQuestion (Question question){
            questionRepo.save(question);
            return new ResponseEntity<> ("success",HttpStatus.CREATED);
        }
    }

