/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFEmbedWFReturnModel
 *  net.ibizsys.pswf.core.IWFProcSubWFModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFEmbedWFProcessBase;
import SA.SRFDA.PS.Core.WF.IPSWFProcessSubWF;
import SA.SRFDA.PS.Core.WF.PSWFProcessImpl;
import SA.SRFDA.PS.Core.WF.PSWFProcessSubWFImpl;
import SA.SRFDA.PS.Data.PSWFProcSubWF;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFEmbedWFReturnModel;
import net.ibizsys.pswf.core.IWFProcSubWFModel;

@PSModelPFIgnoreMeta
public abstract class PSWFEmbedWFProcessBaseImpl
extends PSWFProcessImpl
implements IPSWFEmbedWFProcessBase {
    protected ArrayList<IPSWFProcessSubWF> psWFProcessSubWFList = new ArrayList();
    protected ArrayList<IWFProcSubWFModel> wfProcSubWFModelList = new ArrayList();
    private String strMultiInstMode = "NONE";

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psWFProcess.getMULTIINSTMODE())) {
            this.strMultiInstMode = this.psWFProcess.getMULTIINSTMODE();
        }
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
            iPSWFVersionProcessSubWF.init(this.getDAGlobalHelper(), this, psWFProcSubWF);
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

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u6d41\u7a0b\u96c6\u5408", child=true)
    public Iterator<IPSWFProcessSubWF> getPSWFProcessSubWFs() {
        return this.psWFProcessSubWFList.iterator();
    }

    @Override
    public int getPSWFProcessSubWFCount() {
        return this.psWFProcessSubWFList.size();
    }

    @Override
    protected String onGetWFStepValue() {
        String strWFStepValue = super.onGetWFStepValue();
        if (!StringHelper.isNullOrEmpty((String)strWFStepValue)) {
            return strWFStepValue;
        }
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u591a\u5b9e\u4f8b\u6a21\u5f0f", codelist="WFProcMultiInstMode", hideempty2=true, fields={"MULTIINSTMODE"}, ignoredumpvalues="NONE")
    public String getMultiInstMode() {
        return this.strMultiInstMode;
    }
}

