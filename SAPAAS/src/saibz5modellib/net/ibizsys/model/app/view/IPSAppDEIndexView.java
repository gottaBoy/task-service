package net.ibizsys.model.app.view;


/**
 * 应用实体首页视图对象接口
 * @author lionlau
 *
 */
public interface IPSAppDEIndexView extends IPSAppDEView,IPSAppDataRelationView
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
	
	

}
