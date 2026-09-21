/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFLinkCondModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCond;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCondType;
import SA.SRFDA.PS.Core.WF.IPSWFLinkGroupCond;
import SA.SRFDA.PS.Core.WF.PSWFLinkCondImpl;
import SA.SRFDA.PS.Data.PSWFLinkCond;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.pswf.core.IWFLinkCondModel;

@PSModelPFIgnoreMeta
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
            IPSWFLinkCondType iPSWFLinkCondType = this.getPSModelStorage().getPSWFLinkCondType(psWFLinkCond.getLOGICTYPE());
            IPSWFLinkCond iPSWFLinkCond = iPSWFLinkCondType.createPSWFLinkCond(psWFLinkCond);
            iPSWFLinkCond.init(this.getDAGlobalHelper(), this.getPSWFLink(), this, psWFLinkCond);
            this.psWFLinkCondList.add(iPSWFLinkCond);
        }
        this.wfLinkCondModelList.addAll(this.psWFLinkCondList);
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u5408\u6761\u4ef6", codelist="GroupCond", fields={"GROUPOP"})
    public String getGroupOP() {
        return this.psWFLinkCond.getGROUPOP();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53d6\u53cd", fields={"GROUPNOTFLAG"})
    public boolean isNotMode() {
        return this.psWFLinkCond.getGROUPNOTFLAG();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6761\u4ef6\u96c6\u5408", child=true)
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

