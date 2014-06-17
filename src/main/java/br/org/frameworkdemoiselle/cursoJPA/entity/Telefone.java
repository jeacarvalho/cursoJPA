package br.org.frameworkdemoiselle.cursoJPA.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	@Id
	private Long id;
	
	@ManyToOne
	private Aluno aluno;
}
