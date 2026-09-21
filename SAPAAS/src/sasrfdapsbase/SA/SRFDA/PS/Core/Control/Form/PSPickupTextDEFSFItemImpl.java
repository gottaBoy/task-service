/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.PSPickupDataDEFSFItemImpl;
import SA.SRFDA.PS.Core.DEField.IPSPickupTextDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

public class PSPickupTextDEFSFItemImpl
extends PSPickupDataDEFSFItemImpl {
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

    @Override
    protected void onInit() throws Exception {
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
    }

    @Override
    protected String getDefaultEditorType() throws Exception {
        if (StringHelper.Compare((String)this.getPSDBValueOP().getId(), (String)"EQ", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSDBValueOP().getId(), (String)"NOTEQ", (boolean)true) == 0) {
            return super.getDefaultEditorType();
        }
        if (this.isMobileApp()) {
            return "MOBTEXT";
        }
        return "TEXTBOX";
    }

    @Override
    public String getValueItemName(IPSDEFormItem iPSDEFormItem) {
        if (iPSDEFormItem.getPSEditorType() != null && (StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0)) {
            return StringHelper.Format((String)"N_%1$s_%2$s", (Object)this.iPSPickupDEField.getName(), (Object)this.getPSDBValueOP().getId()).toLowerCase();
        }
        return "";
    }

    @Override
    public String getRefPSDEDataSetId() {
        if (!StringHelper.IsNullOrEmpty((String)super.getRefPSDEDataSetId())) {
            return super.getRefPSDEDataSetId();
        }
        return this.strRefPSDEDataSetId;
    }

    @Override
    public String getRefPSDEACModeId() {
        if (!StringHelper.IsNullOrEmpty((String)super.getRefPSDEACModeId())) {
            return super.getRefPSDEACModeId();
        }
        return this.strRefPSDEACModeId;
    }

    @Override
    public String getRefPickupPSDEViewId() {
        if (!StringHelper.IsNullOrEmpty((String)super.getRefPickupPSDEViewId())) {
            return super.getRefPickupPSDEViewId();
        }
        return this.strRefPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewName() {
        if (!StringHelper.IsNullOrEmpty((String)super.getRefPickupPSDEViewName())) {
            return super.getRefPickupPSDEViewName();
        }
        return this.strRefPickupPSDEViewName;
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        if (!StringHelper.IsNullOrEmpty((String)super.getRefMPickupPSDEViewId())) {
            return super.getRefMPickupPSDEViewId();
        }
        return this.strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        if (!StringHelper.IsNullOrEmpty((String)super.getRefMPickupPSDEViewName())) {
            return super.getRefMPickupPSDEViewName();
        }
        return this.strRefMPickupPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId() {
        if (!StringHelper.IsNullOrEmpty((String)super.getRefLinkPSDEViewId())) {
            return super.getRefLinkPSDEViewId();
        }
        return this.strRefLinkPSDEViewId;
    }

    @Override
    public String getRefLinkPSDEViewName() {
        if (!StringHelper.IsNullOrEmpty((String)super.getRefLinkPSDEViewName())) {
            return super.getRefLinkPSDEViewName();
        }
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
        IPSDER1N iPSDER1N;
        JSONObject itemParam = super.getItemParam(iPSDEFormItem);
        if (iPSDEFormItem.getPSEditorType() != null && (StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0) && (iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER()).getTempDataOrder() >= 0) {
            if (itemParam == null) {
                itemParam = new JSONObject();
            }
            JSONObjectHelper.put((JSONObject)itemParam, (String)"temprs", (Object)true);
        }
        return itemParam;
    }

    @Override
    public String getRefLinkPSDEViewId(IPSApplication iPSApplication) throws Exception {
        IPSAppDataEntity iPSAppDataEntity;
        String strRefLinkPSDEViewId = super.getRefLinkPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefLinkPSDEViewId)) {
            return strRefLinkPSDEViewId;
        }
        IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
        if (iPSApplication.isMobileApp()) {
            if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriMobLinkPSDEViewId())) {
                return iPSDER1N.getOriMobLinkPSDEViewId();
            }
        } else if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriLinkPSDEViewId())) {
            return iPSDER1N.getOriLinkPSDEViewId();
        }
        if ((iPSAppDataEntity = iPSApplication.getPSAppDataEntity(iPSDER1N.getMajorPSDataEntity(), true)) != null && !StringHelper.IsNullOrEmpty((String)iPSAppDataEntity.getRefLinkPSDEViewId())) {
            return iPSAppDataEntity.getRefLinkPSDEViewId();
        }
        if (iPSApplication.isMobileApp()) {
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
        if (iPSApplication.isMobileApp()) {
            if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriMobMPickupPSDEViewId())) {
                return iPSDER1N.getOriMobMPickupPSDEViewId();
            }
        } else if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriMPickupPSDEViewId())) {
            return iPSDER1N.getOriMPickupPSDEViewId();
        }
        if ((iPSAppDataEntity = iPSApplication.getPSAppDataEntity(iPSDER1N.getMajorPSDataEntity(), true)) != null && !StringHelper.IsNullOrEmpty((String)iPSAppDataEntity.getRefMPickupPSDEViewId())) {
            return iPSAppDataEntity.getRefMPickupPSDEViewId();
        }
        if (iPSApplication.isMobileApp()) {
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
        if (iPSApplication.isMobileApp()) {
            if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriMobPickupPSDEViewId())) {
                return iPSDER1N.getOriMobPickupPSDEViewId();
            }
        } else if (!StringHelper.IsNullOrEmpty((String)iPSDER1N.getOriPickupPSDEViewId())) {
            return iPSDER1N.getOriPickupPSDEViewId();
        }
        if ((iPSAppDataEntity = iPSApplication.getPSAppDataEntity(iPSDER1N.getMajorPSDataEntity(), true)) != null && !StringHelper.IsNullOrEmpty((String)iPSAppDataEntity.getRefPickupPSDEViewId())) {
            return iPSAppDataEntity.getRefPickupPSDEViewId();
        }
        if (iPSApplication.isMobileApp()) {
            return iPSDER1N.getMobRefPickupPSDEViewId();
        }
        return iPSDER1N.getRefPickupPSDEViewId();
    }
}

