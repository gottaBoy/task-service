/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.PSLinkDEFGridColumnImpl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItem;
import SA.SRFDA.PS.Core.DEField.IPSInheritDEField;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class PSInheritDEFGridColumnImpl
extends PSLinkDEFGridColumnImpl {
    protected IPSInheritDEField iPSInheritDEField = null;
    protected IPSDEFGridColumn inheritPSDEFGridColumn = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSInheritDEField = (IPSInheritDEField)this.getPSDEField();
        if (this.iPSInheritDEField == null) {
            throw new Exception(StringHelper.Format((String)"\u7ee7\u627f\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)this.getPSDEField().getFullName()));
        }
        this.inheritPSDEFGridColumn = this.iPSInheritDEField.getRealInheritPSDEField().getPSDEFUIMode("DEFAULT").getPSDEFGridColumn();
        super.onInit();
    }

    @Override
    public String getRefPSDEId() {
        String strRefPSDEId = super.getRefPSDEId();
        if (StringHelper.IsNullOrEmpty((String)strRefPSDEId)) {
            return this.inheritPSDEFGridColumn.getRefPSDEId();
        }
        return strRefPSDEId;
    }

    @Override
    public String getRefPSDEACModeId() {
        String strRefPSDEACModeId = super.getRefPSDEACModeId();
        if (StringHelper.IsNullOrEmpty((String)strRefPSDEACModeId)) {
            return this.inheritPSDEFGridColumn.getRefPSDEACModeId();
        }
        return strRefPSDEACModeId;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292)
    public String getEditorType() {
        String strEditorType = super.getEditorType();
        if (StringHelper.IsNullOrEmpty((String)strEditorType)) {
            return this.inheritPSDEFGridColumn.getEditorType();
        }
        return strEditorType;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f")
    public String getEditorStyle() {
        String strEditorStyle = super.getEditorStyle();
        if (StringHelper.IsNullOrEmpty((String)strEditorStyle)) {
            return this.inheritPSDEFGridColumn.getEditorStyle();
        }
        return strEditorStyle;
    }

    @Override
    public String getItemHandlerType(IPSDEGridEditItem iPSDEGridEditItem) {
        String strItemHandlerType = super.getItemHandlerType(iPSDEGridEditItem);
        if (StringHelper.IsNullOrEmpty((String)strItemHandlerType)) {
            return this.inheritPSDEFGridColumn.getItemHandlerType(iPSDEGridEditItem);
        }
        return strItemHandlerType;
    }

    @Override
    public String getItemHandlerType(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) {
        String strItemHandlerType = super.getItemHandlerType(iPSDETreeNodeEditItem);
        if (StringHelper.IsNullOrEmpty((String)strItemHandlerType)) {
            return this.inheritPSDEFGridColumn.getItemHandlerType(iPSDETreeNodeEditItem);
        }
        return strItemHandlerType;
    }

    @Override
    public JSONObject getItemParam(IPSDEGridEditItem iPSDEGridEditItem) throws Exception {
        JSONObject itemParam = super.getItemParam(iPSDEGridEditItem);
        if (itemParam == null) {
            return this.inheritPSDEFGridColumn.getItemParam(iPSDEGridEditItem);
        }
        return itemParam;
    }

    @Override
    public JSONObject getItemParam(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) throws Exception {
        JSONObject itemParam = super.getItemParam(iPSDETreeNodeEditItem);
        if (itemParam == null) {
            return this.inheritPSDEFGridColumn.getItemParam(iPSDETreeNodeEditItem);
        }
        return itemParam;
    }

    @Override
    public String getValueItemName(IPSDEGridEditItem iPSDEGridEditItem) {
        String strValueItemName = super.getValueItemName(iPSDEGridEditItem);
        if (StringHelper.IsNullOrEmpty((String)strValueItemName)) {
            return this.inheritPSDEFGridColumn.getValueItemName(iPSDEGridEditItem);
        }
        return strValueItemName;
    }

    @Override
    public String getValueItemName(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) {
        String strValueItemName = super.getValueItemName(iPSDETreeNodeEditItem);
        if (StringHelper.IsNullOrEmpty((String)strValueItemName)) {
            return this.inheritPSDEFGridColumn.getValueItemName(iPSDETreeNodeEditItem);
        }
        return strValueItemName;
    }

    @Override
    public String getRefPickupPSDEViewId() {
        String strRefPickupPSDEViewId = super.getRefPickupPSDEViewId();
        if (StringHelper.IsNullOrEmpty((String)strRefPickupPSDEViewId)) {
            return this.inheritPSDEFGridColumn.getRefPickupPSDEViewId();
        }
        return strRefPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewName() {
        String strRefPickupPSDEViewName = super.getRefPickupPSDEViewName();
        if (StringHelper.IsNullOrEmpty((String)strRefPickupPSDEViewName)) {
            return this.inheritPSDEFGridColumn.getRefPickupPSDEViewName();
        }
        return strRefPickupPSDEViewName;
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        String strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId();
        if (StringHelper.IsNullOrEmpty((String)strRefMPickupPSDEViewId)) {
            return this.inheritPSDEFGridColumn.getRefMPickupPSDEViewId();
        }
        return strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        String strRefMPickupPSDEViewName = super.getRefMPickupPSDEViewName();
        if (StringHelper.IsNullOrEmpty((String)strRefMPickupPSDEViewName)) {
            return this.inheritPSDEFGridColumn.getRefMPickupPSDEViewName();
        }
        return strRefMPickupPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId() {
        String strRefLinkPSDEViewId = super.getRefLinkPSDEViewId();
        if (StringHelper.IsNullOrEmpty((String)strRefLinkPSDEViewId)) {
            return this.inheritPSDEFGridColumn.getRefLinkPSDEViewId();
        }
        return strRefLinkPSDEViewId;
    }

    @Override
    public String getRefLinkPSDEViewName() {
        String strRefLinkPSDEViewName = super.getRefLinkPSDEViewName();
        if (StringHelper.IsNullOrEmpty((String)strRefLinkPSDEViewName)) {
            return this.inheritPSDEFGridColumn.getRefLinkPSDEViewName();
        }
        return strRefLinkPSDEViewName;
    }

    @Override
    public String getRefPSDEDataSetId() {
        String strRefPSDEDataSetId = super.getRefPSDEDataSetId();
        if (StringHelper.IsNullOrEmpty((String)strRefPSDEDataSetId)) {
            return this.inheritPSDEFGridColumn.getRefPSDEDataSetId();
        }
        return strRefPSDEDataSetId;
    }

    @Override
    public String getRefLinkPSDEViewId(IPSApplication iPSApplication) throws Exception {
        String strRefLinkPSDEViewId = super.getRefLinkPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefLinkPSDEViewId)) {
            return strRefLinkPSDEViewId;
        }
        return this.inheritPSDEFGridColumn.getRefLinkPSDEViewId(iPSApplication);
    }

    @Override
    public String getRefMPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        String strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefMPickupPSDEViewId)) {
            return strRefMPickupPSDEViewId;
        }
        return this.inheritPSDEFGridColumn.getRefMPickupPSDEViewId(iPSApplication);
    }

    @Override
    public String getRefPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        String strRefPickupPSDEViewId = super.getRefPickupPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefPickupPSDEViewId)) {
            return strRefPickupPSDEViewId;
        }
        return this.inheritPSDEFGridColumn.getRefPickupPSDEViewId(iPSApplication);
    }
}

