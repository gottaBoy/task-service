package net.ibizsys.model.control.expbar;

/**
 * 导航栏项对象接口
 * @author lionlau
 *
 */
public interface IPSExpBarItem
{
	/**
	 * 获取子项集合
	 * @return
	 */
	java.util.ArrayList<IPSExpBarItem> getItems();
}
