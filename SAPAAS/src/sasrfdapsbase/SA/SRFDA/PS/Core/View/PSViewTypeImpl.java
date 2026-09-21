/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Core.View.IPSViewTypeCtrl;
import SA.SRFDA.PS.Core.View.IPSViewTypeView;
import SA.SRFDA.PS.Core.View.PSViewTypeCtrlImpl;
import SA.SRFDA.PS.Core.View.PSViewTypeViewImpl;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSViewType;
import SA.SRFDA.PS.Data.PSViewTypeCtrl;
import SA.SRFDA.PS.Data.PSViewTypeView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSViewTypeImpl
extends PSObjectImpl
implements IPSViewType {
    protected PSViewType psViewType = null;
    private static final Log log = LogFactory.getLog(PSViewTypeImpl.class);
    protected ArrayList<IPSViewTypeView> psViewTypeViewList = new ArrayList();
    protected ArrayList<IPSViewTypeCtrl> psViewTypeCtrlList = new ArrayList();
    private boolean bDEViewType = false;
    private String strCodeName = "";
    private boolean bEmbeddedView = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSViewType psViewType) throws Exception {
        this.psViewType = psViewType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psViewType.getPSVIEWTYPEID());
        this.setName(psViewType.getPSVIEWTYPENAME());
        this.setPSObjectData(this.psViewType);
        if (!this.psViewType.isDEVIEWMODENull()) {
            this.bDEViewType = this.psViewType.getDEVIEWMODE();
        }
        this.strCodeName = this.psViewType.getCODENAME();
        if (!this.psViewType.isEMBEDVIEWFLAGNull()) {
            this.bEmbeddedView = this.psViewType.getEMBEDVIEWFLAG();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSViewTypeViews();
        this.onPreparePSViewTypeCtrls();
    }

    protected void onPreparePSViewTypeViews() throws Exception {
        this.psViewTypeViewList.clear();
        Vector<PSViewTypeView> psViewTypeViewList = new Vector<PSViewTypeView>();
        CallResult callResult = this.getPSModelHelper().getPSViewTypeViews(this.getId(), psViewTypeViewList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u7c7b\u578b\u5173\u8054\u89c6\u56fe\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSViewTypeView psViewTypeView : psViewTypeViewList) {
            PSViewTypeViewImpl iPSViewTypeView = new PSViewTypeViewImpl();
            iPSViewTypeView.init(this.getDAGlobalHelper(), this, psViewTypeView);
            this.psViewTypeViewList.add(iPSViewTypeView);
        }
    }

    protected void onPreparePSViewTypeCtrls() throws Exception {
        this.psViewTypeCtrlList.clear();
        Vector<PSViewTypeCtrl> psViewTypeCtrlList = new Vector<PSViewTypeCtrl>();
        CallResult callResult = this.getPSModelHelper().getPSViewTypeCtrls(this.getId(), psViewTypeCtrlList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u7c7b\u578b\u5173\u8054\u90e8\u4ef6\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSViewTypeCtrl psViewTypeCtrl : psViewTypeCtrlList) {
            PSViewTypeCtrlImpl iPSViewTypeCtrl = new PSViewTypeCtrlImpl();
            iPSViewTypeCtrl.init(this.getDAGlobalHelper(), this, psViewTypeCtrl);
            this.psViewTypeCtrlList.add(iPSViewTypeCtrl);
        }
    }

    @Override
    public IPSAppView createPSAppView(PSAppView psApplicationView) throws Exception {
        IPSAppView iPSAppDEView = (IPSAppView)ObjectHelper.Create((String)this.psViewType.getAPPVIEWOBJ());
        iPSAppDEView.setPSViewType(this);
        return iPSAppDEView;
    }

    @Override
    public String getViewDEId() {
        return this.psViewType.getVIEWDEID();
    }

    @Override
    public Iterator<IPSViewTypeView> getPSViewTypeViews() {
        return this.psViewTypeViewList.iterator();
    }

    @Override
    public Iterator<IPSViewTypeCtrl> getPSViewTypeCtrls() {
        return this.psViewTypeCtrlList.iterator();
    }

    @Override
    public boolean isDEViewType() {
        return this.bDEViewType;
    }

    @Override
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public boolean isEmbeddedView() {
        return this.bEmbeddedView;
    }

    @Override
    public String getTitle() {
        return this.psViewType.getTITLE();
    }
}

