/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEDataChgDisp;
import SA.SRFDA.Ctrl.IDEDataChangeDispatchParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDEDataChangeDispatch {
    public void Init(ISRFDAGlobalHelper var1, DEDataChgDisp var2) throws Exception;

    public String getName();

    public void Dispatch(IDEDataChangeDispatchParam var1) throws Exception;
}

