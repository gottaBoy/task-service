/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 */
package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.action.IPSDELogicAction;
import net.ibizsys.model.dataentity.action.PSDEActionImplBase;
import net.ibizsys.model.dataentity.logic.IPSDELogic;

public class PSDELogicActionImpl
extends PSDEActionImplBase
implements IPSDELogicAction {
    protected IPSDELogic iPSDELogic = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.iPSDELogic = this.getPSDataEntity().getPSDELogic(this.psDEAction.getPSDELOGICID());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5904\u7406\u903b\u8f91")
    public IPSDELogic getPSDELogic() throws Exception {
        return this.iPSDELogic;
    }
}

