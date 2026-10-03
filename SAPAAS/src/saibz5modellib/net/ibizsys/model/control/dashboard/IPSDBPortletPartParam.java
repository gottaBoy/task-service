package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.IPSAjaxControlParam;

/**
 * 数据看板部件参数对象接口
 * @author lionlau
 *
 */
public interface IPSDBPortletPartParam extends IPSAjaxControlParam
{
	/**
	 * 获取部件类型
	 * @return
	 */
	String getPortletType();
	
	
	/**
	 * 放入的列编号，-1为不显示
	 * @return
	 */
	int getColumnId();
	
	
	
	/**
	 * 列数
	 * @return
	 */
	int getColumnSpan();
	
	

	/**
	 * @return
	 */
	int getColXS();

	
	/**
	 * @return
	 */
	int getColSM();
	
	
	/**
	 * @return
	 */
	int getColMD();
	
	
	/**
	 * @return
	 */
	int getColLG();
	
	
	/**
	 * @return
	 */
	int getColXSOffset();

	/**
	 * @return
	 */
	int getColSMOffset();
	
	
	/**
	 * @return
	 */
	int getColMDOffset();
	
	
	/**
	 * @return
	 */
	int getColLGOffset();
	
	
	/**
	 * 是否新建行
	 * @return
	 */
	boolean isNewRowMode();
	
	
	
	/**
	 * 获取标题
	 * @return
	 */
	String getTitle();
	

	
	/**
	 * 获取标题语言资源标识标识
	 * @return
	 */
	String getTitlePSLanguageResId();
	
	
	
	/**
	 * 获取是否显示标题栏
	 * @return
	 */
	Boolean getShowTitleBar();
}
