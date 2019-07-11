package com.fireayehu.taco.repositories;

import com.fireayehu.taco.domains.News;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NewsRepository extends PagingAndSortingRepository<News, Integer>{
    Iterable<News> findNewsByCategory(String category);
}
