package net.ibizsys.paas.control.drctrl;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.ctrlmodel.IDRCtrlModel;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

/**
 * 数据关系部件数据项
 * 
 * @author lionlau
 *
 */
public class DRCtrlItem implements IDRCtrlItem {
	/**
	 * 计数器标识
	 */
	public final static String DRCTRLITEM_COUNTERID = "counterid";
	
	/**
	 * 计数器模式
	 */
	public final static String DRCTRLITEM_COUNTERMODE = "countermode";
	

	/**
	 * 数据项标识
	 */
	public final static String DRCTRLITEM_ID = "id";

	/**
	 * 父数据项标识
	 */
	public final static String DRCTRLITEM_PID = "pid";

	/**
	 * 显示文本
	 */
	public final static String DRCTRLITEM_TEXT = "text";

	/**
	 * 图标路径
	 */
	public final static String DRCTRLITEM_ICONPATH = "icon";

	/**
	 * 文本显示样式
	 */
	public final static String DRCTRLITEM_TEXTCLS = "textcls";

	/**
	 * 图标显示样式
	 */
	public final static String DRCTRLITEM_ICONCLS = "iconcls";

	/**
	 * 子项集合
	 */
	public final static String DRCTRLITEM_ITEMS = "items";

	/**
	 * 是否为子节点
	 */
	public final static String DRCTRLITEM_LEAF = "leaf";

	/**
	 * 关系视图标识
	 */
	public final static String DRCTRLITEM_VIEWID = "viewid";

	/**
	 * 关系数据项
	 */
	public final static String DRCTRLITEM_DRITEM = "dritem";

	/**
	 * 视图参数
	 */
	public final static String DRCTRLITEM_VIEWPARAM = "viewparam";

	/**
	 * 是否默认展开
	 */
	public final static String DRCTRLITEM_EXPANDED = "expanded";

	/**
	 * 启用标志
	 */
	public final static String DRCTRLITEM_ENABLED = "enabled";
	
	
	/**
	 * 文本语言资源标识
	 */
	public final static String EXPBARITEM_TEXTLANRESTAG = "textlanrestag";
	
	
	/**
	 * 扩展数据树标识
	 */
	public final static String DRCTRLITEM_DATATREEID = "datatreeid";
	

	private String strId = "";
	private String strText = "";
	private boolean bExpanded = false;
	private String strDRViewId = "";
	private int nAccUserMode = AccessUserModes.UNKNOWN;
	private String strAccessKey = null;
	private String strEnableMode = ENABLEMODE_ALL;
	private String strTestEnableDEActionName = null;
	private String strTestEnableDEOPPriv = null;

	private HashMap<String, String> viewParamMap = new HashMap<String, String>();

	/**
	 * 获取父标识
	 * 
	 * @return
	 */
	private String strPId = "";

	/**
	 * 获取文本样式
	 * 
	 * @return
	 */
	private String strTextCls = "";

	/**
	 * 获取图标样式
	 * 
	 * @return
	 */
	private String strIconCls = "";

	/**
	 * 获取图标路径
	 * 
	 * @return
	 */
	private String strIconPath = "";

	/**
	 * 获取图标样式（X）
	 * 
	 * @return
	 */
	private String strIconClsX = "";

	/**
	 * 获取图标路径（X）
	 * 
	 * @return
	 */
	private String strIconPathX = "";
	
