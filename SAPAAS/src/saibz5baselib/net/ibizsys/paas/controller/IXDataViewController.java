package net.ibizsys.paas.controller;

/**
 * 数据相关视图控制器
 * @author Administrator
 *
 */
public interface IXDataViewController extends IViewController {

	/**
	 * 是否为只读模式
	 * @return
	 */
	boolean isReadOnly();
	
}
