/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.WFEmbedWFReturnModelBase
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFVersionModel;
import SA.SRFDA.PS.Core.WF.IPSWFEmbedWFReturnLink;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.WFEmbedWFReturnModelBase;

public class PSJITWFEmbedWFReturnModel
extends WFEmbedWFReturnModelBase {
    private IPSJITWFVersionModel iPSJITWFVersionModel = null;
    private IPSWFEmbedWFReturnLink iPSWFLink = null;

    public void init(IPSJITWFVersionModel iPSJITWFVersionModel, IPSWFLink iPSWFLink) throws Exception {
        this.iPSJITWFVersionModel = iPSJITWFVersionModel;
        this.iPSWFLink = (IPSWFEmbedWFReturnLink)iPSWFLink;
        this.setId(this.iPSWFLink.getId());
        this.setName(this.iPSWFLink.getName());
        this.setSrcEndPoint(this.iPSWFLink.getSrcEndPoint());
        this.setDstEndPoint(this.iPSWFLink.getDstEndPoint());
        this.setNext(this.iPSWFLink.getToPSWFProcess().getId());
        this.setFrom(this.iPSWFLink.getFromPSWFProcess().getId());
        this.setLogicName(this.iPSWFLink.getLogicName());
        this.setReturnValue(this.iPSWFLink.getReturnValue());
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFLink.getUserData())) {
            this.setUserData(this.iPSWFLink.getUserData());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFLink.getUserData2())) {
            this.setUserData2(this.iPSWFLink.getUserData2());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFLink.getNextCondition())) {
            this.setNextCondition(this.iPSWFLink.getNextCondition());
        }
        this.init(iPSJITWFVersionModel);
    }
}

