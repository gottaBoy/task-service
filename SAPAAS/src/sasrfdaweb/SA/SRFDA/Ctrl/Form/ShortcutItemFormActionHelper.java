/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Ctrl.Form;

import SA.SRFDA.Ctrl.Form.XMLObjectFormActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class ShortcutItemFormActionHelper
extends XMLObjectFormActionHelper {
    @Override
    protected void FillJSONObject(JSONObject jsonObject, BaseDataEntity dataEntity) {
        super.FillJSONObject(jsonObject, dataEntity);
        String strFuncId = dataEntity.GetParamStringValue("FUNCID", "");
        StringHelper.IsNullOrEmpty((String)strFuncId);
    }
}

