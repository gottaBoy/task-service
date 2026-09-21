/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLinkGroupCond
 */
package net.ibizsys.model.dataentity.logic;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCondRuntime;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCondType;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkGroupCond;
import net.ibizsys.model.dataentity.logic.PSDELogicLinkCondImpl;
import net.ibizsys.model.entity.PSDELogicLinkCond;

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
            IPSDELogicLinkCondType iPSDELogicLinkCondType = this.getPSModelStorageContext().getPSDELogicLinkCondType(psDELogicLinkCond.getLOGICTYPE());
            IPSDELogicLinkCond iPSDELogicLinkCond = iPSDELogicLinkCondType.createPSDELogicLinkCond(psDELogicLinkCond);
            ((IPSDELogicLinkCondRuntime)iPSDELogicLinkCond).init(this.getPSModelStorageContext(), this.getPSDELogicLink(), this, psDELogicLinkCond);
            this.psDELogicLinkCondList.add(iPSDELogicLinkCond);
        }
    }

    @PSModelRTMeta(description="\u7ec4\u5408\u6761\u4ef6", codelist="GroupCond")
    public String getGroupOP() {
        return this.psDELogicLinkCond.getGROUPOP();
    }

    @PSModelRTMeta(description="\u903b\u8f91\u53d6\u53cd")
    public boolean isNotMode() {
        return this.psDELogicLinkCond.getGROUPNOTFLAG();
    }

    @PSModelRTMeta(description="\u5b50\u6761\u4ef6\u96c6\u5408", hideempty=true)
    public Iterator<IPSDELogicLinkCond> getPSDELogicLinkConds() {
        if (this.psDELogicLinkCondList == null || this.psDELogicLinkCondList.size() == 0) {
            return null;
        }
        return this.psDELogicLinkCondList.iterator();
    }
}

