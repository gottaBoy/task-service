package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;

/**
 * 实体工具栏分组项对象接口
 * @author lionlau
 *
 */
public interface IPSDETBGroupItem extends IPSDEToolbarItem
{
	/**
	 * 获取工具栏集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEToolbarItem> getPSDEToolbarItems()throws Exception;
	
	
	
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
