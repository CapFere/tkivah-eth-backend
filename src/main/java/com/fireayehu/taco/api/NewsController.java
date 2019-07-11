package com.fireayehu.taco.api;

import java.util.Optional;

import com.fireayehu.taco.domains.News;
import com.fireayehu.taco.repositories.NewsRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/news", produces="application/json")
public class NewsController {
	private NewsRepository newsRepository;
	
	public NewsController(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}

	@GetMapping("/{id}")
	public ResponseEntity<News> newsById(@PathVariable("id") int id) {
		Optional<News> optTaco = newsRepository.findById(id);
		if(optTaco.isPresent()) {
			return new ResponseEntity<>(optTaco.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public ResponseEntity<Iterable<News>> allNews() {
		Iterable<News> optTaco = newsRepository.findAll();
			return new ResponseEntity<>(optTaco,HttpStatus.OK);

	}

	@GetMapping("/category")
	public ResponseEntity<Iterable<News>> findByCategory(@RequestParam(name="category",defaultValue = "General") String category) {
		Iterable<News> optTaco = newsRepository.findNewsByCategory(category);
		return new ResponseEntity<>(optTaco,HttpStatus.OK);

	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public News saveTaco(@RequestBody News news) {
		return newsRepository.save(news);
	}
	
	@PutMapping(path="/{id}", consumes="application/json")
	public News wholesaleTacoUpdate(@PathVariable("id") int id, @RequestBody News news) {
		return newsRepository.save(news);
	}

	
	@DeleteMapping(path="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTaco(@PathVariable("id") int id) {
		try {
			newsRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			
		}
	}

}
