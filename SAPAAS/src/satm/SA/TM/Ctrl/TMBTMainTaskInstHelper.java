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
import SA.TM.Ctrl.Data.TMBTPRJInst;
import SA.TM.Ctrl.Data.TMBTTask;
import SA.TM.Ctrl.Data.TMBookingTest;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMBTMainTaskInstHelper;
import SA.TM.Ctrl.ITMBTPRJInstHelper;
import SA.TM.Ctrl.ITMBTTaskInstHelper;
import SA.TM.Ctrl.TMObjectFactory;
import java.sql.Timestamp;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class TMBTMainTaskInstHelper
extends BaseTMObject
implements ITMBTMainTaskInstHelper {
    protected ITMBTPRJInstHelper iTMBTPRJInstHelper = null;
    protected TMBookingTest tmBookingTest = null;
    protected Vector<ITMBTTaskInstHelper> tmBTTaskInstHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMBookingTest tmBookingTest) throws Exception {
        this.tmBookingTest = tmBookingTest;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(tmBookingTest.getTMBOOKINGTESTID());
        this.setName(tmBookingTest.getTMBOOKINGTESTNAME());
        this.OnInit();
    }

    @Override
    public void ExtractBTTaskInsts(ITMActionContext iTMActionContext) throws Exception {
        this.OnExtractBTTaskInsts(iTMActionContext);
    }

    protected void OnExtractBTTaskInsts(ITMActionContext iTMActionContext) throws Exception {
    }

    @Override
    public Vector<ITMBTTaskInstHelper> getBTTaskInsts(ITMActionContext iTMActionContext) throws Exception {
        return this.getBTTaskInsts(iTMActionContext, false);
    }

    @Override
    public Vector<ITMBTTaskInstHelper> getBTTaskInsts(ITMActionContext iTMActionContext, boolean bReload) throws Exception {
        if (!bReload && this.tmBTTaskInstHelper != null) {
            return this.tmBTTaskInstHelper;
        }
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)this.getId());
        String strSQL = "select t1.* FROM SRFV_TMBTTASK t1 where t1.TMBOOKINGTESTID =? ORDER BY t1.TASKSN ";
        Vector<TMBTTask> tmBTTasks = new Vector<TMBTTask>();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), null, (String)this.getDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), tmBTTasks, (String)TMBTTask.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8bd5\u7b97\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<ITMBTTaskInstHelper> tmBTTaskInstHelper = new Vector<ITMBTTaskInstHelper>();
        for (TMBTTask tmBTTask : tmBTTasks) {
            ITMBTTaskInstHelper iTMBTTaskHelper = TMObjectFactory.getCurrent().CreateBTTaskInstHelper(this.iDAGlobalHelper, tmBTTask);
            tmBTTaskInstHelper.add(iTMBTTaskHelper);
        }
        this.tmBTTaskInstHelper = tmBTTaskInstHelper;
        return this.tmBTTaskInstHelper;
    }

    @Override
    public Timestamp getBeginTime() throws Exception {
        if (this.tmBookingTest.isBEGINTIMENull()) {
            return this.getBTPRJInst().getBeginTime();
        }
        return this.tmBookingTest.getBEGINTIME();
    }

    @Override
    public Timestamp getEndTime() throws Exception {
        if (this.tmBookingTest.isENDTIMENull()) {
            return this.getBTPRJInst().getEndTime();
        }
        return this.tmBookingTest.getENDTIME();
    }

    @Override
    public int getMaxDuration() {
        if (this.tmBookingTest.isMAXDURATIONNull()) {
            return 0;
        }
        return this.tmBookingTest.getMAXDURATION();
    }

    @Override
    public int getMinDuration() {
        return 0;
    }

    @Override
    public boolean isCancelable() {
        return false;
    }

    @Override
    public boolean isExtracted() {
        return this.tmBookingTest.getEXTRACTFLAG();
    }

    @Override
    public boolean isMatch(ITMBTMainTaskInstHelper iTMBTMainTaskInstHelper) {
        return false;
    }

    @Override
    public String getUniqueTag() {
        return "";
    }

    @Override
    public ITMBTPRJInstHelper getBTPRJInst() throws Exception {
        if (this.iTMBTPRJInstHelper != null) {
            return this.iTMBTPRJInstHelper;
        }
        IDEDataCtrl tmBTPRJInstDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl2("TM0147", "SYSTEM", null);
        TMBTPRJInst tmBTPRJInst = new TMBTPRJInst();
        tmBTPRJInst.setTMBTPRJINSTID(this.tmBookingTest.getTMBTPRJINSTID());
        CallResult callResult = tmBTPRJInstDataCtrl.Get((BaseDataEntity)tmBTPRJInst);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8bd5\u7b97\u9879\u76ee\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.iTMBTPRJInstHelper = TMObjectFactory.getCurrent().CreateBTPRJInstHelper(this.iDAGlobalHelper, tmBTPRJInst);
        return this.iTMBTPRJInstHelper;
    }
}
