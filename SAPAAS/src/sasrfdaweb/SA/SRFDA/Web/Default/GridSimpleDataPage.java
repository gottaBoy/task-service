/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExGridFetchResult
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExGridFetchResult;
import net.sf.json.JSONObject;

public class GridSimpleDataPage
extends SRFDAPage {
    public GridSimpleDataPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected void OnLoadBackEnd() {
        SRFExGridFetchResult fetchResult = new SRFExGridFetchResult();
        fetchResult.setTotalRow(1);
        String strDEID = this.getWebContext().getSRFDEID();
        if (StringHelper.IsNullOrEmpty((String)strDEID)) {
            fetchResult.setRetCode(4);
            fetchResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u7f16\u53f7");
            this.Output(fetchResult.ToJSONString());
            return;
        }
        IDEHelper iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(strDEID);
        if (iDEHelper == null) {
            fetchResult.setRetCode(4);
            fetchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230%1$s\u7684\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)strDEID));
            this.Output(fetchResult.ToJSONString());
            return;
        }
        JSONObject jsonObject = new JSONObject();
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            jsonObject.put(iDEFHelper.getName().toLowerCase(), (Object)iDEFHelper.getLogicName(this.getLanguage()));
        }
        fetchResult.getItems().add(jsonObject);
        this.Output(fetchResult.ToJSONString());
    }
}

