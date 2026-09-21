/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.CodeEngine;

import SA.SRFDA.Ctrl.Data.DevCodeEngine;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.io.Writer;

public interface IDACodeEngine {
    public void Init(ISRFDAGlobalHelper var1, DevCodeEngine var2, Writer var3);

    public CallResult GenCode(Writer var1, BaseDataEntity var2);

    public String GetParam(String var1, String var2);

    public DevCodeEngine getDevCodeEngine();
}

