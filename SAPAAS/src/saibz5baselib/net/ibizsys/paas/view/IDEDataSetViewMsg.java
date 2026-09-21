/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.view.IStaticViewMsg;
import net.ibizsys.paas.view.IViewMsgCacheSupporter;

public interface IDEDataSetViewMsg
extends IStaticViewMsg,
IViewMsgCacheSupporter {
    @Override
    public String getTitleLanResTag();

    @Override
    public String getMsgTemplateId();

    public String getDEName();

    public String getDEDataSetName();

    public String getTitleField();

    public String getTitleLanResTagField();

    public String getMsgTypeField();

    public String getMsgPosField();

    public String getRemoveFlagField();

    public String getContentField();

    public String getActiveDataDELogicId();

    public String getOrderValueField();

    public String getDSLink();
}

