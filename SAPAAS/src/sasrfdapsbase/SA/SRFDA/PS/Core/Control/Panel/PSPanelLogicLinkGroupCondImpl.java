/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.GroupCondCodeListModel
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCondType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkGroupCond;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelLogicLinkCondImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSPanelLogicLinkCond;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.GroupCondCodeListModel;

@PSModelIgnoreMeta
public class PSPanelLogicLinkGroupCondImpl
extends PSPanelLogicLinkCondImpl
implements IPSPanelLogicLinkGroupCond {
    protected ArrayList<IPSPanelLogicLinkCond> psPanelLogicLinkCondList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSPanelLogicLinkConds();
    }

    protected void onPreparePSPanelLogicLinkConds() throws Exception {
        ArrayList<PSPanelLogicLinkCond> psPanelLogicLinkCondList = this.psPanelLogicLinkCond.getChildPSPanelLogicLinkConds(false);
        if (psPanelLogicLinkCondList == null) {
            return;
        }
        for (PSPanelLogicLinkCond psPanelLogicLinkCond : psPanelLogicLinkCondList) {
            IPSPanelLogicLinkCondType iPSPanelLogicLinkCondType = this.getPSModelStorage().getPSPanelLogicLinkCondType(psPanelLogicLinkCond.getLOGICTYPE());
            IPSPanelLogicLinkCond iPSPanelLogicLinkCond = iPSPanelLogicLinkCondType.createPSPanelLogicLinkCond(psPanelLogicLinkCond);
            iPSPanelLogicLinkCond.init(this.getDAGlobalHelper(), this.getPSPanelLogicLink(), this, psPanelLogicLinkCond);
            this.psPanelLogicLinkCondList.add(iPSPanelLogicLinkCond);
        }
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u5408\u6761\u4ef6", codelist="GroupCond")
    public String getGroupOP() {
        return this.psPanelLogicLinkCond.getGROUPOP();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53d6\u53cd")
    public boolean isNotMode() {
        return this.psPanelLogicLinkCond.getGROUPNOTFLAG();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6761\u4ef6\u96c6\u5408", hideempty=true, child=true)
    public Iterator<IPSPanelLogicLinkCond> getPSPanelLogicLinkConds() {
        if (this.psPanelLogicLinkCondList == null || this.psPanelLogicLinkCondList.size() == 0) {
            return null;
        }
        return this.psPanelLogicLinkCondList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSDELLCOND_GROUP";
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
}

