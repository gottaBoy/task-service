/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.PSLinkDEFSFItemImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDataDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class PSPickupDataDEFSFItemImpl
extends PSLinkDEFSFItemImpl {
    protected IPSPickupDataDEField iPSPickupDataDEField = null;
    protected IPSPickupDEField iPSPickupDEField = null;
    private String strRefPSDEDataSetId = "";
    private String strRefPSDEId = "";
    private boolean bRefTempData = false;
    private IPSDEFFormItem writeBackPSDEFFormItem = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSPickupDataDEField = (IPSPickupDataDEField)this.getPSDEField();
        this.iPSPickupDEField = this.iPSPickupDataDEField.getPSPickupDEField();
        if (this.iPSPickupDEField == null) {
            throw new Exception(StringHelper.Format((String)"\u5916\u952e\u9644\u52a0\u6570\u636e\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)this.getPSDEField().getFullName()));
        }
        if (this.iPSPickupDataDEField.isEnableWriteBack()) {
            IPSDEFSearchMode iPSDEFSearchMode = this.iPSPickupDataDEField.getRealWriteBackPSDEField().getPSDEFSearchMode(this.getName(), true);
            this.writeBackPSDEFFormItem = iPSDEFSearchMode != null ? iPSDEFSearchMode.getPSDEFFormItem(this.getUIMode()) : (this.isMobileApp() ? this.iPSPickupDataDEField.getRealWriteBackPSDEField().getPSDEFUIMode("MOBILEDEFAULT").getPSDEFFormItem() : this.iPSPickupDataDEField.getRealWriteBackPSDEField().getPSDEFUIMode("DEFAULT").getPSDEFFormItem());
        }
        if (this.writeBackPSDEFFormItem == null) {
            this.strRefPSDEDataSetId = ((IPSDER1N)this.iPSPickupDEField.getPSDER()).getRefPSDEDataSetId();
            this.strRefPSDEId = ((IPSDER1N)this.iPSPickupDEField.getPSDER()).getMajorDEId();
            this.bRefTempData = ((IPSDER1N)this.iPSPickupDEField.getPSDER()).getTempDataOrder() >= 0;
        }
        super.onInit();
    }

    @Override
    public boolean isRefTempData() {
        return this.bRefTempData;
    }

    @Override
    public String getRefPSDEId() {
        String strRefPSDEId = super.getRefPSDEId();
        if (StringHelper.IsNullOrEmpty((String)strRefPSDEId)) {
            if (this.writeBackPSDEFFormItem != null) {
                return this.writeBackPSDEFFormItem.getRefPSDEId();
            }
            return this.strRefPSDEId;
        }
        return strRefPSDEId;
    }

    @Override
    public String getRefPSDEACModeId() {
        String strRefPSDEACModeId = super.getRefPSDEACModeId();
        if (StringHelper.IsNullOrEmpty((String)strRefPSDEACModeId) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getRefPSDEACModeId();
        }
        return strRefPSDEACModeId;
    }

    @Override
    public String getRefPSDEDataSetId() {
        String strRefPSDEDataSetId = super.getRefPSDEDataSetId();
        if (StringHelper.IsNullOrEmpty((String)strRefPSDEDataSetId)) {
            if (this.writeBackPSDEFFormItem != null) {
                return this.writeBackPSDEFFormItem.getRefPSDEDataSetId();
            }
            return this.strRefPSDEDataSetId;
        }
        return strRefPSDEDataSetId;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292)
    public String getEditorType() {
        String strEditorType = super.getEditorType();
        if ((StringHelper.IsNullOrEmpty((String)strEditorType) || !this.isEditorTypeDefined()) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getEditorType();
        }
        return strEditorType;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f", order=293)
    public String getEditorStyle() {
        String strEditorStyle = super.getEditorStyle();
        if ((StringHelper.IsNullOrEmpty((String)strEditorStyle) || !this.isEditorTypeDefined()) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getEditorStyle();
        }
        return strEditorStyle;
    }

    @Override
    public String getItemHandlerType(IPSDEFormItem iPSDEFormItem) {
        String strItemHandlerType = super.getItemHandlerType(iPSDEFormItem);
        if (StringHelper.IsNullOrEmpty((String)strItemHandlerType) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getItemHandlerType(iPSDEFormItem);
        }
        return strItemHandlerType;
    }

    @Override
    public JSONObject getItemParam(IPSDEFormItem iPSDEFormItem) throws Exception {
        JSONObject itemParam = super.getItemParam(iPSDEFormItem);
        if (itemParam == null && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getItemParam(iPSDEFormItem);
        }
        return itemParam;
    }

    @Override
    public String getValueItemName(IPSDEFormItem iPSDEFormItem) {
        String strValueItemName = super.getValueItemName(iPSDEFormItem);
        if (StringHelper.IsNullOrEmpty((String)strValueItemName) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getValueItemName(iPSDEFormItem);
        }
        return strValueItemName;
    }

    @Override
    public String getRefPickupPSDEViewId() {
        String strRefPickupPSDEViewId = super.getRefPickupPSDEViewId();
        if (StringHelper.IsNullOrEmpty((String)strRefPickupPSDEViewId) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getRefPickupPSDEViewId();
        }
        return strRefPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewName() {
        String strRefPickupPSDEViewName = super.getRefPickupPSDEViewName();
        if (StringHelper.IsNullOrEmpty((String)strRefPickupPSDEViewName) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getRefPickupPSDEViewName();
        }
        return strRefPickupPSDEViewName;
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        String strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId();
        if (StringHelper.IsNullOrEmpty((String)strRefMPickupPSDEViewId) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getRefMPickupPSDEViewId();
        }
        return strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        String strRefMPickupPSDEViewName = super.getRefMPickupPSDEViewName();
        if (StringHelper.IsNullOrEmpty((String)strRefMPickupPSDEViewName) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getRefMPickupPSDEViewName();
        }
        return strRefMPickupPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId() {
        String strRefLinkPSDEViewId = super.getRefLinkPSDEViewId();
        if (StringHelper.IsNullOrEmpty((String)strRefLinkPSDEViewId) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getRefLinkPSDEViewId();
        }
        return strRefLinkPSDEViewId;
    }

    @Override
    public String getRefLinkPSDEViewName() {
        String strRefLinkPSDEViewName = super.getRefLinkPSDEViewName();
        if (StringHelper.IsNullOrEmpty((String)strRefLinkPSDEViewName) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getRefLinkPSDEViewName();
        }
        return strRefLinkPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId(IPSApplication iPSApplication) throws Exception {
        String strRefLinkPSDEViewId = super.getRefLinkPSDEViewId(iPSApplication);
        if (StringHelper.IsNullOrEmpty((String)strRefLinkPSDEViewId) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getRefLinkPSDEViewId(iPSApplication);
        }
        return strRefLinkPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        String strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId(iPSApplication);
        if (StringHelper.IsNullOrEmpty((String)strRefMPickupPSDEViewId) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getRefMPickupPSDEViewId(iPSApplication);
        }
        return strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        String strRefPickupPSDEViewId = super.getRefPickupPSDEViewId(iPSApplication);
        if (StringHelper.IsNullOrEmpty((String)strRefPickupPSDEViewId) && this.writeBackPSDEFFormItem != null) {
            return this.writeBackPSDEFFormItem.getRefPickupPSDEViewId(iPSApplication);
        }
        return strRefPickupPSDEViewId;
    }
}

