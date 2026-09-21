/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFPkgVer;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStylePkg;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Data.PSSFStylePkg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStylePkgImpl
extends PSSFObjectImpl
implements IPSSFStylePkg {
    protected PSSFStylePkg psSFStylePkg = null;
    protected IPSSFStyle iPSSFStyle = null;
    private static final Log log = LogFactory.getLog(PSSFStylePkgImpl.class);
    private IPSSFPkgVer iPSSFPkgVer = null;
    public static final Integer DEFAULTORDERVALUE = 10000;
    private int nOrderValue = DEFAULTORDERVALUE;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFStyle iPSSFStyle, PSSFStylePkg psSFStylePkg) throws Exception {
        this.psSFStylePkg = psSFStylePkg;
        this.iPSSFStyle = iPSSFStyle;
        this.setPSSF(this.iPSSFStyle.getPSSF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFStylePkg.getPSSFSTYLEPKGID());
        this.setName(this.psSFStylePkg.getPSSFSTYLEPKGNAME());
        this.setPSObjectData(this.psSFStylePkg);
        this.iPSSFPkgVer = this.getPSSF().getPSSFPkgVer(this.psSFStylePkg.getPSSFPKGVERID());
        if (!this.psSFStylePkg.isORDERVALUENull()) {
            this.nOrderValue = this.psSFStylePkg.getORDERVALUE();
        }
        this.onInit();
    }

    @Override
    public IPSSFPkgVer getPSSFPkgVer() {
        return this.iPSSFPkgVer;
    }

    @Override
    public int getOrderValue() {
        return this.nOrderValue;
    }
}

