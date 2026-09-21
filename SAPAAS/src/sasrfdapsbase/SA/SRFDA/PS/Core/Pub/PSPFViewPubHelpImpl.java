/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFPubObj;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSPFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSPubObj;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisherParamImpl;
import SA.SRFDA.PS.Core.Pub.PSPFPubHelpImpl;
import java.util.HashMap;
import java.util.Map;

public class PSPFViewPubHelpImpl
extends PSPFPubHelpImpl {
    private String strViewType = "";

    public PSPFViewPubHelpImpl(IPSModelObject iPSObject, IPSPubObj iPSPubObj, Map<String, IPSCodePublisherParam> params) {
        super(iPSObject, iPSPubObj, params);
        if (iPSObject instanceof IPSAppView) {
            IPSAppView iPSAppView = (IPSAppView)iPSObject;
            this.strViewType = iPSAppView.getPSViewType().getId();
            if (this.strViewType.indexOf("APP") != 0) {
                this.strViewType = "APP" + this.strViewType;
            }
        }
    }

    @PSModelRTMeta(name="VIEWTYPE", order=500)
    public String getViewType() {
        return this.strViewType;
    }

    public static IPSPFPubHelp createPSPFPubHelp(IPSAppView iPSAppView, Map<String, IPSCodePublisherParam> publisherParamMap) throws Exception {
        IPSDataEntity iPSDataEntity;
        IPSApplication iPSApplication = iPSAppView.getPSApplication();
        if (iPSApplication.getPSPF() == null) {
            return null;
        }
        IPSPFPubObj iPSPFPubObj = iPSApplication.getPSPF().getPSPFPubObjByTarget("PSAPPVIEW", true);
        if (iPSPFPubObj == null) {
            return null;
        }
        if (publisherParamMap == null) {
            publisherParamMap = new HashMap<String, IPSCodePublisherParam>();
        }
        if (!publisherParamMap.containsKey("P")) {
            publisherParamMap.put("P", new PSPFCodePublisherParamImpl(iPSAppView, "P", null, "\u53d1\u5e03\u5668\u4e0a\u4e0b\u6587\u5bf9\u8c61", "net.ibizsys.model.pub.IPSPFViewCodePublisherContext2"));
        }
        if (!publisherParamMap.containsKey("sys")) {
            publisherParamMap.put("sys", new PSPFCodePublisherParamImpl(iPSAppView, "sys", iPSApplication.getPSSystem(), "\u5f53\u524d\u7cfb\u7edf\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("app")) {
            publisherParamMap.put("app", new PSPFCodePublisherParamImpl(iPSAppView, "app", iPSApplication, "\u5f53\u524d\u524d\u7aef\u5e94\u7528\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("view")) {
            publisherParamMap.put("view", new PSPFCodePublisherParamImpl(iPSAppView, "view", iPSAppView, "\u5f53\u524d\u89c6\u56fe\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("appde") && iPSAppView.getPSAppDataEntity() != null) {
            publisherParamMap.put("appde", new PSPFCodePublisherParamImpl(iPSAppView, "appde", iPSAppView.getPSAppDataEntity(), "\u5f53\u524d\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("de") && (iPSDataEntity = PSSystemUtil.getRefPSDataEntity(iPSAppView, true)) != null) {
            publisherParamMap.put("de", new PSPFCodePublisherParamImpl(iPSAppView, "de", iPSDataEntity, "\u5f53\u524d\u5b9e\u4f53\u5bf9\u8c61", null));
        }
        iPSPFPubObj.fillPublisherParams(iPSAppView, publisherParamMap);
        return new PSPFViewPubHelpImpl(iPSAppView, iPSPFPubObj, publisherParamMap);
    }
}

