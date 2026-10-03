package net.ibizsys.paas.util.freemarker;

import java.util.List;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 数据上下文值计算方法
 * 
 * @author Administrator
 *
 */
public class DataContextMethod2 implements TemplateMethodModel {
	public Object exec(List arg0) throws TemplateModelException {
		try {
			// SessionFactory sessionFactory = SqlCodeHelper.getCurrentSessionFactory();
			if (arg0.size() == 0) {
				throw new Exception(StringHelper.format("没有指定当前数据参数"));
			}
			String strKey = arg0.get(0).toString().toLowerCase();
			String strParam = "";
			if (arg0.size() > 1) {
				strParam = arg0.get(1).toString();
			}

			JSONObject jo = WebContext.getActiveData();
			if (jo == null) {
				jo = WebContext.getReferData();
			}
			if (jo == null) {
				jo = WebContext.getParentData();
			}
			if (jo == null) {
				throw new Exception(StringHelper.format("上下文数据无效"));
			}

			// 判断有无实体
			Object objValue = null;
			Object objDEId = jo.opt("srfdeid");
			if (!StringHelper.isNullOrEmpty(objDEId)) {
				IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String) objDEId);
				IEntity iEntity = iDataEntityModel.createEntity();
				DataObject.fromJSONObject(iEntity, jo);
				objValue = iDataEntityModel.getService().getDataContextValue(iEntity, strKey, null);
			} else {
				objValue = jo.opt(strKey);
			}

			SqlParamList sqlParamList = SqlCodeHelper.getCurrentSqlParamList();
			// if(objValue==null && arg0.size()>=3)
			// {
			// objValue = arg0.get(2);
			// }
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
