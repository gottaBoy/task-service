/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.ISRFDATransactionManager
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.ISRFDATransactionManager;
import java.sql.Connection;

public interface ITMActionContext {
    public IDEDataCtrl getDEDataCtrl(String var1) throws Exception;

    public Object getUserTag(String var1);

    public void setUserTag(String var1, Object var2);

    public ISRFDATransactionManager getTransactionManager();

    public Connection getDBConnection(String var1);
}

