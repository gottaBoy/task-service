package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.codelist.IDynamicCodeList;
import net.ibizsys.paas.control.panel.IPanel;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 面板属性项模型对象
 * 
 * @author lionlau
 *
 */
public class PanelFieldModel extends ModelBaseImpl implements IPanelFieldModel {
	
	private static final Log log = LogFactory.getLog(PanelFieldModel.class);

	protected IPanel iPanel = null;

	private String strCodeListId = "";
	
	private boolean bOutputCodeListConfig = false;

	private int nOutputCodeListConfigMode = IPanelFieldModel.OUTPUTCODELISTCONFIGMODE_NONE;
	
	protected IDataItem iDataItem = null;


	public PanelFieldModel() {
	}

	/**
	 * 初始化面板属性项
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {
		
	}

	/**
	 * 设置面板部件对象
	 * 
	 * @param iPanel
	 */
	public void setPanel(IPanel iPanel) {
		this.iPanel = iPanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.form.IPanelField#getPanel()
	 */
	@Override
	public IPanel getPanel() {
		return iPanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IPanelFieldModel#getPanelModel()
	 */
	@Override
	public IPanelModel getPanelModel() {
		return (IPanelModel) getPanel();
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.form.IPanelField#getOutputValue(net.ibizsys.paas.web.IWebContext, net.ibizsys.paas.data.IDataObject, boolean)
	 */
	@Override
	public Object getOutputValue(IWebContext iWebContext, IDataObject iDataObject, boolean bString) throws Exception {
		if (getDataItem() != null) {
			return this.getDataItem().getValue(iWebContext, iDataObject);
		}
		return iDataObject.get(this.getName());
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.form.IPanelField#getCodeList()
	 */
	@Override
	public ICodeList getCodeList() throws Exception {
		if (StringHelper.isNullOrEmpty(this.getCodeListId())) return null;
		return CodeListGlobal.getCodeList(this.getCodeListId());

	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.form.IPanelField#getCodeListId()
	 */
	@Override
	public String getCodeListId() {
		return this.strCodeListId;
	}

	/**
	 * 设置代码表标识
	 * 
	 * @param strCodeListId the strCodeListId to set
	 */
	public void setCodeListId(String strCodeListId) {
		this.strCodeListId = strCodeListId;
	}

	/**
	 * 设置面板属性项名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.panel.IPanelField#getConfig(net.ibizsys.paas.web.IWebContext, net.ibizsys.paas.data.IDataObject)
	 */
	@Override
	public JSONObject getConfig(IWebContext iWebContext, IDataObject iDataObject) throws Exception {
		if (getCodeList() != null) {
			if (isOutputCodeListConfig()) {
				ICodeList iCodeList = getCodeList();
				if (iCodeList != null) {
					JSONObject config = new JSONObject();
					fillCodeListConfig(config, iCodeList, iWebContext, iDataObject, "items");
					return config;
				}
			}
			return null;
		}
		return null;
	}

	/**
	 * 填充面板属性项代码表配置
	 * 
	 * @param config
	 * @param iCodeList
	 * @param iWebContext
	 * @param iDataObject
	 * @param strPropertyName
	 * @throws Exception
	 */
	protected void fillCodeListConfig(JSONObject config, ICodeList iCodeList, IWebContext iWebContext, IDataObject iDataObject, String strPropertyName) throws Exception {
		ArrayList<JSONObject> itemList = new ArrayList<JSONObject>();
		java.util.Iterator<ICodeItem> codeItems = null;
		if((this.getOutputCodeListConfigMode() & IPanelFieldModel.OUTPUTCODELISTCONFIGMODE_SELECTEDONLY)>0){
			String strValue = DataObject.getStringValue(iDataObject.get(this.getName()));
			if(strValue != null)
			{
				ICodeItem iCodeItem  =	iCodeList.getCodeItem(strValue, true);
				if(iCodeItem != null)
				{
					JSONObject item = new JSONObject();
					item.put("text", JSONObjectHelper.stripQuotes(this.getCodeItemText(iWebContext, iCodeItem),true));
					item.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue(),true));
					if (!StringHelper.isNullOrEmpty(iCodeItem.getParentValue())) {
						item.put("pvalue", JSONObjectHelper.stripQuotes(iCodeItem.getParentValue(),true));
					}
					if(iCodeItem.isDisableSelect()){
						item.put("disabled", true);
					}
					if(iCodeItem.getCodeItems()==null ||  !iCodeItem.getCodeItems().hasNext()){
						item.put("leaf", true);
					}
					else{
						if((this.getOutputCodeListConfigMode() & IPanelFieldModel.OUTPUTCODELISTCONFIGMODE_INCLUDECHILD)>0){
							fillCodeListItems(iWebContext,item,iCodeItem);
						}
					}
					itemList.add(item);
				}
			}
		}
		else{
			if (iCodeList instanceof IDynamicCodeList) {
				IDynamicCodeList iDynamicCodeList = (IDynamicCodeList) iCodeList;
				codeItems = iDynamicCodeList.queryCodeItems(iWebContext, iDataObject);
			} else
				codeItems = iCodeList.getCodeItems();
			
			while (codeItems.hasNext()) {
				ICodeItem iCodeItem = codeItems.next();
				JSONObject item = new JSONObject();
				item.put("text",JSONObjectHelper.stripQuotes( this.getCodeItemText(iWebContext, iCodeItem),true));
				item.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue(),true));
				if (!StringHelper.isNullOrEmpty(iCodeItem.getParentValue())) {
					item.put("pvalue", JSONObjectHelper.stripQuotes(iCodeItem.getParentValue(),true));
				}
				if(iCodeItem.isDisableSelect()){
					item.put("disabled", true);
				}
				if(iCodeItem.getCodeItems()==null || !iCodeItem.getCodeItems().hasNext()){
					item.put("leaf", true);
				}
				else{
					if(this.getOutputCodeListConfigMode() == IPanelFieldModel.OUTPUTCODELISTCONFIGMODE_INCLUDECHILD){
						fillCodeListItems(iWebContext,item,iCodeItem);
					}
				}
				itemList.add(item);
			}
		}
		
		config.put(strPropertyName, itemList.toArray());
	}

	/**
	 * 填充代码表项集合
	 * @param parentItem
	 * @param parentCodeItem
	 * @throws Exception
	 */
	protected void fillCodeListItems(JSONObject parentItem,ICodeItem parentCodeItem )throws Exception{
		fillCodeListItems(WebContext.getCurrent(),parentItem, parentCodeItem);
	}
	/**
	 * 填充代码表项集合
	 * @param iWebContext 
	 * @param parentItem
	 * @param parentCodeItem
	 * @throws Exception
	 */
	protected void fillCodeListItems(IWebContext iWebContext, JSONObject parentItem,ICodeItem parentCodeItem )throws Exception{
		ArrayList list = new ArrayList();
		Iterator items = parentCodeItem.getCodeItems();
		while(items.hasNext()){
			ICodeItem iCodeItem = (ICodeItem)items.next();
			JSONObject item = new JSONObject();
			item.put("text",JSONObjectHelper.stripQuotes( this.getCodeItemText(iWebContext, iCodeItem),true));
			item.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue(),true));
			if (!StringHelper.isNullOrEmpty(iCodeItem.getParentValue())) {
				item.put("pvalue", JSONObjectHelper.stripQuotes(iCodeItem.getParentValue(),true));
			}
			if(iCodeItem.isDisableSelect()){
				item.put("disabled", true);
			}
			if(iCodeItem.getCodeItems()==null || !iCodeItem.getCodeItems().hasNext()){
				item.put("leaf", true);
			}
			else{
				fillCodeListItems(iWebContext,item,iCodeItem);
			}
			list.add(item);
		}
		parentItem.put("items",list.toArray());
	}
	
	/**
	 * 获取代码项文本
	 * @param iWebContext
	 * @param iCodeItem
	 * @return
	 */
	protected String getCodeItemText(IWebContext iWebContext,ICodeItem iCodeItem){
		String strText = iCodeItem.getText();
		String strTextLanResTag = iCodeItem.getTextLanResTag();
		if(!StringHelper.isNullOrEmpty(strTextLanResTag)){
			strText = iWebContext.getLocalization(strTextLanResTag, strText);
		}
		return strText;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IPanelFieldModel#isOutputCodeListConfig()
	 */
	@Override
	public boolean isOutputCodeListConfig() {
		return bOutputCodeListConfig;
	}

	/**
	 * 设置输出代码表配置
	 * 
	 * @param bOutputCodeListConfig
	 */
	public void setOutputCodeListConfig(boolean bOutputCodeListConfig) {
		this.bOutputCodeListConfig = bOutputCodeListConfig;
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.IPanelFieldModel#getOutputCodeListConfigMode()
	 */
	@Override
	public int getOutputCodeListConfigMode() {
		return this.nOutputCodeListConfigMode;
	}

	
	/**
	 * 设置输出代码表配置模式
	 * @param nOutputCodeListConfigMode
	 */
	public void setOutputCodeListConfigMode(int  nOutputCodeListConfigMode) {
		this.nOutputCodeListConfigMode = nOutputCodeListConfigMode;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.form.IFormItem#getDataItem()
	 */
	@Override
	public IDataItem getDataItem() {
		return iDataItem;
	}

	/**
	 * 设置表单项数据对象
	 * 
	 * @param iDataItem
	 */
	public void setDataItem(IDataItem iDataItem) {
		this.iDataItem = iDataItem;
	}

	
}
