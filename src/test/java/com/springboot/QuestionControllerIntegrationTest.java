package com.springboot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.model.Question;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest
public class QuestionControllerIntegrationTest {
	@Test
	public void testGetAll() throws IOException {
		RestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080//api/questions", String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonResponse = objectMapper.readTree(response.getBody());
		assertThat(jsonResponse.isMissingNode(), is(false));
		assertThat(jsonResponse.toString().isEmpty(), is(false));
		
		
		ResponseEntity<List<Question>> re = restTemplate.exchange("http://localhost:8080//api/questions", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Question>>() {});
		List<Question> questions = re.getBody();
		assertThat(questions.isEmpty(), is(false));
	}
}
