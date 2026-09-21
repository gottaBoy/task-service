/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Ctrl.Model;

import SA.SRFDA.BI.Ctrl.IBICubeCache;
import SA.SRFDA.BI.Ctrl.IBIRepMSHelper;
import SA.SRFDA.BI.Ctrl.Model.BaseBIObjectModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class BIRepMeasureModel
extends BaseBIObjectModel {
    protected IBIRepMSHelper iBIRepMSHelper = null;
    protected IBICubeCache iIBICubeCache = null;

    public void Init(IBIRepMSHelper iBIRepMSHelper, IBICubeCache iIBICubeCache) throws Exception {
        this.iBIRepMSHelper = iBIRepMSHelper;
        this.iIBICubeCache = iIBICubeCache;
        this.setId(iBIRepMSHelper.getBICubeMeasure().getShortId());
        this.setCaption(iBIRepMSHelper.getLogicName());
        this.setUniqueName(iBIRepMSHelper.getBICubeMeasure().getUniqueName());
    }

    @Override
    protected void OnFillJSONObject(JSONObject jsonObject) throws Exception {
        super.OnFillJSONObject(jsonObject);
        if (!StringHelper.IsNullOrEmpty((String)this.iBIRepMSHelper.getGroupName())) {
            jsonObject.put("groupname", (Object)this.iBIRepMSHelper.getGroupName());
        }
        jsonObject.put("columnwidth", this.iBIRepMSHelper.getColumnWidth());
        jsonObject.put("format", (Object)this.iBIRepMSHelper.getBICubeMeasure().getFormat());
    }

    public String getGroupName() {
        String strGroupName = this.iBIRepMSHelper.getGroupName();
        if (StringHelper.IsNullOrEmpty((String)strGroupName)) {
            return "\u6307\u6807\u5206\u7ec4";
        }
        return strGroupName;
    }

    public int getColumnWidth() {
        return this.iBIRepMSHelper.getColumnWidth();
    }

    public String getFormat() {
        return this.iBIRepMSHelper.getBICubeMeasure().getFormat();
    }
}

