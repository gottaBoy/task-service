/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDSParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDSParam")
public interface IPSDEDataSetParam
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

    public void init(ISRFDAGlobalHelper var1, IPSDEDataSet var2, PSDEDSParam var3) throws Exception;

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEField getPSDEField() throws Exception;

    public IPSDEFSearchMode getPSDEFSearchMode() throws Exception;

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

