/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.List
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.Data.List;
import SA.SRFDA.Report.List.ListActionHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ListDataPage
extends SRFDAPage {
    protected List list = new List();
    private static final Log log = LogFactory.getLog(ListDataPage.class);

    public ListDataPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strListId = this.getWebContext().getSRFListId();
        if (StringHelper.IsNullOrEmpty((String)strListId)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u8868\u683c\u5bf9\u8c61\u7f16\u53f7"));
            return false;
        }
        CallResult callResult = this.getDAModelHelper().GetList(strListId, this.list);
        if (callResult.getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u683c\u5bf9\u8c61[%1$s]", (Object)strListId));
            return false;
        }
        this.list.BuildProperties();
        return true;
    }

    protected void OnLoadBackEnd() {
        ListActionHelper listActionHelper = null;
        String strListObject = this.list.getLISTOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strListObject)) {
            listActionHelper = new ListActionHelper();
        } else {
            Object objActionHelper = ObjectHelper.Create((String)strListObject);
            if (objActionHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u8868\u683c\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strListObject));
                return;
            }
            if (!(objActionHelper instanceof ListActionHelper)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u8868\u683c\u5904\u7406\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strListObject));
                return;
            }
            listActionHelper = (ListActionHelper)objActionHelper;
        }
        this.Output(listActionHelper.GetListHTML((ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.list));
    }
}

