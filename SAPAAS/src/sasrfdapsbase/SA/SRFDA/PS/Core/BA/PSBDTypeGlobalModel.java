/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSBDType;
import SA.SRFDA.PS.Core.BA.PSBDTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSBDType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSBDTypeGlobalModel
extends PSGlobalModelBase<String, PSBDType, IPSBDType> {
    private static final Log log = LogFactory.getLog(PSBDTypeGlobalModel.class);

    @Override
    protected PSBDType GetObject(String strPSBDTypeId) {
        PSBDType psBDType = new PSBDType();
        CallResult callResult = this.iPSModelHelper.getPSBDType(strPSBDTypeId, psBDType);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5927\u6570\u636e\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSBDTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psBDType;
    }

    @Override
    protected IPSBDType OnCreateModelHelper(PSBDType vt) throws Exception {
        PSBDTypeImpl iPSBDType = new PSBDTypeImpl();
        iPSBDType.init(this.iDAGlobalHelper, vt);
        return iPSBDType;
    }

    @Override
    protected Boolean TestObjectRenew(PSBDType obj) {
        return false;
    }

    @Override
    protected IPSBDType registerModel(PSBDType vt) throws Exception {
        IPSBDType iPSBDType = (IPSBDType)this.InternalGetModelHelper(vt.getPSBDTYPEID());
        if (iPSBDType != null) {
            return iPSBDType;
        }
        this.setModel(vt.getPSBDTYPEID(), vt, null);
        iPSBDType = (IPSBDType)this.FindModelHelper(vt.getPSBDTYPEID());
        return iPSBDType;
    }

    @Override
    protected String getObjectId(PSBDType vt) {
        return vt.getPSBDTYPEID();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

