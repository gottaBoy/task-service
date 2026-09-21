/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.pscore.srv.util.PSStudioConsoleHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTaskGlobal;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTaskGlobalContext;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBTType;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskGlobalBase;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskSessionBase;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskSession;
import SA.SRFDA.PS.Data.PSSysDevBKTask;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDevBKTaskGlobal
extends PSBKTaskGlobalBase
implements IPSSysDevBKTaskGlobal,
IPSSysDevBKTaskGlobalContext {
    private static final Log log = LogFactory.getLog(PSSysDevBKTaskSession.class);

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
    public void addPSSysDevBKTask(PSSysDevBKTask psSysDevBKTask) throws Exception {
        if (psSysDevBKTask != null && !StringHelper.isNullOrEmpty((String)psSysDevBKTask.getPSDEVSLNSYSID()) && PSStudioConsoleHelper.getCurrent() != null) {
            String strUserName = "\u7cfb\u7edf\u5185\u7f6e\u7528\u6237";
            if (WebContext.getCurrent() != null && !StringHelper.isNullOrEmpty((String)WebContext.getCurrent().getCurLoginName())) {
                strUserName = WebContext.getCurrent().getCurLoginName();
            }
            String strContent = PSStudioConsoleHelper.getContent((String)StringHelper.format((String)"%1$s \u5efa\u7acb\u4efb\u52a1[%2$s]\u6210\u529f\uff0c\u6b63\u5728\u7b49\u5f85\u8c03\u5ea6\u6267\u884c", (Object)strUserName, (Object)psSysDevBKTask.getPSSYSDEVBKTASKNAME()), (int)32, (int)-1, (int)1);
            if (!StringHelper.isNullOrEmpty((String)psSysDevBKTask.getPSDYNAINSTID())) {
                PSStudioConsoleHelper.getCurrent().sendConsole(psSysDevBKTask.getPSDYNAINSTID(), strContent);
            } else {
                PSStudioConsoleHelper.getCurrent().sendConsole(psSysDevBKTask.getPSDEVSLNSYSID(), strContent);
            }
        }
        final PSSysDevBKTask psSysDevBKTask2 = psSysDevBKTask;
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

            @Override
            public void execute(Object obj) throws Exception {
                PSSysDevBKTaskGlobal.this.onAddPSSysDevBKTask(psSysDevBKTask2);
            }
        });
    }

    protected void onAddPSSysDevBKTask(PSSysDevBKTask psSysDevBKTask) throws Exception {
        IPSSysDevBTType iPSSysDevBTType = this.getPSModelStorage().getPSSysDevBTType(psSysDevBKTask.getTASKTYPE());
        if (iPSSysDevBTType == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u540e\u53f0\u4efb\u52a1\u7c7b\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)psSysDevBKTask.getTASKTYPE()));
        }
        PSBKTaskSessionBase psSysDevBKTaskSession = this.getPSBKTaskSessionBase(psSysDevBKTask);
        IPSSysDevBKTask iPSSysDevBKTask = iPSSysDevBTType.createPSSysDevBKTask(psSysDevBKTask);
        try {
            psSysDevBKTaskSession.incrementPrepareTask();
            iPSSysDevBKTask.init(this.getDAGlobalHelper(), null, psSysDevBKTask);
        }
        finally {
            psSysDevBKTaskSession.decrementPrepareTask();
        }
        psSysDevBKTaskSession.addPSBKTask(iPSSysDevBKTask);
    }

    @Override
    public void cancelPSSysDevBKTask(PSSysDevBKTask psSysDevBKTask) throws Exception {
        final PSSysDevBKTask psSysDevBKTask2 = psSysDevBKTask;
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

            @Override
            public void execute(Object obj) throws Exception {
                PSSysDevBKTaskGlobal.this.onCancelPSSysDevBKTask(psSysDevBKTask2);
            }
        });
    }

    protected void onCancelPSSysDevBKTask(PSSysDevBKTask psSysDevBKTask) throws Exception {
        PSBKTaskSessionBase psBKTaskSessionBase = this.getPSBKTaskSessionBase(psSysDevBKTask);
        psBKTaskSessionBase.cancelPSBKTask(psSysDevBKTask.getPSSYSDEVBKTASKID());
    }

    @Override
    protected PSBKTaskSessionBase createPSBKTaskSession() throws Exception {
        return new PSSysDevBKTaskSession();
    }

    protected PSBKTaskSessionBase getPSBKTaskSessionBase(PSSysDevBKTask psSysDevBKTask) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)psSysDevBKTask.getPSDYNAINSTID())) {
            return this.getPSBKTaskSession("PSDYNAINST:" + psSysDevBKTask.getPSDYNAINSTID());
        }
        return this.getPSBKTaskSession(psSysDevBKTask.getPSDEVSLNSYSID());
    }
}

