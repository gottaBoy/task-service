/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  SA.SRFramework.WebEx.Utility.SRFExPOLogger
 *  SA.SRFramework.WebEx.Utility.SRFExPOLogger$PageAction
 *  SA.SRFramework.WebEx.Utility.SRFExPOLogger$WFAction
 */
package SA.SRFDA.Web.Utility;

import SA.SRFDA.Ctrl.Data.PODBAction;
import SA.SRFDA.Ctrl.Data.PODBQuery;
import SA.SRFDA.Ctrl.Data.PODEDC;
import SA.SRFDA.Ctrl.Data.POPage;
import SA.SRFDA.Ctrl.Data.POWorkflow;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.Utility.ISRFDAPOLogger;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SA.SRFramework.WebEx.Utility.SRFExPOLogger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

public class SRFDAPOLogger
extends SRFExPOLogger
implements ISRFDAPOLogger {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected IDEDataCtrl poPageDataCtrl = null;
    protected IDEDataCtrl poDBQueryDataCtrl = null;
    protected IDEDataCtrl poDBActionDataCtrl = null;
    protected IDEDataCtrl poDCActionDataCtrl = null;
    protected IDEDataCtrl poWFActionDataCtrl = null;
    protected Vector<DBQuery> unlogDBQueryList = new Vector();
    protected Vector<DBAction> unlogDBActionList = new Vector();
    protected Vector<DCAction> unlogDCActionList = new Vector();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void LogDBAction(String strDEId, String strDBAction, String strProcName, boolean bTran, String strTransactionId, int nProcessTime) {
        DBAction dbAction = this.OnCreateDBAction(strDEId, strDBAction, strProcName, bTran, strTransactionId, nProcessTime);
        if (dbAction != null) {
            Vector<DBAction> vector = this.unlogDBActionList;
            synchronized (vector) {
                this.unlogDBActionList.add(dbAction);
            }
        }
    }

    protected DBAction OnCreateDBAction(String strDEId, String strDBAction, String strProcName, boolean bTran, String strTransactionId, int nProcessTime) {
        DBAction dbAction = new DBAction();
        dbAction.strDEId = strDEId;
        dbAction.strDBAction = strDBAction;
        dbAction.strProcName = strProcName;
        dbAction.bTran = bTran;
        dbAction.strTransactionId = strTransactionId;
        dbAction.nProcessTime = nProcessTime;
        dbAction.dtProcessDate = new Timestamp(new Date().getTime());
        return dbAction;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void LogDBQuery(String strDEId, String strQueryKey, String strSQL, String strPersonId, int nProcessTime) {
        DBQuery dbQueryAction = this.OnCreateDBQuery(strDEId, strQueryKey, strSQL, strPersonId, nProcessTime);
        if (dbQueryAction != null) {
            Vector<DBQuery> vector = this.unlogDBQueryList;
            synchronized (vector) {
                this.unlogDBQueryList.add(dbQueryAction);
            }
        }
    }

    protected DBQuery OnCreateDBQuery(String strDEId, String strQueryKey, String strSQL, String strPersonId, int nProcessTime) {
        DBQuery dbQueryAction = new DBQuery();
        dbQueryAction.strDEId = strDEId;
        dbQueryAction.strQueryKey = strQueryKey;
        dbQueryAction.strSQL = strSQL;
        dbQueryAction.strPersonId = strPersonId;
        dbQueryAction.nProcessTime = nProcessTime;
        dbQueryAction.dtProcessDate = new Timestamp(new Date().getTime());
        return dbQueryAction;
    }

    protected SRFExPOLogger.PageAction OnCreatePageAction(SRFExPage page, int nProcessTime) {
        SRFExPOLogger.PageAction pageAction = super.OnCreatePageAction(page, nProcessTime);
        if (pageAction != null) {
            pageAction.strAccSeq = page.getWebContext().GetParamValue("SRFACCSEQ");
            pageAction.strDEId = page.getWebContext().GetParamValue("SRFDEID");
        }
        return pageAction;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnPrepareLogDBQuery() {
        Vector<DBQuery> tempList = new Vector<DBQuery>();
        Vector<DBQuery> vector = this.unlogDBQueryList;
        synchronized (vector) {
            for (DBQuery pageAction : this.unlogDBQueryList) {
                tempList.add(pageAction);
            }
            this.unlogDBQueryList.clear();
        }
        this.OnLogDBQuerys(tempList);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnPrepareLogDBAction() {
        Vector<DBAction> tempList = new Vector<DBAction>();
        Vector<DBAction> vector = this.unlogDBActionList;
        synchronized (vector) {
            for (DBAction dbAction : this.unlogDBActionList) {
                tempList.add(dbAction);
            }
            this.unlogDBActionList.clear();
        }
        this.OnLogDBActions(tempList);
    }

    protected void OnLogDBQuerys(Vector<DBQuery> tempList) {
        if (this.poDBQueryDataCtrl == null) {
            return;
        }
        for (DBQuery dbQuery : tempList) {
            PODBQuery poDBQuery = new PODBQuery();
            poDBQuery.setDEID(dbQuery.strDEId);
            poDBQuery.setQUERYKEY(dbQuery.strQueryKey);
            poDBQuery.setQUERYSQL(dbQuery.strSQL);
            poDBQuery.setPERSONID(dbQuery.strPersonId);
            poDBQuery.SetParamValue("PROCESSDATE", dbQuery.dtProcessDate);
            poDBQuery.setPROCESSTIME(dbQuery.nProcessTime);
            poDBQuery.SetParamValue("SRF_CHECKKEY", 0);
            poDBQuery.SetParamValue("SRF_RETDATA", 0);
            CallResult callResult = this.poDBQueryDataCtrl.Save(true, poDBQuery);
            callResult.IsError();
        }
    }

    protected void OnLogDBActions(Vector<DBAction> tempList) {
        if (this.poDBActionDataCtrl == null) {
            return;
        }
        for (DBAction dbAction : tempList) {
            PODBAction poDBAction = new PODBAction();
            poDBAction.setDEID(dbAction.strDEId);
            poDBAction.setDBACTION(dbAction.strDBAction);
            poDBAction.setPROCNAME(dbAction.strProcName);
            poDBAction.setTRANSACTIONID(dbAction.strTransactionId);
            poDBAction.setISTRAN(dbAction.bTran);
            poDBAction.SetParamValue("PROCESSDATE", dbAction.dtProcessDate);
            poDBAction.setPROCESSTIME(dbAction.nProcessTime);
            poDBAction.SetParamValue("SRF_CHECKKEY", 0);
            poDBAction.SetParamValue("SRF_RETDATA", 0);
            CallResult callResult = this.poDBActionDataCtrl.Save(true, poDBAction);
            callResult.IsError();
        }
    }

    protected void OnLogPageActions(Vector<SRFExPOLogger.PageAction> tempList) {
        if (this.poPageDataCtrl == null) {
            return;
        }
        for (SRFExPOLogger.PageAction pageAction : tempList) {
            POPage poPage = new POPage();
            poPage.setACCSEQ(pageAction.strAccSeq);
            poPage.setBACKENDACTION(pageAction.strBackendAction);
            poPage.setHOSTID("");
            poPage.setISBACKEND(pageAction.bIsBackendMode);
            poPage.setPAGEURL(pageAction.strPageUrl);
            poPage.SetParamValue("PROCESSDATE", pageAction.dtProcessDate);
            poPage.setSESSIONID(pageAction.strSessionId);
            poPage.setQUERYPARAM(pageAction.strQueryParam);
            poPage.setPROCESSTIME(pageAction.nProcessTime);
            poPage.setDEID(pageAction.strDEId);
            poPage.SetParamValue("SRF_CHECKKEY", 0);
            poPage.SetParamValue("SRF_RETDATA", 0);
            CallResult callResult = this.poPageDataCtrl.Save(true, poPage);
            callResult.IsError();
        }
    }

    public void setGlobalHelper(ISRFExGlobalHelper iGlobalHelper) {
        super.setGlobalHelper(iGlobalHelper);
        if (this.iGlobalHelper != null && this.iGlobalHelper instanceof ISRFDAGlobalHelper) {
            this.iDAGlobalHelper = (ISRFDAGlobalHelper)this.iGlobalHelper;
        }
        if (this.iDAGlobalHelper != null) {
            this.poPageDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0180", "SYSTEM", null);
            this.poDBQueryDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0182", "SYSTEM", null);
            this.poDBActionDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0181", "SYSTEM", null);
            this.poDCActionDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0183", "SYSTEM", null);
            this.poWFActionDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0184", "SYSTEM", null);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void LogDCAction(String strDEId, String strAction, String strActionDetail, boolean bTran, String strTransactionId, int nProcessTime) {
        DCAction dcAction = this.OnCreateDCAction(strDEId, strAction, strActionDetail, bTran, strTransactionId, nProcessTime);
        if (dcAction != null) {
            Vector<DCAction> vector = this.unlogDCActionList;
            synchronized (vector) {
                this.unlogDCActionList.add(dcAction);
            }
        }
    }

    protected DCAction OnCreateDCAction(String strDEId, String strAction, String strActionDetail, boolean bTran, String strTransactionId, int nProcessTime) {
        DCAction dcAction = new DCAction();
        dcAction.strDEId = strDEId;
        dcAction.strAction = strAction;
        dcAction.strActionDetail = strActionDetail;
        dcAction.bTran = bTran;
        dcAction.strTransactionId = strTransactionId;
        dcAction.nProcessTime = nProcessTime;
        dcAction.dtProcessDate = new Timestamp(new Date().getTime());
        return dcAction;
    }

    protected void OnLogDCActions(Vector<DCAction> tempList) {
        if (this.poDCActionDataCtrl == null) {
            return;
        }
        for (DCAction dcAction : tempList) {
            PODEDC poDEDC = new PODEDC();
            poDEDC.setDEID(dcAction.strDEId);
            poDEDC.setDCACTION(dcAction.strAction);
            poDEDC.setDCACTIONDETAIL(dcAction.strActionDetail);
            poDEDC.setTRANSACTIONID(dcAction.strTransactionId);
            poDEDC.setISTRAN(dcAction.bTran);
            poDEDC.SetParamValue("PROCESSDATE", dcAction.dtProcessDate);
            poDEDC.setPROCESSTIME(dcAction.nProcessTime);
            poDEDC.SetParamValue("SRF_CHECKKEY", 0);
            poDEDC.SetParamValue("SRF_RETDATA", 0);
            CallResult callResult = this.poDCActionDataCtrl.Save(true, poDEDC);
            callResult.IsError();
        }
    }

    protected void OnLogWFActions(Vector<SRFExPOLogger.WFAction> tempList) {
        if (this.poWFActionDataCtrl == null) {
            return;
        }
        for (SRFExPOLogger.WFAction wfAction : tempList) {
            POWorkflow poWorkflow = new POWorkflow();
            poWorkflow.setWFID(wfAction.strWFId);
            poWorkflow.setWFACTION(wfAction.strWFAction);
            poWorkflow.setWFACTIONDETAIL(wfAction.strWFActionDetail);
            poWorkflow.SetParamValue("PROCESSDATE", wfAction.dtProcessDate);
            poWorkflow.setPROCESSTIME(wfAction.nProcessTime);
            poWorkflow.SetParamValue("SRF_CHECKKEY", 0);
            poWorkflow.SetParamValue("SRF_RETDATA", 0);
            CallResult callResult = this.poWFActionDataCtrl.Save(true, poWorkflow);
            callResult.IsError();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnPrepareLogDCAction() {
        Vector<DCAction> tempList = new Vector<DCAction>();
        Vector<DCAction> vector = this.unlogDCActionList;
        synchronized (vector) {
            for (DCAction dcAction : this.unlogDCActionList) {
                tempList.add(dcAction);
            }
            this.unlogDCActionList.clear();
        }
        this.OnLogDCActions(tempList);
    }

    protected void OnRun() {
        super.OnRun();
        this.OnPrepareLogDBQuery();
        this.OnPrepareLogDBAction();
        this.OnPrepareLogDCAction();
    }

    protected class DBAction {
        public String strDEId = "";
        public String strDBAction = "";
        public String strProcName = "";
        public String strTransactionId = "";
        public boolean bTran;
        public int nProcessTime = 0;
        public Timestamp dtProcessDate;

        protected DBAction() {
        }
    }

    protected class DBQuery {
        public String strDEId = "";
        public String strQueryKey = "";
        public String strSQL = "";
        public String strPersonId = "";
        public int nProcessTime = 0;
        public Timestamp dtProcessDate;

        protected DBQuery() {
        }
    }

    protected class DCAction {
        public String strDEId = "";
        public String strAction = "";
        public String strActionDetail = "";
        public String strTransactionId = "";
        public boolean bTran;
        public int nProcessTime = 0;
        public Timestamp dtProcessDate;

        protected DCAction() {
        }
    }
}

