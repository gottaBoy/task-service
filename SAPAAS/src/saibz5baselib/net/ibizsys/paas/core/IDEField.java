/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IDEFDBValueFunc;
import net.ibizsys.paas.core.IDEFDTColumn;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;

public interface IDEField
extends IModelBase {
    public static final int ENABLEUSERINPUT_NONE = 0;
    public static final int ENABLEUSERINPUT_INSERT = 1;
    public static final int ENABLEUSERINPUT_UPDATE = 2;
    public static final int ENABLEUSERINPUT_INVISIBLE = 4;
    public static final int ENABLEUSERINPUT_ALL = 3;
    public static final String STRINGCASE_UCASE = "UCASE";
    public static final String STRINGCASE_LCASE = "LCASE";
    public static final String DATATYPE_TEXT = "TEXT";
    public static final String DATATYPE_GUID = "GUID";
    public static final String DATATYPE_ACID = "ACID";
    public static final String DATATYPE_LONGTEXT_1000 = "LONGTEXT_1000";
    public static final String DATATYPE_LONGTEXT = "LONGTEXT";
    public static final String DATATYPE_HTMLTEXT = "HTMLTEXT";
    public static final String DATATYPE_INT = "INT";
    public static final String DATATYPE_BIGINT = "BIGINT";
    public static final String DATATYPE_SBID = "SBID";
    public static final String DATATYPE_NBID = "NBID";
    public static final String DATATYPE_FLOAT = "FLOAT";
    public static final String DATATYPE_DECIMAL = "DECIMAL";
    public static final String DATATYPE_BIGDECIMAL = "BIGDECIMAL";
    public static final String DATATYPE_DATE = "DATE";
    public static final String DATATYPE_TIME = "TIME";
    public static final String DATATYPE_DATETIME = "DATETIME";
    public static final String DATATYPE_SSCODELIST = "SSCODELIST";
    public static final String DATATYPE_SMCODELIST = "SMCODELIST";
    public static final String DATATYPE_NSCODELIST = "NSCODELIST";
    public static final String DATATYPE_NMCODELIST = "NMCODELIST";
    public static final String DATATYPE_PICKUP = "PICKUP";
    public static final String DATATYPE_PICKUPTEXT = "PICKUPTEXT";
    public static final String DATATYPE_PICKUPDATA = "PICKUPDATA";
    public static final String DATATYPE_INHERIT = "INHERIT";
    public static final String DATATYPE_YESNO = "YESNO";
    public static final String DATATYPE_TRUEFALSE = "TRUEFALSE";
    public static final String DATATYPE_CURRENCY = "CURRENCY";
    public static final String DATATYPE_CURRENCYUNIT = "CURRENCYUNIT";
    public static final String DATATYPE_WFSTATE = "WFSTATE";
    public static final String DATATYPE_DATETIME_BIRTHDAY = "DATETIME_BIRTHDAY";
    public static final String DATATYPE_TEXT_EMAIL = "TEXT_EMAIL";
    public static final String DATATYPE_BINARY = "BINARY";
    public static final String UPDATEOVMODE_ALWAYS = "ALWAYS";
    public static final String UPDATEOVMODE_NOTEXISTS = "NOTEXISTS";
    public static final String PREDEFINEDTYPE_LOGICVALID = "LOGICVALID";
    public static final String PREDEFINEDTYPE_CREATEMAN = "CREATEMAN";
    public static final String PREDEFINEDTYPE_CREATEMANNAME = "CREATEMANNAME";
    public static final String PREDEFINEDTYPE_CREATEDATE = "CREATEDATE";
    public static final String PREDEFINEDTYPE_UPDATEMAN = "UPDATEMAN";
    public static final String PREDEFINEDTYPE_UPDATEMANNAME = "UPDATEMANNAME";
    public static final String PREDEFINEDTYPE_UPDATEDATE = "UPDATEDATE";
    public static final String PREDEFINEDTYPE_ORGID = "ORGID";
    public static final String PREDEFINEDTYPE_ORGSECTORID = "ORGSECTORID";
    public static final String PREDEFINEDTYPE_ORGNAME = "ORGNAME";
    public static final String PREDEFINEDTYPE_ORGSECTORNAME = "ORGSECTORNAME";
    public static final String PREDEFINEDTYPE_ORDERVALUE = "ORDERVALUE";
    public static final String UNIONKEYVALUE_KEY1 = "KEY1";
    public static final String UNIONKEYVALUE_KEY2 = "KEY2";
    public static final String UNIONKEYVALUE_KEY3 = "KEY3";
    public static final String UNIONKEYVALUE_KEY4 = "KEY4";
    public static final String UNIONKEYVALUE_KEY5 = "KEY5";
    public static final String UNIONKEYVALUE_KEY6 = "KEY6";
    public static final String UNIONKEYVALUE_KEY7 = "KEY7";
    public static final String UNIONKEYVALUE_KEY8 = "KEY8";
    public static final int DEFTYPE_UNKNOWN = 0;
    public static final int DEFTYPE_PHISICAL = 1;
    public static final int DEFTYPE_FORMULA = 2;
    public static final int DEFTYPE_LINK = 3;
    public static final int DEFTYPE_DYNASTORAGE = 4;
    public static final int DEFTYPE_UI = 5;
    public static final String DBVALUEMODE_VERSION = "VERSION";
    public static final String DBVALUEMODE_CURDATETIME = "CURDATETIME";
    public static final String DBVALUEMODE_CURDATE = "CURDATE";
    public static final String DBVALUEMODE_VALUEFUNC = "VALUEFUNC";
    public static final String DBVALUEMODE_IGNORE = "IGNORE";

    public IDataEntity getDataEntity();

    public String getLogicName();

    public String getLogicName(String var1);

    public boolean isKeyDEField();

    public boolean isUniTagField();

    public boolean isMajorDEField();

    public boolean isLinkDEField();

    public String getDataType();

    public int getStdDataType();

    public boolean isEnableQuickSearch();

    public Iterator<IDEFSearchMode> getDEFSearchModes();

    public boolean isEnablePrivilege();

    public String getCodeListId();

    public IDEFValueRule getDEFValueRule(String var1) throws Exception;

    public String getPreDefinedType();

    public boolean isFormulaDEField();

    public boolean isPhisicalDEField();

    public boolean isInheritDEField();

    @Deprecated
    public String getDBValueFunc();

    public String getDBValueInsertMode();

    public String getDBValueUpdateMode();

    public boolean isEnableDBValueInsertUpdateMode();

    public int getImportOrder();

    public String getImportTag();

    public String getMemo();

    public String getDERName();

    public String getLinkDEFName();

    public String getValueFormat();

    public boolean isEnableAudit();

    public String getAuditInfoFormat();

    public boolean isMultiFormDEField();

    public boolean isIndexTypeDEField();

    public boolean isEnableTempData();

    public String getUnionKeyValue();

    public boolean isEnableDBAutoValue();

    public IDEFDBValueFunc getDEFDBValueFunc(String var1, boolean var2) throws Exception;

    public IDEFDTColumn getDEFDTColumn(String var1) throws Exception;

    public int getDEFType();

    public boolean isDynaStorageDEField();
}

