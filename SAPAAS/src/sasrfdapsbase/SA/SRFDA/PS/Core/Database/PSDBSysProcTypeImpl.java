/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBSysProcType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDBSysProcType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDBSysProcTypeImpl
extends PSObjectImpl
implements IPSDBSysProcType {
    protected PSDBSysProcType psDBSysProcType = null;
    private static final Log log = LogFactory.getLog(PSDBSysProcTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDBSysProcType psDBSysProcType) throws Exception {
        this.psDBSysProcType = psDBSysProcType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDBSysProcType.getPSDBSYSPROCTYPEID());
        this.setName(psDBSysProcType.getPSDBSYSPROCTYPENAME());
        this.setPSObjectData(this.psDBSysProcType);
        this.onInit();
    }

    @Override
    public String getCodeName() {
        return this.psDBSysProcType.getCODENAME();
    }

    @Override
    public boolean isReturnResult() {
        return this.psDBSysProcType.getRETURNRESULT();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

