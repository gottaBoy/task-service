/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.ISRFDAExtTransaction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.sql.Connection;

public interface ISRFDATransactionManager {
    public String getTransactionId();

    public void Init(ISRFDAGlobalHelper var1);

    public void Register(IDEDataCtrl var1);

    public Connection GetConnection(String var1);

    public void Commit();

    public void CommitAndBegin();

    public void RollbackAndBegin();

    public void Rollback();

    public void AddExtTransaction(ISRFDAExtTransaction var1);

    public void setParam(String var1, Object var2);

    public Object getParam(String var1);
}

