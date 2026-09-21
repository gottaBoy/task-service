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

public class PSR8JavaTypeMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        int nDataType;
        block23: {
            block22: {
                block21: {
                    boolean bFull;
                    block20: {
                        block19: {
                            block18: {
                                block17: {
                                    block16: {
                                        if (arg0.size() == 0) {
                                            return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u7c7b\u578b");
                                        }
                                        try {
                                            nDataType = Integer.parseInt((String)arg0.get(0));
                                            bFull = true;
                                            if (arg0.size() > 1) {
                                                bFull = arg0.get(1).toString().equals("true");
                                            }
                                            if (!PSR8JavaTypeMethod.isStringType(nDataType)) break block16;
                                            return "String";
                                        }
                                        catch (Exception e) {
                                            throw new TemplateModelException(e);
                                        }
                                    }
                                    if (!PSR8JavaTypeMethod.isLongStringType(nDataType)) break block17;
                                    return "String";
                                }
                                if (!PSR8JavaTypeMethod.isDateTimeType(nDataType)) break block18;
                                if (bFull) {
                                    return "java.sql.Timestamp";
                                }
                                return "Timestamp";
                            }
                            if (!PSR8JavaTypeMethod.isBigIntType(nDataType)) break block19;
                            if (bFull) {
                                return "java.math.BigInteger";
                            }
                            return "BigInteger";
                        }
                        if (!PSR8JavaTypeMethod.isIntType(nDataType)) break block20;
                        return "Integer";
                    }
                    if (!PSR8JavaTypeMethod.isBigDecimalType(nDataType)) break block21;
                    if (bFull) {
                        return "java.math.BigDecimal";
                    }
                    return "BigDecimal";
                }
                if (!PSR8JavaTypeMethod.isDoubleType(nDataType)) break block22;
                return "Double";
            }
            if (!PSR8JavaTypeMethod.isBinaryType(nDataType)) break block23;
            return "byte[]";
        }
        if (PSR8JavaTypeMethod.isBooleanType(nDataType)) {
            return "Boolean";
        }
        return "Object";
    }

    public static boolean isStringDataType(int dataType) {
        switch (dataType) {
            case 4: 
            case 11: 
            case 12: 
            case 13: 
            case 20: 
            case 21: 
            case 25: {
                return true;
            }
        }
        return false;
    }

    public static boolean isDateTimeDataType(int dataType) {
        switch (dataType) {
            case 5: 
            case 16: 
            case 22: 
            case 27: 
            case 28: {
                return true;
            }
        }
        return false;
    }

    public static final boolean isStringType(int dataType) {
        return dataType == 4 || dataType == 11 || dataType == 12 || dataType == 13 || dataType == 20 || dataType == 21 || dataType == 25;
    }

    public static final boolean isStringType(String strDataType) {
        return PSR8JavaTypeMethod.isStringType(DataTypeHelper.fromString((String)strDataType));
    }

    public static final boolean isLongStringType(int dataType) {
        return dataType == 8 || dataType == 12 || dataType == 21;
    }

    public static final boolean isDateTimeType(int dataType) {
        return dataType == 5 || dataType == 16 || dataType == 27 || dataType == 28;
    }

    public static final boolean isDateTimeType(String strDataType) {
        return PSR8JavaTypeMethod.isDateTimeType(DataTypeHelper.fromString((String)strDataType));
    }

    public static final boolean isIntType(int dataType) {
        return dataType == 9 || dataType == 17 || dataType == 1 || dataType == 23;
    }

    public static final boolean isIntType(String strDataType) {
        return PSR8JavaTypeMethod.isIntType(DataTypeHelper.fromString((String)strDataType));
    }

    public static final boolean isBigIntType(int dataType) {
        return dataType == 1;
    }

    public static final boolean isBigDecimalType(int dataType) {
        return dataType == 29 || dataType == 6;
    }

    public static final boolean isBigIntType(String strDataType) {
        return PSR8JavaTypeMethod.isBigIntType(DataTypeHelper.fromString((String)strDataType));
    }

    public static final boolean isBigDecimalType(String strDataType) {
        return PSR8JavaTypeMethod.isBigDecimalType(DataTypeHelper.fromString((String)strDataType));
    }

    public static final boolean isDoubleType(int dataType) {
        return dataType == 7 || dataType == 10 || dataType == 18 || dataType == 14 || dataType == 15;
    }

    public static final boolean isBinaryType(int dataType) {
        return dataType == 2 || dataType == 24;
    }

    public static final boolean isBinaryType(String strDataType) {
        return PSR8JavaTypeMethod.isBinaryType(DataTypeHelper.fromString((String)strDataType));
    }

    public static final boolean isBooleanType(int dataType) {
        return dataType == 3;
    }
}

