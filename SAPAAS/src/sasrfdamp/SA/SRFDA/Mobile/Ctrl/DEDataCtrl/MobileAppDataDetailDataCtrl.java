/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.MobileAppDataDetail
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Mobile.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.MobileAppDataDetail;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MobileAppDataDetailDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(MobileAppDataDetailDataCtrl.class);

    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        if (bInsert) {
            try {
                MobileAppDataDetail mobileAppDataDetail = new MobileAppDataDetail();
                mobileAppDataDetail.Proxy(dataEntity);
                if (StringHelper.IsNullOrEmpty((String)mobileAppDataDetail.getMOBAPPDATADETAILNAME())) {
                    IDEDataCtrl relatedDataCtrl = this.GetRelatedDataCtrl(mobileAppDataDetail.getDEID());
                    BaseDataEntity data = new BaseDataEntity();
                    data.SetParamValue(relatedDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), relatedDataCtrl.GetDEHelper().GetKeyDEFHelper().GetDEFValue(mobileAppDataDetail.getDATAID()));
                    callResult = relatedDataCtrl.Get(data);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s][%2$s]\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)mobileAppDataDetail.getDEID(), (Object)mobileAppDataDetail.getDATAID(), (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                    String strDataInfo = relatedDataCtrl.GetDEHelper().GetDataInfo(data);
                    mobileAppDataDetail.setMOBAPPDATADETAILNAME(strDataInfo);
                }
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u4e4b\u524d\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                return callResult;
            }
        }
        return callResult;
    }
}

