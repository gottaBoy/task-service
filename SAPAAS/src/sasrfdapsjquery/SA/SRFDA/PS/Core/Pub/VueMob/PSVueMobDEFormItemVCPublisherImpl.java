/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.IPSEditorType
 *  SA.SRFDA.PS.Core.PF.IPSPFEditorTempl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 *  SA.SRFDA.PS.Core.Res.IPSSysPFPlugin
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.VueMob;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.VueMob.PSVueMobDEFormDetailVCPublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;

public class PSVueMobDEFormItemVCPublisherImpl
extends PSVueMobDEFormDetailVCPublisherImpl {
    protected IPSDEFormItem iPSDEFormItem = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEFormItem = (IPSDEFormItem)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        IPSEditorType iPSEditorType = this.getPSModelStorage().getPSEditorType(this.iPSDEFormItem.getEditorType());
        IPSSysPFPlugin iPSSysPFPlugin = null;
        if (this.iPSDEFormItem.getPSSysEditorStyle() != null) {
            iPSSysPFPlugin = this.iPSDEFormItem.getPSSysEditorStyle().getPSSysPFPlugin();
        }
        if (iPSSysPFPlugin != null) {
            String strCode;
            String strCodeName = "";
            if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"HTML", (boolean)true) == 0) {
                strCodeName = "CODE";
            } else if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"SERVICE_TS", (boolean)true) == 0) {
                strCodeName = "CODE2";
            }
            if (!StringHelper.isNullOrEmpty((String)strCodeName) && !StringHelper.isNullOrEmpty((String)(strCode = iPSSysPFPlugin.getCode(strCodeName, this.iPSPF.getId(), this.iPSPFStyle.getId(), (Object)this.iPSAppView, (Object)this.iPSControl, (Object)this.iPSDEFormItem)))) {
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

