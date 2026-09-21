/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Native
 */
package SA.SRFDA.PS.Core.Util.JNA;

import SA.SRFDA.PS.Core.Util.JNA.W32API;
import com.sun.jna.Native;
import java.util.Map;

public interface Kernel32
extends W32API {
    public static final Kernel32 INSTANCE = (Kernel32)Native.loadLibrary((String)"kernel32", Kernel32.class, (Map)DEFAULT_OPTIONS);

    public W32API.HANDLE GetCurrentProcess();

    public int GetProcessId(W32API.HANDLE var1);
}

