/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ValueError
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import java.util.Vector;

public interface IDEDataCtrlEngine {
    public boolean Init(IDEDataCtrl var1, ISRFDAGlobalHelper var2);

    public CallResult TestSave(DEDataCtrl var1, BaseDataEntity var2, boolean var3, String var4, Vector<ValueError> var5);

    public CallResult BeforeSave(DEDataCtrl var1, BaseDataEntity var2, BaseDataEntity var3, boolean var4, String var5);

    public CallResult AfterSave(DEDataCtrl var1, BaseDataEntity var2, BaseDataEntity var3, boolean var4, String var5);

    public CallResult CustomCall(DEDataCtrl var1, BaseDataEntity var2, String var3);

    public CallResult GetDefault(DEDataCtrl var1, BaseDataEntity var2, String var3);

    public CallResult BeforeRemove(DEDataCtrl var1, BaseDataEntity var2, String var3);

    public CallResult AfterRemove(DEDataCtrl var1, BaseDataEntity var2, String var3);
}

