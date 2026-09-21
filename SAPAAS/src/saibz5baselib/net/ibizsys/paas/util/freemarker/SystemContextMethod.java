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
import java.sql.Timestamp;
import java.util.List;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.SqlCodeHelper;

public class SystemContextMethod
implements TemplateMethodModel {
    public static final String DATETIME = "DATETIME";

    public Object exec(List arg0) throws TemplateModelException {
        String strKey;
        block4: {
            try {
                SqlParamList sqlParamList = SqlCodeHelper.getCurrentSqlParamList();
                if (arg0.size() == 0) {
                    throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u7cfb\u7edf\u53c2\u6570"));
                }
                strKey = arg0.get(0).toString();
                if (StringHelper.compare(strKey, DATETIME, true) != 0) break block4;
                SqlParam sqlParam = new SqlParam(new Timestamp(System.currentTimeMillis()));
                sqlParam.setParamName(strKey);
                sqlParamList.add(sqlParam);
                return "?";
            }
            catch (Exception ex) {
                throw new TemplateModelException(ex);
            }
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u5f53\u524d\u7cfb\u7edf\u53c2\u6570[%1$s]", strKey));
    }
}

