/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormActionHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormLoadResult
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 *  SA.SRFramework.WebEx.SRFExControl
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Ctrl.Form;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormActionHelper;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormLoadResult;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;
import SA.SRFramework.WebEx.SRFExControl;
import java.util.Hashtable;
import net.sf.json.JSONObject;

public class TreeXMLObjectFormActionHelper
extends SRFExFormActionHelper {
    protected boolean OnSaveAction() {
        SRFExFormSaveResult saveResult = new SRFExFormSaveResult();
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        BaseDataEntity dataEntity = new BaseDataEntity();
        if (!this.getForm().FillDataEntity(dataEntity, false, formItemErrors)) {
            saveResult.setRetCode(5);
            formItemErrors.FillJSONs(saveResult.getItems());
            this.getPage().Output(saveResult.ToJSONString());
            return true;
        }
        this.getForm().FillValueJSON(saveResult.getItems(), this.getPage().isControlValueFromUniqueId());
        JSONObject jsonObject = new JSONObject();
        Hashtable totalParamList = dataEntity.getTotalParamList();
        if (totalParamList != null) {
            for (Object objKey : totalParamList.keySet()) {
                String strKey = objKey.toString();
                jsonObject.put(strKey.toLowerCase(), (Object)dataEntity.GetParamStringValue(strKey, ""));
            }
        }
        saveResult.setJSCode(StringHelper.Format((String)"updatetreenode(%1$s);", (Object)jsonObject.toString()));
        this.getPage().Output(saveResult.ToJSONString());
        return true;
    }

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)"loadxml", (boolean)true) == 0) {
            SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
            BaseDataEntity dataEntity = new BaseDataEntity();
            for (Object object : this.getForm().getFormControls()) {
                SRFExControl control = (SRFExControl)object;
                dataEntity.SetParamValue(control.getID().toUpperCase(), (Object)this.getWebContext().GetPostValue(control.getID().toLowerCase()));
            }
            this.getForm().FillByDataEntity(dataEntity, this.getWebContext().getCopyMode());
            this.getForm().EnableFormItems(this.getWebContext().getCopyMode());
            this.getForm().FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        return super.OnCustomAction(strAction);
    }
}

