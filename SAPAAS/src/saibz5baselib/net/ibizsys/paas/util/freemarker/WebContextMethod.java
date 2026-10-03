package net.ibizsys.paas.util.freemarker;

import java.util.List;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.service.DataContextParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.web.WebContext;

/**
 * 网络请求上下文
 * 
 * @author Administrator
 *
 */
public class WebContextMethod implements TemplateMethodModel {

	public Object exec(List arg0) throws TemplateModelException {
		try {

			SqlParamList sqlParamList = SqlCodeHelper.getCurrentSqlParamList();

			if (arg0.size() == 0) {
				throw new Exception(StringHelper.format("没有指定当前网页上下文参数"));
			}

			String strKey = arg0.get(0).toString();
			String strParam = "";
			DataContextParam iDataContextParam = null;
			boolean bIgnoreEmpty = false;
			if (arg0.size() > 1) {
				strParam = arg0.get(1).toString();
				if (!StringHelper.isNullOrEmpty(strParam)) {
					iDataContextParam = new DataContextParam(strParam);
					bIgnoreEmpty = iDataContextParam.isIgnoreEmpty();
				}
			}

			String strValue = null;
			if (WebContext.getCurrent() != null) {
				strValue = WebContext.getCurrent().getPostOrParamValue(strKey);
			}

			if (StringHelper.isNullOrEmpty(strValue) && bIgnoreEmpty) {
				return "";
			} else {
				SqlParam sqlParam = new SqlParam(strValue);
				sqlParam.setParamName(strKey);

				if (strValue == null) {
					sqlParam.setDataType(DataTypes.VARCHAR);
				}

				sqlParamList.add(sqlParam);
				return "?";
			}

		} catch (Exception ex) {
			throw new TemplateModelException(ex);
		}

	}
}
