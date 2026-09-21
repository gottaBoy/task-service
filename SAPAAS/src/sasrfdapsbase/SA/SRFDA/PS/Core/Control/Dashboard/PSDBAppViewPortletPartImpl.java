/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBAppViewPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBAppViewPortletPartParam;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBPortletPartImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSDBPortletPart", typevalues={"VIEW"})
public class PSDBAppViewPortletPartImpl
extends PSDBPortletPartImpl
implements IPSDBAppViewPortletPart {
    private static final Log log = LogFactory.getLog(PSDBAppViewPortletPartImpl.class);
    private IPSAppView portletPSAppView = null;
    private String strEmbedViewId = null;
    private IPSDBAppViewPortletPartParam iPSDBAppViewPortletPartParam = null;
    private IPSPortletType iPSPortletType = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSDBAppViewPortletPartParam = (IPSDBAppViewPortletPartParam)iPSControlParam;
            this.setId(StringHelper.format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
            this.setName(strName);
            if (!StringHelper.isNullOrEmpty((String)this.iPSDBAppViewPortletPartParam.getEmbededPSAppViewId())) {
                this.setId(this.iPSDBAppViewPortletPartParam.getEmbededPSAppViewId());
            }
            this.iPSPortletType = this.getPSModelStorage().getPSPortletType(this.getPortletType());
            super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
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
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.iPSDBAppViewPortletPartParam.getEmbededPSAppViewId())) {
            try {
                this.portletPSAppView = this.getPSAppView().getPSApplication().getPSAppView(this.iPSDBAppViewPortletPartParam.getEmbededPSAppViewId(), false);
                this.portletPSAppView.markViewUsage(4, this);
                this.strEmbedViewId = this.getPSAppView().generateViewUniId();
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u89c6\u56fe\u95e8\u6237\u90e8\u4ef6[%1$s]\u76f8\u5173\u5e94\u7528\u89c6\u56fe\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getName(), (Object)ex.getMessage()), ex);
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
        if (StringHelper.isNullOrEmpty((String)this.getEmbedViewId())) {
            return;
        }
        IPSAppView refPSAppView = this.getPortletPSAppView();
        PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
        PSAppViewRef psAppViewRef = new PSAppViewRef();
        psAppViewRefImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), psAppViewRef);
        psAppViewRefImpl.setRefPSAppView(refPSAppView);
        String strFullViewId = "";
        strFullViewId = StringHelper.isNullOrEmpty((String)strContainerId) ? this.getEmbedViewId() : StringHelper.format((String)"%1$s_%2$s", (Object)strContainerId, (Object)this.getEmbedViewId());
        psAppViewRefImpl.setEmbedId(strFullViewId);
        embeddedPSAppViewRefList.add(psAppViewRefImpl);
        Iterator<IPSAppViewRef> childPSAppViewRefs = refPSAppView.getEmbeddedPSAppViewRefs(strFullViewId);
        if (childPSAppViewRefs != null) {
            while (childPSAppViewRefs.hasNext()) {
                embeddedPSAppViewRefList.add(childPSAppViewRefs.next());
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u770b\u677f\u90e8\u4ef6\u7c7b\u578b", codelist="PortletType3", fields={"PVPARTTYPE"})
    public String getPortletType() {
        return "VIEW";
    }

    @Override
    public IPSPortletType getPSPortetType() {
        return this.iPSPortletType;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppView().getFullModelName(), (Object)this.getModelName());
    }
}

