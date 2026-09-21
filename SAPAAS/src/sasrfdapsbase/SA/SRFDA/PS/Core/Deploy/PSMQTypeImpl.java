/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSMQInst;
import SA.SRFDA.PS.Core.Deploy.IPSMQType;
import SA.SRFDA.PS.Core.Deploy.PSMQInstImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSMQInst;
import SA.SRFDA.PS.Data.PSMQType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMQTypeImpl
extends PSObjectImpl
implements IPSMQType {
    protected PSMQType psMQType = null;
    private static final Log log = LogFactory.getLog(PSMQTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSMQType psMQType) throws Exception {
        this.psMQType = psMQType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psMQType.getPSMQTYPEID());
        this.setName(psMQType.getPSMQTYPENAME());
        this.setPSObjectData(this.psMQType);
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
    public IPSMQInst createPSMQInst(PSMQInst psMQInst) throws Exception {
        return new PSMQInstImpl();
    }
}

