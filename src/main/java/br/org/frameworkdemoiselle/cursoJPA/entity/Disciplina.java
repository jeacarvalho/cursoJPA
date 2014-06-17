package br.org.frameworkdemoiselle.cursoJPA.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class Disciplina {
	@Id
	private Long id;
	private String nome;

	@JoinTable(name="aluno_disciplina", 
		      joinColumns={@JoinColumn(name="disciplina_id")},
		      inverseJoinColumns={@JoinColumn(name="aluno_id")})
	private List<Aluno> alunos = new ArrayList<Aluno>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
}
