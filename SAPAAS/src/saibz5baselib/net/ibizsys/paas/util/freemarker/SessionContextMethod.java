package net.ibizsys.paas.util.freemarker;

import java.util.List;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

/**
 * 用户 Session上下文方法
 * 
 * @author Administrator
 *
 */
public class SessionContextMethod implements TemplateMethodModel {
	public Object exec(List arg0) throws TemplateModelException {
		try {

			SqlParamList sqlParamList = SqlCodeHelper.getCurrentSqlParamList();

			if (arg0.size() == 0) {
				throw new Exception(StringHelper.format("没有指定当前数据参数"));
			}

			String strKey = arg0.get(0).toString();
			Object objValue = WebContext.getCurrent().getSessionValue(strKey);


			SqlParam sqlParam = new SqlParam(objValue);
			sqlParam.setParamName(strKey);

			if (objValue == null) {
				sqlParam.setDataType(DataTypes.VARCHAR);
			}
			sqlParamList.add(sqlParam);
			return "?";
		} catch (Exception ex) {
			throw new TemplateModelException(ex);
		}

	}
}
