package net.ibizsys.paas.control.panel;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

/**
 * 面板属性项接口
 * 
 * @author lionlau
 *
 */
public interface IPanelField extends IModelBase {
	
	/**
	 * 获取数据项
	 * 
	 * @return
	 */
	IDataItem getDataItem();
	
	/**
	 * 获取动态面板项配置
	 * 
	 * @param iWebContext
	 * @param iDataObject
	 * @return
	 * @throws Exception
	 */
	JSONObject getConfig(IWebContext iWebContext, IDataObject iDataObject) throws Exception;

	/**
	 * 获取面板对象
	 * 
	 * @return
	 */
	IPanel getPanel();

	/**
	 * 获取对应的代码表
	 * 
	 * @return
	 */
	ICodeList getCodeList() throws Exception;


	/**
	 * 获取代码表标识
	 * 
	 * @return
	 */
	String getCodeListId();
	
	
	
	/**
	 * 输出到客户端的值
	 * @param iWebContext
	 * @param iDataObject
	 * @param bString 以字符串形式输出
	 * @return
	 * @throws Exception
	 */
	Object getOutputValue(IWebContext iWebContext, IDataObject iDataObject, boolean bString) throws Exception;
}
