/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.IPSEditorType
 *  SA.SRFDA.PS.Core.PF.IPSPFEditorTempl
 *  SA.SRFDA.PS.Core.PF.IPSPFPluginTempl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 *  SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper
 *  SA.SRFDA.PS.Core.Res.IPSSysPFPlugin
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPluginTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2DEFormDetailVCPublisherImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2TemplHelper;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSVue2DEFormItemVCPublisherImpl
extends PSVue2DEFormDetailVCPublisherImpl {
    protected IPSDEFormItem iPSDEFormItem = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEFormItem = (IPSDEFormItem)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSPFPluginTempl iPSPFPluginTempl;
        super.onFillGenerateCodeParams(params);
        IPSEditorType iPSEditorType = this.getPSModelStorage().getPSEditorType(this.iPSDEFormItem.getEditorType());
        IPSSysPFPlugin iPSSysPFPlugin = null;
        if (this.iPSDEFormItem.getPSSysEditorStyle() != null) {
            iPSSysPFPlugin = this.iPSDEFormItem.getPSSysEditorStyle().getPSSysPFPlugin();
        }
        if (iPSSysPFPlugin != null && (iPSPFPluginTempl = iPSSysPFPlugin.getPSPFPluginTempl(this.iPSPF.getId(), this.getPSPFPubCode().getId(), true)) != null && !StringHelper.isNullOrEmpty((String)iPSPFPluginTempl.getPSPFPubCodeId())) {
            Map lastParams = PSTemplHelper.getCurrentParams();
            HashMap<String, Object> curParams = new HashMap<String, Object>();
            if (lastParams != null) {
                curParams.putAll(lastParams);
            }
            PSVue2TemplHelper.fillParams(curParams);
            PSTemplHelper.setCurrentParams(curParams);
            String strCodeName = "CODE";
            String strCode = iPSSysPFPlugin.getCode(strCodeName, this.getPSPFPubCode().getId(), this.iPSPF.getId(), this.iPSPFStyle.getId(), (Object)this.iPSAppView, (Object)this.iPSControl, (Object)this.iPSDEFormItem);
            PSTemplHelper.setCurrentParams((Map)lastParams);
            if (!StringHelper.isNullOrEmpty((String)strCode)) {
                PSGenerateCodeResultImpl psGenerateCodeResult = new PSGenerateCodeResultImpl();
                psGenerateCodeResult.setObject((Object)this.iPSDEFormItem);
                psGenerateCodeResult.setCode(strCode);
                params.put("editor", psGenerateCodeResult);
                return;
            }
        }
        IPSPFEditorTempl iPSPFEditorTempl = this.iPSApplication.getPSPFEditorTempl(iPSEditorType, "FORMITEM", this.getPSPFPubCode(), this.iPSDEFormItem.getEditorStyle());
        IPSPFEditorCodePublisher psPFEditorCodePublisher = iPSPFEditorTempl.getPSPFEditorCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = psPFEditorCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)this.iPSDEFormItem);
        params.put("editor", iPSGenerateCodeResult);
        psPFEditorCodePublisher.close();
    }

    @Override
    protected void onClose() {
        this.iPSDEFormItem = null;
        super.onClose();
    }
}

