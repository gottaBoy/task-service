package net.ibizsys.paas.control.gantt;

import java.util.Iterator;

import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.SimpleXmlNode;
import net.sf.json.JSONObject;

/**
 * 甘特项对象
 * 
 * @author Administrator
 *
 */
public class GanttItem extends SimpleXmlNode implements IGanttItem {
	
	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(GanttItem.class);
	
	public final static String GANTTITEM_GANTTITEM = "SRFEXGANTTITEM";

	public final static String GANTTITEM_TEXT = "TEXT";
	public final static String GANTTITEM_TIPS = "TIPS";
	public final static String GANTTITEM_CSSCLASS = "CSSCLASS";
	public final static String GANTTITEM_ICONCSSCLASS = "ICONCSSCLASS";
	public final static String GANTTITEM_ICON = "ICON";
	public final static String GANTTITEM_HREF = "HREF";
	public final static String GANTTITEM_HREFTARGET = "HREFTARGET";
	public final static String GANTTITEM_TAG = "TAG";
	public final static String GANTTITEM_CONTENT = "CONTENT";
	public final static String GANTTITEM_BEGINTIME = "BEGINTIME";
	public final static String GANTTITEM_ENDTIME = "ENDTIME";
	public final static String GANTTITEM_COLOR = "COLOR";
	public final static String GANTTITEM_BKCOLOR = "BKCOLOR";
	public final static String GANTTITEM_DISABLE = "DISABLE";
	public final static String GANTTITEM_TYPE = "TYPE";
	
	protected String strText = "";
	protected String strTips = "";
	protected String strCssClass = "";
	protected String strIconCssClass = "";
	protected String strIcon = "";

	protected String strHref = "";
	protected String strHrefTarget = "";
	
	private String strItemType = "";
	private String strContent = "";
	private String strColor = "";
	private String strBKColor = "";
	private java.sql.Timestamp beginTime = null;
	private java.sql.Timestamp endTime = null;
	private boolean bDisable = false;

	protected JSONObject tagObj = null;

	private Object dataSource = null;

	public GanttItem() {

	}



	@Override
	protected void onSetAttribute(String strName, String strValue) {
		
		if (StringHelper.compare(strName, GANTTITEM_TIPS, true) == 0) {
			strTips = strValue;
			return;
		}
		
		if (StringHelper.compare(strName, GANTTITEM_TAG, true) == 0) {
			tagObj = JSONObjectHelper.fromString(strValue);
			return;
		}

		if (StringHelper.compare(strName, GANTTITEM_HREFTARGET, true) == 0) {
			strHrefTarget = strValue;
			return;
		}

		if (StringHelper.compare(strName, GANTTITEM_HREF, true) == 0) {
			strHref = strValue;
			return;
		}

		if (StringHelper.compare(strName, GANTTITEM_CSSCLASS, true) == 0) {
			strCssClass = strValue;
			return;
		}

		if (StringHelper.compare(strName, GANTTITEM_ICONCSSCLASS, true) == 0) {
			strIconCssClass = strValue;
			return;
		}

		if (StringHelper.compare(strName, GANTTITEM_ICON, true) == 0) {
			strIcon = strValue;
			return;
		}

		if (StringHelper.compare(strName, GANTTITEM_TEXT, true) == 0) {
			this.strText = strValue;
			return;
		}

		if (StringHelper.compare(strName, GANTTITEM_CONTENT, true) == 0) {
			this.strContent = strValue;
			return;
		}
		
		if (StringHelper.compare(strName, GANTTITEM_COLOR, true) == 0) {
			this.strColor = strValue;
			return;
		}
		
		if (StringHelper.compare(strName, GANTTITEM_BKCOLOR, true) == 0) {
			this.strBKColor = strValue;
			return;
		}
		
		if (StringHelper.compare(strName, GANTTITEM_TYPE, true) == 0) {
			this.strItemType = strValue;
			return;
		}
		
		
		if (StringHelper.compare(strName, GANTTITEM_DISABLE, true) == 0) {
			bDisable = getValue(strValue, bDisable);
			return;
		}
		
		if (StringHelper.compare(strName, GANTTITEM_BEGINTIME, true) == 0) {
		
			try{
				this.beginTime = new java.sql.Timestamp( DateHelper.parse(strValue).getTime());
			}
			catch(Exception ex){
				log.error(ex);
			}
			return;
		}
		
		if (StringHelper.compare(strName, GANTTITEM_ENDTIME, true) == 0) {
			try{
				this.endTime = new java.sql.Timestamp( DateHelper.parse(strValue).getTime());
			}
			catch(Exception ex){
				log.error(ex);
			}
			return;
		}
		
		super.onSetAttribute(strName, strValue);
	}

	
	/**
	 * 获取样式
	 * 
	 * @return
	 */
	public String getCssClass() {
		return strCssClass;
	}

