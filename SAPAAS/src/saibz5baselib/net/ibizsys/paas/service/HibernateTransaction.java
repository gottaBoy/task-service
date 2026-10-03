package net.ibizsys.paas.service;

/**
 * Hibernate 事物对象
 * 
 * @author Administrator
 *
 */
public class HibernateTransaction implements ITransaction {
	private org.hibernate.Transaction transaction = null;

	public HibernateTransaction(org.hibernate.Transaction transaction) {
		this.transaction = transaction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.ITransaction#isInitiator()
	 */
	@Override
	public boolean isInitiator() {
		return this.transaction.isInitiator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.ITransaction#begin()
	 */
	@Override
	public void begin() {
		this.transaction.begin();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.ITransaction#commit()
	 */
	@Override
	public void commit() {
		this.transaction.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.ITransaction#rollback()
	 */
	@Override
	public void rollback() {
		this.transaction.rollback();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.ITransaction#isActive()
	 */
	@Override
	public boolean isActive() {
		return this.transaction.isActive();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.ITransaction#isParticipating()
	 */
	@Override
	public boolean isParticipating() {
		return this.transaction.isParticipating();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.ITransaction#wasCommitted()
	 */
	@Override
	public boolean wasCommitted() {
		return this.transaction.wasCommitted();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.ITransaction#wasRolledBack()
	 */
	@Override
	public boolean wasRolledBack() {
		return this.transaction.wasRolledBack();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.ITransaction#setTimeout(int)
	 */
	@Override
	public void setTimeout(int arg0) {
		this.transaction.setTimeout(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.ITransaction#getTimeout()
	 */
	@Override
	public int getTimeout() {
		return this.transaction.getTimeout();
	}

}
