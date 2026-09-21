/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Editor.IPSCodeListEditor;
import SA.SRFDA.PS.Core.Control.PSEditorImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSCodeListEditorImpl
extends PSEditorImpl
implements IPSCodeListEditor {
    private IPSAppCodeList iPSAppCodeList = null;

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u4ee3\u7801\u8868")
    public IPSCodeList getPSCodeList() {
        return this.getPSEditorContainer().getPSCodeList();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4ee3\u7801\u8868\u5bf9\u8c61", dumpref=true, modelreftype="IGNOREDESIGN")
    public IPSAppCodeList getPSAppCodeList() {
        try {
            if (this.iPSAppCodeList == null && this.getPSCodeList() != null) {
                this.iPSAppCodeList = this.getPSEditorContainer().getPSControlContainer().getPSAppView().getPSApplication().getPSAppCodeList(this.getPSCodeList(), !this.isEnableUIModelEx());
            }
            return this.iPSAppCodeList;
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\uff08\u8fd0\u884c\u65f6\u5185\u8054\uff09", rtdump=2, hideempty=true, child=true)
    public IPSAppCodeList getInlinePSAppCodeList() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u4e3a\u6570\u7ec4\u5f62\u5f0f", ignoredumpvalues="false", ignorert=3)
    public boolean isArray() {
        Boolean bArray = this.getEditorParam("ARRAY", this.getDefaultArray());
        if (bArray == null) {
            return false;
        }
        return bArray;
    }

    protected Boolean getDefaultArray() {
        String strValue = this.getEditorParam("DEFAULTARRAY", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        try {
            return strValue.equalsIgnoreCase("TRUE");
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u5168\u90e8\u9879[ALLITEMS]", ignoredumpvalues="false")
    public boolean isAllItems() {
        Boolean bAllItem = this.getEditorParam("ALLITEMS", this.getDefaultAllItems());
        if (bAllItem == null) {
            return false;
        }
        return bAllItem;
    }

    protected Boolean getDefaultAllItems() {
        String strValue = this.getEditorParam("DEFAULTALLITEMS", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        try {
            return strValue.equalsIgnoreCase("TRUE");
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u9879\u6587\u672c[ALLITEMSTEXT]")
    public String getAllItemsText() {
        return this.getEditorParam("ALLITEMSTEXT", this.getDefaultAllItemsText());
    }

    protected String getDefaultAllItemsText() {
        String strValue = this.getEditorParam("DEFAULTALLITEMSTEXT", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        return null;
    }
}

