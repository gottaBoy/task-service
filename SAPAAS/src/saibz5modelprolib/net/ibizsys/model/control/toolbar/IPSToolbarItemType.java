/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.toolbar.IPSDEToolbarItem
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.model.entity.PSToolbarItemType;

public interface IPSToolbarItemType
extends IPSModelObject {
    public void init(IPSModelStorageContext var1, PSToolbarItemType var2) throws Exception;

    public IPSDEToolbarItem createPSDEToolbarItem(PSDEToolbarItem var1) throws Exception;
}

