package com.fireayehu.taco.repositories;

import com.fireayehu.taco.domains.Favourite;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FavouriteRepository  extends PagingAndSortingRepository<Favourite, Integer> {
    Iterable<Favourite> findFavouritesByAuthor(int author);
}
