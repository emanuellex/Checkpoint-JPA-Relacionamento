package br.com.fiap.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="TB_AUTOR")
@SequenceGenerator(name = "autor", sequenceName = "SQ_TB_AUTOR", allocationSize = 1)
public class Autor {
	
	@Id
	@Column(name="cd_autor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor")
	private Integer codigo;
	
	@OneToOne(mappedBy="autor", cascade = CascadeType.PERSIST)
	private Livro livro;
	

	@Column(name = "nm_autor", length = 200, nullable = false)
	private String name;
	
	@Column(name = "dt_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
	
	@Enumerated
	@Column(name = "ds_genero", length = 40, nullable = false)
	private Genero genero;
	
	public Autor() {
		
	}
	
	
	public Autor( String name, LocalDate dataNascimento, Genero genero) {

	
		this.name = name;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	

}
