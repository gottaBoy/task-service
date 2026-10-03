package net.ibizsys.paas.core;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;

/**
 * 实体属性集合注解辅助对象
 * 
 * @author lionlau
 *
 */
public class DEFieldsAnnoHelper {

	private HashMap<String, DEField> deFieldMap = new HashMap<String, DEField>();
	private ArrayList<DEField> deFieldList = new ArrayList<DEField>();

	private DEFields defields = null;

	public DEFieldsAnnoHelper(DEFields defields) {
		this.defields = defields;

		for (DEField defield : this.defields.value()) {
			deFieldList.add(defield);
			deFieldMap.put(defield.id(), defield);
			deFieldMap.put(defield.name(), defield);
		}
	}

	/**
	 * 获取指定属性
	 * 
	 * @param strName
	 * @param bTry
	 * @return
	 * @throws Exception
	 */
	public DEField getDEField(String strName, boolean bTry) throws Exception {
		DEField defield = deFieldMap.get(strName);
		if (defield == null) {
			if (!bTry) {
				throw new Exception(StringHelper.format("无法获取属性[%1$s]", strName));
			}
		}

		return defield;
	}

	/**
	 * 获取实体属性
	 * 
	 * @return
	 */
	public java.util.Iterator<DEField> getDEFields() {
		return deFieldList.iterator();
	}

}
