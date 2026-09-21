/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysSF;
import SA.SRFDA.PS.Core.SubSys.PSSubSysObjectImpl;
import SA.SRFDA.PS.Data.PSSubSysSF;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysSFImpl
extends PSSubSysObjectImpl
implements IPSSubSysSF {
    private static final Log log = LogFactory.getLog(PSSubSysSFImpl.class);
    protected PSSubSysSF psSubSysSF = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSys iPSSubSys, PSSubSysSF psSubSysSF) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSSubSys(iPSSubSys);
        this.psSubSysSF = psSubSysSF;
        this.setId(this.psSubSysSF.getPSSUBSYSSFID());
        this.setName(this.psSubSysSF.getPSSUBSYSSFNAME());
        this.setPSObjectData(this.psSubSysSF);
        this.onInit();
    }

    @Override
    public String getPSSFStyleId() {
        return this.psSubSysSF.getPSSFSTYLEID();
    }

    @Override
    public String getPKGCodeName() {
        return this.psSubSysSF.getPKGCODENAME();
    }
}

