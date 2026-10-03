package net.ibizsys.paas.core;

/**
 * 链接属性接口
 * 
 * @author Administrator
 *
 */
public interface ILinkDEField extends IDEField {
	/**
	 * 获取关系标识
	 * 
	 * @return
	 */
	String getDERId();

	/**
	 * 获取链接的属性
	 * 
	 * @return
	 */
	IDEField getRelatedDEField();
}
