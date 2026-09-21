/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.dr.IPSDEDRItem
 */
package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.entity.PSDEDRItem;

public interface IPSDRItemType
extends IPSModelObject {
    public IPSDEDRItem createPSDEDRItem(PSDEDRItem var1) throws Exception;
}

