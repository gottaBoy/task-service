/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 */
package SA.TM.Ctrl.Form;

import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;

public class TMFormActionHelper
extends BaseDAFormActionHelper {
    protected String OnSaveActionOutputResult(BaseDataEntity dataEntity, SRFExFormSaveResult saveResult) {
        String strRBState = dataEntity.GetParamStringValue("RBSTATE", "");
        String strRBInfo = dataEntity.GetParamStringValue("RBInfo", "");
        strRBInfo = strRBInfo.replace("\n", "\\n");
        strRBInfo = strRBInfo.replace("\r", "\\r");
        if (StringHelper.Compare((String)strRBState, (String)"WARNING", (boolean)true) == 0) {
            saveResult.AppendJSBeforeCode(StringHelper.Format((String)"alert(\"\u8d44\u6e90\u9884\u7ea6\u5b58\u5728\u95ee\u9898!\\r\\n%1$s\");", (Object)strRBInfo));
        } else if (StringHelper.Compare((String)strRBState, (String)"ERROR", (boolean)true) == 0) {
            saveResult.AppendJSBeforeCode(StringHelper.Format((String)"alert(\"\u8d44\u6e90\u9884\u7ea6\u5b58\u5728\u9519\u8bef!\\r\\n%1$s\");", (Object)strRBInfo));
        }
        return super.OnSaveActionOutputResult(dataEntity, saveResult);
    }
}

