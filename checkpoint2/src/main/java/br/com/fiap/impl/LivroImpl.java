package br.com.fiap.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.LivroDao;
import br.com.fiap.entity.Livro;

public class LivroImpl extends GenericImp<Livro, Integer> implements LivroDao {

	public LivroImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
