/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAGlobalModel
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.PS.Core.Control.Form.IPSFormDetailType;
import SA.SRFDA.PS.Core.Control.Form.PSFormDetailTypeImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSFormDetailType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFormDetailTypeGlobalModel
extends BaseDAGlobalModel<String, PSFormDetailType, IPSFormDetailType> {
    private static final Log log = LogFactory.getLog(PSFormDetailTypeGlobalModel.class);
    protected IPSModelHelper iPSModelHelper = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iPSModelHelper = PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, null);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u5b9e\u4f53\u8868\u5355\u6210\u5458\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected PSFormDetailType GetObject(String strPSFormDetailTypeId) {
        PSFormDetailType PSFormDetailType2 = new PSFormDetailType();
        CallResult callResult = this.iPSModelHelper.getPSFormDetailType(strPSFormDetailTypeId, PSFormDetailType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u8868\u5355\u6210\u5458\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSFormDetailTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSFormDetailType2;
    }

    protected IPSFormDetailType OnCreateModelHelper(PSFormDetailType vt) throws Exception {
        IPSFormDetailType iPSFormDetailType = null;
        iPSFormDetailType = StringHelper.IsNullOrEmpty((String)vt.getTYPEOBJ()) ? new PSFormDetailTypeImpl() : (IPSFormDetailType)ObjectHelper.Create((String)vt.getTYPEOBJ());
        if (iPSFormDetailType == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u6210\u5458\u7c7b\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)vt.getPSFORMDETAILTYPEID()));
        }
        iPSFormDetailType.init(this.iDAGlobalHelper, vt);
        return iPSFormDetailType;
    }

    protected Boolean TestObjectRenew(PSFormDetailType obj) {
        return false;
    }
}

