/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStylePrj;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Data.PSPFStylePrj;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFStylePrjImpl
extends PSPFObjectImpl
implements IPSPFStylePrj {
    protected PSPFStylePrj psPFStylePrj = null;
    protected IPSPFStyle iPSPFStyle = null;
    private String strNameFormat = null;
    private boolean bReadOnlyMode = false;
    private String strPrjType = null;
    private static final Log log = LogFactory.getLog(PSPFStylePrjImpl.class);
    private boolean bMavenPrj = true;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFStyle iPSPFStyle, PSPFStylePrj psPFStylePrj) throws Exception {
        this.psPFStylePrj = psPFStylePrj;
        this.iPSPFStyle = iPSPFStyle;
        this.setPSPF(this.iPSPFStyle.getPSPF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFStylePrj.getPSPFSTYLEPRJID());
        this.setName(this.psPFStylePrj.getPSPFSTYLEPRJNAME());
        this.setPSObjectData(this.psPFStylePrj);
        this.strNameFormat = this.psPFStylePrj.getNAMEFMT();
        this.strPrjType = this.psPFStylePrj.getPRJTYPE();
        if (!this.psPFStylePrj.isREADONLYMODENull()) {
            this.bReadOnlyMode = this.psPFStylePrj.getREADONLYMODE();
        }
        if (!this.psPFStylePrj.isMAVENFLAGNull()) {
            this.bMavenPrj = this.psPFStylePrj.getMAVENFLAG();
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
    public String getProjectName(IPSApplication iPSSysApp) throws Exception {
        return this.getNameFormat().replace("_APPPKGNAME_", iPSSysApp.getWorkshopName());
    }

    @Override
    public boolean isMavenPrj() {
        return this.bMavenPrj;
    }
}

