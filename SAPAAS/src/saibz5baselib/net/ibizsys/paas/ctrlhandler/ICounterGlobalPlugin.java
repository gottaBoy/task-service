package net.ibizsys.paas.ctrlhandler;


/**
 * 计数器全局对象插件
 * @author Administrator
 *
 */
public interface ICounterGlobalPlugin {
	/**
	 * 注册计数器
	 * 
	 * @param strCounterHandlerClsType
	 * @param iCounterHandler
	 */
	  void registerCounterHandler(String strCounterHandlerClsType, ICounterHandler iCounterHandler) ;

	/**
	 * 获取计数器
	 * 
	 * @param strCounterHandlerClsType
	 * @return
	 * @throws Exception
	 */
	  ICounterHandler getCounterHandler(Class cls) throws Exception ;

	/**
	 * 获取计数器
	 * 
	 * @param strCounterHandlerClsType
	 * @return
	 * @throws Exception
	 */
	ICounterHandler getCounterHandler(String strCounterHandlerClsType) throws Exception;
}
