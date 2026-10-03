package net.ibizsys.model.control.list;

import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;

/**
 * 实体移动端多项数据控件对象接口<BR>
 * 移动端多数据部件会同时绑定多个界面行为组，这些行为组用途由部件解释使用用途，例如左侧滑动、右侧滑动等
 * @author Administrator
 *
 */
public interface IPSDEMobMDCtrl extends IPSDEList
{
	/**
	 * 获取控件子类型
	 * @return
	 */
	String getControlSubType();
	
	
	
	/**
	 * 获取部件使用的界面行为组
	 * @return
	 * @throws Exception
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup()throws Exception;
	
	
	
	/**
	 * 获取部件使用的界面行为组2
	 * @return
	 * @throws Exception
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup2()throws Exception;
	
	
	/**
	 * 获取部件使用的界面行为组3
	 * @return
	 * @throws Exception
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup3()throws Exception;
	
	
	/**
	 * 获取部件使用的界面行为组4
	 * @return
	 * @throws Exception
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup4()throws Exception;
	
	
	/**
	 * 获取部件使用的界面行为组5
	 * @return
	 * @throws Exception
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup5()throws Exception;
	
	
	/**
	 * 获取部件使用的界面行为组6
	 * @return
	 * @throws Exception
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup6()throws Exception;
}
