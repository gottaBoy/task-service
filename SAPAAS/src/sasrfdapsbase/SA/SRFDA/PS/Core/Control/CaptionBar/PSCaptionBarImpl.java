/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.CaptionBar;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.CaptionBar.IPSCaptionBar;
import SA.SRFDA.PS.Core.Control.CaptionBar.IPSCaptionBarParam;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"CAPTIONBAR"})
public class PSCaptionBarImpl
extends PSControlImpl
implements IPSCaptionBar {
    private static final Log log = LogFactory.getLog(PSCaptionBarImpl.class);
    protected IPSCaptionBarParam iPSCaptionBarParam = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.setName(strName);
            if (iPSControlParam != null) {
                this.iPSCaptionBarParam = (IPSCaptionBarParam)iPSControlParam;
            }
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
        super.onInit();
    }

    @Override
    protected String onGetControlType() {
        return "CAPTIONBAR";
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    public String getModelScope() {
        return "VIEW";
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.getPSAppView().getCaption();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.getPSAppView().getCapPSLanguageRes();
    }

    @Override
    public String getModelType() {
        return "PSCAPTIONBAR";
    }

    @Override
    protected boolean isExportModelAlways() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5b50\u6807\u9898")
    public String getSubCaption() {
        return this.getPSAppView().getSubCaption();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getSubCapPSLanguageRes() {
        return this.getPSAppView().getSubCapPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.getPSAppView().getPSSysImage();
    }
}

