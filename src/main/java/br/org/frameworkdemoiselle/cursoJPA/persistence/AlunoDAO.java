package br.org.frameworkdemoiselle.cursoJPA.persistence;

import javax.persistence.EntityManager;

import br.org.frameworkdemoiselle.cursoJPA.entity.Aluno;

public class AlunoDAO {
	private final EntityManager em;
	public AlunoDAO (EntityManager em){
		this.em = em;
	}
	
	public void adicionar(Aluno aluno){
        this.em.persist(aluno);
    }
 
    public void remover(Aluno aluno){
        this.em.remove(aluno);
    }
 
    public Aluno buscar(Long id){
         return this.em.getReference(Aluno.class,id);
    }
}