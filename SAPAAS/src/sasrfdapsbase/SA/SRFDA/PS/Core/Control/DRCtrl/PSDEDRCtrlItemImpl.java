/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.IPSAppPDTView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlItem;
import SA.SRFDA.PS.Core.Control.DRCtrl.PSDEDRBarItemImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRCtrlItemImpl
extends PSObjectImpl
implements IPSDEDRCtrlItem {
    private static final Log log = LogFactory.getLog(PSDEDRBarItemImpl.class);
    private IPSDEDRCtrl iPSDEDRCtrl;
    private IPSDEDRDetail iPSDEDRDetail;
    private IPSAppView iPSAppView = null;
    private String strEmbedViewId = null;
    private JSONObject viewParamJO = new JSONObject();
    private IPSAppDELogic testPSAppDELogic = null;
    private IPSSysPFPlugin headerPSSysPFPlugin = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDRCtrl iPSDEDRCtrl, IPSDEDRDetail iPSDEDRDetail) throws Exception {
        try {
            Iterator it;
            JSONObject drViewParamJO;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDRCtrl = iPSDEDRCtrl;
            this.iPSDEDRDetail = iPSDEDRDetail;
            this.setId(this.iPSDEDRDetail.getId());
            this.setName(this.iPSDEDRDetail.getName());
            if (iPSDEDRDetail.getPSSysPDTView() != null) {
                String strPSAppPDTViewId = Helper.GenUniqueId((String)this.iPSDEDRCtrl.getPSAppView().getPSApplication().getId(), (String)iPSDEDRDetail.getPSSysPDTView().getId());
                IPSAppPDTView iPSAppPDTView = this.iPSDEDRCtrl.getPSAppView().getPSApplication().getPSAppPDTView(strPSAppPDTViewId, true);
                if (iPSAppPDTView != null && iPSAppPDTView.getPSAppView() != null) {
                    this.iPSAppView = iPSAppPDTView.getPSAppView();
                    this.strEmbedViewId = this.iPSDEDRCtrl.getPSAppView().generateViewUniId();
                }
            }
            if (this.iPSAppView == null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEDRDetail.getPSDEViewId())) {
                String strPSAppViewId = Helper.GenUniqueId((String)this.iPSDEDRCtrl.getPSAppView().getPSApplication().getId(), (String)iPSDEDRDetail.getPSDEViewId());
                try {
                    this.iPSAppView = this.iPSDEDRCtrl.getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, iPSDEDRDetail.getPSDEViewId(), this.iPSDEDRCtrl.getPSAppView());
                    this.strEmbedViewId = this.iPSDEDRCtrl.getPSAppView().generateViewUniId();
                }
                catch (Exception ex) {
                    log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u89c6\u56fe[%1$s]\u5173\u7cfb\u680f[%2$s]\u5173\u7cfb\u9879[%3$s]\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe[%4$s]\u53d1\u751f\u5f02\u5e38\uff0c%5$s", (Object)this.iPSDEDRCtrl.getPSAppView().getName(), (Object)iPSDEDRCtrl.getName(), (Object)this.getName(), (Object)this.iPSDEDRDetail.getPSDEViewId(), (Object)ex.getMessage()));
                    throw ex;
                }
            }
            this.viewParamJO.put("srfparentdeid".toLowerCase(), (Object)this.iPSDEDRCtrl.getPSDataEntity().getId());
            if (this.getPSDEDRItem() != null && (drViewParamJO = this.getPSDEDRItem().getViewParamJO()) != null && (it = drViewParamJO.keys()) != null) {
                while (it.hasNext()) {
                    String strKey = (String)it.next();
                    String strValue = drViewParamJO.optString(strKey);
                    if (strValue == null) continue;
                    this.viewParamJO.put(strKey.toLowerCase(), (Object)strValue);
                }
            }
            if (this.getCapPSLanguageRes() != null) {
                this.iPSDEDRCtrl.getPSAppView().getPSApplication().getPSLanguageRes(this.getCapPSLanguageRes().getId());
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getEnableMode(), (String)"DELOGIC", (boolean)false) == 0 && iPSDEDRCtrl.getPSAppDataEntity() != null && iPSDEDRDetail.getTestPSDELogic() != null) {
                this.testPSAppDELogic = iPSDEDRCtrl.getPSAppDataEntity().getPSAppDELogic(iPSDEDRDetail.getTestPSDELogic().getId());
            }
            if (this.iPSDEDRDetail.getHeaderPSSysPFPlugin() != null) {
                this.headerPSSysPFPlugin = this.iPSDEDRCtrl.getPSAppView().getPSApplication().getPSSysPFPlugin(this.iPSDEDRDetail.getHeaderPSSysPFPlugin().getId(), "DEDRITEMHEADER", null, null);
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        return this.iPSDEDRDetail.getCaption(this.iPSDEDRCtrl.getPSAppView().getLanguage());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u7ec4\u6210\u5458")
    public IPSDEDRDetail getPSDEDRDetail() {
        return this.iPSDEDRDetail;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u8054\u89c6\u56fe", dumpref=true, model="PSDEDRItem", fields={"PSDEVIEWBASEID"})
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    @Override
    public String getEmbedViewId() {
        return this.strEmbedViewId;
    }

    @Override
    public IPSDEDRItem getPSDEDRItem() {
        if (this.iPSDEDRDetail == null) {
            return null;
        }
        return this.iPSDEDRDetail.getPSDEDRItem();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDRCtrl.getPSSysModelInstId();
    }

    @Override
    public JSONObject getViewParamJO() {
        return this.viewParamJO;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        if (this.iPSDEDRDetail == null) {
            return null;
        }
        return this.iPSDEDRDetail.getCapPSLanguageRes();
    }

    public IPSDEDRCtrl getPSDEDRCtrl() {
        return this.iPSDEDRCtrl;
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSDEDRCtrl();
    }

    @Override
    public String getFullModelName() {
        if (this.getOwnedPSControl() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)this.getOwnedPSControl().getFullModelName(), (Object)this.getModelName());
        }
        return super.getFullModelName();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDRCtrl().getPSAppView().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.getPSDEDRItem() == null) {
            return null;
        }
        return this.getPSDEDRItem().getPSNavigateParams();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.getPSDEDRItem() == null) {
            return null;
        }
        return this.getPSDEDRItem().getPSNavigateContexts();
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6807\u8bc6", fields={"COUNTERID"})
    public String getCounterId() {
        return this.getPSDEDRDetail().getCounterId();
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6a21\u5f0f", codelist="DETreeNodeCounterMode", ignoredumpvalues="0", fields={"COUNTERMODE"})
    public int getCounterMode() {
        return this.getPSDEDRDetail().getCounterMode();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u56fe\u7247\u8d44\u6e90\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.getPSDEDRDetail().getPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlLogic> getPSControlLogics() {
        return this.onGetPSControlLogics();
    }

    protected Iterator<? extends IPSControlLogic> onGetPSControlLogics() {
        return this.getOwnedPSControl().getPSControlLogicsByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6ce8\u5165\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlAttribute> getPSControlAttributes() {
        return this.onGetPSControlAttributes();
    }

    protected Iterator<? extends IPSControlAttribute> onGetPSControlAttributes() {
        return this.getOwnedPSControl().getPSControlAttributesByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7ed8\u5236\u5668\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlRender> getPSControlRenders() {
        return this.onGetPSControlRenders();
    }

    protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
        return this.getOwnedPSControl().getPSControlRendersByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6a21\u5f0f", codelist="DEDRDetailEnableMode")
    public String getEnableMode() {
        return this.getPSDEDRDetail().getEnableMode();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u6570\u636e\u8bbf\u95ee\u6807\u8bc6")
    public String getDataAccessAction() {
        if ("DEOPPRIV".equals(this.getEnableMode()) && this.getPSDEDRDetail().getTestPSDEOPPriv() != null) {
            return this.getPSDEDRDetail().getTestPSDEOPPriv().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u5b9e\u4f53\u903b\u8f91", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDELogic getTestPSAppDELogic() {
        return this.testPSAppDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u811a\u672c")
    public String getTestScriptCode() {
        return this.getPSDEDRDetail().getTestScriptCode();
    }

    @Override
    public int getOrderValue() {
        return this.getPSDEDRDetail().getOrderValue();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6807\u8bb0")
    public String getItemTag() {
        return this.getPSDEDRDetail().getDetailTag();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6807\u8bb02")
    public String getItemTag2() {
        return this.getPSDEDRDetail().getDetailTag2();
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getHeaderPSSysPFPlugin() {
        return this.headerPSSysPFPlugin;
    }
}

