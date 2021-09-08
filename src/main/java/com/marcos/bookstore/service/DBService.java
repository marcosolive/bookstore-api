package com.marcos.bookstore.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.bookstore.domain.Categoria;
import com.marcos.bookstore.domain.Livro;
import com.marcos.bookstore.repositories.CategoriaRepository;
import com.marcos.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDados() {

		Categoria cat1 = new Categoria(null, "Informática", "Livros TI");
		Categoria cat2 = new Categoria(null, "Religião", "Livros Católicos");

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Loren ipsim", cat1);
		Livro l2 = new Livro(null, "Java", "Java Autor", " Java Loren ipsim", cat1);
		Livro l3 = new Livro(null, "Para Estar Com Deus", "Pe. Francisco Faus", "Sensacional", cat2);
		

		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3));
	}
}
