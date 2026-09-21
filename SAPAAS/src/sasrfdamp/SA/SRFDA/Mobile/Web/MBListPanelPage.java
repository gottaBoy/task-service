/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.MBList
 *  SA.SRFDA.Ctrl.IDAMBConfigHelperContext
 *  SA.SRFDA.Mobile.UIPart.Model.MBListConfig
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Mobile.Web;

import SA.SRFDA.Ctrl.Data.MBList;
import SA.SRFDA.Ctrl.IDAMBConfigHelperContext;
import SA.SRFDA.Mobile.Ctrl.DAMBConfigHelperContext;
import SA.SRFDA.Mobile.Ctrl.MBConfigMgrHelper;
import SA.SRFDA.Mobile.UIPart.Model.MBListConfig;
import SA.SRFDA.Mobile.Web.BaseMBListPanelPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class MBListPanelPage
extends BaseMBListPanelPage {
    @Override
    protected MBListConfig OnGetMBListConfig(MBList mbList) throws Exception {
        DAMBConfigHelperContext context = new DAMBConfigHelperContext();
        context.setMBList(mbList);
        context.setMBPanel(this.mbPanel);
        context.setDEHelper(this.getDEHelper());
        String strConfigId = this.getDAMBConfigHelper().GetMBListPanelListConfigId((IDAMBConfigHelperContext)context);
        MBListConfig listConfig = MBConfigMgrHelper.GetMBListMgr((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper()).GetMBListConfig(strConfigId);
        if (listConfig == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u79fb\u52a8\u5217\u8868\u914d\u7f6e[%1$s]", (Object)strConfigId));
        }
        return listConfig;
    }
}

