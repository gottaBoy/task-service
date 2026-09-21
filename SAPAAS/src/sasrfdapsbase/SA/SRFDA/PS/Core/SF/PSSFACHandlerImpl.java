/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITSFACHandler;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFACHandler;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Data.PSSFACHandler;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFACHandlerImpl
extends PSSFObjectImpl
implements IPSSFACHandler,
IPSJITSFACHandler {
    protected PSSFACHandler psSFACHandler = null;
    private static final Log log = LogFactory.getLog(PSSFACHandlerImpl.class);
    protected ArrayList<IPSSFCodeFolder> psSFCodeFolderList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, PSSFACHandler psSFACHandler) throws Exception {
        this.psSFACHandler = psSFACHandler;
        this.setPSSF(iPSSF);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFACHandler.getPSSFACHANDLERID());
        this.setName(this.psSFACHandler.getPSSFACHANDLERNAME());
        this.setPSObjectData(this.psSFACHandler);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSF.getPSSysModelInstId();
    }

    @Override
    public String getHandlerObj() {
        return this.psSFACHandler.getHANDLEROBJ();
    }

    @Override
    public String getHandlerObj2() {
        return this.psSFACHandler.getHANDLEROBJ2();
    }

    @Override
    public String getHandlerObj3() {
        return this.psSFACHandler.getHANDLEROBJ3();
    }

    @Override
    public String getHandlerObj4() {
        return this.psSFACHandler.getHANDLEROBJ4();
    }

    @Override
    public IPSJITCtrlHandler createPSJITCtrlHandler(IPSControl iPSControl, boolean bTryMode) throws Exception {
        String strObj = this.psSFACHandler.getJITCTRLOBJ();
        if (iPSControl.getPSAppView().isEnableWF() && !StringHelper.IsNullOrEmpty((String)this.psSFACHandler.getJITCTRLOBJ2())) {
            strObj = this.psSFACHandler.getJITCTRLOBJ2();
        }
        if (StringHelper.IsNullOrEmpty((String)strObj)) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49\u90e8\u4ef6[%1$s]\u5373\u65f6\u5904\u7406\u5bf9\u8c61", (Object)iPSControl.getControlType()));
        }
        IPSJITCtrlHandler iPSJITCtrlHandler = (IPSJITCtrlHandler)ObjectHelper.Create((String)strObj);
        return iPSJITCtrlHandler;
    }
}

