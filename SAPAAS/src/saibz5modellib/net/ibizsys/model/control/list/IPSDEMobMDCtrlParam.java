package net.ibizsys.model.control.list;

/**
 * 移动端多项数据部件参数对象接口
 * @author Administrator
 *
 */
public interface IPSDEMobMDCtrlParam extends IPSDEListParam 
{
	/**
	 * 获取控件子类型
	 * @return
	 */
	String getControlSubType();
	
	
	
	/**
	 * 获取界面行为组1标识
	 * @return
	 */
	String getPSDEUIActionGroupId();
	
	
	/**
	 * 获取界面行为组2标识
	 * @return
	 */
	String getNo2PSDEUIActionGroupId();
	
	/**
	 * 获取界面行为组3标识
	 * @return
	 */
	String getNo3PSDEUIActionGroupId();
	
	/**
	 * 获取界面行为组4标识
	 * @return
	 */
	String getNo4PSDEUIActionGroupId();
	
	/**
	 * 获取界面行为组5标识
	 * @return
	 */
	String getNo5PSDEUIActionGroupId();
	
	/**
	 * 获取界面行为组6标识
	 * @return
	 */
	String getNo6PSDEUIActionGroupId();
}
