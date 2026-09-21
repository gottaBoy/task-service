/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.dts.IDTSQueue
 */
package SA.SRFDA.PS.Core.DTS;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysDTSQueue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.dts.IDTSQueue;

@PSModelPFIgnoreMeta
public interface IPSSysDTSQueue
extends IPSSystemObject,
IDTSQueue,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysDTSQueue var3) throws Exception;

    public String getDEName();

    public String getHistoryDEName();

    public String getStateField();

    public String getErrorField();

    public String getTimeField();

    public String getConfirmDEActionName();

    public String getCancelDEActionName();

    public int getCancelTimeout();

    public int getRefreshTimer();

    public String getPushDEActionName();

    public String getRefreshDEActionName();

    public IPSDataEntity getPSDataEntity();

    public IPSDEField getStatePSDEField();

    public IPSDEField getErrorPSDEField();

    public IPSDEField getTimePSDEField();

    public IPSDEAction getCancelPSDEAction();

    public IPSDEAction getConfirmPSDEAction();

    public IPSDEAction getPushPSDEAction();

    public IPSDEAction getRefreshPSDEAction();

    public IPSDataEntity getHistoryPSDataEntity();

    public IPSSystemModule getPSSystemModule();

    public String getCreatedState();

    public String getProcessingState();

    public String getFinishedState();

    public String getFailedState();

    public String getCancelledState();
}

