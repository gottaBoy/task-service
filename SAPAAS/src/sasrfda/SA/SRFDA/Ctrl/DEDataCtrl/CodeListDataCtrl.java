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
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CodeListDataCtrl
extends BaseDEDataCtrl {
    public static final String CUSTOMCALL_RESETCODELIST = "RESETCODELIST";
    public static final String CUSTOMCALL_RESETALLCODELIST = "RESETALLCODELIST";
    private static final Log log = LogFactory.getLog(CodeListDataCtrl.class);
    protected IDBModelHelper iDBModelHelper = null;

    @Override
    protected CallResult OnAfterSaveOK(boolean insert, String strActionType, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(insert, strActionType, dataEntity, lastDataEntity);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        this.globalHelperEx.getDAModelStorage().ResetCodeListConfig(dataEntity.GetParamStringValue("CODELISTID", ""));
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_RESETCODELIST, (boolean)true) == 0) {
            this.globalHelperEx.getDAModelStorage().ResetCodeListConfig(dataEntity.GetParamStringValue("CODELISTID", ""));
            return new CallResult();
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_RESETALLCODELIST, (boolean)true) == 0) {
            this.globalHelperEx.getDAModelStorage().ResetAllCodeList();
            return new CallResult();
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }
}

