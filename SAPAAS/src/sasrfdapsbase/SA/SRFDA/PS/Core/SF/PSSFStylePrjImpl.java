/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStylePrj;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Data.PSSFStylePrj;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStylePrjImpl
extends PSSFObjectImpl
implements IPSSFStylePrj {
    protected PSSFStylePrj psSFStylePrj = null;
    protected IPSSFStyle iPSSFStyle = null;
    private String strNameFormat = null;
    private boolean bReadOnlyMode = false;
    private String strPrjType = null;
    private static final Log log = LogFactory.getLog(PSSFStylePrjImpl.class);
    private boolean bMavenPrj = true;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFStyle iPSSFStyle, PSSFStylePrj psSFStylePrj) throws Exception {
        this.psSFStylePrj = psSFStylePrj;
        this.iPSSFStyle = iPSSFStyle;
        this.setPSSF(this.iPSSFStyle.getPSSF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFStylePrj.getPSSFSTYLEPRJID());
        this.setName(this.psSFStylePrj.getPSSFSTYLEPRJNAME());
        this.setPSObjectData(this.psSFStylePrj);
        this.strNameFormat = this.psSFStylePrj.getNAMEFMT();
        this.strPrjType = this.psSFStylePrj.getPRJTYPE();
        if (!this.psSFStylePrj.isREADONLYMODENull()) {
            this.bReadOnlyMode = this.psSFStylePrj.getREADONLYMODE();
        }
        if (!this.psSFStylePrj.isMAVENFLAGNull()) {
            this.bMavenPrj = this.psSFStylePrj.getMAVENFLAG();
        }
        this.onInit();
    }

    @Override
    public String getNameFormat() {
        return this.strNameFormat;
    }

    @Override
    public boolean isReadOnlyMode() {
        return this.bReadOnlyMode;
    }

    @Override
    public String getPrjType() {
        return this.strPrjType;
    }

    @Override
    public String getProjectName(IPSSysSFPub iPSSysSFPub) throws Exception {
        return this.getNameFormat().replace("_SYSSFPUBNAME_", iPSSysSFPub.getCodeName());
    }

    @Override
    public boolean isMavenPrj() {
        return this.bMavenPrj;
    }
}