	/**
	 * 设置样式
	 * 
	 * @param strCssClass
	 */
	public void setCssClass(String strCssClass) {
		this.strCssClass = strCssClass;
	}

	/**
	 * 获取图标样式
	 * 
	 * @return
	 */
	public String getIconCssClass() {
		return strIconCssClass;
	}

	/**
	 * 设置图标样式
	 * 
	 * @param strIconCssClass
	 */
	public void setIconCssClass(String strIconCssClass) {
		this.strIconCssClass = strIconCssClass;
	}

	/**
	 * 获取图标
	 * 
	 * @return
	 */
	public String getIcon() {
		return strIcon;
	}

	/**
	 * 设置图标
	 * 
	 * @param strIcon
	 */
	public void setIcon(String strIcon) {
		this.strIcon = strIcon;
	}

	/**
	 * 获取链接
	 * 
	 * @return
	 */
	public String getHref() {
		return strHref;
	}

	/**
	 * 设置链接
	 * 
	 * @param strHref
	 */
	public void setHref(String strHref) {
		this.strHref = strHref;
	}

	/**
	 * 获取链接目标
	 * 
	 * @return
	 */
	public String getHrefTarget() {
		return strHrefTarget;
	}

	/**
	 * 设置链接目标
	 * 
	 * @param strHrefTarget
	 */
	public void setHrefTarget(String strHrefTarget) {
		this.strHrefTarget = strHrefTarget;
	}

	/**
	 * 获取甘特项提示信息
	 * 
	 * @return
	 */
	public String getTips() {
		return strTips;
	}

	/**
	 * 设置甘特项提示信息
	 * 
	 * @param strTips
	 */
	public void setTips(String strTips) {
		this.strTips = strTips;
	}

	/**
	 * 获取甘特项文本
	 * 
	 * @return
	 */
	public String getText() {
		return strText;
	}

	/**
	 * 设置甘特项文本
	 * 
	 * @param strText
	 */
	public void setText(String strText) {
		this.strText = strText;
	}



	/**
	 * 获取甘特项内容
	 * 
	 * @return
	 */
	public String getContent() {
		return strContent;
	}

	/**
	 * 设置甘特项内容
	 * 
	 * @param strContent
	 */
	public void setContent(String strContent) {
		this.strContent = strContent;
	}

	/**
	 * 获取甘特项字体颜色
	 * 
	 * @return
	 */
	public String getColor() {
		return strColor;
	}

	/**
	 * 设置甘特项字体颜色
	 * 
	 * @param strColor
	 */
	public void setColor(String strColor) {
		this.strColor = strColor;
	}
	
	
	/**
	 * 获取甘特项背景颜色
	 * 
	 * @return
	 */
	public String getBKColor() {
		return strBKColor;
	}

	/**
	 * 设置甘特项背景颜色
	 * 
	 * @param strBKColor
	 */
	public void setBKColor(String strBKColor) {
		this.strBKColor = strBKColor;
	}
	

	/**
	 * 获取甘特项开始时间
	 * 
	 * @return
	 */
	public java.sql.Timestamp getBeginTime() {
		return beginTime;
	}

	/**
	 * 设置甘特项开始时间
	 * 
	 * @param strBKColor
	 */
	public void setBeginTime(java.sql.Timestamp beginTime) {
		this.beginTime = beginTime;
	}
	
	
	/**
	 * 获取甘特项结束时间
	 * 
	 * @return
	 */
	public java.sql.Timestamp getEndTime() {
		return endTime;
	}

	/**
	 * 设置甘特项结束时间
	 * 
	 * @param strBKColor
	 */
	public void setEndTime(java.sql.Timestamp endTime) {
		this.endTime = endTime;
	}
	
	
	
	/**
	 * 设置标记值
	 * 
	 * @param strKey
	 * @param objValue
	 */
	public void setTagValue(String strKey, Object objValue) {
		if (tagObj == null) tagObj = new JSONObject();

		if (tagObj.has(strKey)) {
			tagObj.remove(strKey);
		}

		if (objValue == null) {
			return;
		} else {
			tagObj.put(strKey,JSONObjectHelper.stripQuotes(objValue));
		}
	}

	/**
	 * 获取甘特项的标记值
	 * 
	 * @param strKey
	 * @return
	 */
	public Object getTagValue(String strKey) {
		return tagObj.get(strKey);
	}

