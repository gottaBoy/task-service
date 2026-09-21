/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IModelBase;

public interface IValueRule
extends IModelBase {
    public static final String RULETYPE_REGEX = "REGEX";
    public static final String RULETYPE_SCRIPT = "SCRIPT";
    public static final String RULETYPE_CUSTOM = "CUSTOM";

    public String getRuleType();

    public String getRuleInfo();
}

