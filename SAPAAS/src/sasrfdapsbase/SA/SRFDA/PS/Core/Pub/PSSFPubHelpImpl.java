/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherMacro;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSPubObj;
import SA.SRFDA.PS.Core.Pub.IPSSFPubHelp;
import SA.SRFDA.PS.Core.Pub.PSPubHelpImplBase;
import SA.SRFDA.PS.Core.Pub.PSSFCodePublisherMacroImpl;
import SA.SRFDA.PS.Core.Pub.PSSFCodePublisherParamImpl;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPubObj;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSSFPubHelpImpl
extends PSPubHelpImplBase
implements IPSSFPubHelp {
    public PSSFPubHelpImpl(IPSModelObject iPSObject, IPSPubObj iPSPubObj, Map<String, IPSCodePublisherParam> params) {
        super(iPSObject, iPSPubObj, params);
    }

    @Override
    protected IPSCodePublisherMacro createPSCodePublisherMacro(String strKey, String strValue) {
        return new PSSFCodePublisherMacroImpl(this.getPSModelObject(), strKey, strValue);
    }

    @Override
    public String getModelType() {
        return "PSSFPUBHELP$" + this.getPSModelObject().getModelType();
    }

    public static IPSSFPubHelp createPSSFPubHelp(String strTarget, IPSSystem iPSSystem, IPSModelObject iPSModelObject, Map<String, IPSCodePublisherParam> publisherParamMap) throws Exception {
        IPSApplication iPSApplication;
        IPSDataEntity iPSDataEntity;
        if (StringHelper.isNullOrEmpty((String)iPSSystem.getPSSFId())) {
            return null;
        }
        IPSSF iPSSF = PSObjectFactory.getPSModelStorage().getPSSF(iPSSystem.getPSSFId(), true);
        if (iPSSF == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u6a21\u677f[%1$s]", (Object)iPSSystem.getPSSFId()));
        }
        IPSSFPubObj iPSSFPubObj = iPSSF.getPSSFPubObjByTarget(strTarget, true);
        if (iPSSFPubObj == null) {
            return null;
        }
        if (publisherParamMap == null) {
            publisherParamMap = new HashMap<String, IPSCodePublisherParam>();
        }
        if (!publisherParamMap.containsKey("sys")) {
            publisherParamMap.put("sys", new PSSFCodePublisherParamImpl(iPSModelObject, "sys", iPSSystem, "\u5f53\u524d\u7cfb\u7edf\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("item")) {
            publisherParamMap.put("item", new PSSFCodePublisherParamImpl(iPSModelObject, "item", iPSModelObject, "\u5f53\u524d\u6a21\u578b\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("pub") && iPSSystem.getDefaultPSSysSFPub() != null) {
            publisherParamMap.put("pub", new PSSFCodePublisherParamImpl(iPSModelObject, "pub", iPSSystem.getDefaultPSSysSFPub(), "\u5f53\u524d\u540e\u53f0\u6a21\u677f\u53d1\u5e03\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("de") && (iPSDataEntity = PSSystemUtil.getRefPSDataEntity(iPSModelObject, true)) != null) {
            publisherParamMap.put("de", new PSSFCodePublisherParamImpl(iPSModelObject, "de", iPSDataEntity, "\u5f53\u524d\u5b9e\u4f53\u5bf9\u8c61", null));
        }
        if (!publisherParamMap.containsKey("app") && (iPSApplication = PSSystemUtil.getRefPSApplication(iPSModelObject, true)) != null) {
            publisherParamMap.put("app", new PSSFCodePublisherParamImpl(iPSModelObject, "app", iPSApplication, "\u5f53\u524d\u524d\u7aef\u5e94\u7528\u5bf9\u8c61", null));
        }
        iPSSFPubObj.fillPublisherParams(iPSModelObject, publisherParamMap);
        return new PSSFPubHelpImpl(iPSModelObject, iPSSFPubObj, publisherParamMap);
    }
}

