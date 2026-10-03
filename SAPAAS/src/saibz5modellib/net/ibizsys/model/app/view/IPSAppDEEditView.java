package net.ibizsys.model.app.view;


/**
 * 应用实体编辑视图对象接口
 * @author lionlau
 *
 */
public interface IPSAppDEEditView extends IPSAppDEView,IPSAppDataRelationView,IPSAppDEXDataView
{
	/**
	 * 显示数据信息栏
	 */
	public final static String VIEWPARAM_UI_SHOWDATAINFOBAR = "UI.SHOWDATAINFOBAR";
	
	
	/**
	 * 是否显示数据信息栏
	 * @return
	 */
	boolean isShowDataInfoBar();
	
	
	/**
	 * 是否隐藏编辑表单
	 * @return
	 */
	boolean isHideEditForm();
	
	
}
