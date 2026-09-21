/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.drctrl.IPSDEDRCtrl
 *  net.ibizsys.model.control.drctrl.IPSDEDRCtrlItem
 *  net.ibizsys.model.dataentity.dr.IPSDEDRDetail
 */
package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrl;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrlItem;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;

public interface IPSDEDRCtrlItemRuntime
extends IPSDEDRCtrlItem {
    public void init(IPSModelStorageContext var1, IPSDEDRCtrl var2, IPSDEDRDetail var3) throws Exception;
}

