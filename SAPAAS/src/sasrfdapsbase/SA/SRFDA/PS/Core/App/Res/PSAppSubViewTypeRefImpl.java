/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Res;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.Res.IPSAppSubViewTypeRef;
import SA.SRFDA.PS.Core.App.View.PSAppDECtrlPreviewViewImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSViewLayoutPanel;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.LinkedHashMap;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppSubViewTypeRefImpl
extends PSApplicationObjectImpl
implements IPSAppSubViewTypeRef {
    private static final Log log = LogFactory.getLog(PSAppSubViewTypeRefImpl.class);
    private IPSSubViewType iPSSubViewType = null;
    private String strRefTag = null;
    private String strViewType = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private IPSViewLayoutPanel iPSViewLayoutPanel = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSSubViewType iPSSubViewType, String strViewType, String strRefTag) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSSubViewType = iPSSubViewType;
            this.strRefTag = strRefTag;
            this.strViewType = strViewType;
            this.setId(KeyValueHelper.genUniqueId((String)iPSApplication.getId(), (String)iPSSubViewType.getId(), (String)strViewType, (String)strRefTag));
            this.setName(iPSSubViewType.getName());
            if (iPSApplication.isEnableUIModelEx() && !StringHelper.isNullOrEmpty((String)iPSSubViewType.getPSSysViewPanelId())) {
                PSAppDECtrlPreviewViewImpl psAppDECtrlPreviewViewImpl = new PSAppDECtrlPreviewViewImpl();
                PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
                psDEViewCtrl.setPSDEVIEWCTRLTYPE("VIEWLAYOUTPANEL");
                psDEViewCtrl.setPSSYSVIEWPANELID(iPSSubViewType.getPSSysViewPanelId());
                PSAppView psAppView = new PSAppView();
                psAppView.setPSAPPVIEWID(iPSSubViewType.getId());
                psAppView.setPSAPPVIEWNAME(iPSSubViewType.getCodeName());
                psAppDECtrlPreviewViewImpl.init(iDAGlobalHelper, iPSApplication, psAppView, null, psDEViewCtrl);
                this.iPSViewLayoutPanel = psAppDECtrlPreviewViewImpl.getPSViewLayoutPanel();
            }
            if (this.getPSSysPFPlugin() != null) {
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
                    params.put("app", this.getPSApplication());
                    this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, null, params);
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
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
    protected int onCheck() throws Exception {
        if (this.getPSViewLayoutPanel() != null) {
            this.getPSViewLayoutPanel().check();
        }
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u89c6\u56fe\u5b50\u7c7b\u578b", group="\u57fa\u672c", order=115)
    public IPSSubViewType getPSSubViewType() {
        return this.iPSSubViewType;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6807\u8bb0", group="\u57fa\u672c", order=117)
    public String getRefTag() {
        return this.strRefTag;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u89c6\u56fe\u7c7b\u578b", group="\u57fa\u672c", order=112)
    public String getViewType() {
        return this.strViewType;
    }

    @Override
    public String getModelType() {
        return "PSAPPSUBVIEWTYPEREF";
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.getPSSubViewType().getPSSysPFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u4ee3\u7801")
    public String getPluginCode() {
        if (this.getPSSysPFPlugin() != null) {
            return this.getPSSysPFPlugin().getPluginCode();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u6269\u5c55\u754c\u9762\u6837\u5f0f", ignoredumpvalues="false")
    public boolean isExtendStyleOnly() {
        if (this.getPSSubViewType() != null) {
            return this.getPSSubViewType().isExtendStyleOnly();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6a21\u578b", hideempty=true)
    public ObjectNode getViewModel() {
        if (this.getPSSubViewType() != null) {
            return this.getPSSubViewType().getViewModel();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u5c40\u9ed8\u8ba4\u66ff\u6362", ignoredumpvalues="false", group="\u57fa\u672c", order=120)
    public boolean isReplaceDefault() {
        if (this.getPSSubViewType() != null) {
            return this.getPSSubViewType().isReplaceDefault();
        }
        return false;
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        return false;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u7c7b\u578b\u4ee3\u7801")
    public String getTypeCode() {
        if (this.getPSSubViewType() != null) {
            return this.getPSSubViewType().getTypeCode();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5e03\u5c40\u9762\u677f", child=true)
    public IPSViewLayoutPanel getPSViewLayoutPanel() {
        return this.iPSViewLayoutPanel;
    }
}

