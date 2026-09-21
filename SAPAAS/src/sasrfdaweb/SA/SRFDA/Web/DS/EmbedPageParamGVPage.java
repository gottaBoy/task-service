/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.Utility.KeyHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.DS;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.DataGrid.PageParamDGActionHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.Utility.KeyHelper;
import SA.SRFDA.Web.DS.JSGear.PageParamDGNewEditJSGear;
import SA.SRFDA.Web.DS.Utility.PageParamDGNewEditPageHelper;
import SA.SRFDA.Web.Default.EmbedGridViewPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class EmbedPageParamGVPage
extends EmbedGridViewPage {
    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        if (this.IsBackEndMode()) {
            String strPageId = this.getWebContext().GetPostValue("PAGEID");
            if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                strPageId = this.getWebContext().GetParamValue("PAGEID");
            }
            if (!KeyHelper.IsTempKey((String)strPageId) && !StringHelper.IsNullOrEmpty((String)strPageId)) {
                IDEDataCtrl pageDataCtrl = this.GetDEDataCtrl("DE0006");
                if (pageDataCtrl == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0006"));
                    return false;
                }
                Page page = new Page();
                page.setPAGEID(strPageId);
                CallResult callResult = pageDataCtrl.Get((BaseDataEntity)page);
                if (callResult.IsError()) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u6570\u636e[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strPageId, (Object)callResult.getErrorInfo()));
                    return false;
                }
                this.getWebContext().SetParamValue("PAGETEMPLID", page.getPAGETEMPLID());
            }
        }
        return true;
    }

    @Override
    protected String GetDataGridActionHelper() {
        return PageParamDGActionHelper.class.getName();
    }

    @Override
    protected boolean IsLoadDataGridNewEditJSGear() {
        return false;
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            PageParamDGNewEditJSGear.Load(this, this.dataGrid, true, true, true, false);
        } else {
            this.editPageInfo = new JSONObject();
            this.editPageInfo.put("dbclkedit", true);
            PageParamDGNewEditPageHelper.Calc(this, this.dataGrid, this.newPageInfo, this.editPageInfo, false);
        }
    }
}

