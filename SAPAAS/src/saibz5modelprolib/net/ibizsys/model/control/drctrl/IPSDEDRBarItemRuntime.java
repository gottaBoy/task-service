/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.drctrl.IPSDEDRBar
 *  net.ibizsys.model.control.drctrl.IPSDEDRBarGroup
 *  net.ibizsys.model.control.drctrl.IPSDEDRBarItem
 *  net.ibizsys.model.dataentity.dr.IPSDEDRDetail
 */
package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.drctrl.IPSDEDRBar;
import net.ibizsys.model.control.drctrl.IPSDEDRBarGroup;
import net.ibizsys.model.control.drctrl.IPSDEDRBarItem;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;

public interface IPSDEDRBarItemRuntime
extends IPSDEDRBarItem {
    public void init(IPSModelStorageContext var1, IPSDEDRBar var2, IPSDEDRBarGroup var3, IPSDEDRDetail var4) throws Exception;
}

