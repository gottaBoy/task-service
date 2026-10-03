package net.ibizsys.paas.control.menu;

import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 菜单项
 * 
 * @author lionlau
 *
 */
public class MenuItem implements IMenuItem {
	/**
	 * 计数器标识
	 */
	public final static String MENUITEM_COUNTERID = "counterid";

	/**
	 * 菜单项标识
	 */
	public final static String MENUITEM_ID = "id";

	/**
	 * 父菜单项标识
	 */
	public final static String MENUITEM_PID = "pid";

	/**
	 * 显示文本
	 */
	public final static String MENUITEM_TEXT = "text";

	/**
	 * 图标路径
	 */
	public final static String MENUITEM_ICONPATH = "icon";

	/**
	 * 文本显示样式
	 */
	public final static String MENUITEM_TEXTCLS = "textcls";

	/**
	 * 图标显示样式
	 */
	public final static String MENUITEM_ICONCLS = "iconcls";

	/**
	 * 子项集合
	 */
	public final static String MENUITEM_ITEMS = "items";

	/**
	 * 是否为子节点
	 */
	public final static String MENUITEM_LEAF = "leaf";

	/**
	 * 是否默认展开
	 */
	public final static String MENUITEM_EXPANDED = "expanded";
	
	/**
	 * 提示
	 */
	public final static String MENUITEM_TOOLTIP = "tooltip";
	
	/**
	 * 提示语言资源标记
	 */
	public final static String MENUITEM_TOOLTIPLANRESTAG = "tooltiplanrestag";
	
	/**
	 * 显示文本语言资源标记
	 */
	public final static String MENUITEM_TEXTLANRESTAG = "textlanrestag";

	/**
	 * 权限标识
	 */
	public final static String MENUITEM_ACCESSKEY = "accesskey";
	
	/**
	 * 用户访问模式
	 */
	public final static String MENUITEM_ACCUSERMODE = "accusermode";
	

	private String strId = "";
	private String strText = "";
	private boolean bExpanded = false;
	private String strItemType = null;
	private int nAccUserMode = AccessUserModes.UNKNOWN;
	private String strAccessKey = null;
	private boolean bHidden = false;

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
	 * 文本语言资源标识
	 */
	private String strTextLanResTag = "";
	
	/**
	 * 提示信息
	 */
	private String strTooltip = "";
	
