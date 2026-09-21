/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.SubSystem;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDASubSystemHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, SubSystem var2) throws Exception;

    public void InitGlobalSession() throws Exception;

    public void InitUserSession(ISRFDAWebContext var1) throws Exception;
}

