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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class PSIBiz5SysAppViewDocPublisherImpl
extends PSIBiz5SysAppCodePublisherImpl {
    public static final String CODETEMPL_APPVIEW = "APPVIEW";
    private IPSAppView iPSAppView = null;
    private IPSAppView prevPSAppView = null;
    private IPSAppView nextPSAppView = null;

    @Override
    protected void onGenerateCode(IPSApplication iPSApplication, ArrayList<PSSysSFCode> list2) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.strDEFilter)) {
            Vector psAppDEViewList = new Vector();
            CallResult callResult = this.getPSModelHelper().getAllPSAppDEViews(iPSApplication.getId(), this.strDEFilter, psAppDEViewList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u5e94\u7528\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSAppDEView psAppDEView : psAppDEViewList) {
                this.iPSAppView = iPSApplication.getPSAppView(psAppDEView.getPSAPPDEVIEWID(), psAppDEView.getPSDEVIEWBASEID());
                this.generateCode(this.iPSAppView);
            }
        } else {
            ArrayList<IPSAppView> list = new ArrayList<IPSAppView>();
            Iterator psAppViews = iPSApplication.getAllPSAppViews();
            while (psAppViews.hasNext()) {
                this.iPSAppView = (IPSAppView)psAppViews.next();
                if (iPSApplication.isPubRefViewOnly() && !this.iPSAppView.getRefFlag() || !StringHelper.IsNullOrEmpty((String)this.iPSAppView.getSubAppFolderName())) continue;
                list.add(this.iPSAppView);
            }
            Collections.sort(list, new Comparator<IPSAppView>(){

                @Override
                public int compare(IPSAppView arg0, IPSAppView arg1) {
                    return arg0.getCodeName().compareTo(arg1.getCodeName());
                }
            });
            int i = 0;
            while (i < list.size()) {
                this.iPSAppView = (IPSAppView)list.get(i);
                this.prevPSAppView = i - 1 >= 0 ? (IPSAppView)list.get(i - 1) : null;
                this.nextPSAppView = i + 1 < list.size() ? (IPSAppView)list.get(i + 1) : null;
                this.generateCode(this.iPSAppView);
                ++i;
            }
        }
        this.iPSAppView = null;
        this.prevPSAppView = null;
        this.nextPSAppView = null;
    }

    protected void generateCode(IPSAppView iPSAppView) throws Exception {
        HashMap params = new HashMap();
        this.savePSSysSFCode(iPSAppView, null, params);
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        if (this.iPSAppView != null) {
            params.put("appview", this.iPSAppView);
            if (this.iPSAppView.getPSAppDataEntity() != null) {
                params.put("appde", this.iPSAppView.getPSAppDataEntity());
            }
            if (this.prevPSAppView != null) {
                params.put("prevappview", this.prevPSAppView);
            }
            if (this.nextPSAppView != null) {
                params.put("nextappview", this.nextPSAppView);
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
        this.prevPSAppView = null;
        this.nextPSAppView = null;
        super.onClose();
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        return null;
    }
}

