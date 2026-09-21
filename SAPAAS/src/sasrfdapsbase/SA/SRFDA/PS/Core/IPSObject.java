/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import java.util.Enumeration;

public interface IPSObject {
    public String getId();

    public String getName();

    public int getVersion();

    public String getPSSysModelInstId();

    public String getMemo();

    public Object getPSObjectParam(String var1, Object var2);

    public Object getUserParam(String var1);

    public boolean containsUserParam(String var1);

    public String getUserParam(String var1, String var2);

    public boolean getUserParam(String var1, boolean var2);

    public int getUserParam(String var1, int var2);

    public Enumeration<Object> getUserParamNames();
}

