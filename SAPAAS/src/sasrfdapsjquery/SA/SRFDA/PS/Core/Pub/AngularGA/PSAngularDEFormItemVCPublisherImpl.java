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
 *  SA.SRFDA.PS.Core.Pub.PSImportHelper
 *  SA.SRFDA.PS.Core.Res.IPSSysPFPlugin
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub.AngularGA;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.Pub.AngularGA.PSAngularDEFormDetailVCPublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSImportHelper;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAngularDEFormItemVCPublisherImpl
extends PSAngularDEFormDetailVCPublisherImpl {
    private static final Log log = LogFactory.getLog(PSAngularDEFormItemVCPublisherImpl.class);
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
            String strCodeName = "";
            String strCodeName2 = "";
            if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"HTML", (boolean)true) == 0) {
                strCodeName = "CODE";
            } else if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"CONTROL_TS", (boolean)true) == 0) {
                strCodeName = "CODE2";
                strCodeName2 = "CODE5";
            }
            if (!StringHelper.isNullOrEmpty((String)strCodeName)) {
                String strCode;
                if (!StringHelper.isNullOrEmpty((String)strCodeName2) && !StringHelper.isNullOrEmpty((String)(strCode = iPSSysPFPlugin.getCode(strCodeName2, this.iPSPF.getId(), this.iPSPFStyle.getId(), (Object)this.iPSAppView, (Object)this.iPSControl, (Object)this.iPSDEFormItem)))) {
                    if (PSImportHelper.getCurrent() == null) {
                        log.warn((Object)StringHelper.format((String)"\u5f53\u524d\u6ca1\u6709\u5bfc\u5165\u8f85\u52a9\u5bf9\u8c61"));
                    } else {
                        PSImportHelper.getCurrent().register("", strCode);
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)(strCode = iPSSysPFPlugin.getCode(strCodeName, this.iPSPF.getId(), this.iPSPFStyle.getId(), (Object)this.iPSAppView, (Object)this.iPSControl, (Object)this.iPSDEFormItem)))) {
                    PSGenerateCodeResultImpl psGenerateCodeResult = new PSGenerateCodeResultImpl();
                    psGenerateCodeResult.setObject((Object)this.iPSDEFormItem);
                    psGenerateCodeResult.setCode(strCode);
                    params.put("editor", psGenerateCodeResult);
                    return;
                }
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

