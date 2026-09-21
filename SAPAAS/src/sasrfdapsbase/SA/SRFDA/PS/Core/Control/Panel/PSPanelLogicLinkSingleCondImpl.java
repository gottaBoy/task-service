/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkSingleCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelLogicLinkCondImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelIgnoreMeta
public class PSPanelLogicLinkSingleCondImpl
extends PSPanelLogicLinkCondImpl
implements IPSPanelLogicLinkSingleCond {
    protected String strDstFieldName = "";
    private IPSPanelLogicParam dstPSPanelLogicParam = null;

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psPanelLogicLinkCond.getDSTPSPANELLPID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u9762\u677f\u903b\u8f91\u53c2\u6570");
        }
        this.dstPSPanelLogicParam = this.getPSPanelLogicLink().getPSPanelLogic().getPSPanelLogicParam(this.psPanelLogicLinkCond.getDSTPSPANELLPID());
        this.strDstFieldName = this.psPanelLogicLinkCond.getDSTFIELDNAME();
        super.onInit();
    }

    @Override
    public IPSPanelLogicParam getDstPanelLogicParam() throws Exception {
        return this.dstPSPanelLogicParam;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u64cd\u4f5c")
    public String getCondOp() {
        return this.psPanelLogicLinkCond.getCONDOP();
    }

    @Override
    @PSModelRTMeta(description="\u503c")
    public String getValue() {
        return this.psPanelLogicLinkCond.getCONDVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5c5e\u6027\u540d\u79f0", hideempty2=true)
    public String getDstFieldName() throws Exception {
        return this.strDstFieldName;
    }

    @Override
    public String getModelType() {
        return "PSDELLCOND_SINGLE";
    }
}

