/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.util;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;

public class PSDEFDataTypeHelper {
    public static final String ACID = "ACID";
    public static final String BIGDECIMAL = "BIGDECIMAL";
    public static final String BIGINT = "BIGINT";
    public static final String CODELISTTEXT = "CODELISTTEXT";
    public static final String CURRENCY = "CURRENCY";
    public static final String CURRENCYUNIT = "CURRENCYUNIT";
    public static final String DATE = "DATE";
    public static final String DATETIME = "DATETIME";
    public static final String DATETIME_BIRTHDAY = "DATETIME_BIRTHDAY";
    public static final String DECIMAL = "DECIMAL";
    public static final String FLOAT = "FLOAT";
    public static final String GUID = "GUID";
    public static final String HTMLTEXT = "HTMLTEXT";
    public static final String INHERIT = "INHERIT";
    public static final String INT = "INT";
    public static final String LONGTEXT = "LONGTEXT";
    public static final String LONGTEXT_1000 = "LONGTEXT_1000";
    public static final String NBID = "NBID";
    public static final String NMCODELIST = "NMCODELIST";
    public static final String NSCODELIST = "NSCODELIST";
    public static final String ONE2MANYDATA = "ONE2MANYDATA";
    public static final String PICKUP = "PICKUP";
    public static final String PICKUPDATA = "PICKUPDATA";
    public static final String PICKUPOBJECT = "PICKUPOBJECT";
    public static final String PICKUPTEXT = "PICKUPTEXT";
    public static final String SBID = "SBID";
    public static final String SMCODELIST = "SMCODELIST";
    public static final String SSCODELIST = "SSCODELIST";
    public static final String TEXT = "TEXT";
    public static final String TEXT_EMAIL = "TEXT_EMAIL";
    public static final String TIME = "TIME";
    public static final String TRUEFALSE = "TRUEFALSE";
    public static final String VARBINARY = "VARBINARY";
    public static final String WFSTATE = "WFSTATE";
    public static final String YESNO = "YESNO";
    private static Map<String, String> dataTypeNameMap = new HashMap<String, String>();
    private static Map<String, Integer> dataTypeStdMap = new HashMap<String, Integer>();

    public static String getName(String string) {
        return dataTypeNameMap.get(string);
    }

    public static int getStdDataType(String string) {
        Integer n = dataTypeStdMap.get(string);
        if (n == null) {
            return 0;
        }
        return n;
    }

    public static void fillPSDEField(PSDEField pSDEField, int n, int n2, int n3) throws Exception {
        switch (n) {
            case 1: {
                pSDEField.setPSDataTypeId(BIGINT);
                if (n2 <= 0) break;
                pSDEField.setLength(n2);
                break;
            }
            case 3: {
                pSDEField.setPSDataTypeId(YESNO);
                break;
            }
            case 4: 
            case 11: {
                pSDEField.setPSDataTypeId(TEXT);
                pSDEField.setLength(1);
                break;
            }
            case 5: 
            case 16: 
            case 22: {
                pSDEField.setPSDataTypeId(DATETIME);
                break;
            }
            case 27: {
                pSDEField.setPSDataTypeId(DATE);
                break;
            }
            case 28: {
                pSDEField.setPSDataTypeId(TIME);
                break;
            }
            case 6: 
            case 10: 
            case 14: 
            case 15: 
            case 29: {
                pSDEField.setPSDataTypeId(BIGDECIMAL);
                if (n2 >= 0) {
                    pSDEField.setLength(n2);
                }
                if (n3 < 0) break;
                pSDEField.setPrecision2(n3);
                break;
            }
            case 7: 
            case 18: {
                pSDEField.setPSDataTypeId(FLOAT);
                if (n2 >= 0) {
                    pSDEField.setLength(n2);
                }
                if (n3 < 0) break;
                pSDEField.setPrecision2(n3);
                break;
            }
            case 9: 
            case 17: 
            case 23: {
                pSDEField.setPSDataTypeId(INT);
                if (n2 <= 0) break;
                pSDEField.setLength(n2);
                break;
            }
            case 12: 
            case 21: {
                pSDEField.setPSDataTypeId(LONGTEXT);
                if (n2 <= 0) break;
                pSDEField.setLength(n2);
                break;
            }
            case 13: 
            case 20: 
            case 25: {
                pSDEField.setPSDataTypeId(TEXT);
                if (n2 <= 0) break;
                pSDEField.setLength(n2);
                break;
            }
            case 26: {
                pSDEField.setPSDataTypeId(GUID);
                if (n2 <= 0) break;
                pSDEField.setLength(n2);
                break;
            }
            case 2: 
            case 8: 
            case 24: {
                pSDEField.setPSDataTypeId(VARBINARY);
                if (n2 <= 0) break;
                pSDEField.setLength(n2);
                break;
            }
            case 0: 
            case 19: {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u652f\u6301\u7684\u6570\u636e\u7c7b\u578b[%1$s]", (Object)DataTypeHelper.getTypeName((int)n)));
            }
        }
        pSDEField.setPSDataTypeName(PSDEFDataTypeHelper.getName(pSDEField.getPSDataTypeId()));
    }

