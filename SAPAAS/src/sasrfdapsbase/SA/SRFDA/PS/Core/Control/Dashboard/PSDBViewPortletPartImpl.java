/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBViewPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBSysPortletPartImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDEViewPortlet;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSDBPortletPart", typevalues={"VIEW"})
public class PSDBViewPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBViewPortletPart {
    private IPSAppView portletPSAppView = null;
    private String strEmbedViewId = null;

    @Override
    protected void onInit() throws Exception {
        IPSSysDEViewPortlet iPSSysDEViewPortlet = (IPSSysDEViewPortlet)this.iPSSysPortlet;
        if (!StringHelper.IsNullOrEmpty((String)iPSSysDEViewPortlet.getPSDEViewId())) {
            try {
                String strPSAppViewId = Helper.GenUniqueId((String)this.getPSAppView().getPSApplication().getId(), (String)iPSSysDEViewPortlet.getPSDEViewId());
                this.portletPSAppView = this.getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, iPSSysDEViewPortlet.getPSDEViewId(), this.getPSAppView());
                this.portletPSAppView.markViewUsage(4, this);
                this.strEmbedViewId = this.getPSAppView().generateViewUniId();
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u89c6\u56fe\u95e8\u6237\u90e8\u4ef6[%1$s]\u76f8\u5173\u5e94\u7528\u89c6\u56fe\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getName(), (Object)ex.getMessage()), ex);
            }
        }
        super.onInit();
    }

    @Override
    public IPSControl getContentPSControl() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5165\u89c6\u56fe\u5bf9\u8c61", child=true, fields={"PSAPPVIEWID"})
    public IPSAppView getPortletPSAppView() {
        return this.portletPSAppView;
    }

    public String getEmbedViewId() {
        return this.strEmbedViewId;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.getPortletPSAppView() != null) {
            relatedAppViewList.add(this.getPortletPSAppView());
        }
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        if (StringHelper.IsNullOrEmpty((String)this.getEmbedViewId())) {
            return;
        }
        IPSAppView refPSAppView = this.getPortletPSAppView();
        PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
        PSAppViewRef psAppViewRef = new PSAppViewRef();
        psAppViewRefImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), psAppViewRef);
        psAppViewRefImpl.setRefPSAppView(refPSAppView);
        String strFullViewId = "";
        strFullViewId = StringHelper.IsNullOrEmpty((String)strContainerId) ? this.getEmbedViewId() : StringHelper.Format((String)"%1$s_%2$s", (Object)strContainerId, (Object)this.getEmbedViewId());
        psAppViewRefImpl.setEmbedId(strFullViewId);
        embeddedPSAppViewRefList.add(psAppViewRefImpl);
        Iterator<IPSAppViewRef> childPSAppViewRefs = refPSAppView.getEmbeddedPSAppViewRefs(strFullViewId);
        if (childPSAppViewRefs != null) {
            while (childPSAppViewRefs.hasNext()) {
                embeddedPSAppViewRefList.add(childPSAppViewRefs.next());
            }
        }
    }
}

