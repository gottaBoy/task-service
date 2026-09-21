/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSSubAppRef;
import SA.SRFDA.PS.Core.App.View.IPSAppSubSysDEView;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SubSys.IPSSubAppView;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public class PSAppSubSysDEViewImpl
extends PSAppViewImpl
implements IPSAppSubSysDEView {
    protected PSDEViewBase psDEViewBase = new PSDEViewBase();
    private IPSSubAppRef iPSSubAppRef = null;
    private IPSSubAppView iPSSubAppView = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppView psApplicationView) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSApplication(iPSApplication);
        CallResult callResult = this.getPSModelHelper().getPSDEViewBase(psApplicationView.getPSDEVIEWBASEID(), this.psDEViewBase);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (StringHelper.IsNullOrEmpty((String)this.psDEViewBase.getPSSUBSYSID())) {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b50\u7cfb\u7edf"));
        }
        if (StringHelper.IsNullOrEmpty((String)this.psDEViewBase.getPSSUBDEVIEWID())) {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b50\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe"));
        }
        super.init(iDAGlobalHelper, iPSApplication, psApplicationView);
    }

    @Override
    protected void onInit() throws Exception {
        Iterator<IPSSubAppRef> psSubAppRefs = this.getPSApplication().getAllPSSubAppRefs();
        while (psSubAppRefs.hasNext()) {
            IPSSubAppView iPSSubAppView;
            IPSSubAppRef iPSSubAppRef = psSubAppRefs.next();
            if (StringHelper.Compare((String)iPSSubAppRef.getPSSubApp().getPSSubSys().getId(), (String)this.psDEViewBase.getPSSUBSYSID(), (boolean)true) != 0 || (iPSSubAppView = iPSSubAppRef.getPSSubApp().getPSSubAppViewBySubDEView(this.psDEViewBase.getPSSUBDEVIEWID(), true)) == null) continue;
            this.iPSSubAppRef = iPSSubAppRef;
            this.iPSSubAppView = iPSSubAppView;
            break;
        }
        if (this.iPSSubAppRef == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5bf9\u5e94\u5b50\u7cfb\u7edf\u5e94\u7528\u5f15\u7528"));
        }
        super.onInit();
    }

    @Override
    public boolean isEnableDP() {
        return true;
    }

    @Override
    public boolean isEnableWF() {
        return false;
    }

    @Override
    public IPSSubAppRef getPSSubAppRef() {
        return this.iPSSubAppRef;
    }

    @Override
    public IPSSubAppView getPSSubAppView() {
        return this.iPSSubAppView;
    }

    @Override
    public String getPageUrl() {
        return this.getPSSubAppView().getPageUrl();
    }

    @Override
    public String getSubAppFolderName() {
        return this.getPSSubAppRef().getFolderName();
    }

    @Override
    public String getModelType() {
        return null;
    }
}

