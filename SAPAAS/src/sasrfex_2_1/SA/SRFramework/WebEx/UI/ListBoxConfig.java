/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.ListControlConfig;
import java.util.ArrayList;

public class ListBoxConfig
extends ListControlConfig {
    public static final String TAG_LISTBOX = "SRFEXLISTBOX";
    public static final String TAG_ROWCOUNT = "ROWCOUNT";
    public static final String TAG_MULTIPLE = "MULTIPLE";
    public static final String TAG_SEPARATOR = "SEPARATOR";
    public static final String TAG_NUMBERORMODE = "NUMBERORMODE";
    protected String strSeparator = "|";
    protected boolean bNumberOrMode = false;
    protected int nRowCount = 5;
    protected boolean bMultiple = false;

    public ListBoxConfig() {
        this.strCssClass = "sx-listbox";
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ROWCOUNT, (boolean)true) == 0) {
            this.nRowCount = ListBoxConfig.GetValue((String)strValue, (int)this.nRowCount);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MULTIPLE, (boolean)true) == 0) {
            this.bMultiple = ListBoxConfig.GetValue((String)strValue, (boolean)this.bMultiple);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SEPARATOR, (boolean)true) == 0) {
            this.strSeparator = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NUMBERORMODE, (boolean)true) == 0) {
            this.bNumberOrMode = ListBoxConfig.GetValue((String)strValue, (boolean)this.bNumberOrMode);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getRowCount() {
        return this.nRowCount;
    }

    public void setRowCount(int nRowCount) {
        this.nRowCount = nRowCount;
    }

    public boolean getMultiple() {
        return this.bMultiple;
    }

    public void setMultiple(boolean bMultiple) {
        this.bMultiple = bMultiple;
    }

    public String getSeparator() {
        return this.strSeparator;
    }

    public void setSeparator(String strSeparator) {
        this.strSeparator = strSeparator;
    }

    public boolean getNumberOrMode() {
        return this.bNumberOrMode;
    }

    public void setNumberOrMode(boolean bNumberOrMode) {
        this.bNumberOrMode = bNumberOrMode;
    }

    public ArrayList getSelectedValues() {
        ArrayList<String> list = new ArrayList<String>();
        if (this.bMultiple) {
            String[] arr = this.getSelectedValue().split(this.strSeparator);
            int i = 0;
            while (i < arr.length) {
                if (StringHelper.Length((String)arr[i]) != 0) {
                    list.add(arr[i]);
                }
                ++i;
            }
        } else {
            list.add(this.getSelectedValue());
        }
        return list;
    }
}

