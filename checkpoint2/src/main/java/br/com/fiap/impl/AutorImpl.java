package br.com.fiap.impl;
import javax.persistence.EntityManager;

import br.com.fiap.dao.AutorDao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Autor;

public class AutorImpl extends GenericImp<Autor, Integer> implements AutorDao{

	public AutorImpl(EntityManager em) {
		super(em);
	
	}
	
}
