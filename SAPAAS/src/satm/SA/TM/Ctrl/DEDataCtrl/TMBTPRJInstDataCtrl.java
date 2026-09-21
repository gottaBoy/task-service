/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.TM.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.Data.TMBTPRJInst;
import SA.TM.Ctrl.Data.TMBookingTest;
import SA.TM.Ctrl.ITMBTMainTaskInstHelper;
import SA.TM.Ctrl.ITMModelStorage;
import SA.TM.Ctrl.TMActionContext;
import SA.TM.Ctrl.TMModelStorageFactory;
import SA.TM.Ctrl.TMObjectFactory;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TMBTPRJInstDataCtrl
extends BaseDEDataCtrl {
    public static final String CUSTOMCALL_EXTRACTMAINTASK = "EXTRACTMAINTASK";
    public static final String CUSTOMCALL_BOOKINGTEST = "BOOKINGTEST";
    public static final String CUSTOMCALL_CANCELBOOKINGTEST = "CANCELBOOKINGTEST";
    private static final Log log = LogFactory.getLog(TMBTPRJInstDataCtrl.class);

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_EXTRACTMAINTASK, (boolean)true) == 0) {
            return this.ExtractMainTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_BOOKINGTEST, (boolean)true) == 0) {
            return this.BookingTest(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CANCELBOOKINGTEST, (boolean)true) == 0) {
            return this.CancelBookingTest(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult ExtractMainTask(BaseDataEntity dataEntity) {
        try {
            return this.OnExtractMainTask(dataEntity);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
    }

    protected CallResult OnExtractMainTask(BaseDataEntity dataEntity) throws Exception {
        TMBTPRJInst tmBTPRJInst = new TMBTPRJInst();
        tmBTPRJInst.Proxy(dataEntity);
        CallResult callResult = this.Get(tmBTPRJInst);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8bd5\u7b97\u9879\u76ee\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("TMBTPRJINSTID", (Object)tmBTPRJInst.getTMBTPRJINSTID());
        IDEDataCtrl tmBookingTestDataCtrl = this.GetRelatedDataCtrl("TM0150");
        Vector tmBookingTests = new Vector();
        callResult = tmBookingTestDataCtrl.Select(cond, tmBookingTests, TMBookingTest.class.getName(), " ORDER BY ORDERFLAG ASC");
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8bd5\u7b97\u9879\u76ee\u4e3b\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        TMActionContext tmActionContext = new TMActionContext();
        tmActionContext.Init(this.globalHelperEx, (IDEDataCtrl)this);
        for (TMBookingTest tmBookingTest : tmBookingTests) {
            ITMBTMainTaskInstHelper iTMBTMainTaskInstHelper = TMObjectFactory.getCurrent().CreateBTMainTaskInstHelper(this.globalHelperEx, tmBookingTest);
            if (iTMBTMainTaskInstHelper.isExtracted()) continue;
            iTMBTMainTaskInstHelper.ExtractBTTaskInsts(tmActionContext);
        }
        return callResult;
    }

    public CallResult BookingTest(BaseDataEntity dataEntity) {
        try {
            return this.OnBookingTest(dataEntity);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
    }

    protected CallResult OnBookingTest(BaseDataEntity dataEntity) throws Exception {
        TMBTPRJInst tmBTPRJInst = new TMBTPRJInst();
        tmBTPRJInst.Proxy(dataEntity);
        ITMModelStorage iTMModelStorage = TMModelStorageFactory.Create(this.getGlobalHelper());
        iTMModelStorage.RunTMBTPrjInst(tmBTPRJInst.getTMBTPRJINSTID());
        return new CallResult();
    }

    public CallResult CancelBookingTest(BaseDataEntity dataEntity) {
        try {
            return this.OnCancelBookingTest(dataEntity);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
    }

    protected CallResult OnCancelBookingTest(BaseDataEntity dataEntity) throws Exception {
        TMBTPRJInst tmBTPRJInst = new TMBTPRJInst();
        tmBTPRJInst.Proxy(dataEntity);
        ITMModelStorage iTMModelStorage = TMModelStorageFactory.Create(this.getGlobalHelper());
        iTMModelStorage.CancelRunTMBTPrjInst(tmBTPRJInst.getTMBTPRJINSTID());
        return new CallResult();
    }
}

