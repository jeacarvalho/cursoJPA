package br.org.frameworkdemoiselle.cursoJPA;

import org.junit.Assert;
import org.junit.Test;

import br.org.frameworkdemoiselle.cursoJPA.entity.Aluno;
import br.org.frameworkdemoiselle.cursoJPA.persistence.AlunoDAO;
import br.org.frameworkdemoiselle.cursoJPA.persistence.JPAUtil;

public class AlunoTest {
	@Test
	public void testInserirAluno(){
		long novoId2 = 2;
        
        Aluno aluno = new Aluno();
        aluno.setId(novoId2);
        aluno.setNome("José");
            aluno.setIdade(30);
        aluno.setMatricula("12345");
        AlunoDAO alunoDAO = new AlunoDAO(JPAUtil.getEntityManager());
        alunoDAO.salvar(aluno);
        
        Aluno aluno2;
        aluno2 = alunoDAO.buscar(novoId2);
        Assert.assertEquals("José", aluno2.getNome());
        Assert.assertFalse(alunoDAO.listar().isEmpty());
	}
}
