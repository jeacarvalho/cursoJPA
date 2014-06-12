package br.org.frameworkdemoiselle.cursoJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Test;

import br.org.frameworkdemoiselle.cursoJPA.entity.Aluno;

public class AlunoTest {
	@Test
	public void testInserirAluno(){
		long novoId = 1;
        
        Aluno aluno = new Aluno();
        aluno.setId(novoId);
        aluno.setNome("João");
            aluno.setIdade(30);
        aluno.setMatricula("12345");
        EntityManagerFactory factory =
                         Persistence.createEntityManagerFactory("cursoJPA-ds");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        
        Aluno aluno2;
        aluno2 = em.find(Aluno.class, novoId);
          Assert.assertEquals("João", aluno2.getNome());
            em.close();
	}
}
