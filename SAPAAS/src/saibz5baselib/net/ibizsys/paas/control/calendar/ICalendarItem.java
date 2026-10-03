package net.ibizsys.paas.control.calendar;

import net.ibizsys.paas.core.IModelBase;
import net.sf.json.JSONObject;

/**
 * 日历项接口
 * 
 * @author Administrator
 *
 */
public interface ICalendarItem extends IModelBase {
	
	/**
	 * 获取日历项类型
	 * 
	 * @return
	 */
	String getItemType();

	
	/**
	 * 获取是否禁用
	 * 
	 * @return
	 */
	boolean isDisabled();



	/**
	 * 获取样式
	 * 
	 * @return
	 */
	String getCssClass();

	/**
	 * 获取图标样式
	 * 
	 * @return
	 */
	String getIconCssClass();

	/**
	 * 获取图标
	 * 
	 * @return
	 */
	String getIcon();

	/**
	 * 获取链接
	 * 
	 * @return
	 */
	String getHref();

	/**
	 * 获取链接目标
	 * 
	 * @return
	 */
	String getHrefTarget();

	/**
	 * 获取节点提示信息
	 * 
	 * @return
	 */
	String getTips();

	/**
	 * 获取节点文本
	 * 
	 * @return
	 */
	String getText();
	
	
	/**
	 * 获取内容
	 * @return
	 */
	String getContent();

	
	/**
	 * 获取字体颜色
	 * @return
	 */
	String getColor();
	
	
	/**
	 * 获取背景颜色
	 * @return
	 */
	String getBKColor();
	
	
	/**
	 * 获取开始时间
	 * @return
	 */
	java.sql.Timestamp getBeginTime();
	
	
	/**
	 * 获取结束时间
	 * @return
	 */
	java.sql.Timestamp getEndTime();
	

	/**
	 * 获取节点的标记值
	 * 
	 * @param strKey
	 * @return
	 */
	Object getTagValue(String strKey);

	/**
	 * 获取标记对象
	 * 
	 * @return
	 */
	JSONObject getTag();

	

	/**
	 * 获取日历项的数据源
	 * 
	 * @return
	 */
	Object getDataSource();
	

}
