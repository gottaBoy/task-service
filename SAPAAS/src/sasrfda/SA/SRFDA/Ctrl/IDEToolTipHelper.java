/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;

public interface IDEToolTipHelper {
    public void Init(IDEHelper var1, ISRFDAGlobalHelper var2);

    public String GetInfo(BaseDataEntity var1, ISRFDAWebContext var2, String var3);
}

