package br.com.fiap.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table (name="TB_LIVRO")
@SequenceGenerator(name = "livro", sequenceName = "SQ_TB_LIVRO", allocationSize = 1)
public class Livro {
	
	@Id
	@Column(name="cd_livro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro")
	private Integer codigo;
	
	//1:1
	@OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JoinColumn(name="cd_autor", nullable = false)
	private Autor autor;
	
	//1:N
	@OneToMany(mappedBy = "livro" , cascade = CascadeType.PERSIST)
	private List<Leitor> leitores = new ArrayList<Leitor>();
	
	//N:M
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name="TB_LIVRO_EDITORA",
		joinColumns = @JoinColumn(name="cd_livro"),
		inverseJoinColumns = @JoinColumn(name="cd_editora"))
	private List<Editora> editoras;
	
	@Column(name = "nm_livro", nullable = false)
	private String name;
	
	@Column(name = "dt_publicacao", nullable = false)
	private LocalDate publicacao;
	
	@Column(name = "vl_preco", nullable = false)
	private BigDecimal preco;
	
	public void addLeitor(Leitor leitor) {
		leitor.setLivro(this);
		
		leitores.add(leitor);
	}
	
	
	public Livro() {
	
	}
	

	public Livro( Autor autor, String name, LocalDate publicacao, BigDecimal preco) {
		super();	
		this.autor = autor;
		this.name = name;
		this.publicacao = publicacao;
		this.preco = preco;
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


	public LocalDate getPublicacao() {
		return publicacao;
	}


	public void setPublicacao(LocalDate publicacao) {
		this.publicacao = publicacao;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public List<Leitor> getLeitores() {
		return leitores;
	}


	public void setLeitores(List<Leitor> leitores) {
		this.leitores = leitores;
	}

	public List<Editora> getEditoras() {
		return editoras;
	}

	public void setEditoras(List<Editora> editoras) {
		this.editoras = editoras;
	}
	
	
	

}
