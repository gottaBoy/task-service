/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepToolType;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDepToolType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepToolTypeImpl
extends PSObjectImpl
implements IPSDepToolType {
    protected PSDepToolType psDepToolType = null;
    private static final Log log = LogFactory.getLog(PSDepToolTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDepToolType psDepToolType) throws Exception {
        this.psDepToolType = psDepToolType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDepToolType.getPSDEPTOOLTYPEID());
        this.setName(psDepToolType.getPSDEPTOOLTYPENAME());
        this.setPSObjectData(this.psDepToolType);
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

