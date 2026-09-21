/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.IPSDEFUIMode
 *  net.ibizsys.model.dataentity.field.IPSDEField
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.field.IPSDEFUIMode;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.entity.PSDEFUIMode;

public interface IPSDEFUIModeRuntime
extends IPSDEFUIMode {
    public void init(IPSModelStorageContext var1, IPSDEField var2, PSDEFUIMode var3) throws Exception;
}

