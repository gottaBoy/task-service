package net.ibizsys.paas.web.util;

import net.ibizsys.paas.web.Page;

/**
 * 菜单页面，提供辅助功能
 * 
 * @author Administrator
 *
 */
public class MenuPage extends Page {

	/**
	 * 判断用户是否允许访问
	 * 
	 * @param nAccessMode
	 * @param strAccessKey
	 * @return
	 * @throws Exception
	 */
	public boolean test(int nAccessMode, String strAccessKey) throws Exception {
		return true;
	}
}
