package net.ibizsys.paas.appmodel;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.util.StringHelper;

/**
 * 应用程序模型全局对象
 * 
 * @author lionlau
 *
 */
public class AppModelGlobal {
	private static final Log log = LogFactory.getLog(AppModelGlobal.class);

	private static HashMap<String, IApplication> applicationMap = new HashMap<String, IApplication>();
	private static IApplication defaultApplication = null;
	//private static IApplicationPlugin iApplicationPlugin = null;
	
	/**
	 * 注册应用程序
	 * 
	 * @param strAppClsType 应用类型
	 * @param iApplication 应用对象
	 */
	public static void registerApplication(String strAppClsType, IApplication iApplication) {
		log.info(StringHelper.format("注册应用模型对象[%1$s][%2$s]", strAppClsType, iApplication));
		applicationMap.put(strAppClsType, iApplication);
		if (defaultApplication == null) {
			defaultApplication = iApplication;
		}
	}

	/**
	 * 获取应用程序
	 * 
	 * @param strAppClsType 应用类型
	 * @return
	 * @throws Exception
	 */
	public static IApplication getApplication(String strAppClsType) throws Exception {
		IApplication iApplication = applicationMap.get(strAppClsType);
		if (iApplication == null) throw new Exception(StringHelper.format("无法获取指定应用模型[%1$s]", strAppClsType));
		return iApplication;
	}

	/**
	 * 获取应用程序
	 * 
	 * @param strServiceClsType 服务类型
	 * @return
	 * @throws Exception
	 */
	public static IApplication getApplication(Class<?> cls) throws Exception {
		return getApplication(cls.getCanonicalName());
	}

	/**
	 * 获取全部应用程序
	 * 
	 * @return
	 * @throws Exception
	 */
	public static java.util.Iterator<IApplication> getAllApplications() throws Exception {
		return applicationMap.values().iterator();
	}

	/**
	 * 获取默认应用程序
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IApplication getDefaultApplication() throws Exception {
		return defaultApplication;
	}

}