    static {
        dataTypeNameMap.put(ACID, "\u81ea\u589e\u6807\u8bc6\uff0c\u6574\u6570\u7c7b\u578b\uff0c\u7528\u6237\u4e0d\u53ef\u89c1");
        dataTypeNameMap.put(BIGDECIMAL, "\u5927\u6570\u503c");
        dataTypeNameMap.put(BIGINT, "\u5927\u6574\u578b");
        dataTypeNameMap.put(CODELISTTEXT, "\u9009\u62e9\u9879\u6587\u672c");
        dataTypeNameMap.put(CURRENCY, "\u8d27\u5e01");
        dataTypeNameMap.put(CURRENCYUNIT, "\u8d27\u5e01\u5355\u4f4d");
        dataTypeNameMap.put(DATE, "\u65e5\u671f\u578b");
        dataTypeNameMap.put(DATETIME, "\u65e5\u671f\u65f6\u95f4\u578b");
        dataTypeNameMap.put(DATETIME_BIRTHDAY, "\u51fa\u751f\u65e5\u671f");
        dataTypeNameMap.put(DECIMAL, "\u6570\u503c");
        dataTypeNameMap.put(FLOAT, "\u6d6e\u70b9");
        dataTypeNameMap.put(GUID, "\u5168\u5c40\u552f\u4e00\u6807\u8bc6\uff0c\u6587\u672c\u7c7b\u578b\uff0c\u7528\u6237\u4e0d\u53ef\u89c1");
        dataTypeNameMap.put(HTMLTEXT, "HTML\u6587\u672c\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236");
        dataTypeNameMap.put(INHERIT, "\u7ee7\u627f\u5c5e\u6027");
        dataTypeNameMap.put(INT, "\u6574\u578b");
        dataTypeNameMap.put(LONGTEXT, "\u957f\u6587\u672c\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236");
        dataTypeNameMap.put(LONGTEXT_1000, "\u957f\u6587\u672c\uff0c\u957f\u5ea61000");
        dataTypeNameMap.put(NBID, "\u6570\u5b57\u4e32\u4e1a\u52a1\u6807\u8bc6\uff0c\u6570\u5b57\u7c7b\u578b\uff0c\u7528\u6237\u53ef\u89c1");
        dataTypeNameMap.put(NMCODELIST, "\u591a\u9879\u9009\u62e9(\u6570\u503c)");
        dataTypeNameMap.put(NSCODELIST, "\u5355\u9879\u9009\u62e9(\u6570\u503c)");
        dataTypeNameMap.put(ONE2MANYDATA, "\u4e00\u5bf9\u591a\u5173\u7cfb\u6570\u636e\u96c6\u5408");
        dataTypeNameMap.put(PICKUP, "\u5916\u952e\u503c");
        dataTypeNameMap.put(PICKUPDATA, "\u5916\u952e\u503c\u9644\u52a0\u6570\u636e");
        dataTypeNameMap.put(PICKUPOBJECT, "\u5916\u952e\u503c\u5bf9\u8c61");
        dataTypeNameMap.put(PICKUPTEXT, "\u5916\u952e\u503c\u6587\u672c");
        dataTypeNameMap.put(SBID, "\u5b57\u7b26\u4e32\u4e1a\u52a1\u6807\u8bc6\uff0c\u6587\u672c\u7c7b\u578b\uff0c\u7528\u6237\u53ef\u89c1");
        dataTypeNameMap.put(SMCODELIST, "\u591a\u9879\u9009\u62e9(\u6587\u672c\u503c)");
        dataTypeNameMap.put(SSCODELIST, "\u5355\u9879\u9009\u62e9(\u6587\u672c\u503c)");
        dataTypeNameMap.put(TEXT, "\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6");
        dataTypeNameMap.put(TEXT_EMAIL, "\u7535\u5b50\u90ae\u4ef6");
        dataTypeNameMap.put(TIME, "\u65f6\u95f4\u578b");
        dataTypeNameMap.put(TRUEFALSE, "\u771f\u5047\u903b\u8f91");
        dataTypeNameMap.put(VARBINARY, "\u4e8c\u8fdb\u5236\u6d41\uff0c\u6ca1\u6709\u957f\u5ea6\u9650\u5236");
        dataTypeNameMap.put(WFSTATE, "\u5de5\u4f5c\u6d41\u5904\u7406\u72b6\u6001");
        dataTypeNameMap.put(YESNO, "\u662f\u5426\u903b\u8f91");
        dataTypeStdMap.put(ACID, 1);
        dataTypeStdMap.put(BIGDECIMAL, 6);
        dataTypeStdMap.put(BIGINT, 1);
        dataTypeStdMap.put(CODELISTTEXT, 25);
        dataTypeStdMap.put(CURRENCY, 25);
        dataTypeStdMap.put(CURRENCYUNIT, 25);
        dataTypeStdMap.put(DATE, 5);
        dataTypeStdMap.put(DATETIME, 5);
        dataTypeStdMap.put(DATETIME_BIRTHDAY, 5);
        dataTypeStdMap.put(DECIMAL, 6);
        dataTypeStdMap.put(FLOAT, 7);
        dataTypeStdMap.put(GUID, 25);
        dataTypeStdMap.put(HTMLTEXT, 21);
        dataTypeStdMap.put(INT, 9);
        dataTypeStdMap.put(LONGTEXT, 21);
        dataTypeStdMap.put(LONGTEXT_1000, 25);
        dataTypeStdMap.put(NBID, 9);
        dataTypeStdMap.put(NMCODELIST, 9);
        dataTypeStdMap.put(NSCODELIST, 9);
        dataTypeStdMap.put(ONE2MANYDATA, 21);
        dataTypeStdMap.put(PICKUPOBJECT, 21);
        dataTypeStdMap.put(SBID, 25);
        dataTypeStdMap.put(SMCODELIST, 25);
        dataTypeStdMap.put(SSCODELIST, 25);
        dataTypeStdMap.put(TEXT, 25);
        dataTypeStdMap.put(TEXT_EMAIL, 25);
        dataTypeStdMap.put(TIME, 5);
        dataTypeStdMap.put(TRUEFALSE, 9);
        dataTypeStdMap.put(WFSTATE, 9);
        dataTypeStdMap.put(YESNO, 9);
    }
}

