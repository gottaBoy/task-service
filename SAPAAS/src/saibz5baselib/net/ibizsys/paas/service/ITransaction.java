package net.ibizsys.paas.service;

/**
 * 事物接口
 * 
 * @author Administrator
 *
 */
public interface ITransaction {
	// Method descriptor #4 ()Z
	public abstract boolean isInitiator();

	// Method descriptor #6 ()V
	public abstract void begin();

	// Method descriptor #6 ()V
	public abstract void commit();

	// Method descriptor #6 ()V
	public abstract void rollback();

	// Method descriptor #10 ()Lorg/hibernate/engine/transaction/spi/LocalStatus;
	// public abstract org.hibernate.engine.transaction.spi.LocalStatus getLocalStatus();

	// Method descriptor #4 ()Z
	public abstract boolean isActive();

	// Method descriptor #4 ()Z
	public abstract boolean isParticipating();

	// Method descriptor #4 ()Z
	public abstract boolean wasCommitted();

	// Method descriptor #4 ()Z
	public abstract boolean wasRolledBack();

	// Method descriptor #16 (Ljavax/transaction/Synchronization;)V
	// public abstract void registerSynchronization(javax.transaction.Synchronization arg0) throws org.hibernate.HibernateException;

	// Method descriptor #20 (I)V
	public abstract void setTimeout(int arg0);

	// Method descriptor #22 ()I
	public abstract int getTimeout();
}
