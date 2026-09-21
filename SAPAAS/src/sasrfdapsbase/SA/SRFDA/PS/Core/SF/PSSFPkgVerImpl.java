/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPkg;
import SA.SRFDA.PS.Core.SF.IPSSFPkgVer;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Data.PSSFPkgVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFPkgVerImpl
extends PSSFObjectImpl
implements IPSSFPkgVer {
    protected PSSFPkgVer psSFPkgVer = null;
    private static final Log log = LogFactory.getLog(PSSFPkgVerImpl.class);
    private String strVerTag = null;
    private String strVerTag2 = null;
    private String strVerParam = null;
    private IPSSFPkg iPSSFPkg = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, PSSFPkgVer psSFPkgVer) throws Exception {
        this.psSFPkgVer = psSFPkgVer;
        this.setPSSF(iPSSF);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFPkgVer.getPSSFPKGVERID());
        this.setName(this.psSFPkgVer.getPSSFPKGVERNAME());
        this.setPSObjectData(this.psSFPkgVer);
        this.strVerParam = this.psSFPkgVer.getVERPARAM();
        this.strVerTag = this.psSFPkgVer.getVERTAG();
        this.strVerTag2 = this.psSFPkgVer.getVERTAG2();
        if (!StringHelper.IsNullOrEmpty((String)this.psSFPkgVer.getPSSFPKGID())) {
            this.iPSSFPkg = this.getPSSF().getPSSFPkg(this.psSFPkgVer.getPSSFPKGID());
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSF.getPSSysModelInstId();
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
    public IPSSFPkg getPSSFPkg() {
        return this.iPSSFPkg;
    }
}

