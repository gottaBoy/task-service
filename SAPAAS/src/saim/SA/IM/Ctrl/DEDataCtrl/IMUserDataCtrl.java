/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.IM.Ctrl.DEDataCtrl;

import SA.IM.Ctrl.DEDataCtrl.IMDEDataCtrl;
import SA.IM.Ctrl.Data.IMOrg;
import SA.IM.Ctrl.Task.IMContactsRender;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;

public class IMUserDataCtrl
extends IMDEDataCtrl {
    public static final String TAG_FULLINFOMODE = "FULLINFOMODE";
    public static final String TAG_CREATECONTACT = "CREATECONTACT";

    public CallResult CustomCall(String strAction, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strAction, (String)TAG_FULLINFOMODE, (boolean)true) == 0) {
            return this.Save(false, TAG_FULLINFOMODE, dataEntity);
        }
        return super.CustomCall(strAction, dataEntity);
    }

    protected CallResult OnCustomCall(String strActionMode, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strActionMode, (String)TAG_CREATECONTACT, (boolean)true) == 0) {
            CallResult callResult = new CallResult();
            String strRootOrgId = dataEntity.GetParamStringValue("ROOTORGID", "");
            if (StringHelper.IsNullOrEmpty((String)strRootOrgId)) {
                callResult.setRetCode(5);
                callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u53c2\u6570[ROOTORGID]\u6839\u7ec4\u7ec7id");
            } else {
                try {
                    String strOutputFile = ((SRFDAWebContext)this.getWebContext()).getPage().getPageContext().getServletContext().getRealPath("/");
                    strOutputFile = String.valueOf(strOutputFile) + File.separator + "Contacts.xml";
                    IMContactsRender iMContactsRender = new IMContactsRender();
                    iMContactsRender.Init(this.globalHelperEx);
                    callResult = iMContactsRender.Export(strOutputFile, strRootOrgId);
                }
                catch (Exception e) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(e.getMessage());
                }
            }
            return callResult;
        }
        return super.OnCustomCall(strActionMode, dataEntity);
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        return this.UpdateOrgVersion(dataEntity);
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity baseDataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, baseDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        return this.UpdateOrgVersion(baseDataEntity);
    }

    public CallResult UpdateOrgVersion(BaseDataEntity dataEntity) {
        try {
            String strOrgId = dataEntity.GetParamStringValue("IMORGID", "");
            if (StringHelper.IsNullOrEmpty((String)strOrgId)) {
                return new CallResult();
            }
            IMOrg org = new IMOrg();
            org.setIMORGID(strOrgId);
            IDEDataCtrl orgCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl2("IM0067", "SYSTEM", null);
            if (orgCtrl == null) {
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[IMORG]\u6570\u636e\u5bf9\u8c61");
            }
            return orgCtrl.Save(false, (BaseDataEntity)org);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

