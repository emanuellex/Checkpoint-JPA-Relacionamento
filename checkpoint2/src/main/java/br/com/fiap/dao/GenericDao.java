package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.ItensNotFoundException;

public interface GenericDao<T, K> {
	
void insert(T entity);
	
	T find(K id) throws ItensNotFoundException;
	
	void update(T entity);
	
	void remove(K id) throws ItensNotFoundException;
	
	void commit() throws CommitException;


}
