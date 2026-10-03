package net.ibizsys.ssdyna.core;

import net.ibizsys.paas.appmodel.AppViewModel;

/**
 * 动态实体视图模板对象模型接口
 * @author Administrator
 *
 */
public interface IDynaDEViewTemplModel extends IDynaDEViewTempl {

	/**
	 * 注册应用动态实体视图
	 * @param strAppId
	 * @param strAppViewId
	 * @param strUrl
	 * @param userData
	 * @throws Exception
	 */
	void registerAppDynaDEView(String strAppId,String strAppViewId,String strUrl,Object userData) throws Exception;
	
	
	
	
	/**
	 * 获取应用视图集合
	 * @return
	 */
	java.util.Iterator<AppViewModel> getAppDynaDEViews();
}
