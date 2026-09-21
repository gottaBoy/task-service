/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.logic.IPSDELogicLink;

public interface IPSDELogicLinkCond
extends IPSModelObject {
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";

    public IPSDELogicLink getPSDELogicLink();

    public String getLogicType();
}

