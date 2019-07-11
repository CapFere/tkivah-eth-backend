package com.fireayehu.taco.domains;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor(access= AccessLevel.PRIVATE,force=true)
@RequiredArgsConstructor
public class Favourite {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final int id;
    private final int author;
    private final String title;
    private final String content;
    private final String category;
}
