/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.logic;

import java.util.Iterator;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond;

public interface IPSDELogicLinkGroupCond
extends IPSDELogicLinkCond {
    public String getGroupOP();

    public boolean isNotMode();

    public Iterator<IPSDELogicLinkCond> getPSDELogicLinkConds();
}

