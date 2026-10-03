package net.ibizsys.paas.report;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;

/**
 * 报表服务全局对象
 * 
 * @author Administrator
 *
 */
public class ReportServiceGlobal {
	private static final Log log = LogFactory.getLog(ReportServiceGlobal.class);
	private static HashMap<String, IReportService> reportServiceMap = new HashMap<String, IReportService>();

	/**
	 * 注册报表服务对象
	 * 
	 * @param strReportServiceClsType
	 * @param iReportService
	 */
	public static void registerReportService(String strReportServiceClsType, IReportService iReportService) {
		reportServiceMap.put(strReportServiceClsType, iReportService);
		// reportServiceMap.put(iReportService.getId(), iReportService);
	}

	/**
	 * 获取报表服务对象
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static IReportService getReportService(Class cls) throws Exception {
		return getReportService(cls.getCanonicalName());
	}

	/**
	 * 获取报表服务对象
	 * 
	 * @param strReportServiceClsType
	 * @return
	 * @throws Exception
	 */
	public static IReportService getReportService(String strReportServiceClsType) throws Exception {
		IReportService iReportService = reportServiceMap.get(strReportServiceClsType);
		if (iReportService == null) throw new Exception(StringHelper.format("无法获取指定报表服务[%1$s]", strReportServiceClsType));
		return iReportService;
	}
}
