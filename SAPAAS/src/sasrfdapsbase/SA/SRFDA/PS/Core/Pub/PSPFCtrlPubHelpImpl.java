/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
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

public class PSPFCtrlPubHelpImpl
extends PSPFPubHelpImpl {
    private String strCtrlType = "";
    private String strTarget = "";

    public PSPFCtrlPubHelpImpl(IPSModelObject iPSObject, IPSPubObj iPSPubObj, Map<String, IPSCodePublisherParam> params) {
        super(iPSObject, iPSPubObj, params);
        if (iPSObject instanceof IPSControl) {
            IPSControl iPSControl = (IPSControl)iPSObject;
            this.strCtrlType = iPSControl.getControlType();
            this.strTarget = "PSAPPVIEWCTRL_" + this.strCtrlType;
            this.setName(this.getTarget());
        }
    }

    @PSModelRTMeta(name="CTRLTYPE", order=500)
    public String getCtrlType() {
        return this.strCtrlType;
    }

    @Override
    @PSModelRTMeta(name="\u53d1\u5e03\u76ee\u6807", order=100)
    public String getTarget() {
        return this.strTarget;
    }

    public static IPSPFPubHelp createPSPFPubHelp(IPSControl iPSControl, Map<String, IPSCodePublisherParam> publisherParamMap) throws Exception {
        IPSDataEntity iPSDataEntity;
        IPSAppView iPSAppView = iPSControl.getPSAppView();
        if (iPSAppView == null) {
            return null;
        }
        IPSApplication iPSApplication = iPSAppView.getPSApplication();
        if (iPSApplication.getPSPF() == null) {
            return null;
        }
        IPSPFPubObj iPSPFPubObj = iPSApplication.getPSPF().getPSPFPubObjByTarget("PSAPPVIEWCTRL", true);
        if (iPSPFPubObj == null) {
            return null;
        }
        if (publisherParamMap == null) {
            publisherParamMap = new HashMap<String, IPSCodePublisherParam>();
        }
        if (!publisherParamMap.containsKey("P")) {
            publisherParamMap.put("P", new PSPFCodePublisherParamImpl(iPSControl, "P", null, "\u53d1\u5e03\u5668\u4e0a\u4e0b\u6587\u5bf9\u8c61", "net.ibizsys.model.pub.IPSPFCtrlCodePublisherContext"));
        }
        if (!publisherParamMap.containsKey("sys")) {
            publisherParamMap.put("sys", new PSPFCodePublisherParamImpl(iPSControl, "sys", iPSApplication.getPSSystem(), "\u5f53\u524d\u7cfb\u7edf\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("app")) {
            publisherParamMap.put("app", new PSPFCodePublisherParamImpl(iPSControl, "app", iPSApplication, "\u5f53\u524d\u524d\u7aef\u5e94\u7528\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("view")) {
            publisherParamMap.put("view", new PSPFCodePublisherParamImpl(iPSControl, "view", iPSAppView, "\u5f53\u524d\u89c6\u56fe\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("ctrl")) {
            publisherParamMap.put("ctrl", new PSPFCodePublisherParamImpl(iPSControl, "ctrl", iPSControl, "\u5f53\u524d\u90e8\u4ef6\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("appde") && iPSControl.getPSAppDataEntity() != null) {
            publisherParamMap.put("appde", new PSPFCodePublisherParamImpl(iPSControl, "appde", iPSAppView.getPSAppDataEntity(), "\u5f53\u524d\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("de") && (iPSDataEntity = PSSystemUtil.getRefPSDataEntity(iPSControl, true)) != null) {
            publisherParamMap.put("de", new PSPFCodePublisherParamImpl(iPSControl, "de", iPSDataEntity, "\u5f53\u524d\u5b9e\u4f53\u5bf9\u8c61", null));
        }
        iPSPFPubObj.fillPublisherParams(iPSControl, publisherParamMap);
        return new PSPFCtrlPubHelpImpl(iPSControl, iPSPFPubObj, publisherParamMap);
    }
}

