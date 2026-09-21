/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.dataentity.logic.IPSDELogicNode
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.logic.IPSDELogicNode;
import net.ibizsys.model.entity.PSDELogicNode;

public interface IPSDELogicNodeRuntime
extends IPSDELogicNode {
    public void init(IPSModelStorageContext var1, IPSDELogic var2, PSDELogicNode var3) throws Exception;
}

