/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import net.sf.json.JSONObject;

public class CaretTemplGroupDataCtrl
extends BaseDEDataCtrl {
    @Override
    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult callResult = super.OnExport(baseDataEntity, list, bFrameOnly);
        if (callResult.IsError()) {
            return callResult;
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("CARETTEMPLGROUPID", baseDataEntity.GetParamValue("CARETTEMPLGROUPID"));
        IDEDataCtrl caretTemplDateCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("DE0110", this);
        if (caretTemplDateCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0110"));
            return callResult;
        }
        Vector<BaseDataEntity> caretTemplList = new Vector<BaseDataEntity>();
        callResult = caretTemplDateCtrl.Select(cond, caretTemplList);
        if (callResult.IsError()) {
            return callResult;
        }
        for (BaseDataEntity caretTempl : caretTemplList) {
            callResult = caretTemplDateCtrl.Export(caretTempl, list, true, bFrameOnly);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return callResult;
    }

    @Override
    protected void OnGetDataLastVersion(BaseDataEntity dataEntity, ArrayList<JSONObject> jsonObjectList, HashMap<String, BaseDataEntity> dataMap, boolean bCheckoutMode) throws Exception {
        super.OnGetDataLastVersion(dataEntity, jsonObjectList, dataMap, bCheckoutMode);
        String strCaretTemplGroupId = dataEntity.GetParamStringValue("CARETTEMPLGROUPID", "");
        if (!StringHelper.IsNullOrEmpty((String)strCaretTemplGroupId)) {
            BaseDataEntity cond = new BaseDataEntity();
            cond.SetParamValue("CARETTEMPLGROUPID", (Object)strCaretTemplGroupId);
            this.GetChildDataLastVersion("DE0110", cond, jsonObjectList, dataMap, bCheckoutMode);
        }
    }
}

