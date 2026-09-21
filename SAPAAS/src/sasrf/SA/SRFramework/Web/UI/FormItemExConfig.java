/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Web.UI.BaseFormItemGroup;
import SA.SRFramework.Web.UI.FormItemConfig;
import org.w3c.dom.Node;

public class FormItemExConfig
extends BaseFormItemGroup {
    protected static String CAPTION = "CAPTION";
    protected static String EMPTY = "EMPTY";
    protected static String CELLCOUNT = "CELLCOUNT";
    protected static String SINGLEROW = "SINGLEROW";
    protected static String LONGCAPTION = "LONGCAPTION";
    protected boolean bAllowEmpty = false;
    protected String strCaption = "";
    protected int nCellCount = 0;
    protected boolean bSingleRow = false;
    protected boolean bLongCaption = false;

    public FormItemExConfig() {
        this.strId = Helper.GenGuid();
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setCaption(String value) {
        this.strCaption = value;
    }

    public boolean getAllowEmpty() {
        return this.bAllowEmpty;
    }

    public void setAllowEmpty(boolean bValue) {
        this.bAllowEmpty = bValue;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(EMPTY) == 0) {
            this.bAllowEmpty = FormItemExConfig.GetValue(strValue, this.bAllowEmpty);
            return;
        }
        if (strName.compareToIgnoreCase(CAPTION) == 0) {
            this.strCaption = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(CELLCOUNT) == 0) {
            this.nCellCount = FormItemExConfig.GetValue(strValue, this.nCellCount);
            return;
        }
        if (strName.compareToIgnoreCase(SINGLEROW) == 0) {
            this.bSingleRow = FormItemExConfig.GetValue(strValue, this.bSingleRow);
            return;
        }
        if (strName.compareToIgnoreCase(LONGCAPTION) == 0) {
            this.bLongCaption = FormItemExConfig.GetValue(strValue, this.bLongCaption);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getCellCount() {
        return this.nCellCount;
    }

    public boolean getSingleRow() {
        return this.bSingleRow;
    }

    public void setSingleRow(boolean value) {
        this.bSingleRow = value;
    }

    public boolean getLongCaption() {
        return this.bLongCaption;
    }

    public void setLongCaption(boolean value) {
        this.bLongCaption = value;
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(FORMITEM) == 0) {
            FormItemConfig formItemConfig = new FormItemConfig();
            if (formItemConfig.LoadConfig(xmlNode)) {
                formItemConfig.setGroup(this.getID());
                this.groupItemList.add(formItemConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

