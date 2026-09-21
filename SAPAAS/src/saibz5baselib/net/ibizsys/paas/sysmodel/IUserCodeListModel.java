/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.codelist.IUserCodeList;

public interface IUserCodeListModel
extends IUserCodeList {
    public void setCurUserId(String var1);

    public String getCurUserId();
}

