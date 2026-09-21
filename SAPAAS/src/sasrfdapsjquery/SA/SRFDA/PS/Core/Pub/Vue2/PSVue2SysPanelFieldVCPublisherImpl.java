/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.IPSEditorType
 *  SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelField
 *  SA.SRFDA.PS.Core.PF.IPSPFEditorTempl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 *  SA.SRFDA.PS.Core.Res.IPSSysPFPlugin
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelField;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2SysPanelItemVCPublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;

public class PSVue2SysPanelFieldVCPublisherImpl
extends PSVue2SysPanelItemVCPublisherImpl {
    protected IPSSysPanelField iPSSysPanelField = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSSysPanelField = (IPSSysPanelField)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        this.iPSSysPanelField = (IPSSysPanelField)this.object;
        IPSEditorType iPSEditorType = this.getPSModelStorage().getPSEditorType(this.iPSSysPanelField.getEditorType());
        IPSSysPFPlugin iPSSysPFPlugin = null;
        if (this.iPSSysPanelField.getPSSysEditorStyle() != null && !this.iPSSysPanelField.getPSSysPanel().isDesignMode()) {
            iPSSysPFPlugin = this.iPSSysPanelField.getPSSysEditorStyle().getPSSysPFPlugin();
        }
        if (iPSSysPFPlugin != null) {
            String strCode;
            String strCodeName = "";
            if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"VIEW", (boolean)true) == 0) {
                strCodeName = "CODE";
            } else if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"CONTROLLER", (boolean)true) == 0) {
                strCodeName = "CODE2";
            }
            if (!StringHelper.isNullOrEmpty((String)strCodeName) && !StringHelper.isNullOrEmpty((String)(strCode = iPSSysPFPlugin.getCode(strCodeName, this.iPSPF.getId(), this.iPSPFStyle.getId(), (Object)this.iPSAppView, (Object)this.iPSControl, (Object)this.iPSSysPanelField)))) {
                PSGenerateCodeResultImpl psGenerateCodeResult = new PSGenerateCodeResultImpl();
                psGenerateCodeResult.setObject((Object)this.iPSSysPanelField);
                psGenerateCodeResult.setCode(strCode);
                params.put("editor", psGenerateCodeResult);
                return;
            }
        }
        IPSPFEditorTempl iPSPFEditorTempl = this.iPSApplication.getPSPFEditorTempl(iPSEditorType, "PANELFIELD", this.getPSPFPubCode(), this.iPSSysPanelField.getEditorStyle());
        IPSPFEditorCodePublisher psPFEditorCodePublisher = iPSPFEditorTempl.getPSPFEditorCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = psPFEditorCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)this.iPSSysPanelField);
        params.put("editor", iPSGenerateCodeResult);
        psPFEditorCodePublisher.close();
    }

    @Override
    protected void onClose() {
        this.iPSSysPanelField = null;
        super.onClose();
    }
}

