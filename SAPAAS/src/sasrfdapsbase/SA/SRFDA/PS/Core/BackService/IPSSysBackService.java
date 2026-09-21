/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.BackService;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysBackService;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u540e\u53f0\u670d\u52a1\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBackService")
public interface IPSSysBackService
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String SERVICECONTAINER_01 = "SC01";
    public static final String SERVICECONTAINER_02 = "SC02";
    public static final String SERVICECONTAINER_03 = "SC03";
    public static final String SERVICECONTAINER_04 = "SC04";
    public static final String SERVICECONTAINER_USER = "USER";
    public static final String TASKTYPE_PREDEFINED = "PREDEFINED";
    public static final String TASKTYPE_DEACTION = "DEACTION";
    public static final String TASKTYPE_USER = "USER";
    public static final String PREDEFINEDTYPE_DENOTIFY = "DENOTIFY";
    public static final String PREDEFINEDTYPE_SYSDATASYNCAGENT = "SYSDATASYNCAGENT";
    public static final String PREDEFINEDTYPE_WFCALLBACK = "WFCALLBACK";
    public static final String PREDEFINEDTYPE_USER = "USER";
    public static final int TIMERMODE_DISABLED = 0;
    public static final int TIMERMODE_ENABLED = 1;
    public static final int TIMERMODE_LOCAL = 2;
    public static final int TIMERMODE_STANDALONE = 3;

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysBackService var3) throws Exception;

    public String getServiceObject(IPSSysSFPub var1) throws Exception;

    public String getStartMode();

    public String getServiceContainer();

    public int getServiceOrder();

    public String getServiceParams();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public String getServiceHandler();

    public String getServiceTag();

    public String getServiceTag2();

    public String getContainerTag();

    public IPSDataEntity getPSDataEntity();

    public IPSDEAction getPSDEAction();

    public IPSDEDataSet getPSDEDataSet();

    public String getServicePolicy();

    public String getServicePolicy2();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();

    public boolean isTimerMode();

    public boolean isLocalMode();

    public boolean isStandalone();

    public String getTimerPolicy();

    public String getTaskType();

    public String getPredefinedType();
}

