package net.ibizsys.paas.util.freemarker;

import java.util.List;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.util.StringHelper;

/**
 * System上下文
 * 
 * @author Administrator
 *
 */
public class SystemContextMethod implements TemplateMethodModel {
	/**
	 * 当前时间
	 */
	public final static String DATETIME = "DATETIME";

	public Object exec(List arg0) throws TemplateModelException {
		try {

			SqlParamList sqlParamList = SqlCodeHelper.getCurrentSqlParamList();

			if (arg0.size() == 0) {
				throw new Exception(StringHelper.format("没有指定当前系统参数"));
			}

			String strKey = arg0.get(0).toString();
			if (StringHelper.compare(strKey, DATETIME, true) == 0) {
				SqlParam sqlParam = new SqlParam(new java.sql.Timestamp(System.currentTimeMillis()));
				sqlParam.setParamName(strKey);
				sqlParamList.add(sqlParam);
				return "?";
			}

			throw new Exception(StringHelper.format("无法识别当前系统参数[%1$s]", strKey));

		} catch (Exception ex) {
			throw new TemplateModelException(ex);
		}

	}
}
