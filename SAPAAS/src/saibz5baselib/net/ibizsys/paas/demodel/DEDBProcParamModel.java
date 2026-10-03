package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.DBProcParam;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.util.StringHelper;

/**
 * 实体数据库参数模型
 * 
 * @author lionlau
 *
 */
public class DEDBProcParamModel extends ModelBaseImpl implements IProcParam {
	private DBProcParam dbProcParam = null;

	public DEDBProcParamModel() {

	}

	/**
	 * 初始化
	 * 
	 * @param dbProcParam
	 */
	public void init(DBProcParam dbProcParam) {
		this.dbProcParam = dbProcParam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IProcParam#getDirection()
	 */
	@Override
	public int getDirection() {
		return this.dbProcParam.dir();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IProcParam#getOutputParamName()
	 */
	@Override
	public String getOutputParamName() {
		if (StringHelper.isNullOrEmpty(this.dbProcParam.outputname())) return this.getName();
		return this.dbProcParam.outputname();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IProcParam#getDataType()
	 */
	@Override
	public int getDataType() {
		return this.dbProcParam.datatype();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IProcParam#getParamName()
	 */
	@Override
	public String getParamName() {
		return this.dbProcParam.name();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.IProcParam#getValue()
	 */
	@Override
	public Object getDefaultValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
