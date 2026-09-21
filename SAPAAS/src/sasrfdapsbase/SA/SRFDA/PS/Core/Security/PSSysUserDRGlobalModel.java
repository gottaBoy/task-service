/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Security;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Security.IPSSysUserDR;
import SA.SRFDA.PS.Core.Security.PSSysUserDRImpl;
import SA.SRFDA.PS.Data.PSSysUserDR;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUserDRGlobalModel
extends PSSystemGlobalModelBase<String, PSSysUserDR, IPSSysUserDR> {
    private static final Log log = LogFactory.getLog(PSSysUserDRGlobalModel.class);

    @Override
    protected PSSysUserDR GetObject(String strPSSysUserDRId) {
        PSSysUserDR psSysUserDR = new PSSysUserDR();
        CallResult callResult = this.iPSModelHelper.getPSSysUserDR(strPSSysUserDRId, psSysUserDR);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u7528\u6237\u81ea\u5b9a\u4e49\u6743\u9650\u6570\u636e\u8303\u56f4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysUserDRId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysUserDR;
    }

    @Override
    protected IPSSysUserDR OnCreateModelHelper(PSSysUserDR vt) throws Exception {
        PSSysUserDRImpl iPSSysUserDR = null;
        iPSSysUserDR = new PSSysUserDRImpl();
        iPSSysUserDR.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysUserDR;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysUserDR obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysUserDR registerModel(PSSysUserDR vt) throws Exception {
        IPSSysUserDR iIPSSysUserDR = (IPSSysUserDR)this.InternalGetModelHelper(vt.getPSSYSUSERDRID());
        if (iIPSSysUserDR != null) {
            return iIPSSysUserDR;
        }
        this.setModel(vt.getPSSYSUSERDRID(), vt, null);
        return (IPSSysUserDR)this.FindModelHelper(vt.getPSSYSUSERDRID());
    }

    @Override
    protected Vector<PSSysUserDR> getAllModels() throws Exception {
        Vector<PSSysUserDR> list = new Vector<PSSysUserDR>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysUserDRs(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u7528\u6237\u81ea\u5b9a\u4e49\u6743\u9650\u6570\u636e\u8303\u56f4\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysUserDR vt) {
        return vt.getPSSYSUSERDRID();
    }

    @Override
    protected void onPreloadModels() {
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

    protected String[] getObjectAliases(PSSysUserDR vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getUSERDRTAG())) {
            return new String[]{vt.getUSERDRTAG().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

