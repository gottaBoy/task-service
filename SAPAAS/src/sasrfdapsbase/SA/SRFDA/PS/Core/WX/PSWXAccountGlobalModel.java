/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.PSWXAccountImpl;
import SA.SRFDA.PS.Data.PSWXAccount;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWXAccountGlobalModel
extends PSSystemGlobalModelBase<String, PSWXAccount, IPSWXAccount> {
    private static final Log log = LogFactory.getLog(PSWXAccountGlobalModel.class);

    @Override
    protected PSWXAccount GetObject(String strPSWXAccountId) {
        PSWXAccount psWXAccount = new PSWXAccount();
        CallResult callResult = this.iPSModelHelper.getPSWXAccount(strPSWXAccountId, psWXAccount);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5fae\u4fe1\u516c\u4f17\u53f7[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWXAccountId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psWXAccount;
    }

    @Override
    protected IPSWXAccount OnCreateModelHelper(PSWXAccount vt) throws Exception {
        PSWXAccountImpl iPSWXAccount = null;
        iPSWXAccount = new PSWXAccountImpl();
        iPSWXAccount.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSWXAccount;
    }

    @Override
    protected Boolean TestObjectRenew(PSWXAccount obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSWXAccount registerModel(PSWXAccount vt) throws Exception {
        IPSWXAccount iIPSWXAccount = (IPSWXAccount)this.InternalGetModelHelper(vt.getPSWXACCOUNTID());
        if (iIPSWXAccount != null) {
            return iIPSWXAccount;
        }
        this.setModel(vt.getPSWXACCOUNTID(), vt, null);
        return (IPSWXAccount)this.FindModelHelper(vt.getPSWXACCOUNTID());
    }

    @Override
    protected Vector<PSWXAccount> getAllModels() throws Exception {
        Vector<PSWXAccount> list = new Vector<PSWXAccount>();
        CallResult callResult = this.iPSModelHelper.getAllPSWXAccounts(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5fae\u4fe1\u516c\u4f17\u53f7\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSWXAccount vt) {
        return vt.getPSWXACCOUNTID();
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSWXAccount vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

