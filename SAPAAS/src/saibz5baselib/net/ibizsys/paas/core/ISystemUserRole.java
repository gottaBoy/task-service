/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.ISystemObject;

public interface ISystemUserRole
extends ISystemObject {
    public static final String ROLETYPE_CUSTOM = "CUSTOM";
    public static final String ROLETYPE_DEDATASET = "DEDATASET";

    public String getRoleTag();

    public String getRoleType();

    public Iterator<String> getUniResTags();
}

