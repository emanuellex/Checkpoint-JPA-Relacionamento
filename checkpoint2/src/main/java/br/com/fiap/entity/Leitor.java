package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="TB_LEITOR")
@SequenceGenerator(name = "leitor", sequenceName = "SQ_TB_LEITOR", allocationSize = 1)
public class Leitor {
	
	@Id
	@Column(name="cd_leitor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leitor")
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name="cd_livro", nullable = false)
	private Livro livro;
	
	@Column(name = "nm_leitor", nullable = false)
	private String name;
	
	@Column(name = "ds_email", nullable = false)
	private String mail;
	
	
	public Leitor() {
	}

	public Leitor( String name, String mail) {
		this.name = name;
		this.mail = mail;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
	
}
