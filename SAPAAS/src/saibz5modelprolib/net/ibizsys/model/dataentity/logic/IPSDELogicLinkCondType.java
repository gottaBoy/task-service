/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond;
import net.ibizsys.model.entity.PSDELogicLinkCond;

public interface IPSDELogicLinkCondType
extends IPSModelObject {
    public IPSDELogicLinkCond createPSDELogicLinkCond(PSDELogicLinkCond var1) throws Exception;
}

