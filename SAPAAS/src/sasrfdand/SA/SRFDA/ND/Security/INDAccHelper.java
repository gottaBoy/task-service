/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.ND.Security;

import SA.SRFDA.ND.Ctrl.INDActionContext;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDFSObject;

public interface INDAccHelper {
    public static final Integer ACTION_CREATE = 1;
    public static final Integer ACTION_READ = 2;
    public static final Integer ACTION_WRITE = 4;
    public static final Integer ACTION_REMOVE = 8;
    public static final Integer ACTION_CREATESHARE = 16;
    public static final Integer ACTION_FILEHIS = 32;

    public boolean Test(INDActionContext var1, NDDisk var2, NDFSObject var3, int var4) throws Exception;
}

