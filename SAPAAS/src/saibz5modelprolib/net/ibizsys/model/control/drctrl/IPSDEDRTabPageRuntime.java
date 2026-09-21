/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.drctrl.IPSDEDRTab
 *  net.ibizsys.model.control.drctrl.IPSDEDRTabPage
 *  net.ibizsys.model.dataentity.dr.IPSDEDRDetail
 */
package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.drctrl.IPSDEDRTab;
import net.ibizsys.model.control.drctrl.IPSDEDRTabPage;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;

public interface IPSDEDRTabPageRuntime
extends IPSDEDRTabPage {
    public void init(IPSModelStorageContext var1, IPSDEDRTab var2, IPSDEDRDetail var3) throws Exception;
}

