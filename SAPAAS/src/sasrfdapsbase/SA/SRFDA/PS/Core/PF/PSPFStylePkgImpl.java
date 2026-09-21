/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStylePkg;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Core.PF.PSPFPkgVerProxy;
import SA.SRFDA.PS.Data.PSPFStylePkg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFStylePkgImpl
extends PSPFObjectImpl
implements IPSPFStylePkg {
    protected PSPFStylePkg psPFStylePkg = null;
    protected IPSPFStyle iPSPFStyle = null;
    private static final Log log = LogFactory.getLog(PSPFStylePkgImpl.class);
    private PSPFPkgVerProxy psPFPkgVerProxy = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFStyle iPSPFStyle, PSPFStylePkg psPFStylePkg) throws Exception {
        this.psPFStylePkg = psPFStylePkg;
        this.iPSPFStyle = iPSPFStyle;
        this.setPSPF(this.iPSPFStyle.getPSPF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFStylePkg.getPSPFSTYLEPKGID());
        this.setName(this.psPFStylePkg.getPSPFSTYLEPKGNAME());
        this.setPSObjectData(this.psPFStylePkg);
        this.psPFPkgVerProxy = new PSPFPkgVerProxy(this.getPSPF().getPSPFPkgVer(this.psPFStylePkg.getPSPFPKGVERID()), this.psPFStylePkg.getORDERVALUE());
        this.onInit();
    }

    @Override
    public IPSPFPkgVer getPSPFPkgVer() {
        return this.psPFPkgVerProxy;
    }
}

