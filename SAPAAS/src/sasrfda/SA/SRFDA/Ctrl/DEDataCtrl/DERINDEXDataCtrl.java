/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ValueError
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Connection;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DERINDEXDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(DERINDEXDataCtrl.class);
    public static final String TAG_CREATEVIEW = "CREATEVIEW";
    protected IDBModelHelper iDBModelHelper = null;

    @Override
    protected Connection getConnection(String strAction, String strActionMode) {
        return null;
    }

    @Override
    protected CallResult OnTestSave(boolean insert, String strActionType, BaseDataEntity dataEntity, Vector<ValueError> errors) {
        CallResult callResult = super.OnTestSave(insert, strActionType, dataEntity, errors);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        DERINDEX derIndex = new DERINDEX();
        dataEntity.CopyTo((BaseDataEntity)derIndex, true);
        String strIndexDEID = derIndex.getINDEXDEID();
        String strDEID = derIndex.getDEID();
        if (!StringHelper.IsNullOrEmpty((String)strIndexDEID)) {
            IDEHelper indexDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strIndexDEID);
            if (indexDEHelper == null) {
                ValueError valueError = new ValueError();
                valueError.setValue("INDEXDEID");
                valueError.setErrorCode(3);
                valueError.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strIndexDEID));
                callResult.setRetCode(5);
                return callResult;
            }
            if (!indexDEHelper.IsIndexDE()) {
                ValueError valueError = new ValueError();
                valueError.setValue("INDEXDEID");
                valueError.setErrorCode(3);
                valueError.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s:%2$s]\u5fc5\u987b\u4e3a\u7d22\u5f15\u5b9e\u4f53", (Object)indexDEHelper.getName(), (Object)indexDEHelper.getLogicName("")));
                callResult.setRetCode(5);
                return callResult;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strDEID)) {
            IDEHelper curDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strDEID);
            if (curDEHelper == null) {
                ValueError valueError = new ValueError();
                valueError.setValue("DEID");
                valueError.setErrorCode(3);
                valueError.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEID));
                callResult.setRetCode(5);
                return callResult;
            }
            if (derIndex.isINHERITMODE() && curDEHelper.IsIndexDE()) {
                ValueError valueError = new ValueError();
                valueError.setValue("DEID");
                valueError.setErrorCode(3);
                valueError.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s:%2$s]\u4e0d\u80fd\u4e3a\u7d22\u5f15\u5b9e\u4f53", (Object)curDEHelper.getName(), (Object)curDEHelper.getLogicName("")));
                callResult.setRetCode(5);
                return callResult;
            }
        }
        return callResult;
    }
}

