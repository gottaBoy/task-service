/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEActionParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", description="", model="PSDEActionParam")
public interface IPSDEActionParam
extends IPSModelObject,
IPSModelSortable {
    public static final String VALUETYPE_INPUTVALUE = "INPUTVALUE";
    public static final String VALUETYPE_VALUE = "VALUE";
    public static final String VALUETYPE_NULLVALUE = "NULLVALUE";
    public static final String VALUETYPE_SESSION = "SESSION";
    public static final String VALUETYPE_APPLICATION = "APPLICATION";
    public static final String VALUETYPE_UNIQUEID = "UNIQUEID";
    public static final String VALUETYPE_CONTEXT = "CONTEXT";
    public static final String VALUETYPE_PARAM = "PARAM";
    public static final String VALUETYPE_OPERATOR = "OPERATOR";
    public static final String VALUETYPE_OPERATORNAME = "OPERATORNAME";
    public static final String VALUETYPE_CURTIME = "CURTIME";
    public static final String VALUETYPE_APPDATA = "APPDATA";
    public static final String VALUETYPE_NONEVALUE = "NONEVALUE";

    public void init(ISRFDAGlobalHelper var1, IPSDEAction var2, PSDEActionParam var3) throws Exception;

    public IPSDEField getPSDEField();

    public IPSDEAction getPSDEAction();

    public String getValueType();

    public String getValue();

    public int getStdDataType();

    public boolean isArray();

    public boolean isAllowEmpty();

    public String getParamTag();

    public String getParamTag2();

    public String getParamDesc();

    public String getJsonFormat();
}

