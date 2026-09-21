/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.ISRFDATransactionManager;
import SA.SRFDA.Web.ISRFDAWebContext;
import java.sql.Connection;

public interface IDAActionContext {
    public IDEDataCtrl getDEDataCtrl(String var1) throws Exception;

    public Object getUserTag(String var1);

    public void setUserTag(String var1, Object var2);

    public ISRFDATransactionManager getTransactionManager();

    public Connection getDBConnection(String var1);

    public ISRFDAWebContext getWebContext();
}

