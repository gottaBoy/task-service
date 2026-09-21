/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.logic.IPSDELogicNode
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.logic.IPSDELogicNode;
import net.ibizsys.model.entity.PSDELogicNode;

public interface IPSDELogicNodeType
extends IPSModelObject {
    public IPSDELogicNode createPSDELogicNode(PSDELogicNode var1) throws Exception;
}

