/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Utility;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SA.SRFramework.WebEx.Utility.ISRFExPOLogger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class SRFExPOLogger
extends TimerTask
implements ISRFExPOLogger {
    protected Vector<PageAction> unlogPageActionList = new Vector();
    protected Vector<WFAction> unlogWFActionList = new Vector();
    protected int nMaxRecordCount = 20;
    private Timer logTimer = null;
    protected ISRFExGlobalHelper iGlobalHelper = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void LogPageAction(SRFExPage page, int nProcessTime) {
        PageAction pageAction = this.OnCreatePageAction(page, nProcessTime);
        if (pageAction != null) {
            Vector<PageAction> vector = this.unlogPageActionList;
            synchronized (vector) {
                this.unlogPageActionList.add(pageAction);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void LogWFAction(String strWFId, String strWFAction, String strWFActionDetail, int nProcessTime) {
        WFAction wfAction = this.OnCreateWFAction(strWFId, strWFAction, strWFActionDetail, nProcessTime);
        if (wfAction != null) {
            Vector<WFAction> vector = this.unlogWFActionList;
            synchronized (vector) {
                this.unlogWFActionList.add(wfAction);
            }
        }
    }

    protected WFAction OnCreateWFAction(String strWFId, String strWFAction, String strWFActionDetail, int nProcessTime) {
        WFAction wfAction = new WFAction();
        wfAction.strWFId = strWFId;
        wfAction.strWFAction = strWFAction;
        wfAction.strWFActionDetail = strWFActionDetail;
        wfAction.nProcessTime = nProcessTime;
        wfAction.dtProcessDate = new Timestamp(new Date().getTime());
        return wfAction;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnPrepareLogPageAction() {
        Vector<PageAction> tempList = new Vector<PageAction>();
        Vector<PageAction> vector = this.unlogPageActionList;
        synchronized (vector) {
            for (PageAction pageAction : this.unlogPageActionList) {
                tempList.add(pageAction);
            }
            this.unlogPageActionList.clear();
        }
        this.OnLogPageActions(tempList);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnPrepareLogWFAction() {
        Vector<WFAction> tempList = new Vector<WFAction>();
        Vector<WFAction> vector = this.unlogWFActionList;
        synchronized (vector) {
            for (WFAction wfAction : this.unlogWFActionList) {
                tempList.add(wfAction);
            }
            this.unlogWFActionList.clear();
        }
        this.OnLogWFActions(tempList);
    }

    protected void OnLogPageActions(Vector<PageAction> tempList) {
    }

    protected void OnLogWFActions(Vector<WFAction> tempList) {
    }

    protected PageAction OnCreatePageAction(SRFExPage page, int nProcessTime) {
        PageAction pageAction = new PageAction();
        pageAction.strAccSeq = "";
        pageAction.bIsBackendMode = page.IsBackEndMode();
        if (pageAction.bIsBackendMode) {
            String strActionType = page.getWebContext().getActionType();
            String strAction = page.getWebContext().getAction();
            pageAction.strBackendAction = StringHelper.Format((String)"%1$s [%2$s]", (Object)strActionType, (Object)strAction);
        }
        pageAction.strHostId = "";
        pageAction.strPageUrl = page.getWebContext().getCurPagePath();
        pageAction.strQueryParam = page.getWebContext().GetQueryString();
        pageAction.nProcessTime = nProcessTime;
        pageAction.strSessionId = page.getWebContext().getSessionId();
        pageAction.dtProcessDate = new Timestamp(new Date().getTime());
        return pageAction;
    }

    @Override
    public void setGlobalHelper(ISRFExGlobalHelper iGlobalHelper) {
        this.iGlobalHelper = iGlobalHelper;
    }

    @Override
    public void Start() {
        this.logTimer = new Timer("POLogTimer");
        this.logTimer.schedule((TimerTask)this, 60000L, 60000L);
    }

    @Override
    public void Stop() {
        this.OnRun();
        if (this.logTimer != null) {
            this.logTimer.cancel();
            this.logTimer = null;
        }
    }

    @Override
    public synchronized void run() {
        this.OnRun();
    }

    protected void OnRun() {
        this.OnPrepareLogWFAction();
        this.OnPrepareLogPageAction();
    }

    protected class PageAction {
        public String strAccSeq = "";
        public String strBackendAction = "";
        public String strHostId = "";
        public String strPageUrl = "";
        public String strQueryParam = "";
        public int nProcessTime = 0;
        public String strSessionId = "";
        public boolean bIsBackendMode = false;
        public Timestamp dtProcessDate;
        public String strDEId = "";

        protected PageAction() {
        }
    }

    protected class WFAction {
        public String strWFId = "";
        public String strWFAction = "";
        public String strWFActionDetail = "";
        public int nProcessTime = 0;
        public Timestamp dtProcessDate;

        protected WFAction() {
        }
    }
}

