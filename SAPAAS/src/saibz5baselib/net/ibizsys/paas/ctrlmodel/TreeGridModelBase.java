package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.control.ControlTypes;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

/**
 * 树表模型
 * 
 * @author lionlau
 *
 */
public abstract class TreeGridModelBase extends GridModelBase implements ITreeGridModel {
	private String strParentDEField = "";

	@Override
	public String getControlType() {
		return ControlTypes.TreeGrid;
	}

	/**
	 * 填充层级数据
	 * 
	 * @param list
	 * @param strKeyField 键属性名称
	 * @param strPKeyField 父键属性名称
	 * @param strItemsField 子节点集合属性名称
	 * @throws Exception
	 */
	public static void fillHierarchyDatas(ArrayList<JSONObject> list, String strKeyField, String strPKeyField, String strItemsField) throws Exception {
		HashMap<Object, JSONObject> entityMap = new HashMap<Object, JSONObject>();
		HashMap<Object, ArrayList<Object>> listMap = new HashMap<Object, ArrayList<Object>>();

		ArrayList<JSONObject> list2 = new ArrayList<JSONObject>();

		for (JSONObject iEntity : list) {
			Object objKey = iEntity.get(strKeyField);
			entityMap.put(objKey, iEntity);

			Object objPKey = iEntity.opt(strPKeyField);
			if (!(objPKey == null || objPKey instanceof JSONNull || objPKey.toString().length() == 0)) {
				ArrayList<Object> list3 = listMap.get(objPKey);
				if (list3 == null) {
					list3 = new ArrayList<Object>();
					listMap.put(objPKey, list3);
				}

				list3.add(iEntity);
			}
		}

		// 放入对象中
		for (JSONObject iEntity : list) {
			Object objKey = iEntity.get(strKeyField);
			ArrayList<Object> list3 = listMap.get(objKey);
			if (list3 != null) {
				iEntity.put(strItemsField, list3);
			} else {
				iEntity.put("leaf", true);
			}
		}

		for (JSONObject iEntity : list) {
			Object objPKey = iEntity.opt(strPKeyField);
			if (objPKey == null || objPKey instanceof JSONNull || objPKey.toString().length() == 0) {
				// 父数据
				list2.add(iEntity);
			}
		}

		list.clear();
		list.addAll(list2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeGridModel#getParentDEField()
	 */
	@Override
	public String getParentDEField() {
		return strParentDEField;
	}

	/**
	 * 设置父属性
	 * 
	 * @param strParentDEField the strParentDEField to set
	 */
	protected void setParentDEField(String strParentDEField) {
		this.strParentDEField = strParentDEField;
	}
}
