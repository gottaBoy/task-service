/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub.Base;

import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.Pub.Base.PSCtrlCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import java.util.HashMap;

public class PSDEDataViewCodePublisherImpl
extends PSCtrlCodePublisherImpl {
    protected IPSDEDataView iPSDEDataView = null;
    public static final String CTRLPART_RECORD = "RECORD";
    public static final String CTRLPART_STORE = "STORE";

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDEDataView = (IPSDEDataView)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSPFCtrlTempl iPSPFCtrlTempl;
        this.iPSDEDataView = (IPSDEDataView)this.iPSControl;
        if (this.iPSDEDataView.getItemPSSysLayoutPanel() != null && (iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl(this.iPSDEDataView.getItemPSSysLayoutPanel().getPSControlType(), this.getPSPFPubCode())) != null) {
            HashMap<String, Object> panelParams = new HashMap<String, Object>();
            panelParams.put("srfctrl", params.get("srfctrl"));
            IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEDataView.getItemPSSysLayoutPanel(), panelParams);
            if (iPSGenerateCodeResult != null) {
                params.put(this.iPSDEDataView.getItemPSSysLayoutPanel().getName(), iPSGenerateCodeResult);
            }
            iPSPFCtrlCodePublisher.close();
        }
        super.onFillGenerateCodeParams(params);
    }

    protected void onClose() {
        this.iPSDEDataView = null;
        super.onClose();
    }
}

