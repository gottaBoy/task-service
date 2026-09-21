/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.sysmodel.DynamicCodeListModelBase;

public class GlobalScopeDictCatCodeListModel
extends DynamicCodeListModelBase {
    private String strCat = "";
    private String strOwnerType = "";
    private String strOwnerId = "";

    public String getCat() {
        return this.strCat;
    }

    public void setCat(String strCat) {
        this.strCat = strCat;
    }

    public String getOwnerType() {
        return this.strOwnerType;
    }

    public void setOwnerType(String strOwnerType) {
        this.strOwnerType = strOwnerType;
    }

    public String getOwnerId() {
        return this.strOwnerId;
    }

    public void setOwnerId(String strOwnerId) {
        this.strOwnerId = strOwnerId;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    @Override
    public String getId() {
        return this.strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getName() {
        return this.strName;
    }

    @Override
    public String getCodeListType() {
        return "DYNAMIC";
    }
}

