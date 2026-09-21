/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.dataentity.field.IPSSysDEFType;
import net.ibizsys.model.entity.PSSysDEFType;

public interface IPSSysDEFTypeRuntime
extends IPSSysDEFType {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSSysDEFType var3) throws Exception;
}

