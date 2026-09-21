/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLink
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.logic.IPSDELogicLink;
import net.ibizsys.model.entity.PSDELogicLink;

public interface IPSDELogicLinkType
extends IPSModelObject {
    public IPSDELogicLink createPSDELogicLink(PSDELogicLink var1) throws Exception;
}

