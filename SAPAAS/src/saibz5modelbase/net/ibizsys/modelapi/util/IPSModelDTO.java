/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.util;

import java.util.Map;
import net.ibizsys.modelapi.util.IEntity;

public interface IPSModelDTO
extends IEntity {
    public Map<String, Object> any();

    public Object get(String var1);

    public String getSrfkey();

    public void setSrfkey(String var1);
}

