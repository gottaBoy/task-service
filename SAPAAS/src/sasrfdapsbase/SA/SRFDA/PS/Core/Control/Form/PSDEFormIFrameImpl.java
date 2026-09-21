/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormIFrame;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormDetailImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import net.ibizsys.paas.util.KeyValueHelper;

public class PSDEFormIFrameImpl
extends PSDEFormDetailImpl
implements IPSDEFormIFrame {
    private String strEmbedViewId = null;
    private String strRefreshItems = null;
    private String strIFrameUrl = null;
    private IPSAppView linkPSAppView = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getRESETITEMNAME())) {
            this.strRefreshItems = this.psDEFormDetail.getRESETITEMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getLINKPSDEVIEWID())) {
            String strLinkPSAppViewId = KeyValueHelper.genUniqueId((String)this.getPSDEForm().getPSAppView().getPSApplication().getId(), (String)this.psDEFormDetail.getLINKPSDEVIEWID());
            this.linkPSAppView = this.getPSDEForm().getPSAppView().getPSApplication().getPSAppView(strLinkPSAppViewId, false);
            this.linkPSAppView.markViewUsage(1, this);
        }
        this.strIFrameUrl = this.linkPSAppView != null ? this.linkPSAppView.getPageUrl() : this.psDEFormDetail.getEDITORPARAMS();
        super.onInit();
        this.strEmbedViewId = this.getPSDEForm().getPSAppView().generateViewUniId();
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
    }

    @Override
    public String getEmbedViewId() {
        return this.strEmbedViewId;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u5237\u65b0\u89e6\u53d1\u8868\u5355\u9879", fields={"resetitemname"})
    public String getRefreshItems() {
        return this.strRefreshItems;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5165Url\u8def\u5f84", fields={"editorparams"})
    public String getIFrameUrl() {
        return this.strIFrameUrl;
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u5e94\u7528\u89c6\u56fe", dumpref=true, fields={"linkpsdeviewid"})
    public IPSAppView getLinkPSAppView() {
        return this.linkPSAppView;
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_IFRAME";
    }
}

