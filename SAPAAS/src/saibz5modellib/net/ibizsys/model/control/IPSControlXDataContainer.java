package net.ibizsys.model.control;


/**
 * 部件数据容器对象接口
 * @author Administrator
 *
 */
public interface IPSControlXDataContainer {

	/**
	 * 是否为默认加载
	 * @return
	 */
	boolean isLoadDefault();
	
	/**
	 * 是否为只读模式
	 * @return
	 */
	boolean isReadOnly();
	
	/**
	 * 是否支持新建数据
	 * @return
	 */
	boolean isEnableNewData();
	
	
	
	/**
	 * 是否支持 编辑数据
	 * @return
	 */
	boolean isEnableEditData();
	
	
	
	
	/**
	 * 是否支持删除数据
	 * @return
	 */
	boolean isEnableRemoveData();
	
	
	
	
	/**
	 * 是否支持打印
	 * @return
	 */
	boolean isEnablePrint();
	
	
	/**
	 * 是否支持拷贝
	 * @return
	 */
	boolean isEnableCopy();
	
	
	
	/**
	 * 是否支持启动流程
	 * @return
	 */
	boolean isEnableStartWF();
	
	
	
//	/**
//	 * 获取视图默认的打印对象
//	 * @return
//	 */
//	IPSDEPrint getPSDEPrint();
}
