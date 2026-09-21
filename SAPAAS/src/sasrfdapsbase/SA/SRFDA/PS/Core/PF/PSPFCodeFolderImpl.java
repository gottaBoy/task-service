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
import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Data.PSPFCodeFolder;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCodeFolderImpl
extends PSPFObjectImpl
implements IPSPFCodeFolder {
    protected PSPFCodeFolder psPFCodeFolder = null;
    private static final Log log = LogFactory.getLog(PSPFCodeFolderImpl.class);
    private String strPrjType = "";
    private String strPrjFolder = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, PSPFCodeFolder psPFCodeFolder) throws Exception {
        this.psPFCodeFolder = psPFCodeFolder;
        this.setPSPF(iPSPF);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFCodeFolder.getPSPFCODEFOLDERID());
        this.setName(this.psPFCodeFolder.getPSPFCODEFOLDERNAME());
        this.setPSObjectData(this.psPFCodeFolder);
        this.strPrjType = this.psPFCodeFolder.getPRJTYPE();
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
}

