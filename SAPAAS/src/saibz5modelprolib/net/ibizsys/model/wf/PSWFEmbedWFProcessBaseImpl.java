/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFEmbedWFProcessBase
 *  net.ibizsys.model.wf.IPSWFProcessSubWF
 *  net.ibizsys.pswf.core.IWFEmbedWFReturnModel
 *  net.ibizsys.pswf.core.IWFProcSubWFModel
 */
package net.ibizsys.model.wf;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.entity.PSWFProcSubWF;
import net.ibizsys.model.wf.IPSWFEmbedWFProcessBase;
import net.ibizsys.model.wf.IPSWFProcessSubWF;
import net.ibizsys.model.wf.PSWFProcessImpl;
import net.ibizsys.model.wf.PSWFProcessSubWFImpl;
import net.ibizsys.pswf.core.IWFEmbedWFReturnModel;
import net.ibizsys.pswf.core.IWFProcSubWFModel;

public abstract class PSWFEmbedWFProcessBaseImpl
extends PSWFProcessImpl
implements IPSWFEmbedWFProcessBase {
    protected ArrayList<IPSWFProcessSubWF> psWFProcessSubWFList = new ArrayList();
    protected ArrayList<IWFProcSubWFModel> wfProcSubWFModelList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.preparePSWFProcessSubWFs();
    }

    protected void preparePSWFProcessSubWFs() throws Exception {
        this.psWFProcessSubWFList.clear();
        this.wfProcSubWFModelList.clear();
        ArrayList<PSWFProcSubWF> psWFProcessSubWFList = this.psWFProcess.getPSWFProcSubWFs(false);
        if (psWFProcessSubWFList == null) {
            return;
        }
        for (PSWFProcSubWF psWFProcSubWF : psWFProcessSubWFList) {
            PSWFProcessSubWFImpl iPSWFVersionProcessSubWF = new PSWFProcessSubWFImpl();
            iPSWFVersionProcessSubWF.init(this.getPSModelStorageContext(), this, psWFProcSubWF);
            this.psWFProcessSubWFList.add(iPSWFVersionProcessSubWF);
        }
        this.wfProcSubWFModelList.addAll(this.psWFProcessSubWFList);
    }

    public IWFEmbedWFReturnModel getWFEmbedWFReturnModelByValue(String strValue, boolean bTryMode) throws Exception {
        return null;
    }

    public Iterator<IWFProcSubWFModel> getWFProcSubWFModels() {
        return this.wfProcSubWFModelList.iterator();
    }

    public Iterator<IPSWFProcessSubWF> getPSWFProcessSubWFs() {
        return this.psWFProcessSubWFList.iterator();
    }

    public int getPSWFProcessSubWFCount() {
        return this.psWFProcessSubWFList.size();
    }
}

