package com.vms.bookstore;

import com.vms.bookstore.models.Categoria;
import com.vms.bookstore.models.Livro;
import com.vms.bookstore.repositories.CategoriaRepository;
import com.vms.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informatica", "livros de TI");
		Livro l1 = new Livro(null, "clean code", "robert", "lorem ", cat1);
		cat1.getLivros().addAll(Arrays.asList(l1));
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));

	}
}
