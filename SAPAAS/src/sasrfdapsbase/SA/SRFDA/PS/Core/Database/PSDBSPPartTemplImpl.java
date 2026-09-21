/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBSPPartTempl;
import SA.SRFDA.PS.Core.Database.IPSDBSysProcTempl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDBSPPartTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDBSPPartTemplImpl
extends PSObjectImpl
implements IPSDBSPPartTempl {
    protected PSDBSPPartTempl psDBSPPartTempl = null;
    private static final Log log = LogFactory.getLog(PSDBSPPartTemplImpl.class);
    protected IPSDBSysProcTempl iPSDBSysProcTempl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDBSysProcTempl iPSDBSysProcTempl, PSDBSPPartTempl psDBSPPartTempl) throws Exception {
        this.psDBSPPartTempl = psDBSPPartTempl;
        this.iPSDBSysProcTempl = iPSDBSysProcTempl;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psDBSPPartTempl.getPSDBSPPARTTEMPLID());
        this.setName(this.psDBSPPartTempl.getPSDBSPPARTTEMPLNAME());
        this.setPSObjectData(this.psDBSPPartTempl);
        this.onInit();
    }

    @Override
    public PSDBSPPartTempl getPSDBSPPartTemplData() {
        return this.psDBSPPartTempl;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDBSysProcTempl.getPSSysModelInstId();
    }
}

