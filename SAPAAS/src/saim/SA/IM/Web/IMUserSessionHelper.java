/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.http.HttpServletRequest
 */
package SA.IM.Web;

import SA.IM.Ctrl.Data.IMUserSession;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;

public class IMUserSessionHelper {
    public static final String IMUSERSESSIONID = "SRFIMUSERSESSIONID";

    public String getIMUserId(ISRFDAGlobalHelper iDAGlobalHelper, HttpServletRequest request) throws Exception {
        String strIMUserSessionId = request.getParameter(IMUSERSESSIONID);
        if (StringHelper.IsNullOrEmpty((String)strIMUserSessionId)) {
            return "";
        }
        return this.getIMUserId(iDAGlobalHelper, request, strIMUserSessionId);
    }

    public String getIMUserId(ISRFDAGlobalHelper iDAGlobalHelper, HttpServletRequest request, String strIMUserSessionId) throws Exception {
        String strSQL = this.OnGetIMUserSessionSQL();
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strIMUserSessionId);
        IMUserSession imUserSession = new IMUserSession();
        CallResult callResult = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)iDAGlobalHelper, (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)imUserSession);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2IM\u7528\u6237\u4f1a\u8bdd\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strRemoteAddr = request.getRemoteAddr();
        if (StringHelper.Compare((String)strRemoteAddr, (String)imUserSession.getREMOTEADDR(), (boolean)false) != 0) {
            throw new Exception(StringHelper.Format((String)"IM\u7528\u6237\u4f1a\u8bdd\u5730\u5740\u4e0d\u4e00\u81f4"));
        }
        return imUserSession.getIMUSERID();
    }

    protected String OnGetIMUserSessionSQL() {
        return "SELECT * FROM SRFT_IMUSERSESSION_BASE WHERE LOGOUTTIME IS NULL AND IMUSERSESSIONID = ? ";
    }
}

