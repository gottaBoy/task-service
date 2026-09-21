/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Core.View.IPSViewTypeView;
import SA.SRFDA.PS.Data.PSViewTypeView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PSViewTypeViewImpl
extends PSObjectImpl
implements IPSViewTypeView {
    protected IPSViewType iPSViewType = null;
    protected PSViewTypeView psViewTypeView = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSViewType iPSViewType, PSViewTypeView psViewTypeView) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSViewType = iPSViewType;
        this.psViewTypeView = psViewTypeView;
        this.setId(this.psViewTypeView.getPSVTRVID());
        this.setName(this.psViewTypeView.getPSVTRVNAME());
        this.setPSObjectData(this.psViewTypeView);
        this.onInit();
    }

    @Override
    public String getPredefinedView() {
        return this.psViewTypeView.getDEFVIEWTYPE();
    }

    @Override
    public String getMemo() {
        return this.psViewTypeView.getMEMO();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSViewType.getPSSysModelInstId();
    }
}

