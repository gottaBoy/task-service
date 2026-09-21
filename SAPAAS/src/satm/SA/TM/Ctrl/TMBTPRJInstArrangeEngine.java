/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.Data.TMBTPRJInst;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMBTMainTaskInstHelper;
import SA.TM.Ctrl.ITMBTMainTaskInstPlanHelper;
import SA.TM.Ctrl.ITMBTPRJInstArrangeEngine;
import SA.TM.Ctrl.ITMBTPRJInstHelper;
import SA.TM.Ctrl.ITMBTPlanHelper;
import SA.TM.Ctrl.ITMBTTaskInstHelper;
import SA.TM.Ctrl.ITMBTTaskInstPlanHelper;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMBTPRJInstArrangeEngine
implements ITMBTPRJInstArrangeEngine {
    protected int PARAM_MAINTASKSUCCESSLOOPCNT = 2;
    protected int PARAM_MAINTASKFAILEDLOOPCNT = 4;
    protected int PARAM_TASKSUCCESSLOOPCNT = 10;
    protected int PARAM_TASKFAILEDLOOPCNT = 30;
    private static final Log log = LogFactory.getLog(TMBTPRJInstArrangeEngine.class);
    protected ITMActionContext iTMActionContext = null;
    protected ITMBTPRJInstHelper iTMBTPRJInstHelper = null;
    protected boolean bUserStop = false;
    protected boolean bEngineStop = false;

    @Override
    public void Init(ITMActionContext iTMActionContext, ITMBTPRJInstHelper iTMBTPRJInstHelper) throws Exception {
        this.iTMActionContext = iTMActionContext;
        this.iTMBTPRJInstHelper = iTMBTPRJInstHelper;
    }

    @Override
    public void Arrange() throws Exception {
        this.PARAM_MAINTASKSUCCESSLOOPCNT = this.iTMBTPRJInstHelper.getAPMainTaskSuccessLoopCnt(this.PARAM_MAINTASKSUCCESSLOOPCNT);
        if (this.PARAM_MAINTASKSUCCESSLOOPCNT < 1) {
            this.PARAM_MAINTASKSUCCESSLOOPCNT = 1;
        }
        this.PARAM_MAINTASKFAILEDLOOPCNT = this.iTMBTPRJInstHelper.getAPMainTaskFailedLoopCnt(this.PARAM_MAINTASKFAILEDLOOPCNT);
        if (this.PARAM_MAINTASKFAILEDLOOPCNT < 1) {
            this.PARAM_MAINTASKFAILEDLOOPCNT = 1;
        }
        this.PARAM_TASKSUCCESSLOOPCNT = this.iTMBTPRJInstHelper.getAPTaskSuccessLoopCnt(this.PARAM_TASKSUCCESSLOOPCNT);
        if (this.PARAM_TASKSUCCESSLOOPCNT < 1) {
            this.PARAM_TASKSUCCESSLOOPCNT = 1;
        }
        this.PARAM_TASKFAILEDLOOPCNT = this.iTMBTPRJInstHelper.getAPTaskFailedLoopCnt(this.PARAM_TASKFAILEDLOOPCNT);
        if (this.PARAM_TASKFAILEDLOOPCNT < 1) {
            this.PARAM_TASKFAILEDLOOPCNT = 1;
        }
        IDEDataCtrl tmBTPRJInstDataCtrl = this.iTMActionContext.getDEDataCtrl("TM0147");
        try {
            TMBTPRJInst tmBTPRJInst = new TMBTPRJInst();
            tmBTPRJInst.setTMBTPRJINSTID(this.iTMBTPRJInstHelper.getId());
            tmBTPRJInst.setBTSTATE("TESTING");
            tmBTPRJInst.setTESTBEGINTIME(new Timestamp(new Date().getTime()));
            CallResult callResult = tmBTPRJInstDataCtrl.Save(false, (BaseDataEntity)tmBTPRJInst);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u8bd5\u7b97\u9879\u76ee\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.iTMActionContext.getTransactionManager().CommitAndBegin();
            Vector<ITMBTMainTaskInstHelper> tmBTMainTaskInsts = this.iTMBTPRJInstHelper.getBTMainTaskInsts();
            Vector<ITMBTMainTaskInstHelper> unArrangeBTMainTaskInsts = new Vector<ITMBTMainTaskInstHelper>();
            for (ITMBTMainTaskInstHelper iTMBTMainTaskInstHelper : tmBTMainTaskInsts) {
                if (!iTMBTMainTaskInstHelper.isExtracted()) {
                    iTMBTMainTaskInstHelper.ExtractBTTaskInsts(this.iTMActionContext);
                    this.iTMActionContext.getTransactionManager().CommitAndBegin();
                }
                if (iTMBTMainTaskInstHelper.getBTTaskInsts(this.iTMActionContext).size() <= 0) continue;
                unArrangeBTMainTaskInsts.add(iTMBTMainTaskInstHelper);
            }
            ITMBTPlanHelper iTMBTPlanHelper = this.iTMBTPRJInstHelper.getDefaultBTPlan(this.iTMActionContext);
            this.ArrangeBTMainTaskInsts(this.iTMActionContext, iTMBTPlanHelper, unArrangeBTMainTaskInsts);
            this.bEngineStop = true;
            tmBTPRJInst.Reset();
            tmBTPRJInst.setTMBTPRJINSTID(this.iTMBTPRJInstHelper.getId());
            tmBTPRJInst.setTESTENDTIME(new Timestamp(new Date().getTime()));
            if (this.isUserStop()) {
                tmBTPRJInst.setBTSTATE("TESTCANCEL");
            } else {
                tmBTPRJInst.setBTSTATE("TESTFINISH");
            }
            callResult = tmBTPRJInstDataCtrl.Save(false, (BaseDataEntity)tmBTPRJInst);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u8bd5\u7b97\u9879\u76ee\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.iTMActionContext.getTransactionManager().CommitAndBegin();
        }
        catch (Exception ex) {
            log.error((Object)"\u6d4b\u8bd5\u9879\u76ee\u53d1\u751f\u5f02\u5e38", (Throwable)ex);
            TMBTPRJInst tmBTPRJInst = new TMBTPRJInst();
            tmBTPRJInst.setTMBTPRJINSTID(this.iTMBTPRJInstHelper.getId());
            tmBTPRJInst.setTESTENDTIME(new Timestamp(new Date().getTime()));
            tmBTPRJInst.setBTSTATE("TESTEXCEPTION");
            CallResult callResult = tmBTPRJInstDataCtrl.Save(false, (BaseDataEntity)tmBTPRJInst);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u8bd5\u7b97\u9879\u76ee\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.iTMActionContext.getTransactionManager().CommitAndBegin();
        }
    }

    protected boolean ArrangeBTMainTaskInsts(ITMActionContext iTMActionContext, ITMBTPlanHelper iTMBTPlanHelper, Vector<ITMBTMainTaskInstHelper> unArrangeBTMainTaskInsts) throws Exception {
        return this.OnArrangeBTMainTaskInsts(iTMActionContext, iTMBTPlanHelper, unArrangeBTMainTaskInsts);
    }

    protected boolean OnArrangeBTMainTaskInsts(ITMActionContext iTMActionContext, ITMBTPlanHelper iTMBTPlanHelper, Vector<ITMBTMainTaskInstHelper> unArrangeBTMainTaskInsts) throws Exception {
        if (unArrangeBTMainTaskInsts.size() == 0) {
            iTMBTPlanHelper.MarkBTPlanFinish(iTMActionContext);
            return true;
        }
        Vector<ITMBTMainTaskInstHelper> unArrangeBTMainTaskInsts2 = new Vector<ITMBTMainTaskInstHelper>();
        unArrangeBTMainTaskInsts2.addAll(unArrangeBTMainTaskInsts);
        ITMBTMainTaskInstHelper iTMBTMainTaskInstHelper = (ITMBTMainTaskInstHelper)unArrangeBTMainTaskInsts2.remove(0);
        if (iTMBTMainTaskInstHelper.getBTTaskInsts(iTMActionContext).size() == 0) {
            throw new Exception("\u8bd5\u7b97\u4e3b\u4efb\u52a1\u4e0d\u5305\u542b\u4efb\u4f55\u8bd5\u7b97\u4efb\u52a1");
        }
        Vector<ITMBTTaskInstHelper> unArrangeBTTaskInsts2 = new Vector<ITMBTTaskInstHelper>();
        unArrangeBTTaskInsts2.addAll(iTMBTMainTaskInstHelper.getBTTaskInsts(iTMActionContext));
        Timestamp dtBeginTime = iTMBTMainTaskInstHelper.getBeginTime();
        if (!this.ArrangBTTaskInsts(iTMActionContext, iTMBTPlanHelper, iTMBTMainTaskInstHelper, dtBeginTime, unArrangeBTTaskInsts2, true, null)) {
            return false;
        }
        Vector<ITMBTPlanHelper> childBTPlanHelpers = iTMBTPlanHelper.getChildBTPlans(iTMActionContext);
        Vector<ITMBTPlanHelper> childBTPlanHelpers2 = new Vector<ITMBTPlanHelper>();
        Hashtable<String, ITMBTMainTaskInstPlanHelper> tmBTPlanHelperScoreMap = new Hashtable<String, ITMBTMainTaskInstPlanHelper>();
        for (ITMBTPlanHelper childBTPlanHelper : childBTPlanHelpers) {
            ITMBTMainTaskInstPlanHelper iTMBTMainTaskInstPlanHelper = null;
            try {
                iTMBTMainTaskInstPlanHelper = childBTPlanHelper.FindBTMainTaskInstPlan(iTMActionContext, iTMBTMainTaskInstHelper.getId());
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
                continue;
            }
            if (iTMBTMainTaskInstPlanHelper.getScore() <= 0) continue;
            tmBTPlanHelperScoreMap.put(childBTPlanHelper.getId(), iTMBTMainTaskInstPlanHelper);
            int nInsertPos = -1;
            int i = 0;
            while (i < childBTPlanHelpers2.size()) {
                ITMBTMainTaskInstPlanHelper iTMBTMainTaskInstPlanHelperLast = (ITMBTMainTaskInstPlanHelper)tmBTPlanHelperScoreMap.get(((ITMBTPlanHelper)childBTPlanHelpers2.get(i)).getId());
                Integer nScore = iTMBTMainTaskInstPlanHelperLast.getScore();
                if (iTMBTMainTaskInstPlanHelper.getScore() > nScore) {
                    nInsertPos = i;
                    break;
                }
                if (iTMBTMainTaskInstPlanHelper.getScore() == nScore.intValue() && iTMBTMainTaskInstPlanHelper.getBeginTime().getTime() < iTMBTMainTaskInstPlanHelperLast.getBeginTime().getTime()) {
                    nInsertPos = i;
                    break;
                }
                ++i;
            }
            if (nInsertPos == -1) {
                childBTPlanHelpers2.add(childBTPlanHelper);
                continue;
            }
            childBTPlanHelpers2.add(nInsertPos, childBTPlanHelper);
        }
        int nFailedCnt = 0;
        int nSuccessCnt = 0;
        for (ITMBTPlanHelper childBTPlanHelper : childBTPlanHelpers2) {
            if (this.ArrangeBTMainTaskInsts(iTMActionContext, childBTPlanHelper, unArrangeBTMainTaskInsts2)) {
                if (!this.isUserStop() && ++nSuccessCnt < this.PARAM_MAINTASKSUCCESSLOOPCNT) continue;
                return true;
            }
            if (!this.isUserStop() && ++nFailedCnt < this.PARAM_MAINTASKFAILEDLOOPCNT) continue;
            return nSuccessCnt > 0;
        }
        return false;
    }

    protected boolean ArrangBTTaskInsts(ITMActionContext iTMActionContext, ITMBTPlanHelper iTMBTPlanHelper, ITMBTMainTaskInstHelper iTMBTMainTaskInstHelper, Timestamp dtBeginTime, Vector<ITMBTTaskInstHelper> unArrangeBTTaskInsts, boolean bFirst, Timestamp dtFirstBeginTime) throws Exception {
        return this.OnArrangBTTaskInsts(iTMActionContext, iTMBTPlanHelper, iTMBTMainTaskInstHelper, dtBeginTime, unArrangeBTTaskInsts, bFirst, dtFirstBeginTime);
    }

    protected boolean OnArrangBTTaskInsts(ITMActionContext iTMActionContext, ITMBTPlanHelper iTMBTPlanHelper, ITMBTMainTaskInstHelper iTMBTMainTaskInstHelper, Timestamp dtBeginTime, Vector<ITMBTTaskInstHelper> unArrangeBTTaskInsts, boolean bFirst, Timestamp dtFirstBeginTime) throws Exception {
        if (unArrangeBTTaskInsts.size() == 0) {
            iTMBTPlanHelper.FinishBTMainTaskInst(iTMActionContext, iTMBTMainTaskInstHelper.getId());
            iTMActionContext.getTransactionManager().CommitAndBegin();
            return true;
        }
        Vector<ITMBTTaskInstHelper> unArrangeBTTaskInsts2 = new Vector<ITMBTTaskInstHelper>();
        unArrangeBTTaskInsts2.addAll(unArrangeBTTaskInsts);
        ITMBTTaskInstHelper iTMBTTaskInstHelper = (ITMBTTaskInstHelper)unArrangeBTTaskInsts2.remove(0);
        Timestamp dtCurBeginTime = iTMBTTaskInstHelper.CalcStartTime(iTMActionContext, iTMBTPlanHelper, new Timestamp(dtBeginTime.getTime()));
        if (dtCurBeginTime == null) {
            return false;
        }
        if (iTMBTMainTaskInstHelper.getMaxDuration() > 0 && !bFirst) {
            String strBeginTime = StringHelper.Format((String)"%1$tY-%1$tm-%1$td 00:00:00", (Object)dtFirstBeginTime);
            try {
                Date data = DateParser.Parse((String)strBeginTime);
                long nHour = (dtCurBeginTime.getTime() - data.getTime()) / 3600000L;
                if (nHour > (long)iTMBTMainTaskInstHelper.getMaxDuration()) {
                    return false;
                }
            }
            catch (Exception data) {
                // empty catch block
            }
        }
        boolean bFinish = false;
        int nLoopCnt = 0;
        int nSuccessLoopCnt = 0;
        while (iTMBTMainTaskInstHelper.getEndTime() == null || iTMBTMainTaskInstHelper.getEndTime().getTime() - dtCurBeginTime.getTime() >= (long)(iTMBTMainTaskInstHelper.getMinDuration() * 60 * 60000)) {
            ITMBTPlanHelper childBTPlanHelper = null;
            if (bFirst) {
                childBTPlanHelper = iTMBTPlanHelper.CreateChildBTPlan(iTMActionContext);
                iTMActionContext.getTransactionManager().CommitAndBegin();
            } else {
                childBTPlanHelper = iTMBTPlanHelper;
            }
            ITMBTTaskInstPlanHelper iTMBTTaskInstPlanHelper = childBTPlanHelper.FinishBTTaskInst(iTMActionContext, iTMBTTaskInstHelper, dtCurBeginTime);
            if (iTMBTTaskInstPlanHelper == null) {
                log.debug((Object)StringHelper.Format((String)"[\u5931\u8d25]>>  \u4efb\u52a1\u5b9e\u4f8b[%1$s][%2$s][%3$s]\u65e0\u6cd5\u6392\u5e03\u5728\u65f6\u95f4[%4$s]", (Object)iTMBTMainTaskInstHelper.getName(), (Object)iTMBTTaskInstHelper.getName(), (Object)iTMBTTaskInstHelper.getTaskSN(), (Object)dtCurBeginTime));
                if (bFirst) {
                    iTMBTPlanHelper.RemoveChildBTPlan(iTMActionContext, childBTPlanHelper.getId());
                    iTMActionContext.getTransactionManager().CommitAndBegin();
                }
            } else {
                log.debug((Object)StringHelper.Format((String)"[\u6210\u529f]>>  \u4efb\u52a1\u5b9e\u4f8b[%1$s][%2$s][%3$s]\u6392\u5e03\u5728\u65f6\u95f4[%4$s]", (Object)iTMBTMainTaskInstHelper.getName(), (Object)iTMBTTaskInstHelper.getName(), (Object)iTMBTTaskInstHelper.getTaskSN(), (Object)dtCurBeginTime));
                boolean bRet = this.ArrangBTTaskInsts(iTMActionContext, childBTPlanHelper, iTMBTMainTaskInstHelper, dtBeginTime, unArrangeBTTaskInsts2, false, bFirst ? dtCurBeginTime : dtFirstBeginTime);
                if (bRet) {
                    bFinish = true;
                } else if (bFirst) {
                    iTMBTPlanHelper.RemoveChildBTPlan(iTMActionContext, childBTPlanHelper.getId());
                    iTMActionContext.getTransactionManager().CommitAndBegin();
                }
            }
            if (!bFirst ? bFinish : iTMBTMainTaskInstHelper.getEndTime() == null && (!bFinish ? this.isUserStop() || ++nLoopCnt >= this.PARAM_TASKFAILEDLOOPCNT : this.isUserStop() || ++nSuccessLoopCnt >= this.PARAM_TASKSUCCESSLOOPCNT)) break;
            if (this.isUserStop()) break;
            Calendar cal = Calendar.getInstance();
            cal.setTime(dtCurBeginTime);
            if (bFirst) {
                cal.add(11, 3);
            } else {
                cal.add(11, 3);
            }
            Timestamp dtCurBeginTime2 = dtCurBeginTime = new Timestamp(cal.getTime().getTime());
            dtCurBeginTime = bFirst ? iTMBTTaskInstHelper.CalcStartTime(iTMActionContext, iTMBTPlanHelper, dtCurBeginTime) : iTMBTTaskInstHelper.CalcStartTime(iTMActionContext, childBTPlanHelper, dtCurBeginTime);
            if (dtCurBeginTime == null) break;
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(dtCurBeginTime2);
            cal2.setTime(dtCurBeginTime);
            if (dtCurBeginTime.getTime() == dtCurBeginTime2.getTime() || !bFirst && cal1.get(6) != cal2.get(6)) break;
        }
        return bFinish;
    }

    @Override
    public void setUserStop() throws Exception {
        this.bUserStop = true;
    }

    protected boolean isUserStop() {
        return this.bUserStop;
    }

    @Override
    public boolean isStop() {
        return this.bEngineStop;
    }
}

