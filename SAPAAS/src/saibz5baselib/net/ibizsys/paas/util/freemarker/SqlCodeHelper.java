package net.ibizsys.paas.util.freemarker;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.db.SqlParamList;

/**
 * SQL 代码辅助对象
 * 
 * @author Administrator
 *
 */
public class SqlCodeHelper {
	private static final Log log = LogFactory.getLog(SqlCodeHelper.class);

	private static ThreadLocal<SqlParamList> sqlParamListParam = new ThreadLocal<SqlParamList>();
	private static ThreadLocal<SessionFactory> sessionFactoryParam = new ThreadLocal<SessionFactory>();

	private static DataContextMethod dataContextMethod = new DataContextMethod();
	private static SessionContextMethod sessionContextMethod = new SessionContextMethod();
	private static SystemContextMethod systemContextMethod = new SystemContextMethod();
	private static WebContextMethod webContextMethod = new WebContextMethod();

	private Map<String, Object> params = new HashMap<String, Object>();
	private Configuration config = new Configuration();
	private Template template = null;

	public void init(IDEDataQueryCode iDEDataQueryCode, String strCode) throws Exception {
		SimpleTemplateLoader deTemplateLoader = new SimpleTemplateLoader(strCode);
		config.setTemplateLoader(deTemplateLoader);
		params.put("srfdatacontext", dataContextMethod);
		params.put("srfsessioncontext", sessionContextMethod);
		params.put("srfsessionvalue", sessionContextMethod);
		params.put("srfsystemcontext", systemContextMethod);
		params.put("srfwebcontext", webContextMethod);
		if (iDEDataQueryCode != null) {
			params.put("srfdefieldexp", new DEFieldExpMethod(iDEDataQueryCode));
		}

		template = config.getTemplate("");
	}

	/**
	 * 参数代码
	 * 
	 * @param sqlParamList
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public String generateCode(SqlParamList sqlParamList, SessionFactory sessionFactory) throws Exception {
		sqlParamListParam.set(sqlParamList);
		sessionFactoryParam.set(sessionFactory);

		try {
			StringWriter sw = new StringWriter();
			template.process(params, sw);
			sqlParamListParam.set(null);
			sessionFactoryParam.set(null);
			return sw.toString();
		} catch (IOException e) {
			sqlParamListParam.set(null);
			sessionFactoryParam.set(null);
			throw new Exception(e);
		} catch (TemplateException e) {
			sqlParamListParam.set(null);
			sessionFactoryParam.set(null);
			throw new Exception(e);
		}
	}

	/**
	 * 获取当前的参数列表
	 * 
	 * @return
	 */
	public static SqlParamList getCurrentSqlParamList() {
		return sqlParamListParam.get();
	}

	/**
	 * 获取当前的会话工厂
	 * 
	 * @return
	 */
	public static SessionFactory getCurrentSessionFactory() {
		return sessionFactoryParam.get();
	}

}
