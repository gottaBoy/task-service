/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.Data.TMComplexRes;
import SA.TM.Ctrl.Data.TMComplexResDetail;
import SA.TM.Ctrl.ITMComplexResHelper;
import SA.TM.Ctrl.ITMResBaseHelper;
import SA.TM.Ctrl.TMResBaseHelper;
import java.sql.Timestamp;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMComplexResHelper
extends TMResBaseHelper
implements ITMComplexResHelper {
    Vector<TMComplexResDetail> tmComplexResDetails = new Vector();
    protected String strDetailInfo = "";
    protected TMComplexRes tmComplexRes = new TMComplexRes();

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        CallResult callResult = this.getTMModelHelper().GetTMComplexRes(this.tmResBase.getTMRESBASEID(), this.tmComplexRes);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u903b\u8f91\u8d44\u6e90[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.tmComplexRes.getTMCOMPLEXRESID(), (Object)callResult.getErrorInfo()));
        }
        this.OnPrepareComplexResDetails();
    }

    protected void OnPrepareComplexResDetails() throws Exception {
        CallResult callResult = this.getTMModelHelper().GetTMComplexResDetails(this.getId(), this.tmComplexResDetails);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u590d\u5408\u8d44\u6e90\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strResourceInfo = "";
        for (TMComplexResDetail tmComplexResDetail : this.tmComplexResDetails) {
            ITMResBaseHelper iTMResBaseHelper = this.getTMModelStorage().FindTMResource(tmComplexResDetail.getTMRESBASEID());
            if (!StringHelper.IsNullOrEmpty((String)strResourceInfo)) {
                strResourceInfo = String.valueOf(strResourceInfo) + "\u3001";
            }
            strResourceInfo = String.valueOf(strResourceInfo) + iTMResBaseHelper.getDetailInfo();
        }
        this.strDetailInfo = StringHelper.Format((String)"%1$s(%2$s)", (Object)this.getName(), (Object)strResourceInfo);
    }

    @Override
    public boolean isComplexResource() {
        return true;
    }

    @Override
    public Vector<TMComplexResDetail> getComplexResDetails() {
        return this.tmComplexResDetails;
    }

    @Override
    protected boolean OnTestValidTime(Timestamp beginTime, Timestamp endTime) throws Exception {
        for (TMComplexResDetail tmComplexResDetail : this.tmComplexResDetails) {
            ITMResBaseHelper ITMResBaseHelper2 = this.getTMModelStorage().FindTMResource(tmComplexResDetail.getTMRESBASEID());
            if (ITMResBaseHelper2.TestValidTime(beginTime, endTime)) continue;
            return false;
        }
        return true;
    }

    @Override
    protected String OnGetDetailInfo() {
        return this.strDetailInfo;
    }

    @Override
    public String getLogicResType() {
        return this.tmComplexRes.getLOGICRESTYPE();
    }
}

