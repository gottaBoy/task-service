/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicInvokeCtrl;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelLogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelIgnoreMeta
public class PSPanelLogicInvokeCtrlImpl
extends PSPanelLogicNodeImpl
implements IPSPanelLogicInvokeCtrl {
    private String strInvokeMethod = null;
    private IPSPanelItem iPSPanelItem = null;

    @Override
    protected void onInit() throws Exception {
        this.strInvokeMethod = this.psPanelLogicNode.getPARAM1();
        if (!StringHelper.IsNullOrEmpty((String)this.psPanelLogicNode.getPSSYSVIEWPANELITEMID())) {
            this.iPSPanelItem = this.getPSPanelLogic().getPSPanel().getPSPanelItem(this.psPanelLogicNode.getPSSYSVIEWPANELITEMID());
        }
        if (this.getPSPanelItem() == null) {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u8c03\u7528\u9762\u677f\u9879"));
        }
        if (StringHelper.IsNullOrEmpty((String)this.getInvokeMethod())) {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u8c03\u7528\u9762\u677f\u9879\u65b9\u6cd5"));
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u9762\u677f\u9879", hideempty=true)
    public IPSPanelItem getPSPanelItem() {
        return this.iPSPanelItem;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u65b9\u6cd5", hideempty=true)
    public String getInvokeMethod() {
        return this.strInvokeMethod;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u53c2\u6570", hideempty=true)
    public IPSPanelLogicParam getPSPanelLogicParam() throws Exception {
        return super.getPSPanelLogicParam();
    }
}

