package br.com.fiap.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.AutorDao;
import br.com.fiap.dao.LivroDao;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Leitor;
import br.com.fiap.entity.Livro;
import br.com.fiap.exception.CommitException;
import br.com.fiap.impl.AutorImpl;
import br.com.fiap.impl.LivroImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroLivro {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		try {
		
		Autor autor = new Autor("Machado de Assis", LocalDate.of(1839, 6, 21), Genero.MASCULINO);
		
		AutorDao autorDao = new AutorImpl(em);
		
		
		Livro livro = new Livro(autor,"O Alienista",LocalDate.of(1882, 3, 15), new BigDecimal("14.90")) ;
		LivroDao livroDao = new LivroImpl(em);
		
		//
		
	
		Leitor gustavo = new Leitor("Gustavo", "gustavo@gmail.com");
		
		Leitor carol = new Leitor("Carol", "caroldosantos@gmail.com");
		
		Leitor gabriel = new Leitor("Gabriel", "gomesgabriel@gmail.com");
		
		Leitor luiz = new Leitor("Luiz", "luoliveira@gmail.com");
		
		Leitor Ana = new Leitor("Ana", "anapereira@gmail.com");
		
		livro.addLeitor(Ana);
		livro.addLeitor(luiz);
		livro.addLeitor(carol);
		livro.addLeitor(gabriel);
		livro.addLeitor(gustavo);
		
		//
		
		Editora aleph = new Editora("Aleph", "Brasil");
		
		Editora globo = new Editora("Globo Livros", "Brasil");
		
		Editora intrinseca = new Editora("Editora Intrínseca", "Brasil");
		
		Editora ediouro = new Editora("Ediouro", "Brasil");
		
		List<Editora> editoras = new ArrayList<Editora>();
		
		editoras.add(aleph);
		editoras.add(globo);
		editoras.add(intrinseca);
		editoras.add(ediouro);
		
	
		
		livro.setEditoras(editoras);
		 
		//
		
		livroDao.insert(livro);
		livroDao.commit();
		
		
		
		
		}catch (CommitException e) {
			System.out.println(e.getMessage());
			
		}
		
		
	}

}
