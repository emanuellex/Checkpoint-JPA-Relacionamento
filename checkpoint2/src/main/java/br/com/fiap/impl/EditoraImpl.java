package br.com.fiap.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EditoraDao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Editora;

public class EditoraImpl extends GenericImp<Editora, Integer>  implements EditoraDao{

	public EditoraImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
