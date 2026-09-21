/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.BaseLayoutItemPublisher;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import net.sf.json.JSONObject;

public class BaseLayoutPanelItemPublisher
extends BaseLayoutItemPublisher {
    @Override
    protected JSONObject OnPublish(IDAConfigPublishContext iDAConfigPublishContext, BaseDataEntity item, JSONObject jo) throws Exception {
        jo = super.OnPublish(iDAConfigPublishContext, item, jo);
        Properties valueMap = null;
        Object objValueMap = iDAConfigPublishContext.getAttribute("CELLITEMNAMEMAP");
        if (objValueMap != null) {
            valueMap = (Properties)objValueMap;
        }
        String strItemName = item.GetParamStringValue("LAYOUTPINAME", "");
        if (valueMap != null) {
            strItemName = PropertiesHelper.GetProperty((Properties)valueMap, (String)strItemName, (String)strItemName);
        }
        jo.put("dsitemids", (Object)strItemName);
        return jo;
    }
}

