/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.DefaultTransactionManager
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.DefaultTransactionManager;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.BaseTMMainTaskViewActionHelper;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.ITMTaskBaseHelper;
import SA.TM.Ctrl.ITMUserSessionStorage;
import SA.TM.Ctrl.TMMainTaskViewEditData;
import SA.TM.Ctrl.TMUSSFactory;
import SA.TM.Web.TMActionResult;
import SA.TM.Web.TMWebCTXHelper;
import java.util.Vector;
import net.sf.json.JSONObject;

public class TMMainTaskViewActionHelper
extends BaseTMMainTaskViewActionHelper {
    protected TMActionResult OnFetch() throws Exception {
        TMActionResult tmActionResult = new TMActionResult();
        String strTMMainTaskViewEditData = TMWebCTXHelper.getTMMainTaskViewEditData((ISRFDAWebContext)this.getWebContext());
        if (!StringHelper.IsNullOrEmpty((String)strTMMainTaskViewEditData)) {
            TMMainTaskViewEditData tmMainTaskViewEditData = new TMMainTaskViewEditData(strTMMainTaskViewEditData);
            IDEDataCtrl tmTaskBaseDataCtrl = this.getPage().getDAModelStorage().FindDEDataCtrl2("TM0050", (ISRFDAWebContext)this.getWebContext());
            TMTaskBase tmTaskBase = new TMTaskBase();
            tmTaskBase.setTMTASKBASEID(tmMainTaskViewEditData.getTMTaskBaseId());
            CallResult callResult = tmTaskBaseDataCtrl.Get((BaseDataEntity)tmTaskBase);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4efb\u52a1\u4fe1\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            DERINDEX derIndex = tmTaskBaseDataCtrl.GetDEHelper().FindDERINDEX(tmTaskBase.getTMTASKBASETYPE());
            IDEDataCtrl tmTaskRealDataCtrl = this.getPage().getDAModelStorage().FindDEDataCtrl2(derIndex.getDEID(), (ISRFDAWebContext)this.getWebContext());
            DefaultTransactionManager transactionManager = new DefaultTransactionManager();
            transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
            transactionManager.Register(tmTaskRealDataCtrl);
            tmTaskBase.Reset();
            tmTaskBase.SetParamValue(tmTaskRealDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), tmMainTaskViewEditData.getTMTaskBaseId());
            tmTaskBase.setBEGINTIME(tmMainTaskViewEditData.getBeginTime());
            tmTaskBase.setENDTIME(tmMainTaskViewEditData.getEndTime());
            callResult = tmTaskRealDataCtrl.Save(false, (BaseDataEntity)tmTaskBase);
            if (callResult.IsError()) {
                transactionManager.Rollback();
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u4efb\u52a1\u65f6\u95f4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            transactionManager.Commit();
        }
        String strSQL = "select t1.*,t2.TMTASKTYPENAME,t2.LEAFTASK from SRFV_TMTASKBASE t1  LEFT JOIN SRFT_TMTASKTYPE_BASE t2 on t1.TMTASKBASETYPE=t2.TMTASKTYPEID where t1.ROOTTMTASKBASEID=? ";
        IDEHelper tmTaskBaseDEHelper = this.getPage().getDAModelStorage().FindDEHelper2("TM0050");
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)this.getTMMainTask().getId());
        Vector tmTaskBases = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), null, (String)tmTaskBaseDEHelper.GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), tmTaskBases, (String)TMTaskBase.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4efb\u52a1\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        ITMUserSessionStorage iTMUserSessionStorage = TMUSSFactory.GetCurrentUSS((ISRFDAWebContext)this.getWebContext());
        Vector<JSONObject> items = new Vector<JSONObject>();
        for (TMTaskBase tmTaskBase : tmTaskBases) {
            ITMTaskBaseHelper iTMTaskBaseHelper = iTMUserSessionStorage.FindTMTask(tmTaskBase.getTMTASKBASEID(), tmTaskBase.getVERSION());
            BaseDataEntity taskSummaryInfo = iTMTaskBaseHelper.getSummaryInfo();
            if (taskSummaryInfo != null) {
                taskSummaryInfo.CopyTo((BaseDataEntity)tmTaskBase, false);
            }
            JSONObject jo = new JSONObject();
            tmTaskBase.FillJSONObject(jo, false);
            items.add(jo);
        }
        tmActionResult.setItems(items);
        return tmActionResult;
    }
}

