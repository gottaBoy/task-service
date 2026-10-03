package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDERIndex;

/**
 * 索引关系对象
 * 
 * @author lionlau
 *
 */
public class DERIndexModel extends DERBaseModel implements IDERIndex {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDERIndex#getIndexValue()
	 */
	@Override
	public String getTypeValue() {
		return this.der.indexvalue();
	}

}
