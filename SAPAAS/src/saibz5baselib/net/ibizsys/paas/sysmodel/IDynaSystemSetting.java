package net.ibizsys.paas.sysmodel;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.pswf.core.IDynaWFSetting;

/**
 * 动态系统设置对象
 * @author Administrator
 *
 */
public interface IDynaSystemSetting {

	/**
	 * 获取动态实例标识
	 * @return
	 */
	String getDynaInstId();
	
	
	/**
	 * 获取数据库会话工厂
	 * @return
	 */
	SessionFactory getSessionFactory();
	
	
	/**
	 * 创建动态视图控制器实例
	 * @param iDynaViewController
	 * @param strDynaViewInstId
	 * @return
	 * @throws Exception
	 */
	IDynaViewControllerInst createDynaViewControllerInst(IDynaViewController iDynaViewController,String strDynaViewInstId)throws Exception;

	
	/**
	 * 获取动态视图设置
	 * @return
	 */
	IDynaViewSetting getDynaViewSetting();
	
	
	
	/**
	 * 获取动态工作流设置
	 * @return
	 */
	IDynaWFSetting getDynaWFSetting();
	
	
	/**
	 * 全部动态系统
	 * @throws Exception
	 */
	void installAll()throws Exception;
	
	
	/**
	 * 同步全部数据
	 * @throws Exception
	 */
	void syncAll()throws Exception;
}
