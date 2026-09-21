/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.drctrl.IPSDEDRBar
 *  net.ibizsys.model.control.drctrl.IPSDEDRBarGroup
 *  net.ibizsys.model.dataentity.dr.IPSDEDRGroup
 */
package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.drctrl.IPSDEDRBar;
import net.ibizsys.model.control.drctrl.IPSDEDRBarGroup;
import net.ibizsys.model.dataentity.dr.IPSDEDRGroup;

public interface IPSDEDRBarGroupRuntime
extends IPSDEDRBarGroup {
    public void init(IPSModelStorageContext var1, IPSDEDRBar var2, IPSDEDRGroup var3) throws Exception;
}

