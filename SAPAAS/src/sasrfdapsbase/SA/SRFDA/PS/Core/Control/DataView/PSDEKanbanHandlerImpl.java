/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.DataView;

import SA.SRFDA.PS.Core.Control.DataView.IPSDEKanbanHandler;
import SA.SRFDA.PS.Core.Control.DataView.PSDEDataViewHandlerImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelRTIgnoreMeta
public class PSDEKanbanHandlerImpl
extends PSDEDataViewHandlerImpl
implements IPSDEKanbanHandler {
    @Override
    protected void onInit() throws Exception {
        this.ajaxDEActionNameMap.put("updategroup", "UPDATE");
        this.ajaxDataAccessActionMap.put("updategroup", "UPDATE");
        super.onInit();
    }

    @Override
    protected String getUserActionName() {
        return "updategroup";
    }

    @Override
    protected String getUser2ActionName() {
        return super.getUser2ActionName();
    }
}