	/**
	 * 获取计数器标识
	 * 
	 * @return
	 */
	private String strCounterId = "";
	
//	/**
//	 * 获取计数器模式
//	 * 
//	 * @return
//	 */
//	private int nCounterMode = 0;
	

	
	/**
	 * 文本语言资源标识
	 * 
	 * @return
	 */
	private String strTextLanResTag = "";
	
	
	/**
	 * 数据树标识
	 */
	private String strDataTreeId = "";
	
	
	private ArrayList<IDRCtrlItem> items = new ArrayList<IDRCtrlItem>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getId()
	 */
	@Override
	public String getId() {
		return strId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getText()
	 */
	@Override
	public String getText() {
		return this.strText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#isExpanded()
	 */
	@Override
	public boolean isExpanded() {
		return this.bExpanded;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getItems()
	 */
	@Override
	public ArrayList<IDRCtrlItem> getItems() {
		return this.items;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getPId()
	 */
	@Override
	public String getPId() {
		return this.strPId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getTextCls()
	 */
	@Override
	public String getTextCls() {
		return this.strTextCls;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getIconCls()
	 */
	@Override
	public String getIconCls() {
		return this.strIconCls;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getIconPath()
	 */
	@Override
	public String getIconPath() {
		return this.strIconPath;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getIconClsX()
	 */
	@Override
	public String getIconClsX() {
		return this.strIconClsX;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getIconPathX()
	 */
	@Override
	public String getIconPathX() {
		return this.strIconPathX;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getCounterId()
	 */
	@Override
	public String getCounterId() {
		return this.strCounterId;
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getCounterMode()
//	 */
//	@Override
//	public int getCounterMode() {
//		return this.nCounterMode;
//	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#setAttribute(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setAttribute(String strName, Object objValue) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getAttribute(java.lang.String)
	 */
	@Override
	public Object getAttribute(String strName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 设置标识
	 * 
	 * @param strId the strId to set
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置显示文本
	 * 
	 * @param strText the strText to set
	 */
	public void setText(String strText) {
		this.strText = strText;
	}

	/**
	 * 是否默认展开
	 * 
	 * @param bExpanded the bExpanded to set
	 */
	public void setExpanded(boolean bExpanded) {
		this.bExpanded = bExpanded;
	}

	/**
	 * 设置父项标识
	 * 
	 * @param strPId the strPId to set
	 */
	public void setPId(String strPId) {
		this.strPId = strPId;
	}

	/**
	 * 设置文本显示样式
	 * 
	 * @param strTextCls the strTextCls to set
	 */
	public void setTextCls(String strTextCls) {
		this.strTextCls = strTextCls;
	}

	/**
	 * 设置图标显示式样
	 * 
	 * @param strIconCls the strIconCls to set
	 */
	public void setIconCls(String strIconCls) {
		this.strIconCls = strIconCls;
	}

	/**
	 * 设置图标路径
	 * 
	 * @param strIconPath the strIconPath to set
	 */
	public void setIconPath(String strIconPath) {
		this.strIconPath = strIconPath;
	}

	/**
	 * 设置图标显示式样（X）
	 * 
	 * @param strIconClsX the strIconClsX to set
	 */
	public void setIconClsX(String strIconClsX) {
		this.strIconClsX = strIconClsX;
	}

	/**
	 * 设置图标路径（X）
	 * 
	 * @param strIconPathX the strIconPathX to set
	 */
	public void setIconPathX(String strIconPathX) {
		this.strIconPathX = strIconPathX;
	}
	
	/**
	 * 设置计数器标识
	 * 
	 * @param strCounterId the strCounterId to set
	 */
	public void setCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}
	
//	/**
//	 * 设置计数器模式
//	 * 
//	 * @param nCounterMode the nCounterMode to set
//	 */
//	public void setCounterMode(int nCounterMode) {
//		this.nCounterMode = nCounterMode;
//	}
//	

	/**
	 * 导出到JSON对象
	 * 
	 * @param iExpBarItem
	 * @param jsonObject
	 * @param iDRCtrlModel
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(IDRCtrlItem iExpBarItem, JSONObject jsonObject, IDRCtrlModel iDRCtrlModel) throws Exception {
		if (jsonObject == null) jsonObject = new JSONObject();
		jsonObject.put(DRCTRLITEM_ID, JSONObjectHelper.stripQuotes(iExpBarItem.getId(),true));
		jsonObject.put(DRCTRLITEM_TEXT,  JSONObjectHelper.stripQuotes(iExpBarItem.getText(),true));
		if(!StringHelper.isNullOrEmpty(iExpBarItem.getTextCls())){
			jsonObject.put(DRCTRLITEM_TEXTCLS,  JSONObjectHelper.stripQuotes(iExpBarItem.getTextCls(),true));
		}
		if(!StringHelper.isNullOrEmpty(iExpBarItem.getIconPath())){
			jsonObject.put(DRCTRLITEM_ICONPATH, JSONObjectHelper.stripQuotes(iDRCtrlModel.getViewController().getAppModel().getAppPFHelper().mapImageRealUrl(iExpBarItem.getIconPath()),true));
			
		}
		if(!StringHelper.isNullOrEmpty(iExpBarItem.getIconCls())){
			jsonObject.put(DRCTRLITEM_ICONCLS,  JSONObjectHelper.stripQuotes(iExpBarItem.getIconCls(),true));
		}
		
		jsonObject.put(DRCTRLITEM_COUNTERID,  JSONObjectHelper.stripQuotes(iExpBarItem.getCounterId(),true));
//		if(iExpBarItem.getCounterMode()>0) {
//			jsonObject.put(DRCTRLITEM_COUNTERMODE,  iExpBarItem.getCounterMode());
//		}
		
		jsonObject.put(DRCTRLITEM_EXPANDED, iExpBarItem.isExpanded());

		if (iDRCtrlModel != null) {
			jsonObject.put(DRCtrlItem.DRCTRLITEM_ENABLED, iDRCtrlModel.testDRCtrlItemEnabled(iExpBarItem));
		}

		JSONObject drItemJO = new JSONObject();
		drItemJO.put(DRCTRLITEM_VIEWID,  JSONObjectHelper.stripQuotes(iExpBarItem.getDRViewId(),true));

		JSONObject viewParamJO = new JSONObject();

		java.util.Iterator<String> viewParamKeys = iExpBarItem.getViewParamNames();
		while (viewParamKeys.hasNext()) {
			String strKey = viewParamKeys.next();
			Object objValue = iExpBarItem.getViewParam(strKey);
			JSONObjectHelper.put(viewParamJO, strKey, objValue);
		}
		drItemJO.put(DRCTRLITEM_VIEWPARAM, viewParamJO);

		jsonObject.put(DRCTRLITEM_DRITEM, drItemJO);

		if (iExpBarItem.getItems().size() == 0) {
			if(StringHelper.isNullOrEmpty(iExpBarItem.getDataTreeId())){
				jsonObject.put(DRCTRLITEM_LEAF, true);
			}
			else{
				jsonObject.put(DRCTRLITEM_LEAF, false);
			}
		} else {
			ArrayList<JSONObject> items = new ArrayList<JSONObject>();
			for (IDRCtrlItem childExpBarItem : iExpBarItem.getItems()) {
				JSONObject jsonItem = toJSONObject(childExpBarItem, null, iDRCtrlModel);
				items.add(jsonItem);
			}
			jsonObject.put(DRCTRLITEM_ITEMS, items.toArray());
		}
		
		if(!StringHelper.isNullOrEmpty(iExpBarItem.getDataTreeId())){
			jsonObject.put(DRCTRLITEM_DATATREEID, JSONObjectHelper.stripQuotes(iExpBarItem.getDataTreeId(),true));
		}
		return jsonObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getDRViewId()
	 */
	@Override
	public String getDRViewId() {
		return this.strDRViewId;
	}

	/**
	 * 设置关系视图标识
	 * 
	 * @param strDRViewId the strDRViewId to set
	 */
	public void setDRViewId(String strDRViewId) {
		this.strDRViewId = strDRViewId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#setViewParam(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setViewParam(String strKey, String objValue) {
		if (objValue == null) {
			this.viewParamMap.remove(strKey.toLowerCase());
		} else {
			this.viewParamMap.put(strKey.toLowerCase(), objValue);
		}
	}

	/**
	 * 设置视图参数
	 * 
	 * @param strKey
	 * @return
	 */
	public String getViewParam(String strKey) {
		return this.viewParamMap.get(strKey.toLowerCase());
	}

	/**
	 * 获取视图参数名称集合
	 * 
	 * @return
	 */
	public java.util.Iterator<String> getViewParamNames() {
		return this.viewParamMap.keySet().iterator();
	}

	/**
	 * 重置子项及视图参数
	 */
	public void reset() {
		items.clear();
		viewParamMap.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getAccessKey()
	 */
	@Override
	public String getAccessKey() {
		return this.strAccessKey;
	}

	/**
	 * 设置菜单项资源编号
	 * 
	 * @param strAccessKey
	 */
	public void setAccessKey(String strAccessKey) {
		this.strAccessKey = strAccessKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getAccUserMode()
	 */
	@Override
	public int getAccUserMode() {
		return nAccUserMode;
	}

	/**
	 * 设置用户访问模式
	 * 
	 * @param nAccUserMode
	 */
	public void setAccUserMode(int nAccUserMode) {
		this.nAccUserMode = nAccUserMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.drctrl.IDRCtrlItem#getEnableMode()
	 */
	@Override
	public String getEnableMode() {
		return this.strEnableMode;
	}

	/**
	 * 设置启用模式
	 * 
	 * @param strEnableMode
	 */
	public void setEnableMode(String strEnableMode) {
		this.strEnableMode = strEnableMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.drctrl.IDRCtrlItem#getTestEnableDEActionName()
	 */
	@Override
	public String getTestEnableDEActionName() {
		return this.strTestEnableDEActionName;
	}

	/**
	 * 设置判断输出实体行为名称
	 * 
	 * @param strTestEnableDEActionName
	 */
	public void setTestEnableDEActionName(String strTestEnableDEActionName) {
		this.strTestEnableDEActionName = strTestEnableDEActionName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.drctrl.IDRCtrlItem#getTestEnableDEOPPriv()
	 */
	@Override
	public String getTestEnableDEOPPriv() {
		return this.strTestEnableDEOPPriv;
	}

	/**
	 * 设置判断输出实体操作标识
	 * 
	 * @param strTestEnableDEOPPriv
	 */
	public void setTestEnableDEOPPriv(String strTestEnableDEOPPriv) {
		this.strTestEnableDEOPPriv = strTestEnableDEOPPriv;
	}
	
	/**
	 * 设置文本语言资源标识
	 * @param strTextLanResTag
	 */
	public void setTextLanResTag(String strTextLanResTag) {
		this.strTextLanResTag = strTextLanResTag;
	}

	/**
	 * 获取文本语言资源标识
	 */
	@Override
	public String getTextLanResTag() {
		return strTextLanResTag;
	}

	@Override
	public String getDataTreeId() {
		return this.strDataTreeId;
	}

	
	/**
	 * 设置数据树标识
	 * @param strDataTreeId
	 */
	public void setDataTreeId(String strDataTreeId){
		this.strDataTreeId = strDataTreeId;
	}
	
}
