package br.com.fiap.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.LeitorDao;
import br.com.fiap.entity.Leitor;

public class LeitorImpl extends GenericImp<Leitor, Integer> implements LeitorDao {

	public LeitorImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
