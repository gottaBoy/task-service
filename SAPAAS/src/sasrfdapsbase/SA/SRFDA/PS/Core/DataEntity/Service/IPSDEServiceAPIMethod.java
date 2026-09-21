/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.api.IServiceAPIAction
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethodInput;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethodReturn;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Data.PSDESADetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.api.IServiceAPIAction;

@PSModelInterfaceMeta(title="\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDESADetail")
public interface IPSDEServiceAPIMethod
extends IPSModelObject,
IServiceAPIAction,
IPSDEMethod {
    public static final String METHODTYPE_UNKNOWN = "UNKNOWN";
    public static final String METHODTYPE_DEACTION = "DEACTION";
    public static final String METHODTYPE_FETCH = "FETCH";
    public static final String METHODTYPE_SELECT = "SELECT";
    public static final String METHODTYPE_FETCHTEMP = "FETCHTEMP";
    public static final String METHODTYPE_SELECTTEMP = "SELECTTEMP";
    public static final String RETVALTYPE_VOID = "VOID";
    public static final String RETVALTYPE_SIMPLE = "SIMPLE";
    public static final String RETVALTYPE_SIMPLES = "SIMPLES";
    public static final String RETVALTYPE_ENTITY = "ENTITY";
    public static final String RETVALTYPE_ENTITIES = "ENTITIES";
    public static final String RETVALTYPE_OBJECT = "OBJECT";
    public static final String RETVALTYPE_PAGE = "PAGE";
    public static final String RETVALTYPE_USER = "USER";
    public static final String RETVALTYPE_USER2 = "USER2";
    public static final String PARENTKEYMODE_DEFAULT = "DEFAULT";
    public static final String PARENTKEYMODE_CHILDOF = "CHILDOF";
    public static final String PARENTKEYMODE_IGNORE = "IGNORE";
    public static final String PARENTKEYMODE_USER = "USER";
    public static final String PARENTKEYMODE_USER2 = "USER2";
    public static final String PARENTKEYMODE_USER3 = "USER3";
    public static final String PARENTKEYMODE_USER4 = "USER4";

    public void init(ISRFDAGlobalHelper var1, IPSDEServiceAPI var2, PSDESADetail var3) throws Exception;

    public IPSDEServiceAPI getPSDEServiceAPI();

    @Override
    public String getCodeName();

    public String getCodeName2();

    @Override
    public String getMethodType();

    public IPSDEAction getPSDEAction();

    public IPSDEDataSet getPSDEDataSet();

    public IPSRESTfulAPI getPSRESTfulAPI();

    public String getMethodParam();

    public String getMethodParam2();

    public String getReturnValueType();

    public int getTempDataMode();

    public IPSSysSFPlugin getPSSysSFPlugin();

    @Override
    public IPSSFXCodeObject getRender();

    public IPSDEOPPriv getPSDEOPPriv();

    public IPSDEOPPriv getMapPSDEOPPriv(int var1);

    public IPSDEOPPriv getMapPSDEOPPrivPath0();

    public IPSDEOPPriv getMapPSDEOPPrivPath1();

    public IPSDEOPPriv getMapPSDEOPPrivPath2();

    public IPSDEOPPriv getMapPSDEOPPrivPath3();

    public IPSDEOPPriv getMapPSDEOPPrivPath4();

    public IPSDEServiceAPIRS getPSDEServiceAPIRS();

    public String getPSDEServiceAPIRSId();

    public String getParentKeyMode();

    public boolean isEnableTestMethod();

    public IPSDEMethod getPSDEMethod() throws Exception;

    public IPSDEServiceAPI getInPSDEServiceAPI() throws Exception;

    public IPSDEServiceAPI getOutPSDEServiceAPI() throws Exception;

    public IPSDEServiceAPIMethodInput getPSDEServiceAPIMethodInput();

    public IPSDEServiceAPIMethodReturn getPSDEServiceAPIMethodReturn();

    public boolean isNoServiceCodeName();

    public String getRequestParamType();

    public String getRequestField();

    public String getRequestPath();

    public String getRequestMethod();

    public String getDataAccessAction();

    public boolean isNeedResourceKey();

    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception;
}

