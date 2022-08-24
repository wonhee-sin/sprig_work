package com.spring.di.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Restaurant {
	private Chef chef;
}
