/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.core.IModelBase2;
import net.ibizsys.paas.view.IViewMessage;

public interface IStaticViewMsg
extends IViewMessage,
IModelBase2 {
    public String getTitleLanResTag();

    public String getMsgTemplateId();
}

