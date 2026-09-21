/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSFDLogicType;
import SA.SRFDA.PS.Core.Control.Form.PSDEFDLogicImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import java.util.ArrayList;
import java.util.Iterator;

public class PSDEFDGroupLogicImpl
extends PSDEFDLogicImpl
implements IPSDEFDGroupLogic {
    protected ArrayList<IPSDEFDLogic> psDEFDLogicList = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEFDLogics();
    }

    protected void onPreparePSDEFDLogics() throws Exception {
        ArrayList<PSDEFDLogic> psDEFDLogicList = this.psDEFDLogic.getChildPSDEFDLogics(false);
        if (psDEFDLogicList == null) {
            return;
        }
        for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
            IPSFDLogicType iPSFDLogicType = this.getPSModelStorage().getPSFDLogicType(psDEFDLogic.getLOGICTYPE());
            IPSDEFDLogic iPSDEFDLogic = iPSFDLogicType.createPSDEFDLogic(psDEFDLogic);
            iPSDEFDLogic.init(this.getDAGlobalHelper(), this.iPSDEFormDetail, this, psDEFDLogic);
            if (iPSDEFDLogic instanceof IPSDEFDGroupLogic && ((IPSDEFDGroupLogic)iPSDEFDLogic).getPSDEFDLogics() == null) continue;
            if (this.psDEFDLogicList == null) {
                this.psDEFDLogicList = new ArrayList();
            }
            this.psDEFDLogicList.add(iPSDEFDLogic);
        }
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u903b\u8f91", fields={"GROUPOP"})
    public String getGroupOP() {
        return this.psDEFDLogic.getGROUPOP();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53d6\u53cd", fields={"GROUPNOTFLAG"})
    public boolean isNotMode() {
        return this.psDEFDLogic.getGROUPNOTFLAG();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u9879\u96c6\u5408", child=true)
    public Iterator<IPSDEFDLogic> getPSDEFDLogics() {
        if (this.psDEFDLogicList == null || this.psDEFDLogicList.size() == 0) {
            return null;
        }
        return this.psDEFDLogicList.iterator();
    }
}

