/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.TS.Ctrl.BaseDATSTask
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SRFTS.Ctrl.Data.TSTaskItem
 *  SRFTS.Ctrl.ISRFTSTaskContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl.Task;

import SA.IM.Ctrl.Task.IMContactsRender;
import SA.SRFDA.TS.Ctrl.BaseDATSTask;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SRFTS.Ctrl.Data.TSTaskItem;
import SRFTS.Ctrl.ISRFTSTaskContext;
import java.io.File;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMContactsMakerTask
extends BaseDATSTask {
    private static final Log log = LogFactory.getLog(IMContactsMakerTask.class);

    public CallResult Run(ISRFTSTaskContext ctx) {
        CallResult callResult = new CallResult();
        TSTaskItem tss = ctx.getTaskItem();
        String strId = tss.getTASKPARAM();
        try {
            log.info((Object)StringHelper.Format((String)"\u51c6\u5907\u4ece\u6839\u8282\u70b9[%1$s]\u5bfc\u51fa\u6570\u636e", (Object)strId));
            String strRootOrgId = strId;
            String strOutputFile = ctx.getContextHelper().getServletContext().getRealPath("/");
            strOutputFile = String.valueOf(strOutputFile) + File.separator + "Contacts.xml";
            IMContactsRender iMContactsRender = new IMContactsRender();
            iMContactsRender.Init(IMContactsMakerTask.GetGlobalHelper((ISRFTSTaskContext)ctx));
            callResult = iMContactsRender.Export(strOutputFile, strRootOrgId);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }
}

