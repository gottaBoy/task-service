/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFDEActionProcess
 *  net.ibizsys.pswf.core.IWFDEActionProcessParamModel
 */
package net.ibizsys.model.wf;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.wf.IPSWFDEActionProcess;
import net.ibizsys.model.wf.PSWFProcessImpl;
import net.ibizsys.pswf.core.IWFDEActionProcessParamModel;

public class PSWFDEActionProcessImpl
extends PSWFProcessImpl
implements IPSWFDEActionProcess {
    private ArrayList<IWFDEActionProcessParamModel> wfDEActionProcessParamModelList = new ArrayList();

    @Override
    protected void preparePSWFProcessParams() throws Exception {
        super.preparePSWFProcessParams();
        this.wfDEActionProcessParamModelList.addAll(this.psWFProcessParamList);
    }

    public Iterator<IWFDEActionProcessParamModel> getWFDEActionProcessParamModels() {
        return this.wfDEActionProcessParamModelList.iterator();
    }

    public String getDEActionName() {
        return this.psWFProcess.getPSDEACTIONNAME();
    }
}

