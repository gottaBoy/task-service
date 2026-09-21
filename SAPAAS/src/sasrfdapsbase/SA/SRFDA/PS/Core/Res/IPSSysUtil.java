/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DataEntity.IPSSysDEGroup;
import SA.SRFDA.PS.Core.DataEntity.Util.IPSDEUtil;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysUtilType;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIBase;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysUtil;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u9884\u7f6e\u529f\u80fd\u7ec4\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysUtil")
public interface IPSSysUtil
extends IPSSystemObject,
IPSDEUtil,
IPSSubSysServiceAPIBase {
    public static final String UTILTYPE_SAASADMIN = "SAASADMIN";
    public static final String UTILTYPE_FILE = "FILE";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysUtil var3) throws Exception;

    @Override
    public String getCodeName();

    public IPSSysUtilType getPSSysUtilType();

    @Override
    public String getUtilType();

    @Override
    public String getUtilPSDEId();

    @Override
    public String getUtilPSDE2Id();

    @Override
    public String getUtilPSDE3Id();

    @Override
    public String getUtilPSDE4Id();

    @Override
    public String getUtilPSDE5Id();

    @Override
    public String getUtilPSDE6Id();

    @Override
    public String getUtilPSDE7Id();

    @Override
    public String getUtilPSDE8Id();

    @Override
    public String getUtilPSDE9Id();

    @Override
    public String getUtilPSDE10Id();

    @Override
    public String getUtilPSDE11Id();

    @Override
    public String getUtilPSDE12Id();

    @Override
    public String getUtilPSDE13Id();

    @Override
    public String getUtilPSDE14Id();

    @Override
    public String getUtilPSDE15Id();

    @Override
    public String getUtilPSDE16Id();

    @Override
    public String getUtilPSDE17Id();

    @Override
    public String getUtilPSDE18Id();

    @Override
    public String getUtilPSDE19Id();

    @Override
    public String getUtilPSDE20Id();

    @Override
    public String getUtilPSDEName();

    @Override
    public String getUtilPSDE2Name();

    @Override
    public String getUtilPSDE3Name();

    @Override
    public String getUtilPSDE4Name();

    @Override
    public String getUtilPSDE5Name();

    @Override
    public String getUtilPSDE6Name();

    @Override
    public String getUtilPSDE7Name();

    @Override
    public String getUtilPSDE8Name();

    @Override
    public String getUtilPSDE9Name();

    @Override
    public String getUtilPSDE10Name();

    @Override
    public String getUtilPSDE11Name();

    @Override
    public String getUtilPSDE12Name();

    @Override
    public String getUtilPSDE13Name();

    @Override
    public String getUtilPSDE14Name();

    @Override
    public String getUtilPSDE15Name();

    @Override
    public String getUtilPSDE16Name();

    @Override
    public String getUtilPSDE17Name();

    @Override
    public String getUtilPSDE18Name();

    @Override
    public String getUtilPSDE19Name();

    @Override
    public String getUtilPSDE20Name();

    public String getUtilRTObject(IPSSysSFPub var1) throws Exception;

    public Iterator<String> getUtilRTParamNames();

    public String getUtilRTParam(String var1, String var2);

    public String getUtilRTParam(String var1);

    public boolean isRegToSys();

    @Override
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception;

    public IPSSysDataSyncAgent getInPSSysDataSyncAgent() throws Exception;

    public IPSSysDataSyncAgent getOutPSSysDataSyncAgent() throws Exception;

    public IPSSysResource getPSSysResource() throws Exception;

    public IPSSysResource getOutPSSysResource() throws Exception;

    public IPSSystemModule getPSSystemModule();

    public IPSSysModelGroup getPSSysModelGroup();

    @Override
    public String getServicePath();

    @Override
    public String getServiceParam();

    @Override
    public String getServiceParam2();

    @Override
    public String getAuthMode();

    @Override
    public String getAuthAccessTokenUrl();

    @Override
    public String getAuthClientId();

    @Override
    public String getAuthClientSecret();

    @Override
    public String getAuthParam();

    @Override
    public String getAuthParam2();

    public int getOrderValue();

    public String getRTObjectName();

    public boolean isTryMode();

    public IPSSysDEGroup getPSSysDEGroup();
}

