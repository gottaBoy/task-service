/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.api.IRestServiceAPIAction
 *  net.ibizsys.paas.api.IServiceAPIAction
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Service.IPSDEActionRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Operation;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Path;
import SA.SRFDA.PS.Data.PSSubSysSADetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.api.IRestServiceAPIAction;
import net.ibizsys.paas.api.IServiceAPIAction;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5916\u90e8\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSubSysSADetail")
public interface IPSSubSysServiceAPIMethod
extends IServiceAPIAction,
IRestServiceAPIAction,
IPSDEActionRESTfulAPI,
IPSModelObject {
    public static final String METHODTYPE_DEACTION = "DEACTION";
    public static final String METHODTYPE_DEDATAQUERY = "DEDATAQUERY";
    public static final String METHODTYPE_DEDATASET = "DEDATASET";
    public static final String METHODTYPE_SELECT = "SELECT";
    public static final String METHODTYPE_USER = "USER";
    public static final String METHODTYPE_USER2 = "USER2";
    public static final String METHODTYPE_USER3 = "USER3";
    public static final String METHODTYPE_USER4 = "USER4";
    public static final String INPUTPARAMTYPE_NONE = "NONE";
    public static final String INPUTPARAMTYPE_FIELD = "FIELD";
    public static final String INPUTPARAMTYPE_FIELDS = "FIELDS";
    public static final String INPUTPARAMTYPE_ENTITY = "ENTITY";
    public static final String INPUTPARAMTYPE_ENTITIES = "ENTITIES";
    public static final String INPUTPARAMTYPE_OBJECT = "OBJECT";
    public static final String INPUTPARAMTYPE_OBJECTS = "OBJECTS";

    public void init(ISRFDAGlobalHelper var1, IPSSubSysServiceAPI var2, IPSDataEntity var3, PSSubSysSADetail var4, Object var5) throws Exception;

    public IPSSubSysServiceAPI getPSSubSysServiceAPI();

    public String getMethodType();

    public IPSRESTfulAPI getPSRESTfulAPI();

    public String getPSDEId();

    public String getPSDEName();

    public String getPSDELogicName();

    public String getPSDECodeName();

    @Override
    public String getCodeName();

    public String getCodeName2();

    public String getMethodParam();

    public String getMethodParam2();

    public String getMethodTag();

    public String getMethodTag2();

    public String getReturnValueType();

    public int getReturnStdDataType();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public String getInputParamType();

    public boolean isNoServiceCodeName();

    public boolean isNeedResourceKey();

    @Override
    public String getRequestParamType();

    @Override
    public String getRequestField();

    @Override
    public String getRequestPath();

    @Override
    public String getRequestMethod();

    public IPSOpenAPI3Operation getPSOpenAPI3Operation();

    public IPSOpenAPI3Path getPSOpenAPI3Path();

    public String getAfterCode();

    public String getMethodScriptCode();

    public boolean isAutoPath();

    public String getBodyContentType();
}

