package br.org.frameworkdemoiselle.cursoJPA.persistence;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> {
	
	private EntityManager em;
    
	public EntityManager getEntityManager(){
	        return em;
	}

    private final Class<T> classe;
	  
	public GenericDAO(EntityManager em, Class<T> classe) {
		this.classe = classe;
	    this.em = em;
	}
	 
	public T buscar(Long id) {
		return em.getReference(classe, id);
	}
	
	public void remover(T t) {    
	    this.em.remove(t);
	}

	public List<T> listar(){
	    return em.createQuery("select e from " + classe.getSimpleName() + " e").getResultList();
	}


	
	public void salvar (T t){
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}
}
