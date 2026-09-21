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
import SA.SRFDA.PS.Core.PF.IPSPFPkg;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Data.PSPFPkgVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPkgVerImpl
extends PSPFObjectImpl
implements IPSPFPkgVer {
    protected PSPFPkgVer psPFPkgVer = null;
    private static final Log log = LogFactory.getLog(PSPFPkgVerImpl.class);
    private String strVerTag = null;
    private String strVerTag2 = null;
    private String strVerParam = null;
    private String strVerParam2 = null;
    private String strVerParam3 = null;
    private String strVerParam4 = null;
    private IPSPFPkg iPSPFPkg = null;
    private int nOrderValue = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, PSPFPkgVer psPFPkgVer) throws Exception {
        this.psPFPkgVer = psPFPkgVer;
        this.setPSPF(iPSPF);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFPkgVer.getPSPFPKGVERID());
        this.setName(this.psPFPkgVer.getPSPFPKGVERNAME());
        this.setPSObjectData(this.psPFPkgVer);
        this.strVerParam = this.psPFPkgVer.getPKGPARAM();
        this.strVerParam2 = this.psPFPkgVer.getPKGPARAM2();
        this.strVerParam3 = this.psPFPkgVer.getPKGPARAM3();
        this.strVerParam4 = this.psPFPkgVer.getPKGPARAM4();
        if (!StringHelper.IsNullOrEmpty((String)this.psPFPkgVer.getPSPFPKGID())) {
            this.iPSPFPkg = this.getPSPF().getPSPFPkg(this.psPFPkgVer.getPSPFPKGID());
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
        return this.iPSPFPkg;
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
}

