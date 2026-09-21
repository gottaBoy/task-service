/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.MBList
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Mobile.Panel;

import SA.SRFDA.Ctrl.Data.MBList;
import SA.SRFDA.Mobile.Panel.BaseListPanel;
import SA.SRFDA.Mobile.UIPart.IMobilePublishContext;
import SA.SRFDA.Mobile.UIPart.JSObjectConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;

public class ListPanel
extends BaseListPanel {
    @Override
    protected String OnGetMBListId() throws Exception {
        MBList mbList = new MBList();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetMBList(this.getDEHelper().getId(), 1, mbList);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u9ed8\u8ba4\u4e3b\u5217\u8868\u5931\u8d25\uff0c%2$s", (Object)this.getDEHelper().getId(), (Object)callResult.getErrorInfo()));
        }
        return ListPanel.CalcUIPartUniqueId("DE0410", this.getDEHelper().getId(), mbList.getMBLISTID());
    }

    @Override
    protected String OnGetUniqueName(IMobilePublishContext context) throws Exception {
        return context.CalcUniqueName(StringHelper.Format((String)"%1$sListPanel", (Object)this.strDEJSObjectName));
    }

    @Override
    protected String OnGetMainListStoreUrl(IMobilePublishContext context) throws Exception {
        String[] items = this.strMBFullListId.split("[;]");
        if (items.length != 3) {
            throw new Exception(StringHelper.Format((String)"\u79fb\u52a8\u5e94\u7528\u90e8\u4ef6\u6807\u8bc6[%1$s]\u65e0\u6548", (Object)this.strMBFullListId));
        }
        String strMBListId = items[2];
        String strUrl = "../srfmobile/mblistviewbackend.jsp";
        strUrl = URLHelper.AppendURLSeperator((String)strUrl);
        strUrl = String.valueOf(strUrl) + StringHelper.Format((String)"SRFDEID=%1$s&SRFMBPANELID=%2$s&SRFMBLISTID=%3$s&SRFMBCTRLID=LIST&SRFACTIONTYPE=MBLIST", (Object)this.getDEHelper().getId(), (Object)this.mbPanel.getMBPANELID(), (Object)strMBListId);
        return strUrl;
    }

    @Override
    protected void OnPreparePublish(IMobilePublishContext context) throws Exception {
        super.OnPreparePublish(context);
        JSObjectConfig mainListStoreConfig = this.GetJSObjectCfg("MainListStore");
        mainListStoreConfig.getProperties().put("autoLoad", "true");
    }
}

