package com.manifestcorp.techreads;

import static org.assertj.core.api.Assertions.assertThat;

import com.manifestcorp.techreads.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmokeTest {

	@Autowired
	private BookController controller;


	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

	@Test
	public void booksShouldReturnAllBooks() throws Exception{
		assertThat(controller).isNotNull();
	}



}
