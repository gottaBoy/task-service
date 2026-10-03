package net.ibizsys.model.control.menu;

import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.control.menu.IAppMenuItem;


/**
 * 应用菜单项接对象口
 * 
 * @author lionlau
 *
 */
public interface IPSAppMenuItem extends IPSMenuItem, IAppMenuItem {
	
	/**
	 * 获取子菜单集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSAppMenuItem> getPSAppMenuItems();

	

	/**
	 * 获取应用功能编号
	 * 
	 * @return
	 */
	IPSAppFunc getPSAppFunc();

	

	/**
	 * 是否为默认打开
	 * 
	 * @return
	 */
	boolean isOpenDefault();

	/**
	 * 是否为禁止关闭
	 * 
	 * @return
	 */
	boolean isDisableClose();

	/**
	 * 隐藏边栏
	 * 
	 * @return
	 */
	boolean isHideSideBar();

	/**
	 * 获取工具提示
	 * 
	 * @return
	 */
	String getTooltip();

	/**
	 * 获取系统图标对象
	 * 
	 * @return
	 */
	IPSSysImage getPSSysImage();

	/**
	 * 获取样式表对象
	 * 
	 * @return
	 */
	IPSSysCss getPSSysCss();

	/**
	 * 该项是否有效
	 * 
	 * @return
	 */
	boolean isValid();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.menu.IMenuItem#getCounterId()
	 */
	String getCounterId();
}
