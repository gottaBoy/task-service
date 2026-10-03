package net.ibizsys.model.control.list;

import net.ibizsys.model.control.IPSMDAjaxControl;
import net.ibizsys.paas.control.list.IList;

/**
 * 数据列表控件对象接口
 * @author lionlau
 *
 */
public interface IPSList extends  IPSMDAjaxControl,IList
{
	/**
	 * 获取列表项集合
	 * @return
	 */
	java.util.Iterator<IPSListItem> getPSListItems();
	
	
	
	
	
	/**
	 * 获取列表的数据项集合
	 * @return
	 */
	java.util.Iterator<IPSListDataItem> getPSListDataItems();
	
	
	
//	/**
//	 * 获取无值显示内容语言资源对象
//	 * @return
//	 */
//	IPSLanguageRes getEmptyTextPSLanguageRes();
	
	
	/**
	 * 获取无值显示内容
	 * @return
	 */
	String getEmptyText();
	
	
	
	/**
	 * 获取指定列表数据项
	 * @param strDataItemName
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IPSListDataItem getPSListDataItem(String strDataItemName,boolean bTryMode) throws Exception;

}
