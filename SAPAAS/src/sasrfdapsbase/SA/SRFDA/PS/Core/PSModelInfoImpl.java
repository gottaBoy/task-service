/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelInfo;

public class PSModelInfoImpl
implements IPSModelInfo {
    private String strTag = null;
    private String strInfo = null;
    private String strType = null;
    private String strLinkTag = null;

    @Override
    public String getTag() {
        return this.strTag;
    }

    public void setTag(String strTag) {
        this.strTag = strTag;
    }

    @Override
    public String getInfo() {
        return this.strInfo;
    }

    public void setInfo(String strInfo) {
        this.strInfo = strInfo;
    }

    @Override
    public String getType() {
        return this.strType;
    }

    public void setType(String strType) {
        this.strType = strType;
    }

    @Override
    public String getLinkTag() {
        return this.strLinkTag;
    }

    public void setLinkTag(String strLinkTag) {
        this.strLinkTag = strLinkTag;
    }
}

