/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.der.IPSDERBase
 */
package net.ibizsys.model.der;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.der.IPSDERType;
import net.ibizsys.model.entity.PSDER;
import net.ibizsys.model.entity.PSDERType;

public interface IPSDERTypeRuntime
extends IPSDERType {
    public void init(IPSModelStorageContext var1, PSDERType var2) throws Exception;

    public IPSDERBase createPSDER(PSDER var1) throws Exception;
}

