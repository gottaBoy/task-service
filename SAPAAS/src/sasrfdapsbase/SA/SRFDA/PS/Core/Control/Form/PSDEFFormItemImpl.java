/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSFIDEFValueRule;
import SA.SRFDA.PS.Core.DEField.PSDEFUIItemImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFFormItemImpl
extends PSDEFUIItemImpl
implements IPSDEFFormItem {
    private static final Log log = LogFactory.getLog(PSDEFFormItemImpl.class);
    protected ArrayList<IPSFIDEFValueRule> psFIDEFValueRuleList = null;
    private String strValueItemName = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strValueItemName = this.psDEFUIMode.getVALUEITEMNAME();
    }

    @Override
    public int getEditorWidth() {
        if (!this.psDEFUIMode.isWIDTHNull()) {
            return this.psDEFUIMode.getWIDTH();
        }
        if (this.nDefaultEditorWidth != null) {
            return this.nDefaultEditorWidth;
        }
        if (this.iPSEditorType != null) {
            return this.iPSEditorType.getWidth();
        }
        return this.psDEFUIMode.getWIDTH();
    }

    @Override
    public int getEditorHeight() {
        if (!this.psDEFUIMode.isHEIGHTNull()) {
            return this.psDEFUIMode.getHEIGHT();
        }
        if (this.nDefaultEditorHeight != null) {
            return this.nDefaultEditorHeight;
        }
        if (this.iPSEditorType != null) {
            return this.iPSEditorType.getHeight();
        }
        return this.psDEFUIMode.getHEIGHT();
    }

    @Override
    public String getValueItemName(IPSDEFormItem iPSDEFormItem) {
        return this.strValueItemName;
    }

    @Override
    public Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules() {
        if (this.psFIDEFValueRuleList == null || this.psFIDEFValueRuleList.size() == 0) {
            return null;
        }
        return this.psFIDEFValueRuleList.iterator();
    }

    @Override
    public String getItemHandlerType(IPSDEFormItem iPSDEFormItem) {
        if (iPSDEFormItem.getPSEditorType() != null) {
            if (StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDEFormItem.getPSCodeList() != null && StringHelper.Compare((String)iPSDEFormItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
                return "CodeList";
            }
            if (StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
                return "AC";
            }
            if (StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0) {
                return "PickupText";
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSAjaxHandlerId())) {
            return "Custom";
        }
        return "";
    }

    @Override
    public int getEnableCond() {
        return this.iPSDEField.getEnableUserInput();
    }

    @Override
    public JSONObject getItemParam(IPSDEFormItem iPSDEFormItem) throws Exception {
        return null;
    }

    @Override
    public String getModelType() {
        return "PSDEFFORMITEM";
    }

    @Override
    public boolean getAllowEmpty(IPSDEFormItem iPSDEFormItem) {
        return this.isAllowEmpty();
    }
}

