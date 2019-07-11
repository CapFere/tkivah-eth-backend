package com.fireayehu.taco.api;

import com.fireayehu.taco.domains.Report;
import com.fireayehu.taco.repositories.ReportRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping(path="/report", produces="application/json")
public class ReportController {
    private ReportRepository reportRepository;

    public ReportController(ReportRepository newsRepository) {
        this.reportRepository = newsRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> newsById(@PathVariable("id") int id) {
        Optional<Report> optTaco = reportRepository.findById(id);
        if(optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<Iterable<Report>> allNews() {
        Iterable<Report> optTaco = reportRepository.findAll();
        return new ResponseEntity<>(optTaco,HttpStatus.OK);

    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Report saveTaco(@RequestBody Report news) {
        return reportRepository.save(news);
    }

    @PutMapping(path="/{id}", consumes="application/json")
    public Report wholesaleTacoUpdate(@PathVariable("id") int id, @RequestBody Report news) {
        return reportRepository.save(news);
    }


    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaco(@PathVariable("id") int id) {
        try {
            reportRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e) {

        }
    }

}
