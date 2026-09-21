/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEGridView8
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.grid.IPSDEGrid
 */
package net.ibizsys.model.app.view;

import java.util.HashMap;
import net.ibizsys.model.app.view.IPSAppDEGridView8;
import net.ibizsys.model.app.view.PSAppDEGridViewImpl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.entity.PSDEViewCtrl;

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

