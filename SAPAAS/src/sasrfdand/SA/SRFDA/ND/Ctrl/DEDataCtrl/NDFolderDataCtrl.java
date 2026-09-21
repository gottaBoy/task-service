/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.ND.Ctrl.DEDataCtrl;

import SA.SRFDA.ND.Ctrl.DEDataCtrl.NDFSObjectDataCtrl;
import SA.SRFDA.ND.Ctrl.DEDataCtrl.NDFileDataCtrl;
import SA.SRFDA.ND.Ctrl.INDFSOTypeHelper;
import SA.SRFDA.ND.Ctrl.NDActionContext;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NDFolderDataCtrl
extends NDFSObjectDataCtrl {
    private static final Log log = LogFactory.getLog(NDFileDataCtrl.class);

    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            NDActionContext iNDActionContext = new NDActionContext(this);
            NDFSObject ndFSObject = new NDFSObject();
            dataEntity.CopyTo((BaseDataEntity)ndFSObject, true);
            ndFSObject.setNDFSOBJECTNAME(dataEntity.GetParamStringValue("NDFOLDERNAME", ""));
            if (!bInsert) {
                ndFSObject.setNDFSOBJECTID(dataEntity.GetParamStringValue("NDFOLDERID", ""));
            }
            INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType("FOLDER");
            String strUniqueName = iNDFSOTypeHelper.CalcFSOUniqueName(iNDActionContext, ndFSObject);
            dataEntity.SetParamValue("NDFOLDERNAME", (Object)strUniqueName);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return callResult;
    }
}

