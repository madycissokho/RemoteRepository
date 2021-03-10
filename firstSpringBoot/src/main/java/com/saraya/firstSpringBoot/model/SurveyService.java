package com.saraya.firstSpringBoot.model;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SurveyService {
	private static List<Survey> surveys = new ArrayList<>();
	
	static {
		Question question1 = new Question("Question1", "Largest Country in the World?","Russia",
				Arrays.asList("India","Russia","United States","China"));
		
		Question question2 = new Question("Question2", "Most Populus Country in the World?","China",
				Arrays.asList("India","Russia","United States","China"));
		
		Question question3 = new Question("Question3", "Highest GDP Country in the World?","United States",
				Arrays.asList("India","Russia","United States","China"));
		
		Question question4 = new Question("Question4", "Second Largest English speaking Country in the World?","India",
				Arrays.asList("India","Russia","United States","China"));
		
		List<Question> questions = new ArrayList<>(Arrays.asList(question1,question2,question3,question4));
//		questions.add(question1);
//		questions.add(question2);
//		questions.add(question3);
//		questions.add(question4);
		Survey survey1 = new Survey("Survey1", "Leyla Survey", "This is Leila's review", questions);
		Survey survey2 = new Survey("Survey2", "Mady's Survey", "This is Mady's review", questions);
		Survey survey3 = new Survey("Survey3", "Idrissa's Survey", "This is Idrissan' review", questions);
//		surveys = new ArrayList<>(Arrays.asList(survey1,survey2,survey3));
		surveys.add(survey1);
		surveys.add(survey2);
		surveys.add(survey3);
	}
	
	public List<Survey> retrieveAllSurveys(){
		return surveys;
	}
	
	public Survey retrieveSurvey(String surveyId) {
		for(Survey survey : surveys) {
			if(survey.getId().equals(surveyId)) {
				return survey;
			}
		}
		return null;
	}
	
	public List<Question> retrieveQuestions(String surveyId){
		Survey survey = retrieveSurvey(surveyId);
		
		if(survey == null) {
			return null;
		}
		return survey.getQuestions();
	}
	
	public Question retrieveQuestion(String surveyId, String questionId) {
	Survey survey = retrieveSurvey(surveyId);
			
			if(survey == null) {
				return null;
			}
			for(Question question : survey.getQuestions()) {
				if(question.getId().equals(questionId)) {
					return question;
				}
			}
			return null;
		}
	
	private SecureRandom random = new SecureRandom();
	
	public Question addQuestion(String surveyId, Question question) {
		Survey survey = retrieveSurvey(surveyId);
		
		if(survey == null) {
			return null;
		}
		String randomId = new BigInteger(130, random).toString(32);
		question.setId(randomId);
		survey.getQuestions().add(question);
		return question;
	}
	
	
	
}










