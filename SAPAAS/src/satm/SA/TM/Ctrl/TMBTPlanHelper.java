/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMBTPlan;
import SA.TM.Ctrl.Data.TMBTPlanMT;
import SA.TM.Ctrl.Data.TMBTPlanTask;
import SA.TM.Ctrl.Data.TMBTPlanTaskRes;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMBTMainTaskInstPlanHelper;
import SA.TM.Ctrl.ITMBTPlanHelper;
import SA.TM.Ctrl.ITMBTTaskInstHelper;
import SA.TM.Ctrl.ITMBTTaskInstPlanHelper;
import SA.TM.Ctrl.ITMBTTaskResHelper;
import SA.TM.Ctrl.ITMResCatalogHelper;
import SA.TM.Ctrl.ITMTaskResArrangeEngine;
import SA.TM.Ctrl.TMObjectFactory;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMBTPlanHelper
extends BaseTMObject
implements ITMBTPlanHelper {
    protected TMBTPlan tmBTPlan = null;
    protected ITMBTPlanHelper pTMBTPlanHelper = null;
    protected Vector<ITMBTPlanHelper> childBTPlanHelpers = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMBTPlan tmBTPlan) throws Exception {
        this.tmBTPlan = tmBTPlan;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(tmBTPlan.getTMBTPLANID());
        this.setName(tmBTPlan.getTMBTPLANNAME());
        this.OnInit();
    }

    @Override
    public void CreateDefault(ITMActionContext iTMActionContext, Timestamp dtBeginTime, Timestamp dtEndTime) throws Exception {
        CallResult callResult;
        if (!StringHelper.IsNullOrEmpty((String)this.tmBTPlan.getPTMBTPLANID())) {
            throw new Exception("\u5b50\u8bd5\u7b97\u8ba1\u5212\u65e0\u6cd5\u5efa\u7acb\u9ed8\u8ba4\u6570\u636e");
        }
        if (dtBeginTime == null) {
            throw new Exception("\u5fc5\u987b\u6307\u5b9a\u5f00\u59cb\u65f6\u95f4");
        }
        CallParamList callParamList = new CallParamList();
        callParamList.AddDateTime((Object)dtBeginTime);
        String strSQL = "INSERT INTO SRFT_TMBTPLANCAL_BASE  (    TMBTPLANCALID, TMBTPLANCALNAME, CREATEMAN, CREATEDATE, UPDATEMAN, UPDATEDATE,  TMBTPLANID,TMRESBASEID, TMRESBASENAME,  BEGINTIME, ENDTIME, EXCLUSIVEFLAG, RESBOOKINGTYPE, TMTASKBASEID, TMRESBOOKINGID,PTMRESBOOKINGID) SELECT FU_SRFGUID(),TMRESBOOKINGNAME,CREATEMAN, CREATEDATE, UPDATEMAN, UPDATEDATE,'" + this.getId() + "', TMRESBASEID, TMRESBASENAME, BEGINTIME, ENDTIME,EXCLUSIVEFLAG,TMRESBOOKINGTYPE,TMTASKBASEID,  TMRESBOOKINGID ,PTMRESBOOKINGID " + " FROM SRFT_TMRESBOOKING_BASE WHERE BEGINTIME>=? ";
        if (dtEndTime != null) {
            strSQL = String.valueOf(strSQL) + " AND BEGINTIME< ?";
            callParamList.AddDateTime((Object)dtEndTime);
        }
        if ((callResult = BaseDEDataCtrl.ExecuteWithoutResultEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), (Connection)iTMActionContext.getDBConnection(this.getDBStorage()), (String)this.getDBStorage(), (String)strSQL, (Vector)callParamList.GetList())).IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u9ed8\u8ba4\u8bd5\u7b97\u8ba1\u5212\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        iTMActionContext.getTransactionManager().CommitAndBegin();
    }

    @Override
    public ITMBTPlanHelper CloneBTPlan(ITMActionContext iTMActionContext) throws Exception {
        TMBTPlan cloneBTPlan = new TMBTPlan();
        this.tmBTPlan.CopyTo(cloneBTPlan, true);
        IDEDataCtrl tmBTPlanDataCtrl = iTMActionContext.getDEDataCtrl("TM0160");
        tmBTPlanDataCtrl.RemoveUncopyValue((BaseDataEntity)cloneBTPlan);
        CallResult callResult = tmBTPlanDataCtrl.Save(true, (BaseDataEntity)cloneBTPlan);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8bd5\u7b97\u8ba1\u5212\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        callResult = tmBTPlanDataCtrl.CopyDetail((BaseDataEntity)cloneBTPlan, (Object)this.getId());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u590d\u5236\u8bd5\u7b97\u8ba1\u5212\u6570\u636e\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        ITMBTPlanHelper iTMBTPlanHelper = TMObjectFactory.getCurrent().CreateBTPlanHelper(this.iDAGlobalHelper, cloneBTPlan);
        return iTMBTPlanHelper;
    }

    @Override
    public ITMBTPlanHelper CreateChildBTPlan(ITMActionContext iTMActionContext) throws Exception {
        TMBTPlan childBTPlan = new TMBTPlan();
        childBTPlan.setPTMBTPLANID(this.getId());
        childBTPlan.setTMBTPRJINSTID(this.tmBTPlan.getTMBTPRJINSTID());
        childBTPlan.setPLANLEVEL(this.tmBTPlan.getPLANLEVEL() + 1);
        IDEDataCtrl tmBTPlanDataCtrl = iTMActionContext.getDEDataCtrl("TM0160");
        CallResult callResult = tmBTPlanDataCtrl.Save(true, (BaseDataEntity)childBTPlan);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8bd5\u7b97\u8ba1\u5212\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        ITMBTPlanHelper iTMBTPlanHelper = TMObjectFactory.getCurrent().CreateBTPlanHelper(this.iDAGlobalHelper, childBTPlan);
        return iTMBTPlanHelper;
    }

    @Override
    public ITMBTMainTaskInstPlanHelper FindBTMainTaskInstPlan(ITMActionContext iTMActionContext, String strTMBTMainTaskInstId) throws Exception {
        String strSQL = String.valueOf(this.getTMModelHelper().GetTMBTPlanJoinQuerySQL(true, "\tselect t1.* from SRFV_TMBTPLANMT  t1 ")) + "  WHERE t1.TMBOOKINGTESTID=? ";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)this.getId());
        callParamList.Add((Object)strTMBTMainTaskInstId);
        TMBTPlanMT tmBTPlanMT = new TMBTPlanMT();
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), (Connection)iTMActionContext.getDBConnection(this.getDBStorage()), (String)this.getDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)tmBTPlanMT);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8bd5\u7b97\u8ba1\u5212\u4e3b\u4efb\u52a1\u5b9e\u4f8b\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return TMObjectFactory.getCurrent().CreateBTMainTaskInstPlanHelper(this.iDAGlobalHelper, tmBTPlanMT);
    }

    @Override
    public ITMBTMainTaskInstPlanHelper FinishBTMainTaskInst(ITMActionContext iTMActionContext, String strTMBTMainTaskInstId) throws Exception {
        String strSQL = "select MIN(t1.BEGINTIME) AS BEGINTIME,MAX(t1.ENDTIME) AS ENDTIME FROM SRFV_TMBTPLANTASK t1   WHERE  TMBOOKINGTESTID=? AND TMBTPLANID=? GROUP BY T1.TMBOOKINGTESTID ";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strTMBTMainTaskInstId);
        callParamList.Add((Object)this.getId());
        TMBTPlanMT tmBTPlanMT = new TMBTPlanMT();
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), (Connection)iTMActionContext.getDBConnection(this.getDBStorage()), (String)this.getDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)tmBTPlanMT);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u8ba1\u7b97\u4e3b\u4efb\u52a1\u5b9e\u4f8b\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        tmBTPlanMT.setTMBTPLANID(this.getId());
        tmBTPlanMT.setTMBOOKINGTESTID(strTMBTMainTaskInstId);
        IDEDataCtrl tmBTPlanMTDataCtrl = iTMActionContext.getDEDataCtrl("TM0164");
        try {
            callResult = tmBTPlanMTDataCtrl.Save(true, (BaseDataEntity)tmBTPlanMT);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e3b\u4efb\u52a1\u5b9e\u4f8b\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            strSQL = " UPDATE SRFT_TMBTPLANTASK_BASE SET TMBTPLANMTID=?  WHERE TMBTTASKID IN (SELECT TMBTTASKID FROM SRFT_TMBTTASK_BASE WHERE TMBOOKINGTESTID=?)  AND TMBTPLANID=? ";
            callParamList.Reset();
            callParamList.Add((Object)tmBTPlanMT.getTMBTPLANMTID());
            callParamList.Add((Object)strTMBTMainTaskInstId);
            callParamList.Add((Object)this.getId());
            callResult = BaseDEDataCtrl.ExecuteWithoutResultEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), (Connection)iTMActionContext.getDBConnection(this.getDBStorage()), (String)this.getDBStorage(), (String)strSQL, (Vector)callParamList.GetList());
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u8ba1\u7b97\u4e3b\u4efb\u52a1\u5b9e\u4f8b\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            strSQL = this.getTMModelHelper().GetTMBTPlanJoinQuerySQL(true, " select MIN(t1.BEGINTIME) AS BEGINTIME,MAX(t1.ENDTIME) AS ENDTIME FROM SRFV_TMBTPLANMT t1  ");
            callParamList.Reset();
            callParamList.Add((Object)this.getId());
            TMBTPlan tmBTPlan = new TMBTPlan();
            callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), (Connection)iTMActionContext.getDBConnection(this.getDBStorage()), (String)this.getDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)tmBTPlan);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u8ba1\u7b97\u8bd5\u7b97\u8ba1\u5212\u5f00\u59cb\u7ed3\u675f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            tmBTPlan.setTMBTPLANID(this.getId());
            IDEDataCtrl tmBTPlanDataCtrl = iTMActionContext.getDEDataCtrl("TM0160");
            callResult = tmBTPlanDataCtrl.Save(false, (BaseDataEntity)tmBTPlan);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u8bd5\u7b97\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            iTMActionContext.getTransactionManager().CommitAndBegin();
        }
        catch (Exception ex) {
            iTMActionContext.getTransactionManager().Rollback();
            throw ex;
        }
        return TMObjectFactory.getCurrent().CreateBTMainTaskInstPlanHelper(this.iDAGlobalHelper, tmBTPlanMT);
    }

    /*
     * Enabled aggressive exception aggregation
     */
    @Override
    public ITMBTTaskInstPlanHelper FinishBTTaskInst(ITMActionContext iTMActionContext, ITMBTTaskInstHelper iTMBTTaskInstHelper, Timestamp dtBeginTime) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dtBeginTime);
        cal.add(12, iTMBTTaskInstHelper.getDuration());
        Timestamp dtEndTime = new Timestamp(cal.getTime().getTime());
        TMBTPlanTask tmBTPlanTask = new TMBTPlanTask();
        Vector<ITMBTTaskResHelper> tmBTTaskResHelpers = iTMBTTaskInstHelper.getBTTaskReses(iTMActionContext);
        IDEDataCtrl tmBTPlanTaskDataCtrl = iTMActionContext.getDEDataCtrl("TM0162");
        IDEDataCtrl tmBTPlanTaskResDataCtrl = iTMActionContext.getDEDataCtrl("TM0163");
        try {
            iTMActionContext.getTransactionManager().CommitAndBegin();
            tmBTPlanTask.setBEGINTIME(dtBeginTime);
            tmBTPlanTask.setENDTIME(dtEndTime);
            tmBTPlanTask.setTMBTPLANID(this.getId());
            tmBTPlanTask.setTMBTTASKID(iTMBTTaskInstHelper.getId());
            CallResult callResult = tmBTPlanTaskDataCtrl.Save(true, (BaseDataEntity)tmBTPlanTask);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8bd5\u7b97\u4efb\u52a1\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            String strTaskResName = "";
            for (ITMBTTaskResHelper iTMBTTaskResHelper : tmBTTaskResHelpers) {
                ITMResCatalogHelper iTMResCatalogHelper = this.getTMModelStorage().FindTMResCatalog(iTMBTTaskResHelper.getResCatalogId());
                if (StringHelper.IsNullOrEmpty((String)iTMResCatalogHelper.getTMTaskResAEId())) continue;
                TMBTPlanTaskRes tmBTPlanTaskRes = new TMBTPlanTaskRes();
                tmBTPlanTaskRes.setTMBTPLANID(this.getId());
                tmBTPlanTaskRes.setTMBTTASKRESID(iTMBTTaskResHelper.getId());
                ITMTaskResArrangeEngine iTMTaskResArrangeEngine = this.getTMModelStorage().CreateTMTaskResArrangeEngine(iTMResCatalogHelper.getTMTaskResAEId());
                if (iTMBTTaskResHelper.isCustomDuration()) {
                    boolean bFind = false;
                    int i = 0;
                    while (i < 10000) {
                        String strResCDId;
                        cal.setTime(dtBeginTime);
                        cal.add(12, i * 10);
                        Timestamp dtCurBeginTime = new Timestamp(cal.getTime().getTime());
                        cal.add(12, iTMBTTaskResHelper.getDuration());
                        Timestamp dtCurEndTime = new Timestamp(cal.getTime().getTime());
                        if (dtCurEndTime.getTime() > dtEndTime.getTime()) break;
                        tmBTPlanTaskRes.setBEGINTIME(dtCurBeginTime);
                        tmBTPlanTaskRes.setENDTIME(dtCurEndTime);
                        tmBTPlanTaskRes.setCUSTOMTRTIME(true);
                        if (iTMBTTaskInstHelper.isIgnoreArrange() || !StringHelper.IsNullOrEmpty((String)(strResCDId = iTMTaskResArrangeEngine.CalcResCDScore(iTMActionContext, iTMBTTaskResHelper.getData(), tmBTPlanTaskRes, null, null)))) {
                            tmBTPlanTaskRes.setTMBTPLANTASKID(tmBTPlanTask.getTMBTPLANTASKID());
                            callResult = tmBTPlanTaskResDataCtrl.Save(true, (BaseDataEntity)tmBTPlanTaskRes);
                            if (callResult.IsError()) {
                                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8bd5\u7b97\u4efb\u52a1\u8d44\u6e90\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                            }
                            if (!StringHelper.IsNullOrEmpty((String)tmBTPlanTaskRes.getTMRESCDNAME())) {
                                if (!StringHelper.IsNullOrEmpty((String)strTaskResName)) {
                                    strTaskResName = String.valueOf(strTaskResName) + "\u3001";
                                }
                                strTaskResName = String.valueOf(strTaskResName) + StringHelper.Format((String)"%1$s(%2$tH%2$tM~%3$tH%3$tM)", (Object)tmBTPlanTaskRes.getTMRESCDNAME(), (Object)tmBTPlanTaskRes.getBEGINTIME(), (Object)tmBTPlanTaskRes.getENDTIME());
                            }
                            bFind = true;
                            break;
                        }
                        ++i;
                    }
                    if (bFind) continue;
                    iTMActionContext.getTransactionManager().RollbackAndBegin();
                    return null;
                }
                tmBTPlanTaskRes.setBEGINTIME(dtBeginTime);
                tmBTPlanTaskRes.setENDTIME(dtEndTime);
                if (!iTMBTTaskInstHelper.isIgnoreArrange()) {
                    String strResCDId = iTMTaskResArrangeEngine.CalcResCDScore(iTMActionContext, iTMBTTaskResHelper.getData(), tmBTPlanTaskRes, null, null);
                    if (StringHelper.IsNullOrEmpty((String)strResCDId)) {
                        iTMActionContext.getTransactionManager().RollbackAndBegin();
                        return null;
                    }
                    tmBTPlanTaskRes.setTMRESCDID(strResCDId);
                }
                tmBTPlanTaskRes.setTMBTPLANTASKID(tmBTPlanTask.getTMBTPLANTASKID());
                callResult = tmBTPlanTaskResDataCtrl.Save(true, (BaseDataEntity)tmBTPlanTaskRes);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8bd5\u7b97\u4efb\u52a1\u8d44\u6e90\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                if (StringHelper.IsNullOrEmpty((String)tmBTPlanTaskRes.getTMRESCDNAME())) continue;
                if (!StringHelper.IsNullOrEmpty((String)strTaskResName)) {
                    strTaskResName = String.valueOf(strTaskResName) + "\u3001";
                }
                strTaskResName = String.valueOf(strTaskResName) + StringHelper.Format((String)"%1$s", (Object)tmBTPlanTaskRes.getTMRESCDNAME());
            }
            String strBTPlanTaskId = tmBTPlanTask.getTMBTPLANTASKID();
            tmBTPlanTask.Reset();
            tmBTPlanTask.setTMBTPLANTASKID(strBTPlanTaskId);
            tmBTPlanTask.setTASKRESINFO(strTaskResName);
            callResult = tmBTPlanTaskDataCtrl.Save(false, (BaseDataEntity)tmBTPlanTask);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u8bd5\u7b97\u4efb\u52a1\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            iTMActionContext.getTransactionManager().CommitAndBegin();
        }
        catch (Exception ex) {
            iTMActionContext.getTransactionManager().RollbackAndBegin();
            throw ex;
        }
        return TMObjectFactory.getCurrent().CreateBTTaskInstPlanHelper(this.iDAGlobalHelper, tmBTPlanTask);
    }

    @Override
    public Vector<ITMBTTaskInstPlanHelper> ListBTTaskInstPlans(ITMActionContext iTMActionContext, String strTMBTMainTaskInstId, String strTaskSN) throws Exception {
        String[] taskSNs = strTaskSN.split("[;]");
        String strTaskSNCond = "";
        int i = 0;
        while (i < taskSNs.length) {
            if (!StringHelper.IsNullOrEmpty((String)strTaskSNCond)) {
                strTaskSNCond = String.valueOf(strTaskSNCond) + ",";
            }
            strTaskSNCond = String.valueOf(strTaskSNCond) + StringHelper.Format((String)"'%1$s'", (Object)taskSNs[i]);
            ++i;
        }
        String strSQL = String.valueOf(this.getTMModelHelper().GetTMBTPlanJoinQuerySQL(true, "\t\tselect t1.* from SRFV_TMBTPLANTASK  t1  ")) + "  WHERE  t1.TASKSN in(" + strTaskSNCond + ")  AND  t1.TMBOOKINGTESTID=? ";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)this.getId());
        callParamList.Add((Object)strTMBTMainTaskInstId);
        Vector<TMBTPlanTask> tmBTPlanTasks = new Vector<TMBTPlanTask>();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), (Connection)iTMActionContext.getDBConnection(this.getDBStorage()), (String)this.getDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), tmBTPlanTasks, (String)TMBTPlanTask.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8bd5\u7b97\u8ba1\u5212\u4efb\u52a1\u5b9e\u4f8b\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (tmBTPlanTasks.size() != taskSNs.length) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8bd5\u7b97\u8ba1\u5212\u4efb\u52a1\u5b9e\u4f8b\u6570\u636e\u6570\u91cf[%1$s]\u4e0e\u4f20\u5165\u53c2\u6570[%2$s]\u4e0d\u4e00\u81f4", (Object)tmBTPlanTasks.size(), (Object)strTaskSN));
        }
        Vector<ITMBTTaskInstPlanHelper> tmBTTaskInstPlanHelpers = new Vector<ITMBTTaskInstPlanHelper>();
        for (TMBTPlanTask tmBTPlanTask : tmBTPlanTasks) {
            ITMBTTaskInstPlanHelper iTMBTTaskInstPlanHelper = TMObjectFactory.getCurrent().CreateBTTaskInstPlanHelper(this.iDAGlobalHelper, tmBTPlanTask);
            tmBTTaskInstPlanHelpers.add(iTMBTTaskInstPlanHelper);
        }
        return tmBTTaskInstPlanHelpers;
    }

    @Override
    public void RemoveChildBTPlan(ITMActionContext iTMActionContext, String strTMBTPlanId) throws Exception {
        TMBTPlan removeBTPlan = new TMBTPlan();
        removeBTPlan.setTMBTPLANID(strTMBTPlanId);
        IDEDataCtrl tmBTPlanDataCtrl = iTMActionContext.getDEDataCtrl("TM0160");
        CallResult callResult = tmBTPlanDataCtrl.Remove((BaseDataEntity)removeBTPlan);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5220\u9664\u8bd5\u7b97\u8ba1\u5212\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.childBTPlanHelpers = null;
    }

    @Override
    public Vector<ITMBTPlanHelper> getChildBTPlans(ITMActionContext iTMActionContext, boolean bReload) throws Exception {
        if (!bReload && this.childBTPlanHelpers != null) {
            return this.childBTPlanHelpers;
        }
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)this.getId());
        String strSQL = "select t1.* FROM SRFV_TMBTPLAN t1 where t1.PTMBTPLANID =? ";
        Vector<TMBTPlan> tmBTPlans = new Vector<TMBTPlan>();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), null, (String)this.getDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), tmBTPlans, (String)TMBTPlan.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8bd5\u7b97\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<ITMBTPlanHelper> childBTPlanHelpers = new Vector<ITMBTPlanHelper>();
        for (TMBTPlan tmBTPlan : tmBTPlans) {
            ITMBTPlanHelper iTMBTPlanHelper = TMObjectFactory.getCurrent().CreateBTPlanHelper(this.iDAGlobalHelper, tmBTPlan);
            childBTPlanHelpers.add(iTMBTPlanHelper);
        }
        this.childBTPlanHelpers = childBTPlanHelpers;
        return this.childBTPlanHelpers;
    }

    @Override
    public Vector<ITMBTPlanHelper> getChildBTPlans(ITMActionContext iTMActionContext) throws Exception {
        return this.getChildBTPlans(iTMActionContext, false);
    }

    @Override
    public ITMBTPlanHelper getParentBTPlan(ITMActionContext iTMActionContext) throws Exception {
        if (this.pTMBTPlanHelper != null) {
            return this.pTMBTPlanHelper;
        }
        TMBTPlan parentBTPlan = new TMBTPlan();
        parentBTPlan.setTMBTPLANID(this.tmBTPlan.getPTMBTPLANID());
        IDEDataCtrl tmBTPlanDataCtrl = iTMActionContext.getDEDataCtrl("TM0160");
        CallResult callResult = tmBTPlanDataCtrl.Get((BaseDataEntity)parentBTPlan);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8bd5\u7b97\u8ba1\u5212\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        ITMBTPlanHelper iTMBTPlanHelper = TMObjectFactory.getCurrent().CreateBTPlanHelper(this.iDAGlobalHelper, parentBTPlan);
        return iTMBTPlanHelper;
    }

    @Override
    public Timestamp getBTMainTaskBeginTime() {
        return this.tmBTPlan.getBEGINTIME();
    }

    @Override
    public Timestamp getBTMainTaskEndTime() {
        return this.tmBTPlan.getENDTIME();
    }

    @Override
    public void MarkBTPlanFinish(ITMActionContext iTMActionContext) throws Exception {
        TMBTPlan tmBTPlan = new TMBTPlan();
        tmBTPlan.setTMBTPLANID(this.getId());
        IDEDataCtrl tmBTPlanDataCtrl = iTMActionContext.getDEDataCtrl("TM0160");
        CallResult callResult = tmBTPlanDataCtrl.Get((BaseDataEntity)tmBTPlan);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8bd5\u7b97\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        double fScore = 0.0;
        if (!tmBTPlan.isBEGINTIMENull() && !tmBTPlan.isENDTIMENull()) {
            fScore = tmBTPlan.getENDTIME().getTime() - tmBTPlan.getBEGINTIME().getTime();
            fScore = (365.0 - fScore / 8.64E7) / 365.0 * 100.0;
        }
        TMBTPlan tmBTPlan2 = new TMBTPlan();
        tmBTPlan2.setTMBTPLANID(this.getId());
        tmBTPlan2.setPLANSCORE((float)fScore);
        tmBTPlan2.setFINISHFLAG(true);
        callResult = tmBTPlanDataCtrl.Save(false, (BaseDataEntity)tmBTPlan2);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8bd5\u7b97\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        iTMActionContext.getTransactionManager().CommitAndBegin();
    }
}
