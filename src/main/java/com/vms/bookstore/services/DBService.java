package com.vms.bookstore.services;

import com.vms.bookstore.models.Categoria;
import com.vms.bookstore.models.Livro;
import com.vms.bookstore.repositories.CategoriaRepository;
import com.vms.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instaciaBaseDeDados() {
        Categoria cat1 = new Categoria(null, "informatica", "livros de TI");
        Categoria cat2 = new Categoria(null, "biografia", "biografia");
        Categoria cat3 = new Categoria(null, "romance", "amor meu");
        Livro l1 = new Livro(null, "clean code", "robert", "lorem ", cat1);
        Livro l2 = new Livro(null, "O lendario cabeludo careca", "raimundo", "cabelo ", cat3);
        Livro l3 = new Livro(null, "robo", "IA", "lorem ", cat1);
        Livro l4 = new Livro(null, "crepusculo", "maria", "lua ", cat3);
        Livro l5 = new Livro(null, "Historia da Dilma", "Dilma", "no final todo mundo vai perder ", cat2);
        cat1.getLivros().addAll(Arrays.asList(l1, l3));
        cat2.getLivros().addAll(Arrays.asList(l5));
        cat3.getLivros().addAll(Arrays.asList(l2, l4));

        this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
    }
}
