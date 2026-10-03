/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.App.View.IPSAppDEView
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSAppDEView
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppCodePublisherImpl;
import SA.SRFDA.PS.Data.PSAppDEView;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public abstract class PSIBiz5SysAppViewCodePublisherImpl
extends PSIBiz5SysAppCodePublisherImpl {
    public static final String CODETEMPL_APPVIEW = "APPVIEW";
    private IPSAppView iPSAppView = null;

    @Override
    protected void onGenerateCode(IPSApplication iPSApplication, ArrayList<PSSysSFCode> list) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.strDEFilter)) {
            Vector<PSAppDEView> psAppDEViewList = new Vector();
            CallResult callResult = this.getPSModelHelper().getAllPSAppDEViews(iPSApplication.getId(), this.strDEFilter, psAppDEViewList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u5e94\u7528\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSAppDEView psAppDEView : psAppDEViewList) {
                this.iPSAppView = iPSApplication.getPSAppView(psAppDEView.getPSAPPDEVIEWID(), psAppDEView.getPSDEVIEWBASEID());
                this.onGenerateAppViewCode(this.iPSAppView, null);
            }
        } else {
            Iterator psAppViews = iPSApplication.getAllPSAppViews();
            while (psAppViews.hasNext()) {
                this.iPSAppView = (IPSAppView)psAppViews.next();
                if (!this.iPSAppView.isDynamicView() || iPSApplication.isPubRefViewOnly() && !this.iPSAppView.getRefFlag() && (this.getPSSysSFPub() == null || !this.getPSSysSFPub().isDocMode()) || !StringHelper.IsNullOrEmpty((String)this.iPSAppView.getSubAppFolderName())) continue;
                this.onGenerateAppViewCode(this.iPSAppView, null);
            }
            psAppViews = iPSApplication.getAllPSAppViews();
            while (psAppViews.hasNext()) {
                this.iPSAppView = (IPSAppView)psAppViews.next();
                if (this.iPSAppView.isDynamicView() || iPSApplication.isPubRefViewOnly() && !this.iPSAppView.getRefFlag() && (this.getPSSysSFPub() == null || !this.getPSSysSFPub().isDocMode()) || !StringHelper.IsNullOrEmpty((String)this.iPSAppView.getSubAppFolderName())) continue;
                this.onGenerateAppViewCode(this.iPSAppView, null);
            }
        }
    }

    protected abstract void onGenerateAppViewCode(IPSAppView var1, ArrayList<PSSysSFCode> var2) throws Exception;

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSAppView) {
            this.iPSAppView = (IPSAppView)iPSObject;
            this.iPSApplication = this.iPSAppView.getPSApplication();
            if (StringHelper.IsNullOrEmpty((String)this.iPSAppView.getSubAppFolderName())) {
                ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
                this.onGenerateAppViewCode(this.iPSAppView, list);
                return list;
            }
            return null;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        if (this.iPSAppView != null) {
            params.put("appview", this.iPSAppView);
            if (!params.containsKey("appde") && this.iPSAppView.getPSAppDataEntity() != null) {
                params.put("appde", this.iPSAppView.getPSAppDataEntity());
            }
            if (this.iPSAppView instanceof IPSAppDEView) {
                IPSAppDEView iPSAppDEView = (IPSAppDEView)this.iPSAppView;
                if (!params.containsKey("de") && iPSAppDEView.getPSDataEntity() != null) {
                    params.put("de", iPSAppDEView.getPSDataEntity());
                }
            }
        }
    }

    @Override
    protected void onClose() {
        this.iPSAppView = null;
        super.onClose();
    }
}

