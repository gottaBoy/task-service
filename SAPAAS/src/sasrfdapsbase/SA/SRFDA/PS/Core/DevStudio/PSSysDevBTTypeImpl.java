/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBTType;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSSysDevBKTask;
import SA.SRFDA.PS.Data.PSSysDevBTType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDevBTTypeImpl
extends PSObjectImpl
implements IPSSysDevBTType {
    protected PSSysDevBTType psSysDevBTType = null;
    private static final Log log = LogFactory.getLog(PSSysDevBTTypeImpl.class);
    private boolean bUseRobot = true;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSSysDevBTType psSysDevBTType) throws Exception {
        this.psSysDevBTType = psSysDevBTType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psSysDevBTType.getPSSYSDEVBTTYPEID());
        this.setName(psSysDevBTType.getPSSYSDEVBTTYPENAME());
        this.setPSObjectData(this.psSysDevBTType);
        if (!this.psSysDevBTType.isUSEROBOTFLAGNull()) {
            this.bUseRobot = this.psSysDevBTType.getUSEROBOTFLAG();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSSysDevBKTask createPSSysDevBKTask(PSSysDevBKTask psSysDevBKTask) throws Exception {
        return (IPSSysDevBKTask)ObjectHelper.Create((String)this.psSysDevBTType.getTASKOBJ());
    }

    @Override
    public boolean isUseRobot() {
        return this.bUseRobot;
    }
}

