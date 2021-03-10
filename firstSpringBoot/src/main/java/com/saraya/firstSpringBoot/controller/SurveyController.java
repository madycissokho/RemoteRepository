package com.saraya.firstSpringBoot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.saraya.firstSpringBoot.model.Question;
import com.saraya.firstSpringBoot.model.Survey;
import com.saraya.firstSpringBoot.model.SurveyService;

@RestController
public class SurveyController {
	@Autowired
	private SurveyService service;
	
	@GetMapping("/surveys")
	public List<Survey> retrieveSurveys(){
		return service.retrieveAllSurveys();
	}
	
	@GetMapping("/surveys/{surveyId}")
		public Survey retrieveOneSurvey(@PathVariable String surveyId) {
			return service.retrieveSurvey(surveyId);
		}
	
	
	
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retieveAllQuestions(@PathVariable String surveyId){
		return service.retrieveQuestions(surveyId);
	}
	
	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveOneQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
		return service.retrieveQuestion(surveyId, questionId);
	}
	
	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<Void> addQuestionToSurvey(@PathVariable String surveyId, 
			@RequestBody Question newQuestion ){
		Question question = service.addQuestion(surveyId, newQuestion);
		if(question == null) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(question.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
}




      

























