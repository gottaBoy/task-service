/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ValueError
 *  SA.SRFramework.WebEx.SRFExPage
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import SA.SRFramework.WebEx.SRFExPage;
import java.util.Vector;

public interface IDEDataCtrlEngineContext {
    public String GetPersonId();

    public ISRFDAGlobalHelper GetGlobalHelper();

    public ISRFDAWebContext GetWebContext();

    public SRFExPage GetPage();

    public Vector<ValueError> GetValueErrors();

    public void setNext(String var1);

    public void Log(int var1, Object var2, String var3);

    public void DebugOutput(Object var1, String var2);

    public BaseDataEntity GetEnv();

    public BaseDataEntity GetDataEntity(String var1);

    public void SetDataEntity(String var1, BaseDataEntity var2);

    public BaseDataEntity Get(String var1);

    public void Set(String var1, BaseDataEntity var2);

    public IDEHelper GetDEHelper();

    public IDEDataCtrl GetDataCtrl();

    public IDEDataCtrl GetDataCtrl(String var1, boolean var2);

    public CallResult InternalCall(DEDataCtrl var1, BaseDataEntity var2, String var3);

    public CallResult InternalCall(DEDataCtrl var1, Vector<BaseDataEntity> var2, String var3);

    public boolean isDebugOutput();
}

