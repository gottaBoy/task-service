/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.config.entity;

import java.util.ArrayList;
import net.ibizsys.pscore.srv.config.entity.PSVTCtrl;
import net.ibizsys.pscore.srv.config.entity.PSVTRV;
import net.ibizsys.pscore.srv.config.entity.PSViewType;

public class PSViewTypeStruct
extends PSViewType {
    private ArrayList<PSVTCtrl> psVTCtrlList = new ArrayList();
    private ArrayList<PSVTRV> psVTRVList = new ArrayList();

    @Override
    public ArrayList<PSVTCtrl> getPSVTCtrls() {
        return this.psVTCtrlList;
    }

    @Override
    public ArrayList<PSVTRV> getPSVTRVs() {
        return this.psVTRVList;
    }
}

