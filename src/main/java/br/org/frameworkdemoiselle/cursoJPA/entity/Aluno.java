package br.org.frameworkdemoiselle.cursoJPA.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table(name="TB_ALUNO")
@Entity
public class Aluno {
	@Id
	private Long id;
	private String matricula;
	private String nome;
	private int idade;
	
	@OneToOne(cascade = {CascadeType.PERSIST})
	@PrimaryKeyJoinColumn(name="endereco_id", referencedColumnName="id")
	private Endereco endereco;

	@OneToOne(cascade = {CascadeType.PERSIST})
	@PrimaryKeyJoinColumn(name="curso_id", referencedColumnName="id")
	private Curso curso;

	
	@OneToMany(cascade = {CascadeType.PERSIST})
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	
	@ManyToMany(mappedBy="alunos", cascade = {CascadeType.PERSIST})
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	

}
