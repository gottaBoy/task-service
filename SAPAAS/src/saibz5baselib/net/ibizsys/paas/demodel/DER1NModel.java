package net.ibizsys.paas.demodel;

import net.ibizsys.paas.sysmodel.ISystemModel;

/**
 * 实体1：N关系模型对象
 * 
 * @author Administrator
 *
 */
public class DER1NModel extends DERBaseModel implements IDER1NModel {
	private IDataEntityModel majorDEModel = null;
	private IDataEntityModel minorDEModel = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDER1N#getPickupDEFName()
	 */
	@Override
	public String getPickupDEFName() {
		return this.der.pickupdefname();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDER1N#getMasterRS()
	 */
	@Override
	public int getMasterRS() {
		return der.masterrs();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDER1NModel#getMajorDEModel()
	 */
	@Override
	public IDataEntityModel getMajorDEModel() throws Exception {
		if (majorDEModel != null) return majorDEModel;
		this.majorDEModel = DEModelGlobal.getDEModel(this.getMajorDEId());
		return this.majorDEModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDER1NModel#getMinorDEModel()
	 */
	@Override
	public IDataEntityModel getMinorDEModel() throws Exception {
		if (minorDEModel != null) return minorDEModel;
		this.minorDEModel = DEModelGlobal.getDEModel(this.getMinorDEId());
		return this.minorDEModel;
	}

	/**
	 * 获取系统模型对象
	 * 
	 * @return
	 */
	public ISystemModel getSystemModel() {
		return (ISystemModel) this.iSystem;
	}

}
