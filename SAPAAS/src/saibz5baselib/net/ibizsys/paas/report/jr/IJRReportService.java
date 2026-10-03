package net.ibizsys.paas.report.jr;

import java.util.List;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.report.IReportService;
import net.ibizsys.paas.web.IWebContext;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * JRReport 报表服务接口
 * 
 * @author Administrator
 *
 */
public interface IJRReportService extends IReportService {
	/**
	 * 获取JR报表打印集合（用于报表套装模式）
	 * 
	 * @param iWebContext
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	List<JasperPrint> getReportJasperPrints(IEntity iEntity, IWebContext iWebContext, SessionFactory sessionFactory, String strContentType, String strPrintFileFolder) throws Exception;

}
