package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenu;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 应用菜单模型接口
 * 
 * @author Administrator
 *
 */
public interface IAppMenuModel extends ICtrlModel, IAppMenu {

	/**
	 * 填充返回结果对象
	 * 
	 * @param fetchResult
	 * @param dt
	 * @throws Exception
	 */
	void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception;

	/**
	 * 获取根项
	 * 
	 * @return
	 */
	AppMenuRootItem getRootItem();
}
