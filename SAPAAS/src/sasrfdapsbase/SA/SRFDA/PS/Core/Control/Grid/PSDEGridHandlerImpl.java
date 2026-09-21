/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Ajax.PSMDAjaxControlHandlerImpl;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridHandler;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import net.ibizsys.paas.util.StringHelper;

public class PSDEGridHandlerImpl
extends PSMDAjaxControlHandlerImpl
implements IPSDEGridHandler {
    @Override
    protected void onInit() throws Exception {
        IPSDEGrid iPSDEGrid;
        IPSControlXDataContainer iPSControlXDataContainer;
        super.onInit();
        if (this.getTempMode() == 1) {
            this.ajaxDEActionNameMap.put("loaddraft", "GETDRAFTTEMPMAJOR");
        } else if (this.getTempMode() == 2) {
            this.ajaxDEActionNameMap.put("loaddraft", "GETDRAFTTEMP");
        } else {
            this.ajaxDEActionNameMap.put("loaddraft", "GETDRAFT");
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getGETDRAFTPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("loaddraft", this.psAjaxControlHandler.getGETDRAFTPSDEACTIONNAME());
        }
        this.ajaxDataAccessActionMap.put("loaddraft", "CREATE");
        if (this.getPSAjaxControl().getRecvAjaxActionMode() == 1 && this.getPSAppView() instanceof IPSControlXDataContainer && !(iPSControlXDataContainer = (IPSControlXDataContainer)((Object)this.getPSAppView())).isEnableNewData()) {
            this.ajaxDataAccessActionMap.put("loaddraft", "DENY");
        }
        if ((iPSDEGrid = this.getPSDEGrid()) != null) {
            iPSDEGrid.isEnableRowEdit();
        }
    }

    public IPSDEGrid getPSDEGrid() {
        if (this.getPSAjaxControl() instanceof IPSDEGrid) {
            return (IPSDEGrid)this.getPSAjaxControl();
        }
        return null;
    }
}

