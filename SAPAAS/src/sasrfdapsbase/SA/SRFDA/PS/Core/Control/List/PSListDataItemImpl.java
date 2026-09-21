/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.List.IPSListDataItem;
import SA.SRFDA.PS.Core.Data.PSDataItemImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSListDataItemImpl
extends PSDataItemImpl
implements IPSListDataItem {
    private IPSCodeList frontPSCodeList = null;
    private String strPrivilegeId = null;
    private String strGroupItem = null;
    private boolean bCustomCode = false;
    private String strScriptCode = null;

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u4ee3\u7801\u8868", dumpref=true)
    public IPSCodeList getFrontPSCodeList() {
        return this.frontPSCodeList;
    }

    public void setFrontPSCodeList(IPSCodeList frontPSCodeList) {
        this.frontPSCodeList = frontPSCodeList;
    }

    public String getPrivilegeId() {
        return this.strPrivilegeId;
    }

    public void setPrivilegeId(String strPrivilegeId) {
        this.strPrivilegeId = strPrivilegeId;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5206\u7ec4\u9879")
    public String getGroupItem() {
        return this.strGroupItem;
    }

    public void setGroupItem(String strGroupItem) {
        this.strGroupItem = strGroupItem;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isCustomCode() {
        return this.bCustomCode;
    }

    public void setCustomCode(boolean bCustomCode) {
        this.bCustomCode = bCustomCode;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801")
    public String getScriptCode() {
        return this.strScriptCode;
    }

    public void setScriptCode(String strScriptCode) {
        this.strScriptCode = strScriptCode;
    }
}

