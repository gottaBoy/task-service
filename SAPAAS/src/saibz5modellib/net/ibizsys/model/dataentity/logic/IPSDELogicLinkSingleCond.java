/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond;
import net.ibizsys.model.dataentity.logic.IPSDELogicParam;

public interface IPSDELogicLinkSingleCond
extends IPSDELogicLinkCond {
    public IPSDELogicParam getDstLogicParam() throws Exception;

    public String getDstFieldName() throws Exception;

    public String getPSDBValueOPId();

    public String getValue();
}

