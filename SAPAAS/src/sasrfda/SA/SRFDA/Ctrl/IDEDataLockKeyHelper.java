/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;

public interface IDEDataLockKeyHelper {
    public String GetDataLockKey(ISRFDAWebContext var1, IDEHelper var2, BaseDataEntity var3) throws Exception;
}

