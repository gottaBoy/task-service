/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.Data.TMBTPRJ;
import SA.TM.Ctrl.Data.TMBTPRJInst;
import SA.TM.Ctrl.Data.TMBTPRJMT;
import java.util.Date;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMBTPRJDataCtrl
extends BaseDEDataCtrl {
    public static final String CUSTOMCALL_CREATEPRJINST = "CREATEPRJINST";

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CREATEPRJINST, (boolean)true) == 0) {
            return this.CreateBTPrjInst(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult CreateBTPrjInst(BaseDataEntity dataEntity) {
        try {
            return this.OnCreateBTPrjInst(dataEntity);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
    }

    protected CallResult OnCreateBTPrjInst(BaseDataEntity dataEntity) throws Exception {
        TMBTPRJ tmBTPRJ = new TMBTPRJ();
        tmBTPRJ.Proxy(dataEntity);
        CallResult callResult = this.Get(tmBTPRJ);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8bd5\u7b97\u9879\u76ee\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("TMBTPRJID", (Object)tmBTPRJ.getTMBTPRJID());
        IDEDataCtrl tmBTPRJMTDataCtrl = this.GetRelatedDataCtrl("TM0144");
        Vector<TMBTPRJMT> tmBTPRJMTs = new Vector<TMBTPRJMT>();
        callResult = tmBTPRJMTDataCtrl.Select(cond, tmBTPRJMTs, TMBTPRJMT.class.getName(), " ORDER BY ORDERFLAG ASC");
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8bd5\u7b97\u9879\u76ee\u4e3b\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        TMBTPRJInst tmBTPRJInst = new TMBTPRJInst();
        tmBTPRJ.CopyTo(tmBTPRJInst, true);
        tmBTPRJInst.setTMBTPRJINSTNAME(String.valueOf(tmBTPRJ.getTMBTPRJNAME()) + StringHelper.Format((String)"_%1$tm%1$td_%1$tH%1$tM", (Object)new Date()));
        IDEDataCtrl tmBTPRJInstDataCtrl = this.GetRelatedDataCtrl("TM0147");
        callResult = tmBTPRJInstDataCtrl.Save(true, (BaseDataEntity)tmBTPRJInst);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8bd5\u7b97\u9879\u76ee\u4e3b\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return this.CreateBTMaskTaskInsts(tmBTPRJInst, tmBTPRJMTs);
    }

    protected CallResult CreateBTMaskTaskInsts(TMBTPRJInst tmBTPRJInst, Vector<TMBTPRJMT> tmBTPRJMTs) throws Exception {
        return this.OnCreateBTMaskTaskInsts(tmBTPRJInst, tmBTPRJMTs);
    }

    protected CallResult OnCreateBTMaskTaskInsts(TMBTPRJInst tmBTPRJInst, Vector<TMBTPRJMT> tmBTPRJMTs) throws Exception {
        return new CallResult();
    }
}

