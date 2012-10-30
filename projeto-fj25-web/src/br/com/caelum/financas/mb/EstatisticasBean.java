package br.com.caelum.financas.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.stat.Statistics;

@ManagedBean
public class EstatisticasBean {

	private Statistics estatisticas;

	@ManagedProperty(name="em",value="#{requestScope.em}")
	private EntityManager em;
	
	

	public void gera() {
		Session session = (Session) em.getDelegate();
		estatisticas = session.getSessionFactory().getStatistics();
	}

	public Statistics getEstatisticas() {
		return estatisticas;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
