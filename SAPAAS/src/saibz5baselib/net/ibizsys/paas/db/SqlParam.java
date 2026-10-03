package net.ibizsys.paas.db;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.util.StringHelper;

/**
 * 数据库SQL参数
 * 
 * @author Administrator
 *
 */
public class SqlParam extends ModelBaseImpl {
	protected Object objValue = null;
	protected int nDirection = SqlParamDirections.Input;
	protected String strOutputParamName = "";
	protected int nDataType = DataTypes.UNKNOWN;
	protected String strParamName = "";

	public SqlParam() {

	}

	@Override
	protected void onInit() throws Exception {
		super.onInit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	public SqlParam clone() {
		SqlParam callParam = new SqlParam();
		callParam.setDataType(nDataType);
		callParam.setDirection(nDirection);
		callParam.setOutputParamName(strOutputParamName);
		callParam.setParamName(strParamName);
		callParam.setValue(objValue);
		return callParam;
	}

	/**
	 * @param objValue
	 */
	public SqlParam(Object objValue) {
		this.objValue = objValue;
	}

	/**
	 * 构造Sql参数
	 * 
	 * @param objValue
	 * @param nDataType 数据类型
	 */
	public SqlParam(Object objValue, int nDataType) {
		this.objValue = objValue;
		this.nDataType = nDataType;
	}

	/**
	 * 获取值
	 * 
	 * @return the objValue
	 */
	public Object getValue() {
		return objValue;
	}

	/**
	 * 设置值
	 * 
	 * @param objValue
	 */
	public void setValue(Object objValue) {
		this.objValue = objValue;
	}

	/**
	 * 获取参数方向
	 * 
	 * @return
	 */
	public int getDirection() {
		return nDirection;
	}

	/**
	 * 设置参数方向
	 * 
	 * @param direction
	 */
	public void setDirection(int direction) {
		nDirection = direction;
	}

	/**
	 * 获取输出参数名称
	 * 
	 * @return
	 */
	public String getOutputParamName() {
		if (StringHelper.isNullOrEmpty(strOutputParamName)) return this.getParamName();

		return strOutputParamName;
	}

	/**
	 * 设置输出参数名称
	 * 
	 * @param strOutputParamName
	 */
	public void setOutputParamName(String strOutputParamName) {
		this.strOutputParamName = strOutputParamName;
	}

	/**
	 * 获取数据类型
	 * 
	 * @return
	 */
	public int getDataType() {
		return nDataType;
	}

	/**
	 * 设置数据类型
	 * 
	 * @param nDataType
	 */
	public void setDataType(int nDataType) {
		this.nDataType = nDataType;
	}

	/**
	 * 获取参数名称
	 * 
	 * @return
	 */
	public String getParamName() {
		if (StringHelper.isNullOrEmpty(strParamName)) return this.getName();

		return strParamName;
	}

	/**
	 * 设置参数名称
	 * 
	 * @param strParamName
	 */
	public void setParamName(String strParamName) {
		this.strParamName = strParamName;
	}

}
