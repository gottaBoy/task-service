/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.PSPickupDataDEFGridColumnImpl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItem;
import SA.SRFDA.PS.Core.DEField.IPSPickupTextDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class PSPickupTextDEFGridColumnImpl
extends PSPickupDataDEFGridColumnImpl {
    protected IPSPickupTextDEField iPSPickupTextDEField = null;
    private String strRefPickupPSDEViewId = "";
    private String strRefPickupPSDEViewName = "";
    private String strRefMPickupPSDEViewId = "";
    private String strRefMPickupPSDEViewName = "";
    private String strRefLinkPSDEViewId = "";
    private String strRefLinkPSDEViewName = "";
    private String strRefPSDEDataSetId = "";
    private String strRefPSDEACModeId = "";
    private int nPickupTextOpts = 0;
    private String strRefPSDERId = "";

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
    public String getValueItemName(IPSDEGridEditItem iPSDEGridEditItem) {
        String strValueItemName = super.getValueItemName(iPSDEGridEditItem);
        if (StringHelper.IsNullOrEmpty((String)strValueItemName) && iPSDEGridEditItem.getPSEditorType() != null && (StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0)) {
            return this.iPSPickupDEField.getName().toLowerCase();
        }
        return strValueItemName;
    }

    @Override
    public String getValueItemName(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) {
        String strValueItemName = super.getValueItemName(iPSDETreeNodeEditItem);
        if (StringHelper.IsNullOrEmpty((String)strValueItemName) && iPSDETreeNodeEditItem.getPSEditorType() != null && (StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0)) {
            return this.iPSPickupDEField.getName().toLowerCase();
        }
        return strValueItemName;
    }

    @Override
    public String getLinkValueItem(IPSDEGridEditItem iPSDEGridEditItem) {
        String strLinkValueItem = super.getLinkValueItem(iPSDEGridEditItem);
        if (StringHelper.IsNullOrEmpty((String)strLinkValueItem)) {
            return this.iPSPickupDEField.getName().toLowerCase();
        }
        return strLinkValueItem;
    }

    @Override
    public String getLinkValueItem(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) {
        String strLinkValueItem = super.getLinkValueItem(iPSDETreeNodeEditItem);
        if (StringHelper.IsNullOrEmpty((String)strLinkValueItem)) {
            return this.iPSPickupDEField.getName().toLowerCase();
        }
        return strLinkValueItem;
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
    public String getItemHandlerType(IPSDEGridEditItem iPSDEGridEditItem) {
        if (iPSDEGridEditItem.getPSEditorType() != null && (StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0)) {
            return "PickupText";
        }
        return super.getItemHandlerType(iPSDEGridEditItem);
    }

    @Override
    public String getItemHandlerType(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) {
        if (iPSDETreeNodeEditItem.getPSEditorType() != null && (StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0)) {
            return "PickupText";
        }
        return super.getItemHandlerType(iPSDETreeNodeEditItem);
    }

    @Override
    public JSONObject getItemParam(IPSDEGridEditItem iPSDEGridEditItem) throws Exception {
        JSONObject itemParam = super.getItemParam(iPSDEGridEditItem);
        if (iPSDEGridEditItem.getPSEditorType() != null && (StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0)) {
            IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
            if (iPSDER1N.isEnableExtRestrict() && (this.nPickupTextOpts & 1) == 0) {
                if (itemParam == null) {
                    itemParam = new JSONObject();
                }
                JSONObject fetchcond = new JSONObject();
                fetchcond.put(StringHelper.Format((String)"n_%1$s_eq", (Object)iPSDER1N.getERMajorPSDEFName().toLowerCase()), (Object)iPSDER1N.getERMinorPSDEFName().toLowerCase());
                itemParam.put("fetchcond", (Object)fetchcond);
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
    public JSONObject getItemParam(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) throws Exception {
        JSONObject itemParam = super.getItemParam(iPSDETreeNodeEditItem);
        if (iPSDETreeNodeEditItem.getPSEditorType() != null && (StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0)) {
            IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
            if (iPSDER1N.isEnableExtRestrict() && (this.nPickupTextOpts & 1) == 0) {
                if (itemParam == null) {
                    itemParam = new JSONObject();
                }
                JSONObject fetchcond = new JSONObject();
                fetchcond.put(StringHelper.Format((String)"n_%1$s_eq", (Object)iPSDER1N.getERMajorPSDEFName().toLowerCase()), (Object)iPSDER1N.getERMinorPSDEFName().toLowerCase());
                itemParam.put("fetchcond", (Object)fetchcond);
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
        String strRefLinkPSDEViewId = super.getRefLinkPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefLinkPSDEViewId)) {
            return strRefLinkPSDEViewId;
        }
        IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
        if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriLinkPSDEViewId())) {
            return iPSDER1N.getOriLinkPSDEViewId();
        }
        IPSAppDataEntity iPSAppDataEntity = iPSApplication.getPSAppDataEntity(iPSDER1N.getMajorPSDataEntity(), true);
        if (iPSAppDataEntity != null && !StringHelper.IsNullOrEmpty((String)iPSAppDataEntity.getRefLinkPSDEViewId())) {
            return iPSAppDataEntity.getRefLinkPSDEViewId();
        }
        return iPSDER1N.getRefLinkPSDEViewId();
    }

    @Override
    public String getRefMPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        String strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefMPickupPSDEViewId)) {
            return strRefMPickupPSDEViewId;
        }
        IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
        if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriMPickupPSDEViewId())) {
            return iPSDER1N.getOriMPickupPSDEViewId();
        }
        IPSAppDataEntity iPSAppDataEntity = iPSApplication.getPSAppDataEntity(iPSDER1N.getMajorPSDataEntity(), true);
        if (iPSAppDataEntity != null && !StringHelper.IsNullOrEmpty((String)iPSAppDataEntity.getRefMPickupPSDEViewId())) {
            return iPSAppDataEntity.getRefMPickupPSDEViewId();
        }
        return iPSDER1N.getRefMPickupPSDEViewId();
    }

    @Override
    public String getRefPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        String strRefPickupPSDEViewId = super.getRefPickupPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefPickupPSDEViewId)) {
            return strRefPickupPSDEViewId;
        }
        IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
        if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriPickupPSDEViewId())) {
            return iPSDER1N.getOriPickupPSDEViewId();
        }
        IPSAppDataEntity iPSAppDataEntity = iPSApplication.getPSAppDataEntity(iPSDER1N.getMajorPSDataEntity(), true);
        if (iPSAppDataEntity != null && !StringHelper.IsNullOrEmpty((String)iPSAppDataEntity.getRefPickupPSDEViewId())) {
            return iPSAppDataEntity.getRefPickupPSDEViewId();
        }
        return iPSDER1N.getRefPickupPSDEViewId();
    }

    @Override
    public boolean getAllowEmpty(IPSDEGridEditItem iPSDEGridEditItem) {
        if (!((this.getPSSystemSetting().getEngineBugFixs() & 0x10) == 0 || this.isAllowEmptyDefined() || StringHelper.Compare((String)this.getEditorType(), (String)iPSDEGridEditItem.getEditorType(), (boolean)false) != 0 || StringHelper.Compare((String)this.getValueItemName(iPSDEGridEditItem), (String)iPSDEGridEditItem.getValueItemName(), (boolean)false) != 0 || StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) != 0 && StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) != 0 || this.iPSPickupDEField.isAllowEmpty())) {
            return false;
        }
        return super.getAllowEmpty(iPSDEGridEditItem);
    }

    @Override
    public boolean getAllowEmpty(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) {
        if (!((this.getPSSystemSetting().getEngineBugFixs() & 0x10) == 0 || this.isAllowEmptyDefined() || StringHelper.Compare((String)this.getEditorType(), (String)iPSDETreeNodeEditItem.getEditorType(), (boolean)false) != 0 || StringHelper.Compare((String)this.getValueItemName(iPSDETreeNodeEditItem), (String)iPSDETreeNodeEditItem.getValueItemName(), (boolean)false) != 0 || StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) != 0 && StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) != 0 || this.iPSPickupDEField.isAllowEmpty())) {
            return false;
        }
        return super.getAllowEmpty(iPSDETreeNodeEditItem);
    }
}

