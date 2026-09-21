/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  net.ibizsys.paas.util.DataTypeHelper
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.util.DataTypeHelper;

public class PSCSTypeMethod2
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        int nDataType;
        block15: {
            block14: {
                block13: {
                    block12: {
                        block11: {
                            block10: {
                                if (arg0.size() == 0) {
                                    return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u7c7b\u578b");
                                }
                                try {
                                    nDataType = Integer.parseInt((String)arg0.get(0));
                                    if (!DataTypeHelper.isStringType((int)nDataType)) break block10;
                                    return "String";
                                }
                                catch (Exception e) {
                                    throw new TemplateModelException(e);
                                }
                            }
                            if (!DataTypeHelper.isLongStringType((int)nDataType)) break block11;
                            return "String";
                        }
                        if (!DataTypeHelper.isDateTimeType((int)nDataType)) break block12;
                        return "DateTime";
                    }
                    if (!DataTypeHelper.isBigIntType((int)nDataType)) break block13;
                    return "BigInteger";
                }
                if (!DataTypeHelper.isIntType((int)nDataType)) break block14;
                return "Integer";
            }
            if (!DataTypeHelper.isBigDecimalType((int)nDataType)) break block15;
            return "Double";
        }
        if (DataTypeHelper.isDoubleType((int)nDataType)) {
            return "Double";
        }
        return "Object";
    }
}

