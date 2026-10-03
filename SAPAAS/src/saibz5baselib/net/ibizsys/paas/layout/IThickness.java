package net.ibizsys.paas.layout;

/**
 * 边框宽度对象接口
 * @author Administrator
 *
 */
public interface IThickness {
	/**
	 * 获取左边值
	 * @return
	 */
	int getLeft();
	
	/**
	 * 获取右边值
	 * @return
	 */
	int getRight();
	
	/**
	 * 获取上边值
	 * @return
	 */
	int getTop();
	
	/**
	 * 获取下边值
	 * @return
	 */
	int getBottom();
}
