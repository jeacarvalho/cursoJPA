package br.org.frameworkdemoiselle.cursoJPA;

import org.junit.Assert;
import org.junit.Test;

import br.org.frameworkdemoiselle.cursoJPA.entity.Aluno;
import br.org.frameworkdemoiselle.cursoJPA.entity.Curso;
import br.org.frameworkdemoiselle.cursoJPA.entity.Disciplina;
import br.org.frameworkdemoiselle.cursoJPA.entity.Endereco;
import br.org.frameworkdemoiselle.cursoJPA.entity.TipoCurso;
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

	@Test
    public void InserirDisciplinaDAO(){
        long novoIdDisciplina = 3;
        long novoIdAluno = 3;
        long novoIdCurso = 3;
        long novoIdEndereco = 3;
        
        
        // ManyToMany
        Disciplina disciplina=new Disciplina();
        disciplina.setId(novoIdDisciplina);
        disciplina.setNome("Algoritmos e Estrutura de Dados");
        //ManyToOne
        Curso curso=new Curso();
        curso.setId(novoIdCurso);
        curso.setNome("Ciências da Computação");
        curso.setTipoCurso(TipoCurso.GRADUACAO);
        
        //ManyToOne
        Endereco endereco= new Endereco();
        endereco.setId(novoIdEndereco);
        endereco.setBairro("Alto da Glória");
        endereco.setRua("Maua");
        endereco.setCidade("Curitiba");
        
        Aluno aluno=new Aluno();
        aluno.setId(novoIdAluno);
        aluno.setNome("João Francisco");
        aluno.getDisciplinas().add(disciplina);
        aluno.setCurso(curso);
        aluno.setEndereco(endereco);
        
        AlunoDAO alunoDAO = new AlunoDAO(JPAUtil.getEntityManager());
        alunoDAO.salvar(aluno);
                
        Aluno alunoPesquisar;
        
        alunoPesquisar=alunoDAO.buscar(novoIdAluno);
        Assert.assertEquals("João Francisco", alunoPesquisar.getNome());
        Assert.assertFalse(alunoPesquisar.getDisciplinas().isEmpty());
        Assert.assertEquals("Ciências da Computação", 
        alunoPesquisar.getCurso().getNome());
        Assert.assertEquals("Alto da Glória", 
        alunoPesquisar.getEndereco().getBairro());
        
	} 

	
	
}
