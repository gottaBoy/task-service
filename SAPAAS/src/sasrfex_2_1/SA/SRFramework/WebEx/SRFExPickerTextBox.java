/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExPickerEx;
import SA.SRFramework.WebEx.SRFExTextBox;

public class SRFExPickerTextBox
extends SRFExTextBox {
    public SRFExPickerEx picker = null;

    public SRFExPickerTextBox(SRFExPickerEx picker) {
        this.picker = picker;
    }

    @Override
    public void setValue(String strValue) {
        CodeListConfig codeListConfig;
        String strHiddenValue;
        String strCodeList;
        if (this.picker != null && StringHelper.Length((String)(strCodeList = this.picker.getPickerExConfig().getCodeList())) > 0 && StringHelper.Length((String)(strHiddenValue = this.picker.getPickerExConfig().getValue())) > 0 && (codeListConfig = this.getPage().getWebContext().getCodeListMgr().GetCodeListConfig(strCodeList, this.getWebContext().getLocalization())) != null) {
            String strText = codeListConfig.GetCodeListValueWithStyle(strHiddenValue, true);
            super.setValue(strText);
            return;
        }
        super.setValue(strValue);
    }

    @Override
    public String getItemEnableStateJSCall() {
        return "";
    }
}

