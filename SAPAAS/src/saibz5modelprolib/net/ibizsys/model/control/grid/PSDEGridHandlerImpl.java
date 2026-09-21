/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlXDataContainer
 *  net.ibizsys.model.control.grid.IPSDEGridHandler
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.control.IPSControlXDataContainer;
import net.ibizsys.model.control.PSMDAjaxControlHandlerImpl;
import net.ibizsys.model.control.grid.IPSDEGridHandler;
import net.ibizsys.paas.util.StringHelper;

public class PSDEGridHandlerImpl
extends PSMDAjaxControlHandlerImpl
implements IPSDEGridHandler {
    @Override
    protected void onInit() throws Exception {
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
        if (this.getPSAjaxControl().getRecvAjaxActionMode() == 1 && this.getPSAppView() instanceof IPSControlXDataContainer && !(iPSControlXDataContainer = (IPSControlXDataContainer)this.getPSAppView()).isEnableNewData()) {
            this.ajaxDataAccessActionMap.put("loaddraft", "DENY");
        }
    }
}

