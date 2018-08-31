package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Question;

public interface QuestionRepository extends JpaRepository<Question,Long> {

}
