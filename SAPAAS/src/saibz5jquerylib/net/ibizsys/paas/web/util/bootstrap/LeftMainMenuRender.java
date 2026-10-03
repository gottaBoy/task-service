package net.ibizsys.paas.web.util.bootstrap;

import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.web.IWebContext;

/**
 * 左侧主菜单绘制器
 * 
 * @author Administrator
 *
 */
public class LeftMainMenuRender extends MenuRenderBase {

	public LeftMainMenuRender() {

	}

	/**
	 * 输出主菜单
	 * 
	 * @param nMode
	 * @param iAppMenuModel
	 * @param iWebContext
	 * @param strCurPagePath 当前界面路径
	 * @return
	 * @throws Exception
	 */
	public static String output(int nMode, IAppMenuModel iAppMenuModel, IWebContext iWebContext, String strCurPagePath) throws Exception {
		webContext.set(iWebContext);
		activeAppMenuItem.set(null);

		StringBuilderEx sb = new StringBuilderEx();
		boolean bFirst = true;
		java.util.Iterator<IAppMenuItem> appMenuItems = iAppMenuModel.getAppMenuItems();
		while (appMenuItems.hasNext()) {
			IAppMenuItem iAppMenuItem = appMenuItems.next();
			String strExtClass = null;
			if (bFirst) {
				strExtClass = "start";
				bFirst = false;
			}

			outputMenuItem(sb, nMode, iAppMenuItem, strExtClass);
		}

		webContext.set(null);
		activeAppMenuItem.set(null);

		return sb.toString();
	}

}
