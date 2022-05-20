package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="TB_EDITORA")
@SequenceGenerator(name = "leitor", sequenceName = "SQ_TB_EDITORA", allocationSize = 1)
public class Editora {
	
	@Id
	@Column(name="cd_editora")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editora")
	private Integer codigo;
	
	
	@Column(name = "nm_editora", nullable = false)
	private String name;
	
	@Column(name = "nm_sede", length = 200 ,nullable = false)
	private String sede;
	
	//N:M 
		@ManyToMany(mappedBy = "editoras")
		private List<Livro> livros;
	
	public Editora() {
		
	}
	
	public Editora( String name, String sede) {
		this.name = name;
		this.sede = sede;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}
		
}
