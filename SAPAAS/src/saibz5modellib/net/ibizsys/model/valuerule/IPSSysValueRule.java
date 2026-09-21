/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.valuerule;

import net.ibizsys.model.IPSSystemObject;

public interface IPSSysValueRule
extends IPSSystemObject {
    public static final String RULETYPE_SCRIPT = "SCRIPT";
    public static final String RULETYPE_REG = "REG";
    public static final String RULETYPE_REGEX = "REGEX";
    public static final String RULETYPE_CUSTOM = "CUSTOM";

    public String getRuleType();

    public String getRuleInfo();

    public String getRegExCode();

    public String getScriptCode();

    public String getCustomObject();

    public String getCustomParams();
}

