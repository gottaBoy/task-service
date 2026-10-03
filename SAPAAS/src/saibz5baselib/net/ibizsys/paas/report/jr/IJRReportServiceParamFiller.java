package net.ibizsys.paas.report.jr;

import java.util.Map;

import net.ibizsys.paas.report.IReportService;

/**
 * 报表服务参数填充器对象接口
 * @author Administrator
 *
 */
public interface IJRReportServiceParamFiller {

	/**
	 * 填充报表服务参数
	 * @param parameters
	 * @param iReportService
	 * @return 是否进行了填充
	 * @throws Exception
	 */
	boolean fillParameters(Map parameters,IReportService iReportService)throws Exception;
}