	/**
	 *  提示信息语言资源标识
	 */
	private String strTooltipLanResTag = "";
	
	
	/**
	 * 填充器对象
	 */
	private String strFillerObj = null;
	
	
	/**
	 * 菜单填充器对象
	 */
	private IMenuItemFiller iMenuItemFiller = null;

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getId()
	 */
	@Override
	public String getId() {
		return strId;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getText()
	 */
	@Override
	public String getText() {
		return this.strText;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#isExpanded()
	 */
	@Override
	public boolean isExpanded() {
		return this.bExpanded;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getPId()
	 */
	@Override
	public String getPId() {
		return this.strPId;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getTextCls()
	 */
	@Override
	public String getTextCls() {
		return this.strTextCls;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getIconCls()
	 */
	@Override
	public String getIconCls() {
		return this.strIconCls;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getIconPath()
	 */
	@Override
	public String getIconPath() {
		return this.strIconPath;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getCounterId()
	 */
	@Override
	public String getCounterId() {
		return this.strCounterId;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#setAttribute(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setAttribute(String strName, Object objValue) {

	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getAttribute(java.lang.String)
	 */
	@Override
	public Object getAttribute(String strName) {
		return null;
	}

	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置文本
	 * 
	 * @param strText
	 */
	public void setText(String strText) {
		this.strText = strText;
	}

	/**
	 * 设置默认展开
	 * 
	 * @param bExpanded
	 */
	public void setExpanded(boolean bExpanded) {
		this.bExpanded = bExpanded;
	}

	/**
	 * 设置父菜单项标识
	 * 
	 * @param strPId
	 */
	public void setPId(String strPId) {
		this.strPId = strPId;
	}

	/**
	 * 设置文本样式
	 * 
	 * @param strTextCls
	 */
	public void setTextCls(String strTextCls) {
		this.strTextCls = strTextCls;
	}

	/**
	 * 设置图标样式
	 * 
	 * @param strIconCls
	 */
	public void setIconCls(String strIconCls) {
		this.strIconCls = strIconCls;
	}

	/**
	 * 设置图标路径
	 * 
	 * @param strIconPath
	 */
	public void setIconPath(String strIconPath) {
		this.strIconPath = strIconPath;
	}

	/**
	 * 设置计数器标识
	 * 
	 * @param strCounterId
	 */
	public void setCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getItemType()
	 */
	@Override
	public String getItemType() {
		return this.strItemType;
	}

	/**
	 * 设置菜单项类型
	 * 
	 * @param strItemType
	 */
	public void setItemType(String strItemType) {
		this.strItemType = strItemType;
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

	/**
	 * 导出到JSON对象
	 * 
	 * @param iMenuItem
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(IMenuItem iMenuItem, JSONObject jsonObject) throws Exception {
		if (jsonObject == null) jsonObject = new JSONObject();
		jsonObject.put(MENUITEM_ID,JSONObjectHelper.stripQuotes( iMenuItem.getId(),true));
		IWebContext iWebContext = WebContext.getCurrent(); 
		if(iWebContext ==null)
		{
			jsonObject.put(MENUITEM_TEXT, JSONObjectHelper.stripQuotes(iMenuItem.getText(),true));
			jsonObject.put(MENUITEM_TOOLTIP, JSONObjectHelper.stripQuotes(iMenuItem.getTooltip(),true));
		}
		else{
			if(!StringHelper.isNullOrEmpty(iMenuItem.getTextLanResTag())){
				jsonObject.put(MENUITEM_TEXT,JSONObjectHelper.stripQuotes(iWebContext.getLocalization(iMenuItem.getTextLanResTag(),iMenuItem.getText()),true));
			}
			else{
				jsonObject.put(MENUITEM_TEXT, JSONObjectHelper.stripQuotes(iMenuItem.getText(),true));
			}
			if(!StringHelper.isNullOrEmpty(iMenuItem.getTooltipLanResTag())){
				jsonObject.put(MENUITEM_TOOLTIP,JSONObjectHelper.stripQuotes(iWebContext.getLocalization(iMenuItem.getTooltipLanResTag(),iMenuItem.getTooltip()),true));
			}
			else{
				jsonObject.put(MENUITEM_TOOLTIP, JSONObjectHelper.stripQuotes(iMenuItem.getTooltip(),true));
			}
		}
		
		jsonObject.put(MENUITEM_TEXTCLS, JSONObjectHelper.stripQuotes(iMenuItem.getTextCls(),true));
		jsonObject.put(MENUITEM_ICONPATH, JSONObjectHelper.stripQuotes(iMenuItem.getIconPath(),true));
		jsonObject.put(MENUITEM_ICONCLS, JSONObjectHelper.stripQuotes(iMenuItem.getIconCls(),true));
		jsonObject.put(MENUITEM_COUNTERID, JSONObjectHelper.stripQuotes(iMenuItem.getCounterId(),true));
		jsonObject.put(MENUITEM_EXPANDED, iMenuItem.isExpanded());
		
		
		
		return jsonObject;
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

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getTextLanResTag()
	 */
	@Override
	public String getTextLanResTag() {
		return this.strTextLanResTag;
	}
	
	
	/**
	 * 设置文本语言标识
	 * @param strTextLanResTag
	 */
	public void setTextLanResTag(String strTextLanResTag){
		this.strTextLanResTag = strTextLanResTag;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getTooltip()
	 */
	@Override
	public String getTooltip() {
		return this.strTooltip;
	}
	
	/**
	 * 设置提示信息
	 * @param strTooltip
	 */
	public void setTooltip(String strTooltip){
		this.strTooltip = strTooltip;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getTooltipLanResTag()
	 */
	@Override
	public String getTooltipLanResTag() {
		return  this.strTooltipLanResTag;
	}
	
	
	/**
	 * 设置提示信息语言标识
	 * @param strTooltipLanResTag
	 */
	public void setTooltipLanResTag(String strTooltipLanResTag){
		this.strTooltipLanResTag = strTooltipLanResTag;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#isHidden()
	 */
	@Override
	public boolean isHidden() {
		return bHidden;
	}
	
	/**
	 * 设置是否隐藏
	 * @param bHidden
	 */
	public void setHidden(boolean bHidden){
		this.bHidden = bHidden;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getFillerObj()
	 */
	@Override
	public String getFillerObj() {
		return this.strFillerObj;
	}
	
	/**
	 * 设置填充器对象
	 * @param strFillerObj
	 */
	public void setFillerObj(String strFillerObj){
		this.strFillerObj = strFillerObj;
	}


	@Override
	public IMenuItemFiller getFiller() throws Exception {
		if(StringHelper.isNullOrEmpty(getFillerObj()))
			return null;
		if(this.iMenuItemFiller ==null){
			this.iMenuItemFiller = (IMenuItemFiller)ObjectHelper.create(this.getFillerObj());
		}
		return this.iMenuItemFiller;
	}
	
	
	

}
