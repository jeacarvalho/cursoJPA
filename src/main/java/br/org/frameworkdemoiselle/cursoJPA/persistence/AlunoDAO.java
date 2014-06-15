package br.org.frameworkdemoiselle.cursoJPA.persistence;

import javax.persistence.EntityManager;

import br.org.frameworkdemoiselle.cursoJPA.entity.Aluno;

public class AlunoDAO extends GenericDAO<Aluno>{

	public AlunoDAO (EntityManager em){
		super(em, Aluno.class);
	}
	
}