package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.DER;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.ISystem;

/**
 * 实体关系模型基类
 * 
 * @author Administrator
 *
 */
public abstract class DERBaseModel implements IDERBase {
	protected ISystem iSystem = null;
	protected DER der = null;

	public void init(ISystem iSystem, DER der) {
		this.iSystem = iSystem;
		this.der = der;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IModelBase#getId()
	 */
	@Override
	public String getId() {
		return this.der.id();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IModelBase#getName()
	 */
	@Override
	public String getName() {
		return this.der.name();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDERBase#getDERType()
	 */
	@Override
	public String getDERType() {
		return this.der.type();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDERBase#getMajorDEId()
	 */
	@Override
	public String getMajorDEId() {
		return this.der.majordeid();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDERBase#getMinorDEId()
	 */
	@Override
	public String getMinorDEId() {
		return this.der.minordeid();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDERBase#getMajorDEName()
	 */
	@Override
	public String getMajorDEName() {
		return this.der.majordename();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDERBase#getMinorDEName()
	 */
	@Override
	public String getMinorDEName() {
		return this.der.minordename();
	}

	/**
	 * 获取系统
	 * 
	 * @return
	 */
	protected ISystem getSystem() {
		return this.iSystem;
	}
}
