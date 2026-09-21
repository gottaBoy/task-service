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

import SA.SRFDA.PS.Core.Pub.Util.PSR7JavaTypeMethod;
import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.util.DataTypeHelper;

public class PSPythonTypeMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        int nDataType;
        block19: {
            block18: {
                block17: {
                    block16: {
                        block15: {
                            block14: {
                                block13: {
                                    block12: {
                                        if (arg0.size() == 0) {
                                            return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u7c7b\u578b");
                                        }
                                        try {
                                            nDataType = Integer.parseInt((String)arg0.get(0));
                                            if (!DataTypeHelper.isStringType((int)nDataType)) break block12;
                                            return "str";
                                        }
                                        catch (Exception e) {
                                            throw new TemplateModelException(e);
                                        }
                                    }
                                    if (!DataTypeHelper.isLongStringType((int)nDataType)) break block13;
                                    return "str";
                                }
                                if (!DataTypeHelper.isDateTimeType((int)nDataType)) break block14;
                                return "str";
                            }
                            if (!DataTypeHelper.isBigIntType((int)nDataType)) break block15;
                            return "int";
                        }
                        if (!DataTypeHelper.isIntType((int)nDataType)) break block16;
                        return "int";
                    }
                    if (!DataTypeHelper.isBigDecimalType((int)nDataType)) break block17;
                    return "float";
                }
                if (!DataTypeHelper.isDoubleType((int)nDataType)) break block18;
                return "float";
            }
            if (!DataTypeHelper.isBinaryType((int)nDataType)) break block19;
            return "byte[]";
        }
        if (PSR7JavaTypeMethod.isBooleanType(nDataType)) {
            return "bool";
        }
        return "str";
    }
}

