package net.ibizsys.paas.report;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONArray;

/**
 * 报表服务对象接口
 * 
 * @author Administrator
 *
 */
public interface IReportService extends IDataEntityObject {
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
	 * 获取访问权限标识
	 * 
	 * @return
	 */
	String getAccessKey();

	/**
	 * 获取报表路径
	 * 
	 * @return
	 */
	String getReportFilePath();

	/**
	 * 获取实体数据结果集名称
	 * 
	 * @return
	 */
	String getDEDataSetName();

	/**
	 * 是否支持日志
	 * 
	 * @return
	 */
	boolean isEnableLog();

	/**
	 * 获取打印文件
	 * 
	 * @param iWebContext
	 * @param sessionFactory
	 * @param strContentType
	 * @return
	 * @throws Exception
	 */
	String getReportFile(IWebContext iWebContext, SessionFactory sessionFactory, String strContentType, String strPrintFileFolder) throws Exception;

	/**
	 * 获取子报表标识集合
	 * 
	 * @return
	 */
	java.util.Iterator<String> getSubReportIds();

	/**
	 * 是否有子报表
	 * 
	 * @return
	 */
	boolean hasSubReport();

	/**
	 * 获取代码表文本
	 * 
	 * @param strCodeListId 代码表标识
	 * @param strValue 要转换的值
	 * @return 转换后文本
	 * @throws Exception
	 */
	String getCodeListText(String strCodeListId, String strValue) throws Exception;
	
	/**
	 * 获取字符串JSON数组指定Key的文本显示内容
	 * 默认数据键值为: name
	 * 默认显示分隔符为: ,
	 * 无值默认显示内容为空
	 * @param objValue	字符串JSON数组数据
	 * @return
	 */
	String getJSONArrayText(Object objValue);
	
	/**
	 * 获取字符串JSON数组指定Key的文本显示内容
	 * @param objValue		字符串JSON数组数据
	 * @param strKey		获取数据键值
	 * @param strSplit		显示分隔符
	 * @param strDefault	无值默认显示内容
	 * @return
	 */
	String getJSONArrayText(Object objValue, String strKey, String strSplit, String strDefault);
	
	/**
	 * 获取JSON数组指定Key的文本显示内容
	 * 默认数据键值为: name
	 * 默认显示分隔符为: ,
	 * 无值默认显示内容为空
	 * @param jaList	JSON数组数据
	 * @return
	 */
	String getJSONArrayText(JSONArray jaList);

	/**
	 * 获取JSON数组指定Key的文本显示内容
	 * @param jaList		JSON数组数据
	 * @param strKey		获取数据键值
	 * @param strSplit		显示分隔符
	 * @param strDefault	无值默认显示内容
	 * @return
	 */
	String getJSONArrayText(JSONArray jaList, String strKey, String strSplit, String strDefault);
}
