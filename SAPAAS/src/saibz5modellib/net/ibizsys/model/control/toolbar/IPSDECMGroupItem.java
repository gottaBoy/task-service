package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;

/**
 * 上下文菜单分组项对象接口
 * @author Administrator
 *
 */
public interface IPSDECMGroupItem extends IPSDEContextMenuItem {
	
	/**
	 * 获取菜单项集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems()throws Exception;
	
	
	
	/**
	 * 获取系统图标对象
	 * @return
	 */
	IPSSysImage getPSSysImage();
	
	
	
	/**
	 * 获取样式表对象
	 * @return
	 */
	IPSSysCss getPSSysCss();
}
