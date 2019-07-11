package com.fireayehu.taco.domains;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;


import lombok.Data;

@Data
@Entity
@NoArgsConstructor(access= AccessLevel.PRIVATE,force=true)
@RequiredArgsConstructor
public class Report {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private final int id;
    private final String headline;
    private final String author;
}

