/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultDAGlobalModel
extends BaseDAGlobalModel {
    private static final Log log = LogFactory.getLog(DefaultDAGlobalModel.class);
    protected IDEDataCtrl iDataCtrl = null;
    protected String strKeyField = "";
    protected String strVersionField = "";
    protected String strObjectName = "";

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IDEHelper iDEHelper) {
        CallResult callResult = super.Init(iDAGlobalHelper);
        if (callResult.IsError()) {
            return callResult;
        }
        this.iDataCtrl = iDEHelper.GetDEDataCtrl("SYSTEM", null);
        if (this.iDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)iDEHelper.getId()));
            return callResult;
        }
        this.strKeyField = iDEHelper.GetKeyDEFHelper().getName();
        this.strObjectName = iDEHelper.getDataEntity().getDEOBJECT();
        this.strVersionField = iDEHelper.getDataEntity().getVERFIELD();
        if (iDEHelper.getDataEntity().getVERCHECKTIMER() > 0) {
            this.nRenewTimer = iDEHelper.getDataEntity().getVERCHECKTIMER() * 1000;
        }
        if (StringHelper.IsNullOrEmpty((String)this.strVersionField)) {
            log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u5c5e\u6027\uff0c\u65e0\u6cd5\u8fdb\u884c\u7248\u672c\u6bd4\u8f83", (Object)iDEHelper.getId()));
        }
        return callResult;
    }

    protected Object GetObject(Object objObjectId) {
        BaseDataEntity dataEntity = null;
        dataEntity = !StringHelper.IsNullOrEmpty((String)this.strObjectName) ? (BaseDataEntity)ObjectHelper.Create((String)this.strObjectName) : new BaseDataEntity();
        dataEntity.SetParamValue(this.strKeyField, objObjectId);
        CallResult callResult = this.iDataCtrl.Get(dataEntity);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s],%3$s", (Object)this.iDataCtrl.GetDEHelper().getId(), (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return dataEntity;
    }

    protected Boolean TestObjectRenew(Object obj) {
        if (StringHelper.IsNullOrEmpty((String)this.strVersionField)) {
            return false;
        }
        BaseDataEntity dataEntity = (BaseDataEntity)obj;
        int nVersion = dataEntity.GetParamIntValue(this.strVersionField, 1);
        if (this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion(this.iDataCtrl.GetDEHelper().getId(), dataEntity.GetParamStringValue(this.strKeyField, "")) != nVersion) {
            return true;
        }
        return false;
    }
}

