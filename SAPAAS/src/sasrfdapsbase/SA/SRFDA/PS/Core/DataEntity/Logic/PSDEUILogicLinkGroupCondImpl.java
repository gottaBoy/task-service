/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.GroupCondCodeListModel
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCondBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCondType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLinkGroupCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicLinkCondImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.GroupCondCodeListModel;

@PSModelImplementMeta(implement="IPSDEUILogicLinkCond", typevalues={"GROUP"})
public class PSDEUILogicLinkGroupCondImpl
extends PSDEUILogicLinkCondImpl
implements IPSDEUILogicLinkGroupCond {
    protected ArrayList<IPSDEUILogicLinkCond> psDEUILogicLinkCondList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEUILogicLinkConds();
    }

    protected void onPreparePSDEUILogicLinkConds() throws Exception {
        ArrayList<PSDELogicLinkCond> psDEUILogicLinkCondList = this.psDELogicLinkCond.getChildPSDELogicLinkConds(false);
        if (psDEUILogicLinkCondList == null) {
            return;
        }
        for (PSDELogicLinkCond psDELogicLinkCond : psDEUILogicLinkCondList) {
            IPSDELogicLinkCondType iPSDELogicLinkCondType = this.getPSModelStorage().getPSDELogicLinkCondType(psDELogicLinkCond.getLOGICTYPE());
            IPSDEUILogicLinkCond iPSDEUILogicLinkCond = iPSDELogicLinkCondType.createPSDEUILogicLinkCond(psDELogicLinkCond);
            iPSDEUILogicLinkCond.init(this.getDAGlobalHelper(), this.getPSDEUILogicLink(), this, psDELogicLinkCond);
            this.psDEUILogicLinkCondList.add(iPSDEUILogicLinkCond);
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

    @Override
    @PSModelRTMeta(description="\u5b50\u6761\u4ef6\u96c6\u5408", hideempty=true, child=true)
    public Iterator<? extends IPSDEUILogicLinkCond> getPSDEUILogicLinkConds() {
        if (this.psDEUILogicLinkCondList == null || this.psDEUILogicLinkCondList.size() == 0) {
            return null;
        }
        return this.psDEUILogicLinkCondList.iterator();
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
        return this.getPSDEUILogicLinkConds();
    }
}

