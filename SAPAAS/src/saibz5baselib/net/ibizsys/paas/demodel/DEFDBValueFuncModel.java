package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEFDBValueFunc;
import net.ibizsys.paas.core.ModelBaseImpl;

/**
 * 属性数据库值函数对象
 * @author Administrator
 *
 */
public class DEFDBValueFuncModel extends ModelBaseImpl implements IDEFDBValueFunc {

	private String strCodeFormat = null;
	private String[] fields = null;
	
	
	/**
	 * 设置函数标识
	 * @param strId
	 */
	public void setId(String strId){
		this.strId = strId;
	}
	
	/**
	 * 设置函数名称
	 * @param strName
	 */
	public void setName(String strName){
		this.strName = strName;
	}

	@Override
	public String getCodeFormat() {
		return this.strCodeFormat;
	}

	@Override
	public String[] getFields() {
		return this.fields;
	}

	/**
	 * 设置代码格式化
	 * @param strCodeFormat
	 */
	public void setCodeFormat(String strCodeFormat) {
		this.strCodeFormat = strCodeFormat;
	}

	/**
	 * 设置相关的属性
	 * @param fields
	 */
	public void setFields(String[] fields) {
		this.fields = fields;
	}
	
	
	
	
}
