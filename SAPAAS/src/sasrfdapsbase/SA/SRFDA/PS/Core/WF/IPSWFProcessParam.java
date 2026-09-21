/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswf.core.IWFDEActionProcessParamModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Data.PSWFProcParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.pswf.core.IWFDEActionProcessParamModel;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5904\u7406\u8282\u70b9\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWFProcParam")
public interface IPSWFProcessParam
extends IPSModelObject,
IWFDEActionProcessParamModel {
    public static final String SRCVALUETYPE_SESSION = "SESSION";
    public static final String SRCVALUETYPE_APPLICATION = "APPLICATION";
    public static final String SRCVALUETYPE_UNIQUEID = "UNIQUEID";
    public static final String SRCVALUETYPE_CONTEXT = "CONTEXT";
    public static final String SRCVALUETYPE_OPERATOR = "OPERATOR";
    public static final String SRCVALUETYPE_OPERATORNAME = "OPERATORNAME";
    public static final String SRCVALUETYPE_CURTIME = "CURTIME";

    public void init(ISRFDAGlobalHelper var1, IPSWFProcess var2, PSWFProcParam var3) throws Exception;

    public IPSWFProcess getPSWFProcess();

    public String getDstField() throws Exception;

    public String getSrcValue();

    public String getDirectCode();

    public String getSrcValueType();

    public String getUserData();

    public String getUserData2();
}

