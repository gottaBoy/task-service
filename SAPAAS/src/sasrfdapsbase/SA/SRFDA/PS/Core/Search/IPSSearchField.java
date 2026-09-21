/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Search.IPSSearchDocObject;
import java.util.Properties;

@PSModelPFIgnoreMeta
public interface IPSSearchField
extends IPSSearchDocObject {
    public static final String FIELDTYPE_TEXT = "TEXT";
    public static final String FIELDTYPE_INTEGER = "INTEGER";
    public static final String FIELDTYPE_LONG = "LONG";
    public static final String FIELDTYPE_DATE = "DATE";
    public static final String FIELDTYPE_FLOAT = "FLOAT";
    public static final String FIELDTYPE_DOUBLE = "DOUBLE";
    public static final String FIELDTYPE_BOOLEAN = "BOOLEAN";
    public static final String FIELDTYPE_OBJECT = "OBJECT";
    public static final String FIELDTYPE_AUTO = "AUTO";
    public static final String FIELDTYPE_NESTED = "NESTED";
    public static final String FIELDTYPE_IP = "IP";
    public static final String FIELDTYPE_ATTACHMENT = "ATTACHMENT";
    public static final String FIELDTYPE_KEYWORD = "KEYWORD";

    @Override
    public String getCodeName();

    public String getLogicName();

    public boolean isPKey();

    public String getFieldType();

    public int getStdDataType();

    public boolean isIndex();

    public String getDateFormat();

    public String getPattern();

    public boolean isStore();

    public boolean isFieldData();

    public String getAnalyzer();

    public String getSearchAnalyzer();

    public String[] getIgnoreFields();

    public boolean isIncludeInParent();

    public String getFieldTag();

    public String getFieldTag2();

    public Properties getFieldParams();
}

