/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnType;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDepSlnType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnTypeImpl
extends PSObjectImpl
implements IPSDepSlnType {
    protected PSDepSlnType psDepSlnType = null;
    private static final Log log = LogFactory.getLog(PSDepSlnTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDepSlnType psDepSlnType) throws Exception {
        this.psDepSlnType = psDepSlnType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDepSlnType.getPSDEPSLNTYPEID());
        this.setName(psDepSlnType.getPSDEPSLNTYPENAME());
        this.setPSObjectData(this.psDepSlnType);
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
}

