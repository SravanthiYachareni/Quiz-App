package com.sravs.controllers;

import com.sravs.model.Question;
import com.sravs.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService quizService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return  quizService.getAllQuestions();
    }
    @GetMapping("category/{category}")
public List<Question> getAllByCategory(@PathVariable  String category){
        return  quizService.getAllByCategory(category);
}
@PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return quizService.addQuestion(question);
}
}
