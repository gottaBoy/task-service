/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFCallActivityProcess;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.PSWFProcessImpl;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public abstract class PSWFCallActivityProcessImplBase
extends PSWFProcessImpl
implements IPSWFCallActivityProcess {
    private IPSWorkflow targetPSWF = null;
    private String strMultiInstMode = "NONE";

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psWFProcess.getEMBEDPSWFID())) {
            this.targetPSWF = this.getPSWFVersion().getPSWorkflow().getPSSystem().getPSWorkflow(this.psWFProcess.getEMBEDPSWFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFProcess.getMULTIINSTMODE())) {
            this.strMultiInstMode = this.psWFProcess.getMULTIINSTMODE();
        }
        super.onInit();
        if (this.getTargetPSWF() == null) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u6d41\u7a0b"));
        }
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u76ee\u6807\u6d41\u7a0b", dumpref=true, fields={"EMBEDPSWFID"})
    public IPSWorkflow getTargetPSWF() {
        return this.targetPSWF;
    }

    @Override
    @PSModelRTMeta(description="\u591a\u5b9e\u4f8b\u6a21\u5f0f", codelist="WFProcMultiInstMode", hideempty2=true, fields={"MULTIINSTMODE"}, ignoredumpvalues="NONE")
    public String getMultiInstMode() {
        return this.strMultiInstMode;
    }
}

