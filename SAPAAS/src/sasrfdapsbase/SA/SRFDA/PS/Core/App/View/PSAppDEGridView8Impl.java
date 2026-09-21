/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEGridView8;
import SA.SRFDA.PS.Core.App.View.PSAppDEGridViewImpl;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.HashMap;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEGRIDVIEW8"})
public class PSAppDEGridView8Impl
extends PSAppDEGridViewImpl
implements IPSAppDEGridView8 {
    private IPSDEGrid totalPSDEGrid = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("totalgrid");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDEGrid) {
            this.totalPSDEGrid = (IPSDEGrid)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    public IPSDEGrid getTotalPSDEGrid() {
        return this.totalPSDEGrid;
    }
}

