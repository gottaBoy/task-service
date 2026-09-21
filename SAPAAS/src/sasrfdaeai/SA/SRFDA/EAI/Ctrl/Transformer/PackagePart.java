/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.Utility.StringHelper;

public class PackagePart {
    protected int nSize = 0;
    protected String strDataType = "";
    protected String strFormat = "";

    public int getSize() {
        return this.nSize;
    }

    public String getDataType() {
        if (StringHelper.IsNullOrEmpty((String)this.strDataType)) {
            return "STRING";
        }
        return this.strDataType;
    }

    public void setSize(int nSize) {
        this.nSize = nSize;
    }

    public void setDataType(String strDataType) {
        this.strDataType = strDataType;
    }

    public String getFormat() {
        return this.strFormat;
    }

    public void setFormat(String strFormat) {
        this.strFormat = strFormat;
    }
}