	/**
	 * 获取标记数据
	 * 
	 * @return
	 */
	public JSONObject getTag() {
		return tagObj;
	}

	/**
	 * 导出甘特项到Json
	 * 
	 * @param calendarItem
	 * @param bSimple
	 * @return
	 */
	public static JSONObject toJSONObject(IGanttItem calendarItem, boolean bSimple) {
		JSONObject objJSON = new JSONObject();

		objJSON.put("id", JSONObjectHelper.stripQuotes( calendarItem.getId(),true));
		objJSON.put("text", JSONObjectHelper.stripQuotes( calendarItem.getText(),true));
		objJSON.put("content", JSONObjectHelper.stripQuotes( calendarItem.getContent(),true));
		if(!StringHelper.isNullOrEmpty(calendarItem.getColor())){
			objJSON.put("color", JSONObjectHelper.stripQuotes( calendarItem.getColor(),true));
		}
		if(!StringHelper.isNullOrEmpty(calendarItem.getBKColor())){
			objJSON.put("bkcolor", JSONObjectHelper.stripQuotes( calendarItem.getBKColor(),true));
		}
		if(!StringHelper.isNullOrEmpty(calendarItem.getItemType())){
			objJSON.put("type", JSONObjectHelper.stripQuotes( calendarItem.getItemType(),true));
		}
		
		if(calendarItem.getBeginTime()!=null){
			objJSON.put("begintime",DateHelper.toDateTimeString(calendarItem.getBeginTime()));
		}
		
		if(calendarItem.getEndTime()!=null){
			objJSON.put("endtime",DateHelper.toDateTimeString(calendarItem.getEndTime()));
		}
		
		if (!StringHelper.isNullOrEmpty(calendarItem.getTips()) || !bSimple) {
			objJSON.put("qtip",JSONObjectHelper.stripQuotes(  calendarItem.getTips(),true));
		}

		if (!StringHelper.isNullOrEmpty(calendarItem.getCssClass()) || !bSimple) {
			objJSON.put("cls", JSONObjectHelper.stripQuotes( calendarItem.getCssClass(),true));
		}

		if (calendarItem.isDisabled() || !bSimple){
			objJSON.put("disabled", calendarItem.isDisabled());
		}

		if (!StringHelper.isNullOrEmpty(calendarItem.getHref()) || !bSimple){
			objJSON.put("href", JSONObjectHelper.stripQuotes( calendarItem.getHref(),true));
		}

		if (!StringHelper.isNullOrEmpty(calendarItem.getHrefTarget()) || !bSimple){
			objJSON.put("hrefTarget", JSONObjectHelper.stripQuotes( calendarItem.getHrefTarget(),true));
		}

		if (!StringHelper.isNullOrEmpty(calendarItem.getIcon()) || !bSimple){
			objJSON.put("icon", JSONObjectHelper.stripQuotes( calendarItem.getIcon(),true));
		}

		if (!StringHelper.isNullOrEmpty(calendarItem.getIconCssClass()) || !bSimple){
			objJSON.put("iconCls",JSONObjectHelper.stripQuotes(  calendarItem.getIconCssClass(),true));
		}
		
		
		if (calendarItem.getTag() != null) {
			Iterator en = calendarItem.getTag().keys();
			while (en.hasNext()) {
				String strKey = (String) en.next();
				if (!objJSON.has(strKey)){
					//避免重复写入
					objJSON.put(strKey, calendarItem.getTag().get(strKey));
				}
			}
		}

		return objJSON;
	}


	/**
	 * 导出JSON对象
	 * @param calendarItem
	 * @return
	 */
	public static JSONObject toJSONObject(IGanttItem calendarItem) {
		return toJSONObject(calendarItem, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IModelBase#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.tree.ICalendarItem#getItemType()
	 */
	@Override
	public String getItemType() {
		return this.strItemType;
	}

	/**
	 * 设置甘特项类型
	 * 
	 * @param strItemType
	 */
	public void setItemType(String strItemType) {
		this.strItemType = strItemType;
	}



	/**
	 * 设置数据源
	 * 
	 * @param dataSource
	 */
	public void setDataSource(Object dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 设置是否禁用
	 * 
	 * @param bDisable
	 */
	public void setDisabled(boolean bDisable) {
		this.bDisable = bDisable;
	}

	/**
	 * 获取是否禁用
	 * 
	 * @return
	 */
	public boolean isDisabled() {
		return this.bDisable;
	}



	@Override
	public Object getDataSource() {
		return this.dataSource;
	}


	
}
