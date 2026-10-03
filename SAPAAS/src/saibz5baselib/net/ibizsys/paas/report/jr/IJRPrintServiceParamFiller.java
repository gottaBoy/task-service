package net.ibizsys.paas.report.jr;

import java.util.Map;

import net.ibizsys.paas.report.IPrintService;

/**
 * 打印服务参数填充器对象接口
 * @author Administrator
 *
 */
public interface IJRPrintServiceParamFiller {

	/**
	 * 填充打印服务参数
	 * @param parameters
	 * @param iPrintService
	 * @return 是否进行了填充
	 * @throws Exception
	 */
	boolean fillParameters(Map parameters,IPrintService iPrintService)throws Exception;
}
