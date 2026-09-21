/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dynasys;

import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSDynaInst
extends IPSModelObject,
IPSSystem {
    public static final String INSTMODE_DEFAULT = "DEFAULT";
    public static final String INSTMODE_PROXY = "PROXY";

    public String getInstMode();

    public String getDynaTag();
}

