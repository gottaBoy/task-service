/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFLinkCond
 *  net.ibizsys.model.wf.IPSWFLinkGroupCond
 *  net.ibizsys.pswf.core.IWFLinkCondModel
 */
package net.ibizsys.model.wf;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.entity.PSWFLinkCond;
import net.ibizsys.model.wf.IPSWFLinkCond;
import net.ibizsys.model.wf.IPSWFLinkCondRuntime;
import net.ibizsys.model.wf.IPSWFLinkCondType;
import net.ibizsys.model.wf.IPSWFLinkGroupCond;
import net.ibizsys.model.wf.PSWFLinkCondImpl;
import net.ibizsys.pswf.core.IWFLinkCondModel;

public class PSWFLinkGroupCondImpl
extends PSWFLinkCondImpl
implements IPSWFLinkGroupCond {
    protected ArrayList<IPSWFLinkCond> psWFLinkCondList = new ArrayList();
    protected ArrayList<IWFLinkCondModel> wfLinkCondModelList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSWFLinkConds();
    }

    protected void onPreparePSWFLinkConds() throws Exception {
        ArrayList<PSWFLinkCond> psWFLinkCondList = this.psWFLinkCond.getChildPSWFLinkConds(false);
        if (psWFLinkCondList == null) {
            return;
        }
        this.wfLinkCondModelList.clear();
        for (PSWFLinkCond psWFLinkCond : psWFLinkCondList) {
            IPSWFLinkCondType iPSWFLinkCondType = this.getPSModelStorageContext().getPSWFLinkCondType(psWFLinkCond.getLOGICTYPE());
            IPSWFLinkCond iPSWFLinkCond = iPSWFLinkCondType.createPSWFLinkCond(psWFLinkCond);
            ((IPSWFLinkCondRuntime)iPSWFLinkCond).init(this.getPSModelStorageContext(), this.getPSWFLink(), this, psWFLinkCond);
            this.psWFLinkCondList.add(iPSWFLinkCond);
        }
        this.wfLinkCondModelList.addAll(this.psWFLinkCondList);
    }

    public String getGroupOP() {
        return this.psWFLinkCond.getGROUPOP();
    }

    public boolean isNotMode() {
        return this.psWFLinkCond.getGROUPNOTFLAG();
    }

    public Iterator<IPSWFLinkCond> getPSWFLinkConds() {
        if (this.psWFLinkCondList == null || this.psWFLinkCondList.size() == 0) {
            return null;
        }
        return this.psWFLinkCondList.iterator();
    }

    public Iterator<IWFLinkCondModel> getWFLinkCondModels() {
        if (this.wfLinkCondModelList == null || this.wfLinkCondModelList.size() == 0) {
            return null;
        }
        return this.wfLinkCondModelList.iterator();
    }
}

