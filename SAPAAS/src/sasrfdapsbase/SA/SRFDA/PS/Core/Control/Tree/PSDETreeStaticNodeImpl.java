/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeStaticNode;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeImplBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSDETreeStaticNodeImpl
extends PSDETreeNodeImplBase
implements IPSDETreeStaticNode {
    private IPSLanguageRes tooltipPSLanguageRes = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNode.getTIPPSLANRESID())) {
            this.tooltipPSLanguageRes = this.getPSDETree().getPSAppView().getPSApplication().getPSLanguageRes(this.psDETreeNode.getTIPPSLANRESID());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u6587\u672c", fields={"CAPTION"})
    public String getText() {
        if (StringHelper.isNullOrEmpty((String)this.psDETreeNode.getCAPTION())) {
            return this.getName();
        }
        return this.psDETreeNode.getCAPTION();
    }

    @Override
    @PSModelRTMeta(description="\u9759\u6001\u8282\u70b9\u503c", fields={"NODEVALUE"})
    public String getNodeValue() {
        return this.psDETreeNode.getNODEVALUE();
    }

    @Override
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u8bed\u8a00\u8d44\u6e90", fields={"TIPPSLANRESID"})
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u4fe1\u606f", fields={"TOOLTIPINFO"})
    public String getTooltip() {
        return this.psDETreeNode.getTOOLTIPINFO();
    }
}

