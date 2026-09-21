/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFLinkCond
 *  net.ibizsys.model.wf.IPSWFRouteLink
 *  net.ibizsys.pswf.core.IWFLinkCondModel
 *  net.ibizsys.pswf.core.IWFLinkGroupCondModel
 *  net.ibizsys.pswf.core.IWFLinkSingleCondModel
 *  net.ibizsys.pswf.core.RootWFLinkGroupCondModel
 *  net.ibizsys.pswf.core.WFLinkGroupCondModel
 *  net.ibizsys.pswf.core.WFLinkSingleCondModel
 */
package net.ibizsys.model.wf;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.wf.IPSWFLinkCond;
import net.ibizsys.model.wf.IPSWFRouteLink;
import net.ibizsys.model.wf.PSWFLinkImpl;
import net.ibizsys.pswf.core.IWFLinkCondModel;
import net.ibizsys.pswf.core.IWFLinkGroupCondModel;
import net.ibizsys.pswf.core.IWFLinkSingleCondModel;
import net.ibizsys.pswf.core.RootWFLinkGroupCondModel;
import net.ibizsys.pswf.core.WFLinkGroupCondModel;
import net.ibizsys.pswf.core.WFLinkSingleCondModel;

public class PSWFRouteLinkImpl
extends PSWFLinkImpl
implements IPSWFRouteLink {
    private RootWFLinkGroupCondModel rootWFLinkGroupCondModel = new RootWFLinkGroupCondModel();
    private boolean bDefaultLink = false;

    @Override
    protected void onInit() throws Exception {
        if (!this.psWFLink.isDEFAULTLINKNull()) {
            this.bDefaultLink = this.psWFLink.getDEFAULTLINK();
        }
        super.onInit();
    }

    @Override
    protected void preparePSWFLinkConds() throws Exception {
        super.preparePSWFLinkConds();
        if (this.psWFLinkGroupCondImpl == null) {
            return;
        }
        RootWFLinkGroupCondModel rootWFLinkGroupCondModel2 = new RootWFLinkGroupCondModel();
        ArrayList<IWFLinkCondModel> allItems = new ArrayList<IWFLinkCondModel>();
        this.fillWFLinkCondModels((IWFLinkGroupCondModel)this.psWFLinkGroupCondImpl, allItems);
        for (IWFLinkCondModel iWFLinkCondModel : allItems) {
            String strPId = "";
            IPSWFLinkCond parentPSWFLinkCond = ((IPSWFLinkCond)iWFLinkCondModel).getParentPSWFLinkCond();
            if (parentPSWFLinkCond != null) {
                strPId = parentPSWFLinkCond.getId();
            }
            if (iWFLinkCondModel instanceof IWFLinkGroupCondModel) {
                IWFLinkGroupCondModel iWFLinkGroupCondModel = (IWFLinkGroupCondModel)iWFLinkCondModel;
                WFLinkGroupCondModel wfLinkGroupCondModel = rootWFLinkGroupCondModel2.addGroupCond(iWFLinkCondModel.getId(), strPId);
                wfLinkGroupCondModel.setGroupOP(iWFLinkGroupCondModel.getGroupOP());
                wfLinkGroupCondModel.setNotMode(iWFLinkGroupCondModel.isNotMode());
                continue;
            }
            if (!(iWFLinkCondModel instanceof IWFLinkSingleCondModel)) continue;
            IWFLinkSingleCondModel iWFLinkSingleCondModel = (IWFLinkSingleCondModel)iWFLinkCondModel;
            WFLinkSingleCondModel wfLinkSingleCondModel = rootWFLinkGroupCondModel2.addSingleCond(iWFLinkCondModel.getId(), strPId);
            wfLinkSingleCondModel.setCondOP(iWFLinkSingleCondModel.getCondOP());
            wfLinkSingleCondModel.setFieldName(iWFLinkSingleCondModel.getFieldName());
            wfLinkSingleCondModel.setParamType(iWFLinkSingleCondModel.getParamType());
            wfLinkSingleCondModel.setParamValue(iWFLinkSingleCondModel.getParamValue());
        }
        this.rootWFLinkGroupCondModel = rootWFLinkGroupCondModel2;
    }

    protected void fillWFLinkCondModels(IWFLinkGroupCondModel iPSWFLinkGroupCond, ArrayList<IWFLinkCondModel> allItems) {
        if (iPSWFLinkGroupCond.getWFLinkCondModels() == null) {
            return;
        }
        Iterator wfLinkCondModels = iPSWFLinkGroupCond.getWFLinkCondModels();
        while (wfLinkCondModels.hasNext()) {
            IWFLinkCondModel iWFLinkCondModel = (IWFLinkCondModel)wfLinkCondModels.next();
            allItems.add(iWFLinkCondModel);
            if (!(iWFLinkCondModel instanceof IWFLinkGroupCondModel)) continue;
            this.fillWFLinkCondModels((IWFLinkGroupCondModel)iWFLinkCondModel, allItems);
        }
    }

    public boolean isDefault() {
        return this.bDefaultLink;
    }

    public RootWFLinkGroupCondModel getRootWFLinkGroupCondModel() {
        return this.rootWFLinkGroupCondModel;
    }

    public IWFLinkGroupCondModel getWFLinkGroupCondModel() {
        return this.rootWFLinkGroupCondModel;
    }
}

