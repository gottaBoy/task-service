/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFPkg;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Data.PSPFPkg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPkgImpl
extends PSPFObjectImpl
implements IPSPFPkg {
    protected PSPFPkg psSFPkg = null;
    private static final Log log = LogFactory.getLog(PSPFPkgImpl.class);
    private String strTag = null;
    private String strTag2 = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, PSPFPkg psSFPkg) throws Exception {
        this.psSFPkg = psSFPkg;
        this.setPSPF(iPSPF);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFPkg.getPSPFPKGID());
        this.setName(this.psSFPkg.getPSPFPKGNAME());
        this.setPSObjectData(this.psSFPkg);
        this.strTag = this.psSFPkg.getPKGTAG();
        this.strTag2 = this.psSFPkg.getPKGTAG2();
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSPF.getPSSysModelInstId();
    }

    @Override
    public String getTag() {
        return this.strTag;
    }

    @Override
    public String getTag2() {
        return this.strTag2;
    }
}

