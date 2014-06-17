package br.org.frameworkdemoiselle.cursoJPA.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	@ManyToOne
	private Aluno aluno;
}
