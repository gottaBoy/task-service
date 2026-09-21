/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DGEx.DGExFetchResultHelper
 *  SA.SRFramework.WebEx.DGEx.DGExFetchResultHelperContext
 *  SA.SRFramework.WebEx.DGEx.SRFExDGEx
 *  SA.SRFramework.WebEx.DGEx.UI.DGExConfig
 *  SA.SRFramework.WebEx.ISRFExWebContext
 */
package SA.SRFDA.Web.DS;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DGEx.DGExFetchResultHelper;
import SA.SRFramework.WebEx.DGEx.DGExFetchResultHelperContext;
import SA.SRFramework.WebEx.DGEx.SRFExDGEx;
import SA.SRFramework.WebEx.DGEx.UI.DGExConfig;
import SA.SRFramework.WebEx.ISRFExWebContext;

public class DGExPreviewPage
extends SRFDAPage {
    protected SRFExDGEx dgEx = null;
    protected StringBuilderEx sb = new StringBuilderEx();

    public DGExPreviewPage() {
        this.setJSCache(false);
    }

    @Override
    protected boolean PreparePageEnv() {
        this.setID(this.getWebContext().getTabViewPageId());
        this.strPageDataEntityId = this.getWebContext().GetPostValue("srfdeid");
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        return super.PreparePageEnv();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        String strXML = this.getWebContext().GetPostValue("dgxml");
        strXML = strXML.replace("\n", "&#xA;");
        strXML = strXML.replace("\r", "&#xD;");
        DGExConfig dgExConfig = this.getDAConfigHelper().GetDGExConfig(this.getDEHelper(), strXML);
        if (dgExConfig == null) {
            return;
        }
        try {
            BaseDAQueryModelHelper daQueryModelHelper = this.getDAModelStorage().getDAQueryModelHelper(this.getDEHelper());
            if (daQueryModelHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61", (Object)this.getDEHelper().getId()));
                return;
            }
            BaseDataEntity cond = new BaseDataEntity();
            String strSelectCode = this.getDEHelper().GetSelectCode(cond, null);
            strSelectCode = daQueryModelHelper.GetPagingSQL(strSelectCode, 0, 5, "", "", "", "");
            SelectResult selectResult = this.getWebContext().getDBCaller(this.getDEHelper().GetDBStorage()).CallRaw2(strSelectCode);
            if (selectResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53[%1$s]\u793a\u4f8b\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getDEHelper().getId(), (Object)selectResult.getErrorInfo()));
                return;
            }
            DGExFetchResultHelperContext context = new DGExFetchResultHelperContext();
            context.setDGExConfig(dgExConfig);
            context.setDGExUniqueId(String.valueOf(this.getID()) + "DGEX");
            context.setWebContext((ISRFExWebContext)this.getWebContext());
            DGExFetchResultHelper.Output((DGExFetchResultHelperContext)context, (StringBuilderEx)this.sb, (DataTable)selectResult.getMainTable());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String RenderDGEx() {
        return this.sb.toString();
    }
}

