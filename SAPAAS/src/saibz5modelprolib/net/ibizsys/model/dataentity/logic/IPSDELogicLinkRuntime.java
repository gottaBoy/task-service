/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLink
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.logic.IPSDELogicLink;
import net.ibizsys.model.entity.PSDELogicLink;

public interface IPSDELogicLinkRuntime
extends IPSDELogicLink {
    public void init(IPSModelStorageContext var1, IPSDELogic var2, PSDELogicLink var3) throws Exception;
}

