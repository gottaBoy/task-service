package net.ibizsys.paas.ctrlhandler;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;

/**
 * 计数器全局对象
 * 
 * @author Administrator
 *
 */
public class CounterGlobal {
	private static final Log log = LogFactory.getLog(CounterGlobal.class);
	private static HashMap<String, ICounterHandler> counterHandlerMap = new HashMap<String, ICounterHandler>();
	private static ICounterGlobalPlugin iCounterGlobalPlugin = null;
	/**
	 * 注册计数器
	 * 
	 * @param strCounterHandlerClsType 计数处理对象类
	 * @param iCounterHandler
	 */
	public static void registerCounterHandler(String strCounterHandlerClsType, ICounterHandler iCounterHandler) {
		if(getPlugin()!=null){
			 getPlugin().registerCounterHandler(strCounterHandlerClsType,iCounterHandler);
			 return;
		}
		
		if (!counterHandlerMap.containsKey(strCounterHandlerClsType)) {
			counterHandlerMap.put(strCounterHandlerClsType, iCounterHandler);
		}
	}

	/**
	 * 获取计数器
	 * 
	 * @param cls 计数处理对象类
	 * @return
	 * @throws Exception
	 */
	public static ICounterHandler getCounterHandler(Class cls) throws Exception {
		if(getPlugin()!=null){
			return getPlugin().getCounterHandler(cls);
		}
		return getCounterHandler(cls.getCanonicalName());
	}

	/**
	 * 获取计数器
	 * 
	 * @param strCounterHandlerClsType 计数处理对象类
	 * @return
	 * @throws Exception
	 */
	public static ICounterHandler getCounterHandler(String strCounterHandlerClsType) throws Exception {
		if(getPlugin()!=null){
			return getPlugin().getCounterHandler(strCounterHandlerClsType);
		}
		
		ICounterHandler iCounterHandler = counterHandlerMap.get(strCounterHandlerClsType);
		if (iCounterHandler == null) throw new Exception(StringHelper.format("无法获取指定计数器[%1$s]", strCounterHandlerClsType));
		return iCounterHandler;
	}
	
	/**
	 * 设置插件
	 * @param iCounterGlobalPlugin
	 */
	public static void setPlugin(ICounterGlobalPlugin iCounterGlobalPlugin){
		CounterGlobal.iCounterGlobalPlugin = iCounterGlobalPlugin;
	}
	
	public static ICounterGlobalPlugin getPlugin(){
		return CounterGlobal.iCounterGlobalPlugin; 
	}
}
