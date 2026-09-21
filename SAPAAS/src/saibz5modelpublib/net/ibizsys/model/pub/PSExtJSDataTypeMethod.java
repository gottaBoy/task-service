/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.pub;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSExtJSDataTypeMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        int nDataType;
        block11: {
            block10: {
                block9: {
                    block8: {
                        if (arg0.size() == 0) {
                            return StringHelper.format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u7c7b\u578b");
                        }
                        try {
                            nDataType = Integer.parseInt((String)arg0.get(0));
                            if (!DataTypeHelper.isStringType((int)nDataType)) break block8;
                            return "string";
                        }
                        catch (Exception e) {
                            throw new TemplateModelException(e);
                        }
                    }
                    if (!DataTypeHelper.isLongStringType((int)nDataType)) break block9;
                    return "string";
                }
                if (!DataTypeHelper.isDateTimeType((int)nDataType)) break block10;
                return "date";
            }
            if (!DataTypeHelper.isIntType((int)nDataType)) break block11;
            return "int";
        }
        if (DataTypeHelper.isDoubleType((int)nDataType)) {
            return "number";
        }
        return "auto";
    }
}

