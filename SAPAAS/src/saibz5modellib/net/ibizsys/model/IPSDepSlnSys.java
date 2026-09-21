/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model;

import java.sql.Timestamp;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSDepSlnSys
extends IPSModelObject {
    public String getPSSystemId();

    public IPSSystem getPSSystem() throws Exception;

    public IPSSystem getPSSystem(boolean var1) throws Exception;

    public String getPSSysModelInstId();

    public int getModelInstVer();

    public long getLastActiveTime();

    public void active();

    public Timestamp getExpiredTime();

    public boolean isExpired();
}

