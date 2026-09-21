/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Security;

import SA.SRFDA.Ctrl.Data.DEDSCtrl;
import SA.SRFDA.Ctrl.Data.DEDataAction;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.ISRFDATransactionManager;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;

public interface IDataAccHelper {
    public void Init(ISRFDAGlobalHelper var1, IDEHelper var2);

    public CallResult Test(ISRFDAWebContext var1, BaseDataEntity var2, String var3);

    public CallResult GetDataActionMap(String var1, ISRFDAGlobalHelper var2, DEDataAction var3);

    public CallResult Audit(String var1, ISRFDATransactionManager var2, ISRFDAWebContext var3, BaseDataEntity var4, BaseDataEntity var5, String var6);

    public CallResult Audit(String var1, ISRFDATransactionManager var2, String var3, String var4, BaseDataEntity var5, BaseDataEntity var6, String var7);

    public String GetDataActions();

    public DEDSCtrl FindFieldCtrl(BaseDataEntity var1);
}

