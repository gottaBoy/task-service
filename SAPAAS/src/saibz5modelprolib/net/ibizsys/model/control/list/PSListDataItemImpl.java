/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.list.IPSListDataItem
 */
package net.ibizsys.model.control.list;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.list.IPSListDataItem;
import net.ibizsys.model.data.PSDataItemImpl;

public class PSListDataItemImpl
extends PSDataItemImpl
implements IPSListDataItem {
    private IPSCodeList frontPSCodeList = null;
    private String strPrivilegeId = null;

    @PSModelRTMeta(description="\u524d\u7aef\u4ee3\u7801\u8868\u5bf9\u8c61")
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
}

