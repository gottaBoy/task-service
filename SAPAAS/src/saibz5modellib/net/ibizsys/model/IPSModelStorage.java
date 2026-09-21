/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model;

import net.ibizsys.model.IPSDepSlnSys;
import net.ibizsys.model.IPSSystem;

public interface IPSModelStorage {
    public IPSDepSlnSys getPSDepSlnSys(String var1) throws Exception;

    public boolean isLoaded();

    public IPSSystem getPSSystem() throws Exception;

    public IPSSystem getPSSystem(boolean var1) throws Exception;
}

