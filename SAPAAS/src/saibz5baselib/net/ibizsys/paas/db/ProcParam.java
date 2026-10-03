package net.ibizsys.paas.db;

/**
 * 存储过程参数对象
 * 
 * @author Administrator
 *
 */
public class ProcParam extends SqlParam implements IProcParam {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IProcParam#getDefaultValue()
	 */
	@Override
	public Object getDefaultValue() {
		return this.getValue();
	}

	/**
	 * 设置默认值
	 * 
	 * @param objValue
	 */
	public void setDefaultValue(Object objValue) {
		this.setValue(objValue);
	}

}
