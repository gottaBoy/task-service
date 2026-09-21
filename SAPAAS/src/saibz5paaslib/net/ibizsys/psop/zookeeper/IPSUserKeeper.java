/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psop.zookeeper;

import net.ibizsys.psop.zookeeper.IPSObjectKeeper;

public interface IPSUserKeeper
extends IPSObjectKeeper {
    public void loginUser(String var1, String var2) throws Exception;

    public void logoutUser(String var1, String var2) throws Exception;

    public boolean activeUser(String var1, String var2) throws Exception;
}

