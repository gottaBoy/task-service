/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDEVersionHelper {
    public void Init(ISRFDAGlobalHelper var1, DataEntity var2) throws Exception;

    public String getDEId();

    public int GetDataVersion(Object var1);

    public void RunTimer(long var1);

    public int GetDataVersion(Object var1, boolean var2);
}

