/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.util.freemarker;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.SqlCodeHelper;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public class DataContextMethod2
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        try {
            JSONObject jo;
            if (arg0.size() == 0) {
                throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u6570\u636e\u53c2\u6570"));
            }
            String strKey = arg0.get(0).toString().toLowerCase();
            String strParam = "";
            if (arg0.size() > 1) {
                strParam = arg0.get(1).toString();
            }
            if ((jo = WebContext.getActiveData()) == null) {
                jo = WebContext.getReferData();
            }
            if (jo == null) {
                jo = WebContext.getParentData();
            }
            if (jo == null) {
                throw new Exception(StringHelper.format("\u4e0a\u4e0b\u6587\u6570\u636e\u65e0\u6548"));
            }
            Object objValue = null;
            Object objDEId = jo.opt("srfdeid");
            if (!StringHelper.isNullOrEmpty(objDEId)) {
                IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)objDEId);
                Object iEntity = iDataEntityModel.createEntity();
                DataObject.fromJSONObject(iEntity, jo);
                objValue = iDataEntityModel.getService().getDataContextValue(iEntity, strKey, null);
            } else {
                objValue = jo.opt(strKey);
            }
            SqlParamList sqlParamList = SqlCodeHelper.getCurrentSqlParamList();
            SqlParam sqlParam = new SqlParam(objValue);
            sqlParam.setParamName(strKey);
            if (objValue == null) {
                sqlParam.setDataType(25);
            }
            sqlParamList.add(sqlParam);
            return "?";
        }
        catch (Exception ex) {
            throw new TemplateModelException(ex);
        }
    }
}

