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
import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder2;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Data.PSPFCodeFolder;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCodeFolder2Impl
extends PSPFObjectImpl
implements IPSPFCodeFolder2 {
    protected PSPFCodeFolder psPFCodeFolder = null;
    private static final Log log = LogFactory.getLog(PSPFCodeFolder2Impl.class);
    private String strPrjType = "";
    private String strPrjFolder = "";
    private IPSPFStyle2 iPSPFStyle2 = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFStyle2 iPSPFStyle2, PSPFCodeFolder psPFCodeFolder) throws Exception {
        this.psPFCodeFolder = psPFCodeFolder;
        this.iPSPFStyle2 = iPSPFStyle2;
        this.setPSPF(this.getPSPFStyle2().getPSPF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFCodeFolder.getPSPFCODEFOLDERID());
        this.setName(this.psPFCodeFolder.getPSPFCODEFOLDERNAME());
        this.setPSObjectData(this.psPFCodeFolder);
        this.strPrjType = this.psPFCodeFolder.getPRJTYPE();
        if (StringHelper.IsNullOrEmpty((String)this.strPrjType)) {
            this.strPrjType = "APP_PUB";
        }
        this.strPrjFolder = this.psPFCodeFolder.getPRJFOLDER();
        this.onInit();
    }

    @Override
    public String getFolderName() {
        return this.psPFCodeFolder.getFOLDERNAME();
    }

    @Override
    public String getPrjType() {
        return this.strPrjType;
    }

    @Override
    public String getPrjFolder() {
        return this.strPrjFolder;
    }

    @Override
    public IPSPFStyle2 getPSPFStyle2() {
        return this.iPSPFStyle2;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, PSPFCodeFolder psPFCodeFolder) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }
}

