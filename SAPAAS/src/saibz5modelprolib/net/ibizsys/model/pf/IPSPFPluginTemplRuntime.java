/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSPFPluginTempl;
import net.ibizsys.model.pf.IPSPFPluginTempl;
import net.ibizsys.model.pf.IPSPFStyle;

public interface IPSPFPluginTemplRuntime
extends IPSPFPluginTempl {
    public void init(IPSModelStorageContext var1, PSPFPluginTempl var2) throws Exception;

    public BaseDataEntity getPSPFPluginTemplData(IPSPFStyle var1) throws Exception;
}

