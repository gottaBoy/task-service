/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.SubSys.IPSSubDE;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.PSSubSysObjectImpl;
import SA.SRFDA.PS.Data.PSSubDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubDEImpl
extends PSSubSysObjectImpl
implements IPSSubDE {
    private static final Log log = LogFactory.getLog(PSSubDEImpl.class);
    protected PSSubDE psSubDE = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSys iPSSubSys, PSSubDE psSubDE) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSSubSys(iPSSubSys);
        this.psSubDE = psSubDE;
        this.setId(this.psSubDE.getPSSUBDEID());
        this.setName(this.psSubDE.getPSSUBDENAME());
        this.setPSObjectData(this.psSubDE);
        this.onInit();
    }
}

