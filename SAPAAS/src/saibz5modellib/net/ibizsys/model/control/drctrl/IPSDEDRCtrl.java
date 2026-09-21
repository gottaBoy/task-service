/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.drctrl;

import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrlItem;
import net.ibizsys.model.control.drctrl.IPSDRCtrl;
import net.ibizsys.model.dataentity.dr.IPSDEDataRelation;

public interface IPSDEDRCtrl
extends IPSDRCtrl {
    public Iterator<IPSDEDRCtrlItem> getPSDEDRCtrlItems();

    public int getPSDEDRCtrlItemCount();

    public IPSAppView getFormPSAppView();

    public IPSDEDataRelation getPSDEDataRelation();

    public boolean isHideEditItem();
}

