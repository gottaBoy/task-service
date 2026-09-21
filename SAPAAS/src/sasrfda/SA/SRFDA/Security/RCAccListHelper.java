/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Security;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.RCALDetail;
import SA.SRFDA.Ctrl.Data.RCAccList;
import SA.SRFDA.Security.IRCALDetailHelper;
import SA.SRFDA.Security.IRCAccListHelper;
import SA.SRFDA.Security.RCALDetailHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RCAccListHelper
extends BaseDAObjectHelper
implements IRCAccListHelper {
    private static final Log log = LogFactory.getLog(RCAccListHelper.class);
    protected RCAccList rcAccList = null;
    protected HashMap<String, IRCALDetailHelper> rcALDetailHelperMap = new HashMap();
    protected HashMap<String, Integer> remoteAddrMap = new HashMap();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, RCAccList rcAccList) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.rcAccList = rcAccList;
        this.setId(rcAccList.getRCACCLISTID());
        this.setName(rcAccList.getRCACCLISTNAME());
        this.setVersion(rcAccList.getVERSION());
        String strRemoteAddr = rcAccList.getADDRESSLIST();
        strRemoteAddr = strRemoteAddr.replace("\r\n", ";");
        strRemoteAddr = strRemoteAddr.replace("\r", ";");
        strRemoteAddr = strRemoteAddr.replace("\n", ";");
        if (!StringHelper.IsNullOrEmpty((String)strRemoteAddr)) {
            String[] items = strRemoteAddr.split("[;]");
            int i = 0;
            while (i < items.length) {
                String strAddr = items[i];
                strAddr = strAddr.trim();
                this.remoteAddrMap.put(strAddr, 32);
                ++i;
            }
        }
        this.OnInit();
    }

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.PrepareRCALDetails();
    }

    protected synchronized void PrepareRCALDetails() throws Exception {
        Vector<RCALDetail> rcALDetailList = new Vector<RCALDetail>();
        CallResult callResult = this.getDAModelHelper().GetRCALDetails(this.getId(), rcALDetailList);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8fdc\u7a0b\u8c03\u7528\u63a7\u5236\u5217\u8868[%1$s]\u7b56\u7565\u660e\u7ec6\u53d1\u751f\u9519\u8bef, %2$s", (Object)this.getId(), (Object)callResult.getErrorInfo()));
        }
        for (RCALDetail rcALDetail : rcALDetailList) {
            RCALDetailHelper rcALDetailHelper = new RCALDetailHelper();
            rcALDetailHelper.Init(this.getDAGlobalHelper(), this, rcALDetail);
            this.rcALDetailHelperMap.put(rcALDetailHelper.getDEId(), rcALDetailHelper);
        }
    }

    @Override
    public boolean isValid() {
        return this.rcAccList.getVALIDFLAG();
    }

    @Override
    public boolean TestRemoteCall(String strRemoteAddr, String strDEId, String strAction, String strActionMode, String strArg, String strArg2) throws Exception {
        if (!this.remoteAddrMap.containsKey(strRemoteAddr)) {
            log.warn((Object)StringHelper.Format((String)"\u8fdc\u7a0b\u5730\u5740[%1$s]\u4e0d\u5728\u8fdc\u7a0b\u8c03\u7528\u63a7\u5236\u5217\u8868[%2$s]\u5730\u5740\u5217\u8868\u4e2d", (Object)strRemoteAddr, (Object)this.getId()));
            return false;
        }
        IRCALDetailHelper iRCALDetailHelper = this.rcALDetailHelperMap.get(strDEId);
        if (iRCALDetailHelper == null) {
            log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5728\u8fdc\u7a0b\u8c03\u7528\u63a7\u5236\u5217\u8868[%2$s]\u5b9e\u4f53\u5217\u8868\u4e2d", (Object)strDEId, (Object)this.getId()));
            return false;
        }
        if (!iRCALDetailHelper.TestRemoteCall(strAction, strActionMode, strArg, strArg2)) {
            log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s|%2$s|%3$s]\u4e0d\u5728\u8fdc\u7a0b\u8c03\u7528\u63a7\u5236\u5217\u8868[%4$s]\u6388\u6743\u4e2d", (Object)strDEId, (Object)strAction, (Object)strActionMode, (Object)this.getId()));
            return false;
        }
        return true;
    }
}

