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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.SqlCodeHelper;
import net.ibizsys.paas.web.WebContext;

public class SessionContextMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        try {
            SqlParamList sqlParamList = SqlCodeHelper.getCurrentSqlParamList();
            if (arg0.size() == 0) {
                throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u6570\u636e\u53c2\u6570"));
            }
            String strKey = arg0.get(0).toString();
            Object objValue = WebContext.getCurrent().getSessionValue(strKey);
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

