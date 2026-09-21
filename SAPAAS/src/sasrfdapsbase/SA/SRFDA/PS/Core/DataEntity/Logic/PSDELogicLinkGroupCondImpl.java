/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.GroupCondCodeListModel
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCondBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCondType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkGroupCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicLinkCondImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.GroupCondCodeListModel;

@PSModelImplementMeta(implement="IPSDELogicLinkCond", typevalues={"GROUP"})
public class PSDELogicLinkGroupCondImpl
extends PSDELogicLinkCondImpl
implements IPSDELogicLinkGroupCond {
    protected ArrayList<IPSDELogicLinkCond> psDELogicLinkCondList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDELogicLinkConds();
    }

    protected void onPreparePSDELogicLinkConds() throws Exception {
        ArrayList<PSDELogicLinkCond> psDELogicLinkCondList = this.psDELogicLinkCond.getChildPSDELogicLinkConds(false);
        if (psDELogicLinkCondList == null) {
            return;
        }
        for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
            IPSDELogicLinkCondType iPSDELogicLinkCondType = this.getPSModelStorage().getPSDELogicLinkCondType(psDELogicLinkCond.getLOGICTYPE());
            IPSDELogicLinkCond iPSDELogicLinkCond = iPSDELogicLinkCondType.createPSDELogicLinkCond(psDELogicLinkCond);
            iPSDELogicLinkCond.init(this.getDAGlobalHelper(), this.getPSDELogicLink(), this, psDELogicLinkCond);
            this.psDELogicLinkCondList.add(iPSDELogicLinkCond);
        }
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u5408\u6761\u4ef6", codelist="GroupCond", fields={"GROUPOP"})
    public String getGroupOP() {
        return this.psDELogicLinkCond.getGROUPOP();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53d6\u53cd", ignoredumpvalues="false", fields={"GROUPNOTFLAG"})
    public boolean isNotMode() {
        return this.psDELogicLinkCond.getGROUPNOTFLAG();
    }

    @PSModelRTMeta(description="\u5b50\u6761\u4ef6\u96c6\u5408", hideempty=true, child=true, rtname="getConds")
    public Iterator<IPSDELogicLinkCond> getPSDELogicLinkConds() {
        if (this.psDELogicLinkCondList == null || this.psDELogicLinkCondList.size() == 0) {
            return null;
        }
        return this.psDELogicLinkCondList.iterator();
    }

    @Override
    public String getModelName() {
        String strModelName = "";
        if (this.isNotMode()) {
            strModelName = String.valueOf(strModelName) + StringHelper.format((String)"[!]");
        }
        try {
            strModelName = String.valueOf(strModelName) + CodeListGlobal.getCodeList(GroupCondCodeListModel.class).getCodeListText(this.getGroupOP(), true);
            return strModelName;
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    public Iterator<? extends IPSDELogicLinkCondBase> getPSDELogicLinkCondBases() {
        return this.getPSDELogicLinkConds();
    }
}

