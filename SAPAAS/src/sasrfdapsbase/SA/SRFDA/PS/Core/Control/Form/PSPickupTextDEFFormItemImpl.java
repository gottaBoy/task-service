/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.PSPickupDataDEFFormItemImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSInheritDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupTextDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class PSPickupTextDEFFormItemImpl
extends PSPickupDataDEFFormItemImpl {
    protected IPSPickupTextDEField iPSPickupTextDEField = null;
    private String strRefPickupPSDEViewId = "";
    private String strRefPickupPSDEViewName = "";
    private String strRefMPickupPSDEViewId = "";
    private String strRefMPickupPSDEViewName = "";
    private String strRefLinkPSDEViewId = "";
    private String strRefLinkPSDEViewName = "";
    private String strRefPSDEDataSetId = "";
    private String strRefPSDEACModeId = "";
    private String strRefPSDERId = "";
    private int nPickupTextOpts = 0;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDEFUIMode.isPICKUPTEXTOPTSNull()) {
            this.nPickupTextOpts = this.psDEFUIMode.getPICKUPTEXTOPTS();
        }
        this.iPSPickupTextDEField = (IPSPickupTextDEField)this.getPSDEField();
        if (this.iPSPickupTextDEField == null) {
            throw new Exception(StringHelper.Format((String)"\u5916\u952e\u6587\u672c\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)this.getPSDEField().getFullName()));
        }
        super.onInit();
        IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
        this.strRefPickupPSDEViewId = super.getRefPickupPSDEViewId();
        this.strRefPickupPSDEViewName = super.getRefPickupPSDEViewName();
        if (StringHelper.IsNullOrEmpty((String)super.getRefPickupPSDEViewId())) {
            this.strRefPickupPSDEViewId = iPSDER1N.getRefPickupPSDEViewId();
            this.strRefPickupPSDEViewName = iPSDER1N.getRefPickupPSDEViewName();
        }
        this.strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId();
        this.strRefMPickupPSDEViewName = super.getRefMPickupPSDEViewName();
        if (StringHelper.IsNullOrEmpty((String)super.getRefPickupPSDEViewId())) {
            this.strRefMPickupPSDEViewId = iPSDER1N.getRefMPickupPSDEViewId();
            this.strRefMPickupPSDEViewName = iPSDER1N.getRefMPickupPSDEViewName();
        }
        this.strRefLinkPSDEViewId = super.getRefLinkPSDEViewId();
        this.strRefLinkPSDEViewName = super.getRefLinkPSDEViewName();
        if (StringHelper.IsNullOrEmpty((String)super.getRefLinkPSDEViewId())) {
            this.strRefLinkPSDEViewId = iPSDER1N.getRefLinkPSDEViewId();
            this.strRefLinkPSDEViewName = iPSDER1N.getRefLinkPSDEViewName();
        }
        this.strRefPSDEDataSetId = super.getRefPSDEDataSetId();
        if (StringHelper.IsNullOrEmpty((String)super.getRefPSDEDataSetId())) {
            this.strRefPSDEDataSetId = iPSDER1N.getRefPSDEDataSetId();
        }
        this.strRefPSDEACModeId = super.getRefPSDEACModeId();
        if (StringHelper.IsNullOrEmpty((String)super.getRefPSDEACModeId())) {
            this.strRefPSDEACModeId = iPSDER1N.getRefPSDEACModeId();
        }
        this.strRefPSDERId = super.getRefPSDERId();
        if (StringHelper.IsNullOrEmpty((String)super.getRefPSDERId())) {
            this.strRefPSDERId = iPSDER1N.getId();
        }
    }

    @Override
    public String getValueItemName(IPSDEFormItem iPSDEFormItem) {
        String strValueItemName = super.getValueItemName(iPSDEFormItem);
        if (StringHelper.IsNullOrEmpty((String)strValueItemName) && iPSDEFormItem.getPSEditorType() != null && (StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0)) {
            return this.iPSPickupDEField.getName().toLowerCase();
        }
        return strValueItemName;
    }

    @Override
    public String getRefPSDEDataSetId() {
        return this.strRefPSDEDataSetId;
    }

    @Override
    public String getRefPSDEACModeId() {
        return this.strRefPSDEACModeId;
    }

    @Override
    public String getRefPickupPSDEViewId() {
        return this.strRefPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewName() {
        return this.strRefPickupPSDEViewName;
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        return this.strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        return this.strRefMPickupPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId() {
        return this.strRefLinkPSDEViewId;
    }

    @Override
    public String getRefLinkPSDEViewName() {
        return this.strRefLinkPSDEViewName;
    }

    @Override
    public String getItemHandlerType(IPSDEFormItem iPSDEFormItem) {
        if (iPSDEFormItem.getPSEditorType() != null && (StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0)) {
            return "PickupText";
        }
        return super.getItemHandlerType(iPSDEFormItem);
    }

    @Override
    public JSONObject getItemParam(IPSDEFormItem iPSDEFormItem) throws Exception {
        JSONObject itemParam = super.getItemParam(iPSDEFormItem);
        if (iPSDEFormItem.getPSEditorType() != null && (StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0)) {
            IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
            if (iPSDER1N.isEnableExtRestrict() && (this.nPickupTextOpts & 1) == 0) {
                IPSDEField erMajorPSDEField;
                if (itemParam == null) {
                    itemParam = new JSONObject();
                }
                JSONObject fetchcond = new JSONObject();
                fetchcond.put(StringHelper.Format((String)"n_%1$s_eq", (Object)iPSDER1N.getERMajorPSDEFName().toLowerCase()), (Object)iPSDER1N.getERMinorPSDEFName().toLowerCase());
                itemParam.put("fetchcond", (Object)fetchcond);
                if (iPSDEFormItem.getPSDEForm().getPSAppView().getPSPFStyle().getPFEngineVer() >= 20 && (erMajorPSDEField = iPSDER1N.getMajorPSDataEntity().getPSDEField(iPSDER1N.getERMajorPSDEFName(), true)) != null) {
                    JSONObject parentDataJO;
                    if (erMajorPSDEField instanceof IPSInheritDEField) {
                        erMajorPSDEField = ((IPSInheritDEField)erMajorPSDEField).getRelatedPSDEField();
                    }
                    IPSPickupDEField iPSPickupDEField2 = null;
                    if (erMajorPSDEField instanceof IPSPickupDEField) {
                        iPSPickupDEField2 = (IPSPickupDEField)erMajorPSDEField;
                    }
                    if ((parentDataJO = itemParam.optJSONObject("parentdata")) == null) {
                        parentDataJO = new JSONObject();
                        itemParam.put("parentdata", (Object)parentDataJO);
                    }
                    if (!parentDataJO.has("srfparentkey") && !parentDataJO.has("SRFPARENTKEY")) {
                        parentDataJO.put("srfparentkey", (Object)("%" + iPSDER1N.getERMinorPSDEFName().toLowerCase() + "%"));
                    }
                    if (iPSPickupDEField2 != null) {
                        IPSDER1N iPSDER1N2 = (IPSDER1N)iPSPickupDEField2.getPSDER();
                        if (!parentDataJO.has("srfparentdename") && !parentDataJO.has("SRFPARENTDENAME")) {
                            parentDataJO.put("srfparentdename", (Object)iPSDER1N2.getMajorPSDataEntity().getName());
                        }
                        if (!parentDataJO.has("srfparentmode") && !parentDataJO.has("SRFPARENTMODE")) {
                            parentDataJO.put("srfparentmode", (Object)iPSDER1N2.getName());
                        }
                        if (!parentDataJO.has("srfparentdefname") && !parentDataJO.has("SRFPARENTDEFNAME")) {
                            parentDataJO.put("srfparentdefname", (Object)iPSDER1N2.getPickupDEFName());
                        }
                    } else if (!parentDataJO.has("srfparentdefname") && !parentDataJO.has("SRFPARENTDEFNAME")) {
                        parentDataJO.put("srfparentdefname", (Object)iPSDER1N.getERMajorPSDEFName());
                    }
                }
            }
            if (iPSDER1N.getTempDataOrder() >= 0 && (this.nPickupTextOpts & 2) == 0) {
                if (itemParam == null) {
                    itemParam = new JSONObject();
                }
                itemParam.put("temprs", true);
            }
        }
        return itemParam;
    }

    @Override
    public String getRefPSDERId() {
        return this.strRefPSDERId;
    }

    @Override
    public String getRefLinkPSDEViewId(IPSApplication iPSApplication) throws Exception {
        IPSAppDataEntity iPSAppDataEntity;
        String strRefLinkPSDEViewId = super.getRefLinkPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefLinkPSDEViewId)) {
            return strRefLinkPSDEViewId;
        }
        IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
        if (this.isMobileMode()) {
            if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriMobLinkPSDEViewId())) {
                return iPSDER1N.getOriMobLinkPSDEViewId();
            }
        } else if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriLinkPSDEViewId())) {
            return iPSDER1N.getOriLinkPSDEViewId();
        }
        if ((iPSAppDataEntity = iPSApplication.getPSAppDataEntity(iPSDER1N.getMajorPSDataEntity(), true)) != null && !StringHelper.IsNullOrEmpty((String)iPSAppDataEntity.getRefLinkPSDEViewId())) {
            return iPSAppDataEntity.getRefLinkPSDEViewId();
        }
        if (this.isMobileMode()) {
            return iPSDER1N.getMobRefLinkPSDEViewId();
        }
        return iPSDER1N.getRefLinkPSDEViewId();
    }

    @Override
    public String getRefMPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        IPSAppDataEntity iPSAppDataEntity;
        String strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefMPickupPSDEViewId)) {
            return strRefMPickupPSDEViewId;
        }
        IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
        if (this.isMobileMode()) {
            if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriMobMPickupPSDEViewId())) {
                return iPSDER1N.getOriMobMPickupPSDEViewId();
            }
        } else if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriMPickupPSDEViewId())) {
            return iPSDER1N.getOriMPickupPSDEViewId();
        }
        if ((iPSAppDataEntity = iPSApplication.getPSAppDataEntity(iPSDER1N.getMajorPSDataEntity(), true)) != null && !StringHelper.IsNullOrEmpty((String)iPSAppDataEntity.getRefMPickupPSDEViewId())) {
            return iPSAppDataEntity.getRefMPickupPSDEViewId();
        }
        if (this.isMobileMode()) {
            return iPSDER1N.getMobRefMPickupPSDEViewId();
        }
        return iPSDER1N.getRefMPickupPSDEViewId();
    }

    @Override
    public String getRefPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        IPSAppDataEntity iPSAppDataEntity;
        String strRefPickupPSDEViewId = super.getRefPickupPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefPickupPSDEViewId)) {
            return strRefPickupPSDEViewId;
        }
        IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
        if (this.isMobileMode()) {
            if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriMobPickupPSDEViewId())) {
                return iPSDER1N.getOriMobPickupPSDEViewId();
            }
        } else if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriPickupPSDEViewId())) {
            return iPSDER1N.getOriPickupPSDEViewId();
        }
        if ((iPSAppDataEntity = iPSApplication.getPSAppDataEntity(iPSDER1N.getMajorPSDataEntity(), true)) != null && !StringHelper.IsNullOrEmpty((String)iPSAppDataEntity.getRefPickupPSDEViewId())) {
            return iPSAppDataEntity.getRefPickupPSDEViewId();
        }
        if (this.isMobileMode()) {
            return iPSDER1N.getMobRefPickupPSDEViewId();
        }
        return iPSDER1N.getRefPickupPSDEViewId();
    }

    @Override
    public boolean getAllowEmpty(IPSDEFormItem iPSDEFormItem) {
        if (!((this.getPSSystemSetting().getEngineBugFixs() & 0x10) == 0 || this.isAllowEmptyDefined() || StringHelper.Compare((String)this.getEditorType(), (String)iPSDEFormItem.getEditorType(), (boolean)false) != 0 || StringHelper.Compare((String)this.getValueItemName(iPSDEFormItem), (String)iPSDEFormItem.getValueItemName(), (boolean)false) != 0 || StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) != 0 && StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) != 0 || this.iPSPickupDEField.isAllowEmpty())) {
            return false;
        }
        return super.getAllowEmpty(iPSDEFormItem);
    }
}

