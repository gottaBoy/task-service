/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.Data.LayoutItem;
import SA.SRFDA.Ctrl.ILayoutItemHelper;
import SA.SRFDA.Ctrl.LayoutItemHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LayoutItemlGlobalModel
extends BaseDAGlobalModel<String, LayoutItem, ILayoutItemHelper> {
    private static final Log log = LogFactory.getLog(LayoutItemlGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected LayoutItem GetObject(String strLayoutItemId) {
        LayoutItem layoutItem = new LayoutItem();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetLayoutItem(strLayoutItemId, layoutItem);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6\u9879[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strLayoutItemId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return layoutItem;
    }

    @Override
    protected ILayoutItemHelper OnCreateModelHelper(LayoutItem vt) throws Exception {
        LayoutItemHelper iLayoutItemHelper = new LayoutItemHelper();
        iLayoutItemHelper.Init(this.iDAGlobalHelper, vt);
        return iLayoutItemHelper;
    }

    @Override
    protected Boolean TestObjectRenew(LayoutItem obj) {
        return false;
    }
}

