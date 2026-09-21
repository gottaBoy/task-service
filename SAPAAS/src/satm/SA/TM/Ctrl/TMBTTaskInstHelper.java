/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMBTTask;
import SA.TM.Ctrl.Data.TMBTTaskRes;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMBTPlanHelper;
import SA.TM.Ctrl.ITMBTTaskInstHelper;
import SA.TM.Ctrl.ITMBTTaskInstPlanHelper;
import SA.TM.Ctrl.ITMBTTaskResHelper;
import SA.TM.Ctrl.ITMTimeRuleHelper;
import SA.TM.Ctrl.TMObjectFactory;
import java.sql.Timestamp;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMBTTaskInstHelper
extends BaseTMObject
implements ITMBTTaskInstHelper {
    protected TMBTTask tmBTTask = null;
    protected Vector<ITMBTTaskResHelper> tmBTTaskResHelpers = null;
    private static final Log log = LogFactory.getLog(TMBTTaskInstHelper.class);

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMBTTask tmBTTask) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.tmBTTask = tmBTTask;
        this.setId(this.tmBTTask.getTMBTTASKID());
        this.setName(this.tmBTTask.getTMBTTASKNAME());
        this.OnInit();
    }

    @Override
    public Timestamp CalcStartTime(ITMActionContext iTMActionContext, ITMBTPlanHelper iTMBTPlanHelper, Timestamp dtBeginTime) throws Exception {
        String strFrontTaskSN = this.getFrontTaskSN();
        Timestamp realBeginTime = dtBeginTime;
        if (!StringHelper.IsNullOrEmpty((String)strFrontTaskSN)) {
            try {
                Vector<ITMBTTaskInstPlanHelper> tmBTTaskInstPlanHelpers = iTMBTPlanHelper.ListBTTaskInstPlans(iTMActionContext, this.getBTMainTaskInstId(), strFrontTaskSN);
                for (ITMBTTaskInstPlanHelper iTMBTTaskInstPlanHelper : tmBTTaskInstPlanHelpers) {
                    if (iTMBTTaskInstPlanHelper.isIgnoreArrange()) {
                        if (realBeginTime == null) {
                            realBeginTime = iTMBTTaskInstPlanHelper.getBeginTime();
                            continue;
                        }
                        if (iTMBTTaskInstPlanHelper.getBeginTime().getTime() <= realBeginTime.getTime()) continue;
                        realBeginTime = iTMBTTaskInstPlanHelper.getBeginTime();
                        continue;
                    }
                    if (realBeginTime == null) {
                        realBeginTime = iTMBTTaskInstPlanHelper.getEndTime();
                        continue;
                    }
                    if (iTMBTTaskInstPlanHelper.getEndTime().getTime() <= realBeginTime.getTime()) continue;
                    realBeginTime = iTMBTTaskInstPlanHelper.getEndTime();
                }
            }
            catch (Exception ex) {
                log.debug((Object)"\u8ba1\u7b97\u4efb\u52a1\u5f00\u59cb\u65f6\u95f4\u53d1\u751f\u5f02\u5e38", (Throwable)ex);
                return null;
            }
        } else {
            realBeginTime = dtBeginTime;
        }
        if (this.isIgnoreArrange()) {
            return realBeginTime;
        }
        return this.OnCalcStartTime(iTMActionContext, iTMBTPlanHelper, realBeginTime);
    }

    protected Timestamp OnCalcStartTime(ITMActionContext iTMActionContext, ITMBTPlanHelper iTMBTPlanHelper, Timestamp dtBeginTime) throws Exception {
        ITMTimeRuleHelper iTMTimeRuleHelper = this.getTMModelStorage().FindTMTimeRule("UID_20124121151454750019817901");
        return iTMTimeRuleHelper.CalcValidTime(dtBeginTime, this.getDuration(), true);
    }

    @Override
    public String getBTMainTaskInstId() {
        return this.tmBTTask.getTMBOOKINGTESTID();
    }

    @Override
    public int getTaskSN() {
        return Integer.parseInt(this.tmBTTask.getTASKSN());
    }

    @Override
    public String getFrontTaskSN() {
        return this.tmBTTask.getFRONTTASKSN();
    }

    @Override
    public int getDuration() {
        return this.tmBTTask.getDURATION();
    }

    @Override
    public Vector<ITMBTTaskResHelper> getBTTaskReses(ITMActionContext iTMActionContext, boolean bReload) throws Exception {
        if (!bReload && this.tmBTTaskResHelpers != null) {
            return this.tmBTTaskResHelpers;
        }
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)this.getId());
        String strSQL = "select t1.* FROM SRFV_TMBTTASKRES t1 where t1.TMBTTASKID = ? ";
        Vector tmBTTaskReses = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), null, (String)this.getDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), tmBTTaskReses, (String)TMBTTaskRes.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8bd5\u7b97\u4efb\u52a1\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<ITMBTTaskResHelper> tmBTTaskResHelpers = new Vector<ITMBTTaskResHelper>();
        for (TMBTTaskRes tmBTTaskRes : tmBTTaskReses) {
            ITMBTTaskResHelper iTMBTTaskResHelper = TMObjectFactory.getCurrent().CreateBTTaskResHelper(this.iDAGlobalHelper, tmBTTaskRes);
            tmBTTaskResHelpers.add(iTMBTTaskResHelper);
        }
        this.tmBTTaskResHelpers = tmBTTaskResHelpers;
        return this.tmBTTaskResHelpers;
    }

    @Override
    public Vector<ITMBTTaskResHelper> getBTTaskReses(ITMActionContext iTMActionContext) throws Exception {
        return this.getBTTaskReses(iTMActionContext, false);
    }

    @Override
    public boolean isIgnoreArrange() {
        if (this.tmBTTask.isIGNOREARRANGENull()) {
            return false;
        }
        return this.tmBTTask.getIGNOREARRANGE();
    }
}

