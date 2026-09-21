/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswf.core.IWFProcessModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFProcessParam;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWFWorkTime;
import SA.SRFDA.PS.Data.PSWFProcess;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.pswf.core.IWFProcessModel;

@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5904\u7406\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="wFProcessType", implement="PSWFProcessImpl", model="PSWFProcess")
public interface IPSWFProcess
extends IPSObject,
IWFProcessModel,
IPSModelObject {
    public static final String WFPROCESSTYPE_CALLORGACTIVITY = "CALLORGACTIVITY";
    public static final String WFPROCESSTYPE_EMBED = "EMBED";
    public static final String WFPROCESSTYPE_END = "END";
    public static final String WFPROCESSTYPE_EXCLUSIVEGATEWAY = "EXCLUSIVEGATEWAY";
    public static final String WFPROCESSTYPE_INCLUSIVEGATEWAY = "INCLUSIVEGATEWAY";
    public static final String WFPROCESSTYPE_INTERACTIVE = "INTERACTIVE";
    public static final String WFPROCESSTYPE_PARALLEL = "PARALLEL";
    public static final String WFPROCESSTYPE_PARALLELGATEWAY = "PARALLELGATEWAY";
    public static final String WFPROCESSTYPE_PROCESS = "PROCESS";
    public static final String WFPROCESSTYPE_START = "START";
    public static final String WFPROCESSTYPE_TIMEREVENT = "TIMEREVENT";
    public static final String TIMEOUTTYPE_MINUTE = "MINUTE";
    public static final String TIMEOUTTYPE_HOUR = "HOUR";
    public static final String TIMEOUTTYPE_DAY = "DAY";
    public static final String TIMEOUTTYPE_WORKDAY = "WORKDAY";

    public void init(ISRFDAGlobalHelper var1, IPSWFVersion var2, PSWFProcess var3) throws Exception;

    public Iterator<IPSWFLink> getPSWFLinks();

    public Iterator<IPSWFProcessParam> getPSWFProcessParams();

    public String getWFProcessType();

    public IPSWFVersion getPSWFVersion();

    @Override
    public String getCodeName();

    public boolean isParallelOutput();

    public String getWFStepValue();

    public IPSLanguageRes getNamePSLanguageRes();

    public IPSLanguageRes getTSNPSLanguageRes();

    public int getWidth();

    public int getHeight();

    public IPSSysMsgTempl getPSSysMsgTempl();

    public IPSWFWorkTime getPSWFWorkTime();

    public IPSDEWF getPSDEWF();

    public String getLogicName();

    public boolean isAsynchronousProcess();

    public boolean isSuspendProcess();

    public boolean isTerminalProcess();

    public boolean isStartProcess();

    public boolean isEnableTimeout();

    public String getTimeoutNext();

    public int getTimeout();

    public String getTimeoutField();

    public String getTimeoutType();

    public String getWorkTimeType();

    public int getLeftPos();

    public int getTopPos();

    public String getUserData();

    public String getUserData2();

    public int getThreadSN();

    public String getThreadShowName();

    public String getBPMNModelId();
}

