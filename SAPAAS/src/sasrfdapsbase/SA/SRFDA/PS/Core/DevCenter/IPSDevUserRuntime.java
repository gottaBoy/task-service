/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevUser;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSDevUserRuntime
extends IPSDevUser {
    public void login(String var1, String var2) throws Exception;

    public void active(String var1, String var2, String var3, String var4) throws Exception;

    public void logout(String var1) throws Exception;

    public String getActiveSessionId();

    public String getRemoteAddr();

    public long getLastActiveTime();

    public boolean isActive();
}

