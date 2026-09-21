/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package net.ibizsys.paas.util.freemarker;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.service.DataContextParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.SqlCodeHelper;
import net.ibizsys.psrt.srv.web.WebContext;

public class WebContextMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        String strValue;
        String strKey;
        SqlParamList sqlParamList;
        block7: {
            try {
                sqlParamList = SqlCodeHelper.getCurrentSqlParamList();
                if (arg0.size() == 0) {
                    throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u7f51\u9875\u4e0a\u4e0b\u6587\u53c2\u6570"));
                }
                strKey = arg0.get(0).toString();
                String strParam = "";
                DataContextParam iDataContextParam = null;
                boolean bIgnoreEmpty = false;
                if (arg0.size() > 1 && !StringHelper.isNullOrEmpty(strParam = arg0.get(1).toString())) {
                    iDataContextParam = new DataContextParam(strParam);
                    bIgnoreEmpty = iDataContextParam.isIgnoreEmpty();
                }
                strValue = null;
                if (WebContext.getCurrent() != null) {
                    strValue = WebContext.getCurrent().getPostOrParamValue(strKey);
                }
                if (!StringHelper.isNullOrEmpty(strValue) || !bIgnoreEmpty) break block7;
                return "";
            }
            catch (Exception ex) {
                throw new TemplateModelException(ex);
            }
        }
        SqlParam sqlParam = new SqlParam(strValue);
        sqlParam.setParamName(strKey);
        if (strValue == null) {
            sqlParam.setDataType(25);
        }
        sqlParamList.add(sqlParam);
        return "?";
    }
}

