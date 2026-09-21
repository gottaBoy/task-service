/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.SubSys.IPSSubDE;
import SA.SRFDA.PS.Core.SubSys.IPSSubDEView;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.PSSubSysObjectImpl;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Data.PSSubDEView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubDEViewImpl
extends PSSubSysObjectImpl
implements IPSSubDEView {
    private static final Log log = LogFactory.getLog(PSSubDEViewImpl.class);
    protected PSSubDEView psSubDEView = null;
    private IPSSubDE iPSSubDE = null;
    private IPSViewType iPSViewType = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSys iPSSubSys, PSSubDEView psSubDEView) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSSubSys(iPSSubSys);
        this.psSubDEView = psSubDEView;
        if (!StringHelper.IsNullOrEmpty((String)this.psSubDEView.getPSSUBDEID())) {
            this.iPSSubDE = this.iPSSubSys.getPSSubDE(this.psSubDEView.getPSSUBDEID());
        }
        this.setId(this.psSubDEView.getPSSUBDEVIEWID());
        this.setName(this.psSubDEView.getPSSUBDEVIEWNAME());
        this.setPSObjectData(this.psSubDEView);
        this.iPSViewType = this.getPSModelStorage().getPSViewType(this.psSubDEView.getVIEWTYPE());
        this.onInit();
    }

    @Override
    public IPSSubDE getPSSubDE() {
        return this.iPSSubDE;
    }

    @Override
    public IPSViewType getPSViewType() {
        return this.iPSViewType;
    }
}

