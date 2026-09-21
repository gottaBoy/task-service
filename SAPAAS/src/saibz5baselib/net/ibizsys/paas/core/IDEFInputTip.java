/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IModelBase;

public interface IDEFInputTip
extends IModelBase {
    public String getContent();

    public String getContentLanResTag();

    public String getMoreUrl();

    public boolean isEnableClose();

    public String getUniqueTag();
}

