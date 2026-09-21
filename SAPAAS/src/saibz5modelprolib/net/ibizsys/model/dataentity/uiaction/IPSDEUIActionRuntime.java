/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIAction
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.entity.PSDEUIAction;
import net.ibizsys.model.view.IPSUIActionRuntime;

public interface IPSDEUIActionRuntime
extends IPSDEUIAction,
IPSUIActionRuntime {
    public void init(IPSModelStorageContext var1, IPSSystem var2, IPSDataEntity var3, PSDEUIAction var4) throws Exception;
}

