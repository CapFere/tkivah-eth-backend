package com.fireayehu.taco.domains;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access= AccessLevel.PRIVATE,force=true)
@RequiredArgsConstructor
public class News {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private final int id;
	private final int author;
	private final String title;
	private final String content;
	private final String category;
}
