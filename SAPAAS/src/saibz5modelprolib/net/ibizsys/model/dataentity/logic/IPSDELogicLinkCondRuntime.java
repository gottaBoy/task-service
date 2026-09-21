/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLink
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.logic.IPSDELogicLink;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond;
import net.ibizsys.model.entity.PSDELogicLinkCond;

public interface IPSDELogicLinkCondRuntime
extends IPSDELogicLinkCond {
    public void init(IPSModelStorageContext var1, IPSDELogicLink var2, IPSDELogicLinkCond var3, PSDELogicLinkCond var4) throws Exception;
}

