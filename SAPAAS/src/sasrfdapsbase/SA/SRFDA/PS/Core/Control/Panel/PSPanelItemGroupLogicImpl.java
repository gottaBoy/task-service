/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemGroupLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogicType;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelItemLogicImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSPanelItemLogic;
import java.util.ArrayList;
import java.util.Iterator;

public class PSPanelItemGroupLogicImpl
extends PSPanelItemLogicImpl
implements IPSPanelItemGroupLogic {
    protected ArrayList<IPSPanelItemLogic> psPanelItemLogicList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSPanelItemLogics();
    }

    protected void onPreparePSPanelItemLogics() throws Exception {
        ArrayList<PSPanelItemLogic> psPanelItemLogicList = this.psPanelItemLogic.getChildPSPanelItemLogics(false);
        if (psPanelItemLogicList == null) {
            return;
        }
        for (PSPanelItemLogic psPanelItemLogic : psPanelItemLogicList) {
            IPSPanelItemLogicType iPSPanelItemLogicType = this.getPSModelStorage().getPSPanelItemLogicType(psPanelItemLogic.getLOGICTYPE());
            IPSPanelItemLogic iPSPanelItemLogic = iPSPanelItemLogicType.createPSPanelItemLogic(psPanelItemLogic);
            iPSPanelItemLogic.init(this.getDAGlobalHelper(), this.iPSPanelItem, this, psPanelItemLogic);
            this.psPanelItemLogicList.add(iPSPanelItemLogic);
        }
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u903b\u8f91", fields={"GROUPOP"})
    public String getGroupOP() {
        return this.psPanelItemLogic.getGROUPOP();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53d6\u53cd", fields={"GROUPNOTFLAG"})
    public boolean isNotMode() {
        return this.psPanelItemLogic.getGROUPNOTFLAG();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u9879\u96c6\u5408", child=true)
    public Iterator<IPSPanelItemLogic> getPSPanelItemLogics() {
        if (this.psPanelItemLogicList == null || this.psPanelItemLogicList.size() == 0) {
            return null;
        }
        return this.psPanelItemLogicList.iterator();
    }
}

