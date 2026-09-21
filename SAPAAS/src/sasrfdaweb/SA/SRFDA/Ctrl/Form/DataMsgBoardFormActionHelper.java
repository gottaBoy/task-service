/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Ctrl.Form;

import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class DataMsgBoardFormActionHelper
extends BaseDAFormActionHelper {
    @Override
    protected void OnLoadDefaultActionAfterFillDataEntity(BaseDataEntity dataEntity) {
        super.OnLoadDefaultActionAfterFillDataEntity(dataEntity);
        dataEntity.SetParamValue("DEID", (Object)this.getWebContext().getSRFPDEID());
        IDEHelper pdeHelper = this.getPage().getDAModelStorage().FindDEHelper(this.getWebContext().getSRFPDEID());
        if (pdeHelper == null) {
            this.page.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.getWebContext().getSRFPDEID()));
            return;
        }
        dataEntity.SetParamValue("DATAID", (Object)this.getWebContext().GetParamValue(pdeHelper.GetKeyDEFHelper().getName()));
    }

    @Override
    protected void OnSetMainFormState(JSONObject jsonObject, boolean bCreate, BaseDataEntity dataEntity) {
        super.OnSetMainFormState(jsonObject, bCreate, dataEntity);
        if (!bCreate) {
            jsonObject.remove("UPDATE".toLowerCase());
            jsonObject.put("UPDATE".toLowerCase(), false);
            jsonObject.remove("CREATE".toLowerCase());
            jsonObject.put("CREATE".toLowerCase(), true);
            jsonObject.remove("DELETE".toLowerCase());
            jsonObject.put("DELETE".toLowerCase(), false);
        }
    }
}

