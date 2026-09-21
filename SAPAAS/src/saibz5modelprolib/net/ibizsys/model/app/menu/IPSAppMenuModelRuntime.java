/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.menu.IPSAppMenuModel
 */
package net.ibizsys.model.app.menu;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.menu.IPSAppMenuModel;
import net.ibizsys.model.entity.PSAppMenu;

public interface IPSAppMenuModelRuntime
extends IPSAppMenuModel {
    public void init(IPSModelStorageContext var1, IPSApplication var2, PSAppMenu var3) throws Exception;
}

