/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCDN;
import SA.SRFDA.PS.Core.PF.IPSPFPkg;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVerCDN;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Data.PSPFPkgVer;
import SA.SRFDA.PS.Data.PSPFPkgVerCDN;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPkgVerCDNImpl
extends PSPFObjectImpl
implements IPSPFPkgVerCDN {
    protected PSPFPkgVerCDN psPFPkgVerCDN = null;
    private static final Log log = LogFactory.getLog(PSPFPkgVerCDNImpl.class);
    private String strVerTag = null;
    private String strVerTag2 = null;
    private String strVerParam = null;
    private String strVerParam2 = null;
    private String strVerParam3 = null;
    private String strVerParam4 = null;
    private IPSPFPkgVer iPSPFPkgVer = null;
    private IPSPFCDN iPSPFCDN = null;
    private int nOrderValue = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, PSPFPkgVerCDN psPFPkgVerCDN) throws Exception {
        this.psPFPkgVerCDN = psPFPkgVerCDN;
        this.setPSPF(iPSPF);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFPkgVerCDN.getPSPFPKGVERCDNID());
        this.setName(this.psPFPkgVerCDN.getPSPFPKGVERCDNNAME());
        this.setPSObjectData(this.psPFPkgVerCDN);
        this.strVerParam = this.psPFPkgVerCDN.getPKGPARAM();
        this.strVerParam2 = this.psPFPkgVerCDN.getPKGPARAM2();
        this.strVerParam3 = this.psPFPkgVerCDN.getPKGPARAM3();
        this.strVerParam4 = this.psPFPkgVerCDN.getPKGPARAM4();
        if (!StringHelper.IsNullOrEmpty((String)this.psPFPkgVerCDN.getPSPFPKGVERID())) {
            this.iPSPFPkgVer = this.getPSPF().getPSPFPkgVer(this.psPFPkgVerCDN.getPSPFPKGVERID());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psPFPkgVerCDN.getPSPFCDNID())) {
            this.iPSPFCDN = this.getPSModelStorage().getPSPFCDN(this.psPFPkgVerCDN.getPSPFCDNID());
        }
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
    public String getVerTag() {
        return this.strVerTag;
    }

    @Override
    public String getVerTag2() {
        return this.strVerTag2;
    }

    @Override
    public String getVerParam() {
        return this.strVerParam;
    }

    @Override
    public IPSPFPkg getPSPFPkg() {
        return this.getPSPFPkgVer().getPSPFPkg();
    }

    @Override
    public String getVerParam2() {
        return this.strVerParam2;
    }

    @Override
    public String getVerParam3() {
        return this.strVerParam3;
    }

    @Override
    public String getVerParam4() {
        return this.strVerParam4;
    }

    @Override
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, PSPFPkgVer psSFPkgVer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSPFCDN getPSPFCDN() {
        return this.iPSPFCDN;
    }

    @Override
    public IPSPFPkgVer getPSPFPkgVer() {
        return this.iPSPFPkgVer;
    }
}

