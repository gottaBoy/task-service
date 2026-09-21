/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.ISRFDAExtTransaction;
import SA.SRFDA.Ctrl.ISRFDATransactionManager;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Connection;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultTransactionManager
implements ISRFDATransactionManager {
    protected ISRFDAGlobalHelper iGlobalHelper = null;
    protected Vector<IDEDataCtrl> deDataCtrlList = new Vector();
    protected TreeMap<String, Connection> connectionMap = new TreeMap();
    private static final Log log = LogFactory.getLog(DefaultTransactionManager.class);
    protected boolean bEnableTransaction = false;
    protected String strTransactionId = "";
    private Vector<ISRFDAExtTransaction> transactionList = new Vector();
    private HashMap<String, Object> paramMap = new HashMap();

    @Override
    public void Init(ISRFDAGlobalHelper iGlobalHelper) {
        this.iGlobalHelper = iGlobalHelper;
        this.bEnableTransaction = this.iGlobalHelper.getWebExConfig().GetValue("SRFDA", "TRANSACTION", false);
        this.strTransactionId = Helper.GenGuidEx();
    }

    @Override
    public String getTransactionId() {
        return this.strTransactionId;
    }

    @Override
    public Connection GetConnection(String strDBStorage) {
        if (!this.bEnableTransaction) {
            return null;
        }
        if (this.connectionMap.containsKey(strDBStorage = strDBStorage.toUpperCase())) {
            return this.connectionMap.get(strDBStorage);
        }
        try {
            Connection connection = this.iGlobalHelper.getDBCallerEx(strDBStorage).ConnectionCaller().CreateConnection();
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
                int nTI = connection.getTransactionIsolation();
                if (nTI != 2) {
                    connection.setTransactionIsolation(2);
                }
            }
            this.connectionMap.put(strDBStorage, connection);
            return connection;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25", (Object)ex));
            return null;
        }
    }

    @Override
    public void Register(IDEDataCtrl iDEDataCtrl) {
        if (!this.bEnableTransaction) {
            return;
        }
        this.deDataCtrlList.add(iDEDataCtrl);
        iDEDataCtrl.setTransactionManager(this);
    }

    @Override
    public void Commit() {
        if (!this.bEnableTransaction) {
            return;
        }
        for (String strDBStorage : this.connectionMap.keySet()) {
            Connection conn = this.connectionMap.get(strDBStorage);
            try {
                try {
                    conn.commit();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    this.iGlobalHelper.getDBCallerEx(strDBStorage).ConnectionCaller().ReleaseConnection(conn);
                    continue;
                }
            }
            catch (Throwable throwable) {
                this.iGlobalHelper.getDBCallerEx(strDBStorage).ConnectionCaller().ReleaseConnection(conn);
                throw throwable;
            }
            this.iGlobalHelper.getDBCallerEx(strDBStorage).ConnectionCaller().ReleaseConnection(conn);
        }
        this.connectionMap.clear();
        for (IDEDataCtrl iDEDataCtrl : this.deDataCtrlList) {
            iDEDataCtrl.setTransactionManager(null);
        }
        this.deDataCtrlList.clear();
        for (ISRFDAExtTransaction iSRFDATransaction : this.transactionList) {
            iSRFDATransaction.getDEDataCtrl().CommitExtTransaction(iSRFDATransaction);
        }
        this.transactionList.clear();
    }

    @Override
    public void CommitAndBegin() {
        if (!this.bEnableTransaction) {
            return;
        }
        for (String strDBStorage : this.connectionMap.keySet()) {
            Connection conn = this.connectionMap.get(strDBStorage);
            try {
                conn.commit();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        for (ISRFDAExtTransaction iSRFDATransaction : this.transactionList) {
            iSRFDATransaction.getDEDataCtrl().CommitExtTransaction(iSRFDATransaction);
        }
        this.transactionList.clear();
    }

    @Override
    public void Rollback() {
        if (!this.bEnableTransaction) {
            return;
        }
        for (String strDBStorage : this.connectionMap.keySet()) {
            Connection conn = this.connectionMap.get(strDBStorage);
            try {
                try {
                    conn.rollback();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    this.iGlobalHelper.getDBCallerEx(strDBStorage).ConnectionCaller().ReleaseConnection(conn);
                    continue;
                }
            }
            catch (Throwable throwable) {
                this.iGlobalHelper.getDBCallerEx(strDBStorage).ConnectionCaller().ReleaseConnection(conn);
                throw throwable;
            }
            this.iGlobalHelper.getDBCallerEx(strDBStorage).ConnectionCaller().ReleaseConnection(conn);
        }
        this.connectionMap.clear();
        for (IDEDataCtrl iDEDataCtrl : this.deDataCtrlList) {
            iDEDataCtrl.setTransactionManager(null);
        }
        this.deDataCtrlList.clear();
        int i = this.transactionList.size() - 1;
        while (i >= 0) {
            ISRFDAExtTransaction iSRFDATransaction = this.transactionList.get(i);
            iSRFDATransaction.getDEDataCtrl().RollbackExtTransaction(iSRFDATransaction);
            --i;
        }
        this.transactionList.clear();
    }

    @Override
    public void RollbackAndBegin() {
        if (!this.bEnableTransaction) {
            return;
        }
        for (String strDBStorage : this.connectionMap.keySet()) {
            Connection conn = this.connectionMap.get(strDBStorage);
            try {
                conn.rollback();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int i = this.transactionList.size() - 1;
        while (i >= 0) {
            ISRFDAExtTransaction iSRFDATransaction = this.transactionList.get(i);
            iSRFDATransaction.getDEDataCtrl().RollbackExtTransaction(iSRFDATransaction);
            --i;
        }
        this.transactionList.clear();
    }

    @Override
    public void AddExtTransaction(ISRFDAExtTransaction iSRFDAExtTransaction) {
        this.transactionList.add(iSRFDAExtTransaction);
    }

    @Override
    public void setParam(String strKey, Object objParam) {
        strKey = strKey.toUpperCase();
        if (objParam == null) {
            this.paramMap.remove(strKey);
        }
        this.paramMap.put(strKey, objParam);
    }

    @Override
    public Object getParam(String strKey) {
        return this.paramMap.get(strKey.toUpperCase());
    }
}

