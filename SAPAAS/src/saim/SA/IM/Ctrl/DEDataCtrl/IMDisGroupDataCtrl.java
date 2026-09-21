/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl.DEDataCtrl;

import SA.IM.Ctrl.DEDataCtrl.IMDEDataCtrl;
import SA.IM.Ctrl.Data.IMDisGroup;
import SA.IM.Ctrl.Data.IMMeeting;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMDisGroupDataCtrl
extends IMDEDataCtrl {
    private static final Log log = LogFactory.getLog(IMDisGroupDataCtrl.class);

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        IMDisGroup imDisGroup = new IMDisGroup();
        imDisGroup.Proxy(dataEntity);
        try {
            IMMeeting imMeeting = new IMMeeting();
            imMeeting.setIMMEETINGID(imDisGroup.getIMDISGROUPID());
            imMeeting.setIMMEETINGNAME(imDisGroup.getIMDISGROUPNAME());
            imMeeting.setMEETINGTYPE(2);
            imMeeting.setIMUSERIDS(imDisGroup.getIMDISGROUPID());
            IDEDataCtrl imMeetingDataCtrl = this.GetRelatedDataCtrl("IM0080");
            callResult = imMeetingDataCtrl.AutoSave((BaseDataEntity)imMeeting);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8ba8\u8bba\u7ec4[%1$s]\u4f1a\u8bae\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)imDisGroup.getIMDISGROUPID(), (Object)callResult.getErrorInfo()));
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5efa\u7acb\u8ba8\u8bba\u7ec4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnBeforeRemove(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnBeforeRemove(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        IMDisGroup imDisGroup = new IMDisGroup();
        imDisGroup.Proxy(dataEntity);
        try {
            IMMeeting imMeeting = new IMMeeting();
            imMeeting.setIMMEETINGID(imDisGroup.getIMDISGROUPID());
            IDEDataCtrl imMeetingDataCtrl = this.GetRelatedDataCtrl("IM0080");
            callResult = imMeetingDataCtrl.Remove((BaseDataEntity)imMeeting);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u5220\u9664\u8ba8\u8bba\u7ec4[%1$s]\u4f1a\u8bae\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)imDisGroup.getIMDISGROUPID(), (Object)callResult.getErrorInfo()));
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5220\u9664\u8ba8\u8bba\u7ec4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    public IDEDataCtrl GetRelatedDataCtrl(String strDEID) throws Exception {
        return this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2(strDEID, "SYSTEM", null);
    }
}

