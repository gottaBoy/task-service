/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAObjectHelper
 *  SA.SRFDA.Ctrl.Data.LayoutFont
 *  SA.SRFDA.Ctrl.Data.LayoutItem
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.ILayoutItemPublisher
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.LayoutFont;
import SA.SRFDA.Ctrl.Data.LayoutItem;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.ILayoutItemPublisher;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import net.sf.json.JSONObject;

public abstract class BaseLayoutItemPublisher
extends BaseDAObjectHelper
implements ILayoutItemPublisher {
    protected Hashtable<String, ModelProperty> modelPropertyMap = new Hashtable();
    protected LayoutItem layoutItem = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, LayoutItem layoutItem) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.layoutItem = layoutItem;
        this.setId(this.layoutItem.getLAYOUTITEMID());
        this.setName(this.layoutItem.getLAYOUTITEMNAME());
        this.OnInit();
    }

    public JSONObject Publish(IDAConfigPublishContext iDAConfigPublishContext, BaseDataEntity item, JSONObject jo) throws Exception {
        if (jo == null) {
            jo = new JSONObject();
        }
        jo.put("itemtype", (Object)this.layoutItem.getLAYOUTITEMID().toLowerCase());
        return this.OnPublish(iDAConfigPublishContext, item, jo);
    }

    protected JSONObject OnPublish(IDAConfigPublishContext iDAConfigPublishContext, BaseDataEntity item, JSONObject jo) throws Exception {
        for (String strKey : this.modelPropertyMap.keySet()) {
            LayoutFont layoutFont;
            ModelProperty modelProperty = this.modelPropertyMap.get(strKey);
            Object objValue = item.GetParamValue(modelProperty.strProperty);
            if (objValue == null) {
                objValue = modelProperty.objDefaultValue;
            }
            if (objValue == null) continue;
            if (StringHelper.IsNullOrEmpty((String)modelProperty.strObjectType)) {
                jo.put(strKey, objValue);
                continue;
            }
            if (StringHelper.Compare((String)modelProperty.strObjectType, (String)"FONT", (boolean)true) != 0) continue;
            ILayoutItemPublisher iLayoutItemPublisher = this.getDAGlobalHelper().getDAModelStorage().FindLayoutItem(modelProperty.strObjectType).getPublisher();
            String strFontKey = StringHelper.Format((String)"%1$s_%2$s", (Object)modelProperty.strObjectType, (Object)objValue);
            Object objFont = iDAConfigPublishContext.getAttribute(strFontKey);
            if (objFont != null) {
                layoutFont = (LayoutFont)objFont;
                continue;
            }
            layoutFont = new LayoutFont();
            layoutFont.setLAYOUTFONTID((String)objValue);
            IDEDataCtrl layoutFontDataCtrl = iDAConfigPublishContext.getDEDataCtrl("DE0351");
            CallResult callResult = layoutFontDataCtrl.Get((BaseDataEntity)layoutFont);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e03\u5c40\u5b57\u4f53[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objValue, (Object)callResult.getErrorInfo()));
            }
            iDAConfigPublishContext.setAttribute(strFontKey, (Object)layoutFont);
            JSONObject joFont = iLayoutItemPublisher.Publish(iDAConfigPublishContext, (BaseDataEntity)layoutFont, null);
            if (joFont == null) continue;
            jo.put(strKey, (Object)joFont);
        }
        return jo;
    }

    protected class ModelProperty {
        public String strObjectType;
        public String strProperty;
        public Object objDefaultValue;

        public ModelProperty(String strProperty, Object objDefaultValue) {
            this.strProperty = strProperty;
            this.objDefaultValue = objDefaultValue;
        }

        public ModelProperty(String strObjectType, String strProperty, Object objDefaultValue) {
            this.strObjectType = strObjectType;
            this.strProperty = strProperty;
            this.objDefaultValue = objDefaultValue;
        }
    }
}

