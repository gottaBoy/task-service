/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.form.IPSDEFFormItem
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSFIDEFValueRule
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 *  net.ibizsys.paas.core.valuerule.IDEFValueRule
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSFIDEFValueRule;
import net.ibizsys.model.control.form.PSFIDEFValueRuleImpl;
import net.ibizsys.model.dataentity.field.PSDEFUIItemImpl;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;
import net.ibizsys.paas.util.StringHelper;
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
        Iterator psDEFValueRules = this.iPSDEField.getAllPSDEFValueRules();
        if (psDEFValueRules != null) {
            while (psDEFValueRules.hasNext()) {
                if (this.psFIDEFValueRuleList == null) {
                    this.psFIDEFValueRuleList = new ArrayList();
                }
                IPSDEFValueRule iPSDEFValueRule = (IPSDEFValueRule)psDEFValueRules.next();
                PSFIDEFValueRuleImpl psFIDEFValueRuleImpl = new PSFIDEFValueRuleImpl();
                psFIDEFValueRuleImpl.setDEFValueRule((IDEFValueRule)iPSDEFValueRule);
                this.psFIDEFValueRuleList.add(psFIDEFValueRuleImpl);
            }
        }
    }

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

    public String getValueItemName(IPSDEFormItem iPSDEFormItem) {
        return this.strValueItemName;
    }

    public Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules() {
        if (this.psFIDEFValueRuleList == null || this.psFIDEFValueRuleList.size() == 0) {
            return null;
        }
        return this.psFIDEFValueRuleList.iterator();
    }

    public String getItemHandlerType(IPSDEFormItem iPSDEFormItem) {
        if (iPSDEFormItem.getPSEditorType() != null) {
            if (StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDEFormItem.getPSCodeList() != null && StringHelper.compare((String)iPSDEFormItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
                return "CodeList";
            }
            if (StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
                return "AC";
            }
            if (StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0) {
                return "PickupText";
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSAjaxHandlerId())) {
            return "Custom";
        }
        return "";
    }

    public int getEnableCond() {
        return this.iPSDEField.getEnableUserInput();
    }

    public ObjectNode getItemParam(IPSDEFormItem iPSDEFormItem) throws Exception {
        return null;
    }
}

