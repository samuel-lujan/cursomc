package com.example.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.domain.Cidade;
import com.example.cursomc.domain.Estado;
import com.example.cursomc.domain.Produto;
import com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.repositories.CidadeRepository;
import com.example.cursomc.repositories.EstadoRepository;
import com.example.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		c1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		c2.getProdutos().add(p2);
		
		p1.getCategorias().add(c1);
		p2.getCategorias().addAll(Arrays.asList(c1,c2));
		p3.getCategorias().add(c1);
		
		categoriaRepository.saveAll(Arrays.asList(c1,c2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		
		Cidade ci1 = new Cidade(null, "Araçatuba", est2);
		Cidade ci2 = new Cidade(null, "Uberlândia", est1);
		Cidade ci3 = new Cidade(null, "São Paulo", est1);
		
		est1.getCidades().addAll(Arrays.asList(ci2));
		est2.getCidades().addAll(Arrays.asList(ci1, ci3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(ci1, ci2, ci3));
		
	
	}

}
