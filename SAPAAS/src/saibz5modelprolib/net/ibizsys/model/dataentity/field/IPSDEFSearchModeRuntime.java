/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.IPSDEFSearchMode
 *  net.ibizsys.model.dataentity.field.IPSDEField
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.entity.PSDEFSearchMode;

public interface IPSDEFSearchModeRuntime
extends IPSDEFSearchMode {
    public void init(IPSModelStorageContext var1, IPSDEField var2, PSDEFSearchMode var3) throws Exception;
}

