/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 *  net.ibizsys.model.res.IPSSysEditorStyleRuntime
 *  net.ibizsys.model.res.IPSSysPFPlugin
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.pub;

import java.util.HashMap;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.PSNGDEFormDetailVCPublisherImpl;
import net.ibizsys.model.res.IPSSysEditorStyleRuntime;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.paas.util.StringHelper;

public class PSNGDEFormItemVCPublisherImpl
extends PSNGDEFormDetailVCPublisherImpl {
    protected IPSDEFormItem iPSDEFormItem = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEFormItem = (IPSDEFormItem)object;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        IPSEditorType iPSEditorType = this.getPSModelStorageContext().getPSEditorType(this.iPSDEFormItem.getEditorType());
        IPSSysPFPlugin iPSSysPFPlugin = null;
        if (this.iPSDEFormItem.getPSSysEditorStyle() != null) {
            iPSSysPFPlugin = ((IPSSysEditorStyleRuntime)this.iPSDEFormItem.getPSSysEditorStyle()).getPSSysPFPlugin();
        }
        if (iPSSysPFPlugin != null) {
            String strCode;
            String strCodeName = "";
            if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"PART", (boolean)true) == 0) {
                strCodeName = "CODE";
            } else if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"CONTROLLER", (boolean)true) == 0) {
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
    }
}

