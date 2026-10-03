package net.ibizsys.paas.entity;

import java.util.HashMap;

/**
 * 简单数据对象
 * 
 * @author Administrator
 *
 */
public class SimpleEntity extends EntityBase {
	/**
	 * 获取数据对象属性名称集合
	 * 
	 * @return
	 */
	public java.util.Iterator<String> getFieldNames() {
		HashMap<String, Object> fieldsMap = new HashMap<String, Object>();
		this.fillMap(fieldsMap);
		return fieldsMap.keySet().iterator();
	}
}
