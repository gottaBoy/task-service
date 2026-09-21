/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;

public class PSFR7DataTypeMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        int nDataType;
        block11: {
            block10: {
                block9: {
                    block8: {
                        if (arg0.size() == 0) {
                            return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u7c7b\u578b");
                        }
                        try {
                            nDataType = Integer.parseInt((String)arg0.get(0));
                            if (!DataTypeHelper.IsStringType((int)nDataType)) break block8;
                            return "string";
                        }
                        catch (Exception e) {
                            throw new TemplateModelException(e);
                        }
                    }
                    if (!DataTypeHelper.IsLongStringType((int)nDataType)) break block9;
                    return "string";
                }
                if (!DataTypeHelper.IsDateTimeType((int)nDataType)) break block10;
                return "date";
            }
            if (!DataTypeHelper.IsIntType((int)nDataType)) break block11;
            return "int";
        }
        if (DataTypeHelper.IsDoubleType((int)nDataType)) {
            return "number";
        }
        return "auto";
    }
}

