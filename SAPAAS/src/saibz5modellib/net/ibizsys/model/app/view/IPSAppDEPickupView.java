package net.ibizsys.model.app.view;

/**
 * 应用实体选择视图对象接口
 * @author Administrator
 *
 */
public interface IPSAppDEPickupView extends IPSAppDEView
{
	/**
	 * 是否支持多选
	 * @return
	 */
	boolean isEnableMultiSelect();
	
	
	/**
	 * 是否转化选择数据
	 * @return
	 */
	boolean isConvertPickupData();
}
