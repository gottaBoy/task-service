/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.LayoutPanel
 *  SA.SRFDA.Ctrl.Data.LayoutPanelItem
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.ILayoutItemPublisher
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.BaseLayoutItemPublisher;
import SA.SRFDA.Ctrl.Data.LayoutPanel;
import SA.SRFDA.Ctrl.Data.LayoutPanelItem;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.ILayoutItemPublisher;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Vector;
import net.sf.json.JSONObject;

public class LayoutPanelPublisher
extends BaseLayoutItemPublisher {
    @Override
    protected JSONObject OnPublish(IDAConfigPublishContext iDAConfigPublishContext, BaseDataEntity item, JSONObject jo) throws Exception {
        LayoutPanel layoutPanel = new LayoutPanel();
        item.CopyTo((BaseDataEntity)layoutPanel, false);
        IDEDataCtrl layoutPanelDataCtrl = iDAConfigPublishContext.getDEDataCtrl("DE0350");
        CallResult callResult = layoutPanelDataCtrl.Get((BaseDataEntity)layoutPanel);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e03\u5c40\u9762\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("LAYOUTPANELID", (Object)layoutPanel.getLAYOUTPANELID());
        IDEDataCtrl layoutPanelItemDataCtrl = iDAConfigPublishContext.getDEDataCtrl("DE0353");
        Vector<LayoutPanelItem> layoutPanelItems = new Vector<LayoutPanelItem>();
        callResult = layoutPanelItemDataCtrl.Select(cond, layoutPanelItems, LayoutPanelItem.class.getName(), "", "ORDER BY ORDERFLAG");
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e03\u5c40\u9762\u677f\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        ArrayList<JSONObject> items = new ArrayList<JSONObject>();
        for (LayoutPanelItem layoutPanelItem : layoutPanelItems) {
            ILayoutItemPublisher iLayoutItemPublisher = this.getDAGlobalHelper().getDAModelStorage().FindLayoutItem(layoutPanelItem.getITEMTYPE()).getPublisher();
            JSONObject itemObject = iLayoutItemPublisher.Publish(iDAConfigPublishContext, (BaseDataEntity)layoutPanelItem, null);
            if (itemObject == null) continue;
            items.add(itemObject);
        }
        jo.put("items", (Object)items.toArray());
        return jo;
    }
}
