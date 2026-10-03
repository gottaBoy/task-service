package net.ibizsys.paas.report;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;

/**
 * 打印服务全局对象
 * 
 * @author Administrator
 *
 */
public class PrintServiceGlobal {
	private static final Log log = LogFactory.getLog(PrintServiceGlobal.class);
	private static HashMap<String, IPrintService> reportServiceMap = new HashMap<String, IPrintService>();

	/**
	 * 注册打印服务对象
	 * 
	 * @param strPrintServiceClsType
	 * @param iPrintService
	 */
	public static void registerPrintService(String strPrintServiceClsType, IPrintService iPrintService) {
		reportServiceMap.put(strPrintServiceClsType, iPrintService);
		// reportServiceMap.put(iPrintService.getId(), iPrintService);
	}

	/**
	 * 获取打印服务对象
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static IPrintService getPrintService(Class cls) throws Exception {
		return getPrintService(cls.getCanonicalName());
	}

	/**
	 * 获取打印服务对象
	 * 
	 * @param strPrintServiceClsType
	 * @return
	 * @throws Exception
	 */
	public static IPrintService getPrintService(String strPrintServiceClsType) throws Exception {
		IPrintService iPrintService = reportServiceMap.get(strPrintServiceClsType);
		if (iPrintService == null) throw new Exception(StringHelper.format("无法获取指定打印服务[%1$s]", strPrintServiceClsType));
		return iPrintService;
	}
}
