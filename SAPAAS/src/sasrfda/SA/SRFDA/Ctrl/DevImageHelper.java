/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.DEDataCtrl.IDevImageDataCtrl;
import SA.SRFDA.Ctrl.Data.DevImage;
import SA.SRFDA.Ctrl.Data.DevImgDetail;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DevImageHelper
extends BaseDAGlobalModel {
    protected IDevImageDataCtrl imgDataCtrl = null;
    private static final Log log = LogFactory.getLog(DevImageHelper.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.nRenewTimer = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "DEVIMAGERENEWTIMER", this.nRenewTimer);
        if (this.nRenewTimer < 5000) {
            this.nRenewTimer = 5000;
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11052400) {
            IDEDataCtrl deDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0255", "SYSTEM", null);
            if (deDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0255"));
                return callResult;
            }
            if (!(deDataCtrl instanceof IDevImageDataCtrl)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)"DE0255"));
                return callResult;
            }
            this.imgDataCtrl = (IDevImageDataCtrl)deDataCtrl;
        } else {
            log.warn((Object)StringHelper.Format((String)"\u6a21\u578b\u7248\u672c[%1$s]\u4e0d\u80fd\u6ee1\u8db3\u5206\u7ec4\u7edf\u8ba1\u62a5\u88682\u5bf9\u8c61\u52a0\u8f7d\u8981\u6c42", (Object)this.iDAGlobalHelper.getDAModelVersion()));
        }
        return callResult;
    }

    protected Object GetObject(Object objObjectId) {
        if (this.imgDataCtrl == null) {
            return null;
        }
        DevImage devImage = new DevImage();
        devImage.setDEVIMAGEID((String)objObjectId);
        CallResult callResult = this.imgDataCtrl.Get(devImage);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u56fe\u7247[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return null;
        }
        Vector<DevImgDetail> devImgDetails = new Vector<DevImgDetail>();
        callResult = this.imgDataCtrl.ListDevImgDetails(devImage.getDEVIMAGEID(), devImgDetails);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u56fe\u7247\u89c4\u683c\u660e\u7ec6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return null;
        }
        for (DevImgDetail devImgDetail : devImgDetails) {
            devImage.RegisterDevImgDetail(devImgDetail.getIMAGETYPE(), devImgDetail);
        }
        return devImage;
    }

    protected Boolean TestObjectRenew(Object obj) {
        DevImage devImage = (DevImage)((Object)obj);
        if (this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("DE0255", devImage.getDEVIMAGEID()) != devImage.getVERSION()) {
            return true;
        }
        return false;
    }
}

