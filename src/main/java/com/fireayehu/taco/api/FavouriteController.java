package com.fireayehu.taco.api;

import com.fireayehu.taco.domains.Favourite;
import com.fireayehu.taco.repositories.FavouriteRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/news/favourite", produces="application/json")
public class FavouriteController {
    private FavouriteRepository favouriteRepository;

    public FavouriteController(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    @GetMapping("/{author}")
    public ResponseEntity<Iterable<Favourite>> newsById(@PathVariable("author") int author) {
        Iterable<Favourite> optTaco = favouriteRepository.findFavouritesByAuthor(author);
        return new ResponseEntity<>(optTaco,HttpStatus.OK);
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Favourite saveTaco(@RequestBody Favourite news) {
        return favouriteRepository.save(news);
    }


    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaco(@PathVariable("id") int id) {
        try {
            favouriteRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e) {

        }
    }
}
