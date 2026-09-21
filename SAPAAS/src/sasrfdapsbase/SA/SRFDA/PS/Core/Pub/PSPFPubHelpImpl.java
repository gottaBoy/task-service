/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFPubObj;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherMacro;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSPFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSPubObj;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisherMacroImpl;
import SA.SRFDA.PS.Core.Pub.PSPFCodePublisherParamImpl;
import SA.SRFDA.PS.Core.Pub.PSPubHelpImplBase;
import java.util.HashMap;
import java.util.Map;

public class PSPFPubHelpImpl
extends PSPubHelpImplBase
implements IPSPFPubHelp {
    public PSPFPubHelpImpl(IPSModelObject iPSObject, IPSPubObj iPSPubObj, Map<String, IPSCodePublisherParam> params) {
        super(iPSObject, iPSPubObj, params);
    }

    @Override
    protected IPSCodePublisherMacro createPSCodePublisherMacro(String strKey, String strValue) {
        return new PSPFCodePublisherMacroImpl(this.getPSModelObject(), strKey, strValue);
    }

    @Override
    public String getModelType() {
        return "PSPFPUBHELP$" + this.getPSModelObject().getModelType();
    }

    public static IPSPFPubHelp createPSPFPubHelp(String strTarget, IPSApplication iPSApplication, IPSModelObject iPSModelObject, Map<String, IPSCodePublisherParam> publisherParamMap) throws Exception {
        IPSAppDataEntityObject iPSAppDataEntityObject;
        if (iPSApplication == null && (iPSApplication = PSSystemUtil.getRefPSApplication(iPSModelObject, true)) == null) {
            return null;
        }
        if (iPSApplication.getPSPF() == null) {
            return null;
        }
        IPSPFPubObj iPSPFPubObj = iPSApplication.getPSPF().getPSPFPubObjByTarget(strTarget, true);
        if (iPSPFPubObj == null) {
            return null;
        }
        if (publisherParamMap == null) {
            publisherParamMap = new HashMap<String, IPSCodePublisherParam>();
        }
        if (!publisherParamMap.containsKey("P")) {
            publisherParamMap.put("P", new PSPFCodePublisherParamImpl(iPSModelObject, "P", null, "\u53d1\u5e03\u5668\u4e0a\u4e0b\u6587\u5bf9\u8c61", "net.ibizsys.model.pub.IPSPFCodePublisherContext"));
        }
        if (!publisherParamMap.containsKey("sys")) {
            publisherParamMap.put("sys", new PSPFCodePublisherParamImpl(iPSModelObject, "sys", iPSApplication.getPSSystem(), "\u5f53\u524d\u7cfb\u7edf\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("app")) {
            publisherParamMap.put("app", new PSPFCodePublisherParamImpl(iPSModelObject, "app", iPSApplication, "\u5f53\u524d\u524d\u7aef\u5e94\u7528\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("item")) {
            publisherParamMap.put("item", new PSPFCodePublisherParamImpl(iPSModelObject, "item", iPSModelObject, "\u5f53\u524d\u6a21\u578b\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("appde") && iPSModelObject instanceof IPSAppDataEntityObject && (iPSAppDataEntityObject = (IPSAppDataEntityObject)iPSModelObject).getPSAppDataEntity() != null) {
            publisherParamMap.put("appde", new PSPFCodePublisherParamImpl(iPSModelObject, "appde", iPSAppDataEntityObject.getPSAppDataEntity(), "\u5f53\u524d\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", null));
            if (!publisherParamMap.containsKey("de")) {
                publisherParamMap.put("de", new PSPFCodePublisherParamImpl(iPSModelObject, "de", iPSAppDataEntityObject.getPSAppDataEntity().getPSDataEntity(), "\u5f53\u524d\u5b9e\u4f53\u5bf9\u8c61", null));
            }
        }
        iPSPFPubObj.fillPublisherParams(iPSModelObject, publisherParamMap);
        return new PSPFPubHelpImpl(iPSModelObject, iPSPFPubObj, publisherParamMap);
    }
}

