/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.menu.IPSAppMenuItem
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model.control.menu;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSAppMenuItem;
import net.ibizsys.model.entity.PSAppMenuItemType;

public interface IPSAppMenuItemType
extends IPSModelObject {
    public void init(IPSModelStorageContext var1, PSAppMenuItemType var2) throws Exception;

    public IPSAppMenuItem createPSAppMenuItem(PSAppMenuItem var1) throws Exception;
}

