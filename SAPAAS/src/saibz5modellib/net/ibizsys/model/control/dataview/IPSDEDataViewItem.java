package net.ibizsys.model.control.dataview;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.core.IPSModelObject;


/**
 * 实体数据视图数据项对象接口
 * @author lionlau
 *
 */
public interface IPSDEDataViewItem extends IPSModelObject
{
	
	/**
	 * 获取实体列表
	 * @return
	 */
	IPSDEDataView getPSDEDataView();
	
	
	
	/**
	 * 获取数据项名称
	 * @return
	 */
	String getDataItemName();
	
	
	
	/**
	 * 获取值格式化
	 * @return
	 */
	String getValueFormat();

	
	/**
	 * 获取数据字段集合
	 * @return
	 */
	String[] getFields();
	
	
	/**
	 * 获取代码表对象
	 * @return
	 */
	IPSCodeList getPSCodeList();
	
	
	/**
	 * 获取代码表转换模式，是前台转换或是后台转换
	 * @return
	 */
	String getCLConvertMode();

}
