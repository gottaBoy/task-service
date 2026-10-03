package net.ibizsys.paas.report;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.web.IWebContext;

/**
 * 打印服务接口
 * 
 * @author Administrator
 *
 */
public interface IPrintService extends IDataEntityObject {
	/**
	 * 内容类型，PDF
	 */
	final static String CONTENTTYPE_PDF = "PDF";

	/**
	 * 内容类型，HTML
	 */
	final static String CONTENTTYPE_HTML = "HTML";

	/**
	 * 内容类型，EXCEL
	 */
	final static String CONTENTTYPE_EXCEL = "EXCEL";

	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;

	/**
	 * 获取实体模型
	 * 
	 * @return
	 */
	IDataEntityModel getDEModel();

	/**
	 * 获取明细数据实体数据结果集名称
	 * 
	 * @return
	 */
	String getDEDataSetName();
	
	
	
	/**
	 * 获取明细数据实体数据结果集名称
	 * @return
	 */
	String getDetailDEDataSetName();
	
	
	
	/**
	 * 获取明细数据实体名称
	 * @return
	 */
	String getDetailDEName();

	/**
	 * 是否启用列权限
	 * 
	 * @return
	 */
	boolean isEnableColPriv();

	/**
	 * 是否启用打印日志
	 * 
	 * @return
	 */
	boolean isEnableLog();

	/**
	 * 是否启用多数据打印
	 * 
	 * @return
	 */
	boolean isEnableMulitPrint();

	/**
	 * 获取获取数据实体行为对象名称
	 * 
	 * @return
	 */
	String getGetDataDEActionName();

	/**
	 * 获取获取数据访问操作
	 * 
	 * @return
	 */
	String getGetDataDataAccessAction();

	/**
	 * 获取报表路径
	 * 
	 * @return
	 */
	String getReportFilePath();

	/**
	 * 获取打印文件
	 * 
	 * @param iWebContext
	 * @param sessionFactory
	 * @param strContentType
	 * @return
	 * @throws Exception
	 */
	String getPrintFile(String strKeys, IWebContext iWebContext, SessionFactory sessionFactory, String strContentType, String strPrintFileFolder) throws Exception;

	/**
	 * 获取代码表文本
	 * 
	 * @param strCodeListId 代码表标识
	 * @param strValue 要转换的值
	 * @return 转换后文本
	 * @throws Exception
	 */
	String getCodeListText(String strCodeListId, String strValue) throws Exception;
}
