/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFLinkCondModel
 *  net.ibizsys.pswf.core.IWFLinkGroupCondModel
 *  net.ibizsys.pswf.core.IWFLinkSingleCondModel
 *  net.ibizsys.pswf.core.WFLinkGroupCondModel
 *  net.ibizsys.pswf.core.WFLinkSingleCondModel
 *  net.ibizsys.pswf.core.WFRouteLinkModelBase
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFVersionModel;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFRouteLink;
import java.util.ArrayList;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFLinkCondModel;
import net.ibizsys.pswf.core.IWFLinkGroupCondModel;
import net.ibizsys.pswf.core.IWFLinkSingleCondModel;
import net.ibizsys.pswf.core.WFLinkGroupCondModel;
import net.ibizsys.pswf.core.WFLinkSingleCondModel;
import net.ibizsys.pswf.core.WFRouteLinkModelBase;

public class PSJITWFRouteLinkModel
extends WFRouteLinkModelBase {
    private IPSJITWFVersionModel iPSJITWFVersionModel = null;
    private IPSWFRouteLink iPSWFLink = null;

    public void init(IPSJITWFVersionModel iPSJITWFVersionModel, IPSWFLink iPSWFLink) throws Exception {
        this.iPSJITWFVersionModel = iPSJITWFVersionModel;
        this.iPSWFLink = (IPSWFRouteLink)iPSWFLink;
        this.setId(this.iPSWFLink.getId());
        this.setName(this.iPSWFLink.getName());
        this.setSrcEndPoint(this.iPSWFLink.getSrcEndPoint());
        this.setDstEndPoint(this.iPSWFLink.getDstEndPoint());
        this.setNext(this.iPSWFLink.getToPSWFProcess().getId());
        this.setFrom(this.iPSWFLink.getFromPSWFProcess().getId());
        this.setLogicName(this.iPSWFLink.getLogicName());
        if (this.iPSWFLink.isDefault()) {
            this.setDefault(true);
        }
        this.init(iPSJITWFVersionModel);
    }

    protected void onInit() throws Exception {
        super.onInit();
        if (this.iPSWFLink.isDefault()) {
            ArrayList wfLinkCondModels = this.iPSWFLink.getRootWFLinkGroupCondModel().getAllWFLinkCondModels();
            for (IWFLinkCondModel iWFLinkCondModel : wfLinkCondModels) {
                if (StringHelper.compare((String)iWFLinkCondModel.getCondType(), (String)"GROUP", (boolean)true) == 0) {
                    IWFLinkGroupCondModel iWFLinkGroupCondModel = (IWFLinkGroupCondModel)iWFLinkCondModel;
                    WFLinkGroupCondModel wfLinkGroupCondModel = this.getRootWFLinkGroupCondModel().addGroupCond(iWFLinkCondModel.getId(), iWFLinkGroupCondModel.getPId());
                    wfLinkGroupCondModel.setGroupOP(iWFLinkGroupCondModel.getGroupOP());
                    wfLinkGroupCondModel.setNotMode(iWFLinkGroupCondModel.isNotMode());
                    continue;
                }
                if (StringHelper.compare((String)iWFLinkCondModel.getCondType(), (String)"SINGLE", (boolean)true) != 0) continue;
                IWFLinkSingleCondModel iWFLinkSingleCondModel = (IWFLinkSingleCondModel)iWFLinkCondModel;
                WFLinkSingleCondModel wfLinkSingleCondModel = this.getRootWFLinkGroupCondModel().addSingleCond(iWFLinkCondModel.getId(), iWFLinkSingleCondModel.getPId());
                wfLinkSingleCondModel.setCondOP(iWFLinkSingleCondModel.getCondOP());
                wfLinkSingleCondModel.setFieldName(iWFLinkSingleCondModel.getFieldName());
                if (iWFLinkSingleCondModel.getParamType() != null) {
                    wfLinkSingleCondModel.setParamType(iWFLinkSingleCondModel.getParamType());
                }
                if (iWFLinkSingleCondModel.getParamValue() == null) continue;
                wfLinkSingleCondModel.setParamValue(iWFLinkSingleCondModel.getParamValue());
            }
        }
    }
}

