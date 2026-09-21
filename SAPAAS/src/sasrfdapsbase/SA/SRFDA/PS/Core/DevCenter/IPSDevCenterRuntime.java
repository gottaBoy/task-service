/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.DevCenter.IPSDevUserRuntime;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSDevCenterRuntime
extends IPSDevCenter {
    public void reload() throws Exception;

    public IPSDevUserRuntime loginUser(String var1, String var2, String var3) throws Exception;

    public IPSDevUserRuntime logoutUser(String var1, String var2, String var3) throws Exception;

    public IPSDevUserRuntime activeUser(String var1, String var2, String var3, String var4, String var5) throws Exception;

    public int getActiveUserCount();

    public String getRootFolder();
}

