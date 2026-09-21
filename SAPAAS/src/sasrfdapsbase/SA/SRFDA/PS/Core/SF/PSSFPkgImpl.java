/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPkg;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Data.PSSFPkg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFPkgImpl
extends PSSFObjectImpl
implements IPSSFPkg {
    protected PSSFPkg psSFPkg = null;
    private static final Log log = LogFactory.getLog(PSSFPkgImpl.class);
    private String strTag = null;
    private String strTag2 = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, PSSFPkg psSFPkg) throws Exception {
        this.psSFPkg = psSFPkg;
        this.setPSSF(iPSSF);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFPkg.getPSSFPKGID());
        this.setName(this.psSFPkg.getPSSFPKGNAME());
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
        return this.iPSSF.getPSSysModelInstId();
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

