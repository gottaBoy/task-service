/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util;

import java.sql.Timestamp;
import java.util.Iterator;

public interface IPSWorkspace {
    public Iterator<String> getPSModelLimitNames();

    public int getTotalPSModelLimit();

    public int getPSModelLimit(String var1);

    public int getTotalFileCountLimit();

    public int getFileSizeLimit();

    public int getTotalFileSizeLimit();

    public Timestamp getExpiredTime();

    public Iterator<String> getEntities();

    public String getWorkspaceMode();
}

