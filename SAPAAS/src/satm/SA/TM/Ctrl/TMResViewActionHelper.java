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
import SA.TM.Ctrl.BaseTMResViewActionHelper;
import SA.TM.Ctrl.Data.TMResBooking;
import SA.TM.Ctrl.Data.TMResView;
import SA.TM.Ctrl.Data.TMResViewDetail;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.Data.TMTaskRes;
import SA.TM.Ctrl.ITMModelStorage;
import SA.TM.Ctrl.ITMResBTHelper;
import SA.TM.Ctrl.ITMTaskBaseHelper;
import SA.TM.Ctrl.ITMUserSessionStorage;
import SA.TM.Ctrl.TMResViewEditData;
import SA.TM.Ctrl.TMResViewFilter;
import SA.TM.Ctrl.TMResViewSaveParam;
import SA.TM.Ctrl.TMUSSFactory;
import SA.TM.Web.TMActionResult;
import SA.TM.Web.TMWebCTXHelper;
import java.util.Vector;
import net.sf.json.JSONObject;

public class TMResViewActionHelper
extends BaseTMResViewActionHelper {
    protected TMActionResult OnFetch() throws Exception {
        TMActionResult tmActionResult = new TMActionResult();
        String strTMResViewFilter = TMWebCTXHelper.getTMResViewActionParam((ISRFDAWebContext)this.getWebContext());
        TMResViewFilter tmResViewFilter = new TMResViewFilter(strTMResViewFilter);
        ITMModelStorage iTMModelStorage = this.getTMModelStorage();
        String strTMResViewEditData = TMWebCTXHelper.getTMResViewEditData((ISRFDAWebContext)this.getWebContext());
        if (!StringHelper.IsNullOrEmpty((String)strTMResViewEditData)) {
            TMResViewEditData tmResViewEditData = new TMResViewEditData(strTMResViewEditData);
            IDEDataCtrl tmResBookingDataCtrl = this.getPage().getDAModelStorage().FindDEDataCtrl2("TM0110", (ISRFDAWebContext)this.getWebContext());
            TMResBooking tmResBooking = new TMResBooking();
            tmResBooking.setTMRESBOOKINGID(tmResViewEditData.getTMResBookingId());
            CallResult callResult = tmResBookingDataCtrl.Get((BaseDataEntity)tmResBooking);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u9884\u7ea6\u4fe1\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (StringHelper.Compare((String)tmResViewEditData.getAction(), (String)"EDIT", (boolean)true) == 0) {
                ITMResBTHelper iTMResBTHelper = iTMModelStorage.FindTMResBT(tmResBooking.getTMRESBOOKINGTYPE());
                if (iTMResBTHelper.isEnableUserCreate()) {
                    DERINDEX derIndex = tmResBookingDataCtrl.GetDEHelper().FindDERINDEX(tmResBooking.getTMRESBOOKINGTYPE());
                    IDEDataCtrl tmBKRealDataCtrl = this.getPage().getDAModelStorage().FindDEDataCtrl2(derIndex.getDEID(), (ISRFDAWebContext)this.getWebContext());
                    DefaultTransactionManager transactionManager = new DefaultTransactionManager();
                    transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
                    transactionManager.Register(tmBKRealDataCtrl);
                    TMResBooking tmResBooking2 = new TMResBooking();
                    tmResBooking2.SetParamValue(tmBKRealDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), tmResBooking.getTMRESBOOKINGID());
                    tmResBooking2.setBEGINTIME(tmResViewEditData.getBeginTime());
                    tmResBooking2.setENDTIME(tmResViewEditData.getEndTime());
                    callResult = tmBKRealDataCtrl.Save(false, (BaseDataEntity)tmResBooking2);
                    if (callResult.IsError()) {
                        transactionManager.Rollback();
                        throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u9884\u7ea6\u65f6\u95f4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    transactionManager.Commit();
                } else if (StringHelper.Compare((String)tmResBooking.getTMRESBOOKINGTYPE(), (String)"TASKRESBOOKING", (boolean)true) == 0) {
                    boolean bModifyTaskTime = true;
                    if (!StringHelper.IsNullOrEmpty((String)tmResBooking.getUSERTAG())) {
                        IDEDataCtrl tmTaskResDataCtrl = this.getPage().getDAModelStorage().FindDEDataCtrl2("TM0115", (ISRFDAWebContext)this.getWebContext());
                        TMTaskRes tmTaskRes = new TMTaskRes();
                        tmTaskRes.setTMTASKRESID(tmResBooking.getUSERTAG());
                        callResult = tmTaskResDataCtrl.Get((BaseDataEntity)tmTaskRes);
                        if (callResult.IsError()) {
                            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4efb\u52a1\u8d44\u6e90\u4fe1\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        if (tmTaskRes.getCUSTOMTRTIME()) {
                            bModifyTaskTime = false;
                            DefaultTransactionManager transactionManager = new DefaultTransactionManager();
                            transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
                            transactionManager.Register(tmTaskResDataCtrl);
                            long nMin = tmResViewEditData.getEndTime().getTime() - tmResViewEditData.getBeginTime().getTime();
                            tmTaskRes.setBEGINTIME(tmResViewEditData.getBeginTime());
                            tmTaskRes.setDURATION((int)(nMin /= 60000L));
                            callResult = tmTaskResDataCtrl.Save(false, (BaseDataEntity)tmTaskRes);
                            if (callResult.IsError()) {
                                transactionManager.Rollback();
                                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u4efb\u52a1\u8d44\u6e90\u65f6\u95f4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                            }
                            transactionManager.Commit();
                        }
                    }
                    if (bModifyTaskTime) {
                        IDEDataCtrl tmTaskBaseDataCtrl = this.getPage().getDAModelStorage().FindDEDataCtrl2("TM0050", (ISRFDAWebContext)this.getWebContext());
                        TMTaskBase tmTaskBase = new TMTaskBase();
                        tmTaskBase.setTMTASKBASEID(tmResBooking.getTMTASKBASEID());
                        callResult = tmTaskBaseDataCtrl.Get((BaseDataEntity)tmTaskBase);
                        if (callResult.IsError()) {
                            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4efb\u52a1\u4fe1\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        DERINDEX derIndex = tmTaskBaseDataCtrl.GetDEHelper().FindDERINDEX(tmTaskBase.getTMTASKBASETYPE());
                        IDEDataCtrl tmTaskRealDataCtrl = this.getPage().getDAModelStorage().FindDEDataCtrl2(derIndex.getDEID(), (ISRFDAWebContext)this.getWebContext());
                        DefaultTransactionManager transactionManager = new DefaultTransactionManager();
                        transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
                        transactionManager.Register(tmTaskRealDataCtrl);
                        tmTaskBase.Reset();
                        tmTaskBase.SetParamValue(tmTaskRealDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), tmResBooking.getTMTASKBASEID());
                        tmTaskBase.setBEGINTIME(tmResViewEditData.getBeginTime());
                        tmTaskBase.setENDTIME(tmResViewEditData.getEndTime());
                        callResult = tmTaskRealDataCtrl.Save(false, (BaseDataEntity)tmTaskBase);
                        if (callResult.IsError()) {
                            transactionManager.Rollback();
                            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u4efb\u52a1\u65f6\u95f4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        transactionManager.Commit();
                    }
                }
            }
        }
        String[] resources = tmResViewFilter.getResources().split("[;]");
        String strSQL = "select t1.* from SRFV_TMRESBOOKING t1 where t1.ENDTIME>? AND t1.BEGINTIME<?    ";
        String strResCond = "";
        int i = 0;
        while (i < resources.length) {
            if (i != 0) {
                strResCond = String.valueOf(strResCond) + " OR ";
            }
            strResCond = String.valueOf(strResCond) + StringHelper.Format((String)"t1.TMRESBASEID='%1$s'", (Object)resources[i]);
            ++i;
        }
        if (!StringHelper.IsNullOrEmpty((String)strResCond)) {
            strSQL = String.valueOf(strSQL) + " AND (" + strResCond + ")";
        }
        IDEHelper tmResBookingDEHelper = this.getPage().getDAModelStorage().FindDEHelper2("TM0110");
        CallParamList callParamList = new CallParamList();
        callParamList.AddDateTime((Object)tmResViewFilter.getBeginTime());
        callParamList.AddDateTime((Object)tmResViewFilter.getEndTime());
        Vector tmResBookings = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), null, (String)tmResBookingDEHelper.GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), tmResBookings, (String)TMResBooking.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8d44\u6e90\u9884\u7ea6\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        ITMUserSessionStorage iTMUserSessionStorage = TMUSSFactory.GetCurrentUSS((ISRFDAWebContext)this.getWebContext());
        Vector<JSONObject> items = new Vector<JSONObject>();
        for (TMResBooking tmResBooking : tmResBookings) {
            ITMTaskBaseHelper iTMTaskBaseHelper;
            BaseDataEntity taskSummaryInfo;
            if (StringHelper.IsNullOrEmpty((String)tmResBooking.getBKTHEME())) {
                ITMResBTHelper iTMResBTHelper = iTMModelStorage.FindTMResBT(tmResBooking.getTMRESBOOKINGTYPE());
                tmResBooking.setBKTHEME(iTMResBTHelper.getBKTheme());
            }
            if (!StringHelper.IsNullOrEmpty((String)tmResBooking.getTMTASKBASEID()) && (taskSummaryInfo = (iTMTaskBaseHelper = iTMUserSessionStorage.FindTMTask(tmResBooking.getTMTASKBASEID(), tmResBooking.getTASKVERION())).getSummaryInfo()) != null) {
                taskSummaryInfo.CopyTo((BaseDataEntity)tmResBooking, false);
            }
            JSONObject jo = new JSONObject();
            tmResBooking.FillJSONObject(jo, false);
            items.add(jo);
        }
        tmActionResult.setItems(items);
        return tmActionResult;
    }

    protected TMActionResult OnSaveResView() throws Exception {
        TMActionResult tmActionResult = new TMActionResult();
        String strTMResViewSaveParam = TMWebCTXHelper.getTMResViewActionParam((ISRFDAWebContext)this.getWebContext());
        TMResViewSaveParam tmResViewSaveParam = new TMResViewSaveParam(strTMResViewSaveParam);
        String[] resources = null;
        if (!StringHelper.IsNullOrEmpty((String)tmResViewSaveParam.getResources())) {
            resources = tmResViewSaveParam.getResources().split("[;]");
        }
        DefaultTransactionManager transactionManager = new DefaultTransactionManager();
        transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        try {
            IDEDataCtrl tmResViewDataCtrl = this.getPage().getDEDataCtrl2("TM0200");
            transactionManager.Register(tmResViewDataCtrl);
            IDEDataCtrl tmResViewDetailDataCtrl = tmResViewDataCtrl.GetRelatedDataCtrl("TM0201");
            BaseDataEntity cond = new BaseDataEntity();
            cond.SetParamValue("TMRESVIEWID", (Object)this.getTMResView().getId());
            Vector tmResViewDetails = new Vector();
            CallResult callResult = tmResViewDetailDataCtrl.Select(cond, tmResViewDetails, TMResViewDetail.class.getName());
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8d44\u6e90\u89c6\u56fe\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (TMResViewDetail tmResViewDetail : tmResViewDetails) {
                callResult = tmResViewDetailDataCtrl.Remove((BaseDataEntity)tmResViewDetail);
                if (!callResult.IsError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5220\u9664\u8d44\u6e90\u89c6\u56fe\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (resources != null) {
                int i = 0;
                while (i < resources.length) {
                    TMResViewDetail tmResViewDetail = new TMResViewDetail();
                    tmResViewDetail.setTMRESBASEID(resources[i]);
                    tmResViewDetail.setTMRESVIEWID(this.getTMResView().getId());
                    callResult = tmResViewDetailDataCtrl.Save(true, (BaseDataEntity)tmResViewDetail);
                    if (callResult.IsError()) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8d44\u6e90\u89c6\u56fe\u660e\u7ec6\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    ++i;
                }
            }
            TMResView tmResView = new TMResView();
            tmResView.setTMRESVIEWID(this.getTMResView().getId());
            tmResViewDataCtrl.Save(false, (BaseDataEntity)tmResView);
            transactionManager.Commit();
        }
        catch (Exception ex) {
            transactionManager.Rollback();
            throw ex;
        }
        return tmActionResult;
    }
}

