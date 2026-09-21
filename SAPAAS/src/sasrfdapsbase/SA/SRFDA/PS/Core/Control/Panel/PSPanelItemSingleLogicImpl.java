/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemSingleLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelItemLogicImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSPanelItemSingleLogicImpl
extends PSPanelItemLogicImpl
implements IPSPanelItemSingleLogic {
    private IPSPanelModel iPSPanelModel = null;

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psPanelItemLogic.getDSTPSPANELMODELID())) {
            this.iPSPanelModel = this.getPSPanelItem().getPSPanel().getPSPanelModel("PANELMODEL", true);
            if (this.iPSPanelModel == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u9762\u677f\u6a21\u578b\u5bf9\u8c61");
            }
        } else {
            this.iPSPanelModel = this.getPSPanelItem().getPSPanel().getPSPanelModel(this.psPanelItemLogic.getDSTPSPANELMODELID());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u503c", fields={"CONDVALUE"})
    public String getValue() {
        return this.psPanelItemLogic.getCONDVALUE();
    }

    @Override
    public IPSPanelModel getDstPSPanelModel() {
        return this.iPSPanelModel;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u5c5e\u6027\u540d\u79f0", fields={"DSTFIELDNAME"})
    public String getDstModelField() {
        return this.psPanelItemLogic.getDSTFIELDNAME();
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u64cd\u4f5c", fields={"CONDOP"})
    public String getCondOp() {
        return this.psPanelItemLogic.getCONDOP();
    }
}

