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
import SA.TM.Ctrl.Data.TMBTPRJ;
import SA.TM.Ctrl.Data.TMBTPRJInst;
import SA.TM.Ctrl.Data.TMBTPlan;
import SA.TM.Ctrl.Data.TMBookingTest;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMBTMainTaskInstHelper;
import SA.TM.Ctrl.ITMBTPRJInstHelper;
import SA.TM.Ctrl.ITMBTPlanHelper;
import SA.TM.Ctrl.ITMBTProjectHelper;
import SA.TM.Ctrl.TMObjectFactory;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMBTPRJInstHelper
extends BaseTMObject
implements ITMBTPRJInstHelper {
    protected ITMBTProjectHelper iTMBTProjectHelper = null;
    protected TMBTPRJInst tmBTPRJInst = null;
    protected ITMBTPlanHelper iTMBTPlanHelper = null;
    protected Vector<ITMBTMainTaskInstHelper> tmBTMainTaskInstHelpers = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMBTPRJInst tmBTPRJInst) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmBTPRJInst = tmBTPRJInst;
        this.setId(this.tmBTPRJInst.getTMBTPRJINSTID());
        this.setName(this.tmBTPRJInst.getTMBTPRJINSTNAME());
        this.OnInit();
    }

    @Override
    public Vector<ITMBTMainTaskInstHelper> getBTMainTaskInsts(boolean bReload) throws Exception {
        if (!bReload && this.tmBTMainTaskInstHelpers != null) {
            return this.tmBTMainTaskInstHelpers;
        }
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)this.getId());
        String strSQL = "select t1.* FROM SRFV_TMBOOKINGTEST t1 where t1.TMBTPRJINSTID =? ORDER BY T1.ORDERFLAG";
        Vector<TMBookingTest> tmBookingTests = new Vector<TMBookingTest>();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), null, (String)this.getDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), tmBookingTests, (String)TMBookingTest.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8bd5\u7b97\u8ba1\u5212\u4e3b\u4efb\u52a1\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<ITMBTMainTaskInstHelper> tmBTMainTaskInstHelpers = new Vector<ITMBTMainTaskInstHelper>();
        for (TMBookingTest tmBookingTest : tmBookingTests) {
            ITMBTMainTaskInstHelper iTMBTMainTaskInstHelper = TMObjectFactory.getCurrent().CreateBTMainTaskInstHelper(this.iDAGlobalHelper, tmBookingTest);
            tmBTMainTaskInstHelpers.add(iTMBTMainTaskInstHelper);
        }
        this.tmBTMainTaskInstHelpers = tmBTMainTaskInstHelpers;
        return this.tmBTMainTaskInstHelpers;
    }

    @Override
    public Vector<ITMBTMainTaskInstHelper> getBTMainTaskInsts() throws Exception {
        return this.getBTMainTaskInsts(false);
    }

    @Override
    public ITMBTProjectHelper getBTProject() throws Exception {
        if (this.iTMBTProjectHelper != null) {
            return this.iTMBTProjectHelper;
        }
        IDEDataCtrl tmBTProjectDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl2("TM0142", "SYSTEM", null);
        TMBTPRJ tmBTPRJ = new TMBTPRJ();
        tmBTPRJ.setTMBTPRJID(this.tmBTPRJInst.getTMBTPRJID());
        CallResult callResult = tmBTProjectDataCtrl.Get((BaseDataEntity)tmBTPRJ);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8bd5\u7b97\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.iTMBTProjectHelper = TMObjectFactory.getCurrent().CreateBTProjectHelper(this.iDAGlobalHelper, tmBTPRJ);
        return this.iTMBTProjectHelper;
    }

    @Override
    public ITMBTPlanHelper getDefaultBTPlan(ITMActionContext iTMActionContext) throws Exception {
        if (this.iTMBTPlanHelper != null) {
            return this.iTMBTPlanHelper;
        }
        TMBTPlan tmBTPlan = new TMBTPlan();
        IDEDataCtrl tmBTPlanDataCtrl = iTMActionContext.getDEDataCtrl("TM0160");
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)this.getId());
        String strSQL = "select t1.* from SRFV_TMBTPLAN t1 where t1.TMBTPRJINSTID=? and t1.PTMBTPLANID IS NULL";
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), (Connection)iTMActionContext.getDBConnection(tmBTPlanDataCtrl.GetDEHelper().GetDBStorage()), (String)tmBTPlanDataCtrl.GetDEHelper().GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)tmBTPlan);
        if (callResult.IsError()) {
            if (callResult.getRetCode() == 3 || callResult.getRetCode() == 1003) {
                tmBTPlan.setTMBTPLANNAME(StringHelper.Format((String)"%1$s\u9ed8\u8ba4\u8bd5\u7b97\u8ba1\u5212", (Object)this.getName()));
                tmBTPlan.setTMBTPRJINSTID(this.getId());
                callResult = tmBTPlanDataCtrl.Save(true, (BaseDataEntity)tmBTPlan);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u9ed8\u8ba4\u8bd5\u7b97\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            } else {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u9ed8\u8ba4\u8bd5\u7b97\u8ba1\u5212\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        ITMBTPlanHelper iTMBTPlanHelper = TMObjectFactory.getCurrent().CreateBTPlanHelper(this.iDAGlobalHelper, tmBTPlan);
        iTMBTPlanHelper.CreateDefault(iTMActionContext, this.getBeginTime(), this.getEndTime());
        this.iTMBTPlanHelper = iTMBTPlanHelper;
        return iTMBTPlanHelper;
    }

    @Override
    public Timestamp getBeginTime() throws Exception {
        if (!this.tmBTPRJInst.isBEGINTIMENull()) {
            return this.tmBTPRJInst.getBEGINTIME();
        }
        return this.getBTProject().getBeginTime();
    }

    @Override
    public Timestamp getEndTime() throws Exception {
        if (!this.tmBTPRJInst.isENDTIMENull()) {
            return this.tmBTPRJInst.getENDTIME();
        }
        return this.getBTProject().getEndTime();
    }

    @Override
    public int getAPMainTaskSuccessLoopCnt(int nDefault) {
        if (this.tmBTPRJInst.isMAINTASKSUCCESSLOOPCNTNull()) {
            return nDefault;
        }
        return this.tmBTPRJInst.getMAINTASKSUCCESSLOOPCNT();
    }

    @Override
    public int getAPMainTaskFailedLoopCnt(int nDefault) {
        if (this.tmBTPRJInst.isMAINTASKFAILEDLOOPCNTNull()) {
            return nDefault;
        }
        return this.tmBTPRJInst.getMAINTASKFAILEDLOOPCNT();
    }

    @Override
    public int getAPTaskSuccessLoopCnt(int nDefault) {
        if (this.tmBTPRJInst.isTASKSUCCESSLOOPCNTNull()) {
            return nDefault;
        }
        return this.tmBTPRJInst.getTASKSUCCESSLOOPCNT();
    }

    @Override
    public int getAPTaskFailedLoopCnt(int nDefault) {
        if (this.tmBTPRJInst.isTASKFAILEDLOOPCNTNull()) {
            return nDefault;
        }
        return this.tmBTPRJInst.getTASKFAILEDLOOPCNT();
    }
}
