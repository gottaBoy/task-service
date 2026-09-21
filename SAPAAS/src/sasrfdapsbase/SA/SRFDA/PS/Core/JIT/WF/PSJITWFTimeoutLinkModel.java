/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.WFTimeoutLinkModelBase
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFVersionModel;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFTimeoutLink;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.WFTimeoutLinkModelBase;

public class PSJITWFTimeoutLinkModel
extends WFTimeoutLinkModelBase {
    private IPSJITWFVersionModel iPSJITWFVersionModel = null;
    private IPSWFTimeoutLink iPSWFLink = null;

    public void init(IPSJITWFVersionModel iPSJITWFVersionModel, IPSWFLink iPSWFLink) throws Exception {
        this.iPSJITWFVersionModel = iPSJITWFVersionModel;
        this.iPSWFLink = (IPSWFTimeoutLink)iPSWFLink;
        this.setId(this.iPSWFLink.getId());
        this.setName(this.iPSWFLink.getName());
        this.setSrcEndPoint(this.iPSWFLink.getSrcEndPoint());
        this.setDstEndPoint(this.iPSWFLink.getDstEndPoint());
        this.setNext(this.iPSWFLink.getToPSWFProcess().getId());
        this.setFrom(this.iPSWFLink.getFromPSWFProcess().getId());
        this.setLogicName(this.iPSWFLink.getLogicName());
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFLink.getUserData())) {
            this.setUserData(this.iPSWFLink.getUserData());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFLink.getUserData2())) {
            this.setUserData2(this.iPSWFLink.getUserData2());
        }
        this.init(iPSJITWFVersionModel);
    }
}

