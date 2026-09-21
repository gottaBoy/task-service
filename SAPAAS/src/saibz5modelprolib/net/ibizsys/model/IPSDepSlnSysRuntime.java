/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSDepSlnSys
 *  net.ibizsys.model.IPSSystem
 */
package net.ibizsys.model;

import net.ibizsys.model.IPSDepSlnSys;
import net.ibizsys.model.IPSSystem;

public interface IPSDepSlnSysRuntime
extends IPSDepSlnSys {
    public IPSSystem reloadPSSystem(int var1) throws Exception;

    public IPSSystem reloadPSSystem(int var1, int var2) throws Exception;

    public void uploadPSSystem() throws Exception;
}

