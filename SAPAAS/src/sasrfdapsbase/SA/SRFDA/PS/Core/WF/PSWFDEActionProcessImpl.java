/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFDEActionProcessParamModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFDEActionProcess;
import SA.SRFDA.PS.Core.WF.PSWFProcessImpl;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFDEActionProcessParamModel;

@PSModelImplementMeta(implement="IPSWFProcess", typevalues={"PROCESS"})
@PSModelPFIgnoreMeta
public class PSWFDEActionProcessImpl
extends PSWFProcessImpl
implements IPSWFDEActionProcess {
    private ArrayList<IWFDEActionProcessParamModel> wfDEActionProcessParamModelList = new ArrayList();
    private IPSDEAction iPSDEAction = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.psWFProcess.getPSDEACTIONID())) {
            this.iPSDEAction = this.getPSDataEntity().getPSDEAction(this.psWFProcess.getPSDEACTIONID(), true);
        }
    }

    @Override
    protected void preparePSWFProcessParams() throws Exception {
        super.preparePSWFProcessParams();
        this.wfDEActionProcessParamModelList.addAll(this.psWFProcessParamList);
    }

    public Iterator<IWFDEActionProcessParamModel> getWFDEActionProcessParamModels() {
        return this.wfDEActionProcessParamModelList.iterator();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u6807\u8bc6", doc="\u8ba1\u7b97{@link #getPSDEAction}\u884c\u4e3a\u6807\u8bc6", ignorert=3)
    public String getDEActionName() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getName();
        }
        return this.psWFProcess.getPSDEACTIONNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5de5\u4f5c\u6d41")
    public IPSDEWF getPSDEWF() {
        return super.getPSDEWF();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        if (this.getPSDEWF() != null) {
            return this.getPSDEWF().getPSDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity", fields={"PSDEACTIONID"})
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }
}

