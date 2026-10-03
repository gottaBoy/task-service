package net.ibizsys.paas.control.expbar;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

/**
 * 导航栏数据项
 * 
 * @author lionlau
 *
 */
public class ExpBarItem implements IExpBarItem {
	/**
	 * 计数器标识
	 */
	public final static String EXPBARITEM_COUNTERID = "counterid";

	/**
	 * 计数器模式
	 */
	public final static String EXPBARITEM_COUNTERMODE = "countermode";

	/**
	 * 数据项标识
	 */
	public final static String EXPBARITEM_ID = "id";

	/**
	 * 父数据项标识
	 */
	public final static String EXPBARITEM_PID = "pid";

	/**
	 * 显示文本
	 */
	public final static String EXPBARITEM_TEXT = "text";

	/**
	 * 图标路径
	 */
	public final static String EXPBARITEM_ICONPATH = "icon";

	/**
	 * 文本显示样式
	 */
	public final static String EXPBARITEM_TEXTCLS = "textcls";

	/**
	 * 图标显示样式
	 */
	public final static String EXPBARITEM_ICONCLS = "iconcls";

	/**
	 * 子项集合
	 */
	public final static String EXPBARITEM_ITEMS = "items";

	/**
	 * 是否为子节点
	 */
	public final static String EXPBARITEM_LEAF = "leaf";

	/**
	 * 导航视图标识
	 */
	public final static String EXPBARITEM_VIEWID = "viewid";

	/**
	 * 导航数据项
	 */
	public final static String EXPBARITEM_EXPITEM = "expitem";

	/**
	 * 视图参数
	 */
	public final static String EXPBARITEM_VIEWPARAM = "viewparam";

	/**
	 * 是否默认展开
	 */
	public final static String EXPBARITEM_EXPANDED = "expanded";

	/**
	 * 文本语言资源标识
	 */
	public final static String EXPBARITEM_TEXTLANRESTAG = "textlanrestag";

	private String strId = "";
	private String strText = "";
	private boolean bExpanded = false;
	private String strExpViewId = "";

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
	 * 获取计数器标识
	 * 
	 * @return
	 */
	private String strCounterId = "";

	/**
	 * 获取计数器模式
	 */
	private int nCounterMode = COUNTERMODE_NONE;

	/**
	 * 文本语言资源标识
	 * 
	 * @return
	 */
	private String strTextLanResTag = "";
	
	private ArrayList<IExpBarItem> items = new ArrayList<IExpBarItem>();

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
	public ArrayList<IExpBarItem> getItems() {
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
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getCounterId()
	 */
	@Override
	public String getCounterId() {
		return this.strCounterId;
	}

	/**
	 * 获取计数器模式
	 * 
	 * @return
	 */
	@Override
	public int getCounterMode() {
		return this.nCounterMode;
	}

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
	 * @param strId the strId to set
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * @param strText the strText to set
	 */
	public void setText(String strText) {
		this.strText = strText;
	}

	/**
	 * @param bExpanded the bExpanded to set
	 */
	public void setExpanded(boolean bExpanded) {
		this.bExpanded = bExpanded;
	}

	/**
	 * @param strPId the strPId to set
	 */
	public void setPId(String strPId) {
		this.strPId = strPId;
	}

	/**
	 * @param strTextCls the strTextCls to set
	 */
	public void setTextCls(String strTextCls) {
		this.strTextCls = strTextCls;
	}

	/**
	 * @param strIconCls the strIconCls to set
	 */
	public void setIconCls(String strIconCls) {
		this.strIconCls = strIconCls;
	}

	/**
	 * @param strIconPath the strIconPath to set
	 */
	public void setIconPath(String strIconPath) {
		this.strIconPath = strIconPath;
	}

	/**
	 * @param strCounterId the strCounterId to set
	 */
	public void setCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}

	/**
	 * @param strCounterId the strCounterId to set
	 */
	public void setCounterMode(int nCounterMode) {
		this.nCounterMode = nCounterMode;
	}

	/**
	 * 导出到JSON对象
	 * 
	 * @param iExpBarItem
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(IExpBarItem iExpBarItem, JSONObject jsonObject) throws Exception {
		if (jsonObject == null) jsonObject = new JSONObject();
		jsonObject.put(EXPBARITEM_ID, JSONObjectHelper.stripQuotes(iExpBarItem.getId(),true));
		jsonObject.put(EXPBARITEM_TEXT, JSONObjectHelper.stripQuotes(iExpBarItem.getText(),true));
		jsonObject.put(EXPBARITEM_TEXTCLS, JSONObjectHelper.stripQuotes(iExpBarItem.getTextCls(),true));
		jsonObject.put(EXPBARITEM_ICONPATH, JSONObjectHelper.stripQuotes(iExpBarItem.getIconPath(),true));
		jsonObject.put(EXPBARITEM_ICONCLS, JSONObjectHelper.stripQuotes(iExpBarItem.getIconCls(),true));
		jsonObject.put(EXPBARITEM_COUNTERID, JSONObjectHelper.stripQuotes(iExpBarItem.getCounterId(),true));
		if (iExpBarItem.getCounterMode() != COUNTERMODE_NONE) {
			jsonObject.put(EXPBARITEM_COUNTERMODE, iExpBarItem.getCounterMode());
		}
		jsonObject.put(EXPBARITEM_EXPANDED, iExpBarItem.isExpanded());

		JSONObject expItemJO = new JSONObject();
		expItemJO.put(EXPBARITEM_VIEWID, JSONObjectHelper.stripQuotes(iExpBarItem.getExpViewId(),true));

		JSONObject viewParamJO = new JSONObject();

		java.util.Iterator<String> viewParamKeys = iExpBarItem.getViewParamNames();
		while (viewParamKeys.hasNext()) {
			String strKey = viewParamKeys.next();
			Object objValue = iExpBarItem.getViewParam(strKey);
			JSONObjectHelper.put(viewParamJO, strKey, objValue);
		}
		expItemJO.put(EXPBARITEM_VIEWPARAM, viewParamJO);

		jsonObject.put(EXPBARITEM_EXPITEM, expItemJO);

		if (iExpBarItem.getItems().size() == 0) {
			jsonObject.put(EXPBARITEM_LEAF, true);
		} else {
			ArrayList<JSONObject> items = new ArrayList<JSONObject>();
			for (IExpBarItem childExpBarItem : iExpBarItem.getItems()) {
				JSONObject jsonItem = toJSONObject(childExpBarItem, null);
				items.add(jsonItem);
			}
			jsonObject.put(EXPBARITEM_ITEMS, items.toArray());
		}
		return jsonObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getExpViewId()
	 */
	@Override
	public String getExpViewId() {
		return this.strExpViewId;
	}

	/**
	 * @param strExpViewId the strExpViewId to set
	 */
	public void setExpViewId(String strExpViewId) {
		this.strExpViewId = strExpViewId;
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
	 * 获取视图参数的名称集合
	 * 
	 * @return
	 */
	public java.util.Iterator<String> getViewParamNames() {
		return this.viewParamMap.keySet().iterator();
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

}
