/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper
 *  SA.SRFDA.Web.Script.RichAppJSHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 */
package SA.SRFDA.EAI.Form;

import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFDA.Web.Script.RichAppJSHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;

public class BaseEAIFormActionHelper
extends BaseDAFormActionHelper {
    protected String OnSaveActionOutputResult(BaseDataEntity dataEntity, SRFExFormSaveResult saveResult) {
        if (!saveResult.IsOk()) {
            return saveResult.ToJSONString();
        }
        String strDEID = this.getPage().getDEHelper().getId();
        String strConfigId = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "");
        String strLogicName = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetMajorDEFHelper().getName(), "");
        saveResult.setRetCode(0);
        saveResult.AppendJSCode(RichAppJSHelper.getSetDialogResult((String)this.getPage().getPageModel(), (String)"OK"));
        saveResult.AppendJSCode(RichAppJSHelper.getSetReturnValue((String)this.getPage().getPageModel(), (String)"procconfigId", (String)String.format("'%1$s'", strConfigId)));
        saveResult.AppendJSCode(RichAppJSHelper.getSetReturnValue((String)this.getPage().getPageModel(), (String)"srfdeid", (String)String.format("'%1$s'", strDEID)));
        saveResult.AppendJSBeforeCode(RichAppJSHelper.getSetReturnValue((String)this.getPage().getPageModel(), (String)"logicname", (String)String.format("'%1$s'", strLogicName)));
        saveResult.AppendJSCode(RichAppJSHelper.getCloseWindowScript((String)this.getPage().getPageModel()));
        return saveResult.ToJSONString();
    }
}

