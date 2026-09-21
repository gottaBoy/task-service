/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFLink
 *  net.ibizsys.model.wf.IPSWFTimeoutLink
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.ibizsys.pswf.core.WFTimeoutLinkModelBase
 */
package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFTimeoutLink;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFTimeoutLinkModelBase;
import net.ibizsys.ssdynawf.core.IDynaWFVersionModel;

public class DynaWFTimeoutLinkModel
extends WFTimeoutLinkModelBase {
    private IDynaWFVersionModel iDynaWFVersionModel = null;
    private IPSWFTimeoutLink iPSWFLink = null;

    public void init(IDynaWFVersionModel iDynaWFVersionModel, IPSWFLink iPSWFLink) throws Exception {
        this.iDynaWFVersionModel = iDynaWFVersionModel;
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
        this.setBPMNModelId(iPSWFLink.getBPMNModelId());
        this.init((IWFVersionModel)iDynaWFVersionModel);
    }
}

