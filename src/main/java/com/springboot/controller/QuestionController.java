package com.springboot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Question;
import com.springboot.repository.QuestionRepository;

@RestController
@RequestMapping("/api/")
public class QuestionController {
	@Autowired
	private QuestionRepository questionRepository;
	
	@RequestMapping(value = "questions", method = RequestMethod.GET)
	public List<Question> list(){
		return questionRepository.findAll();
	}

	@RequestMapping(value = "questions", method = RequestMethod.POST)
	public Question create(@RequestBody Question question){
		return questionRepository.saveAndFlush(question);
	}
	
	@RequestMapping(value = "questions/{id}", method = RequestMethod.GET)
	public Question get(@PathVariable Long id){
		return questionRepository.findOne(id);
	}
	
	@RequestMapping(value = "questions/{id}", method = RequestMethod.PUT)
	public Question update(@PathVariable Long id, @RequestBody Question question){
		Question existingQuestion = questionRepository.findOne(id);
		BeanUtils.copyProperties(question, existingQuestion);
		return questionRepository.saveAndFlush(existingQuestion);
	}
	
	@RequestMapping(value = "questions/{id}", method = RequestMethod.DELETE)
	public Question delete(@PathVariable Long id){
		Question existingQuestion =questionRepository.findOne(id);
		questionRepository.delete(existingQuestion);
		return existingQuestion;
	}
}
