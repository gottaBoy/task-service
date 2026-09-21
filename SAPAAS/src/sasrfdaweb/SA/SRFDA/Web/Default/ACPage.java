/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEACMode
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.SRFExAjaxListResult
 *  SA.SRFramework.WebEx.SRFExAutoCompleteActionHelper
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.UI.AutoCompleteConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.AC.BaseDAACActionHelper;
import SA.SRFDA.Ctrl.Data.DEACMode;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.SRFExAjaxListResult;
import SA.SRFramework.WebEx.SRFExAutoCompleteActionHelper;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.UI.AutoCompleteConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ACPage
extends SRFDAPage {
    private static final Log log = LogFactory.getLog(ACPage.class);

    public ACPage() {
        this.setResourceId("");
    }

    protected boolean OnCustomAction(String strActionType, String strAction) {
        if (StringHelper.Compare((String)strActionType, (String)"autocompleteaction", (boolean)true) == 0) {
            String strACMode = this.getWebContext().getACMode();
            AutoCompleteConfig autoCompleteConfig = this.getWebContext().getAutoCompleteMgr().Get(strACMode);
            if (autoCompleteConfig == null) {
                return true;
            }
            Object objHelper = null;
            if (StringHelper.IsNullOrEmpty((String)autoCompleteConfig.getType())) {
                BaseDAACActionHelper helper = new BaseDAACActionHelper();
                helper.setACConfig(autoCompleteConfig);
                helper.Process(this, strACMode, strAction);
            } else {
                SRFExAjaxListResult fetchResult = new SRFExAjaxListResult();
                String strObjectType = "";
                if (StringHelper.Compare((String)strACMode, (String)"SRFDAAC", (boolean)true) == 0) {
                    String strDEId = this.getWebContext().getSRFDEID();
                    IDEHelper iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
                    if (iDEHelper == null) {
                        fetchResult.setRetCode(1);
                        fetchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                        log.error((Object)fetchResult.getErrorInfo());
                        this.getPage().Output(fetchResult.ToJSONString());
                        return true;
                    }
                    String strACUserMode = this.getWebContext().GetPostValue("acusermode");
                    if (!StringHelper.IsNullOrEmpty((String)strACUserMode)) {
                        DEACMode deACMode = iDEHelper.GetACMode(strACUserMode);
                        if (deACMode == null) {
                            fetchResult.setRetCode(3);
                            fetchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f[%1$s]\u914d\u7f6e\u4fe1\u606f", (Object)strACUserMode));
                            log.error((Object)fetchResult.getErrorInfo());
                            this.getPage().Output(fetchResult.ToJSONString());
                            return true;
                        }
                        strObjectType = deACMode.getACOBJECT();
                    }
                    if (StringHelper.IsNullOrEmpty((String)strObjectType)) {
                        strObjectType = iDEHelper.getDataEntity().getACOBJECT();
                    }
                    if (StringHelper.IsNullOrEmpty((String)strObjectType)) {
                        strObjectType = autoCompleteConfig.getType();
                    }
                } else {
                    strObjectType = autoCompleteConfig.getType();
                }
                if ((objHelper = ObjectHelper.Create((String)strObjectType)) == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)strObjectType));
                    return true;
                }
                if (objHelper instanceof SRFExAutoCompleteActionHelper) {
                    SRFExAutoCompleteActionHelper helper = (SRFExAutoCompleteActionHelper)objHelper;
                    helper.Process((SRFExPage)this, strACMode, strAction);
                }
            }
            return true;
        }
        return super.OnCustomAction(strActionType, strAction);
    }
}

