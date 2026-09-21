/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTask;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTaskGlobal;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTaskGlobalContext;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBTType;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskSession;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskGlobalBase;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskSessionBase;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Data.PSDCBKTask;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevCenterBKTaskGlobal
extends PSBKTaskGlobalBase
implements IPSDevCenterBKTaskGlobal,
IPSDevCenterBKTaskGlobalContext {
    private static final Log log = LogFactory.getLog(PSDevCenterBKTaskSession.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, int nQueueCount, int nSessionTimeout) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        super.init(iDAGlobalHelper, nQueueCount, nSessionTimeout);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public void addPSDCBKTask(PSDCBKTask psDevCenterBKTask) throws Exception {
        final PSDCBKTask psDevCenterBKTask2 = psDevCenterBKTask;
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

            @Override
            public void execute(Object obj) throws Exception {
                PSDevCenterBKTaskGlobal.this.onAddPSDCBKTask(psDevCenterBKTask2);
            }
        });
    }

    protected void onAddPSDCBKTask(PSDCBKTask psDevCenterBKTask) throws Exception {
        IPSDevCenterBTType iPSDevCenterBTType = this.getPSModelStorage().getPSDevCenterBTType(psDevCenterBKTask.getTASKTYPE());
        IPSDevCenterBKTask iPSDevCenterBKTask = iPSDevCenterBTType.createPSDevCenterBKTask(psDevCenterBKTask);
        iPSDevCenterBKTask.init(this.getDAGlobalHelper(), null, psDevCenterBKTask);
        PSBKTaskSessionBase psDevCenterBKTaskSession = this.getPSBKTaskSession(psDevCenterBKTask.getPSDEVCENTERID());
        psDevCenterBKTaskSession.addPSBKTask(iPSDevCenterBKTask);
    }

    @Override
    public void cancelPSDCBKTask(PSDCBKTask psDevCenterBKTask) throws Exception {
        final PSDCBKTask psDevCenterBKTask2 = psDevCenterBKTask;
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

            @Override
            public void execute(Object obj) throws Exception {
                PSDevCenterBKTaskGlobal.this.onCancelPSDCBKTask(psDevCenterBKTask2);
            }
        });
    }

    protected void onCancelPSDCBKTask(PSDCBKTask psDevCenterBKTask) throws Exception {
        PSBKTaskSessionBase psBKTaskSessionBase = this.getPSBKTaskSession(psDevCenterBKTask.getPSDEVCENTERID());
        psBKTaskSessionBase.cancelPSBKTask(psDevCenterBKTask.getPSDCBKTASKID());
    }

    @Override
    protected PSBKTaskSessionBase createPSBKTaskSession() throws Exception {
        return new PSDevCenterBKTaskSession();
    }
}

