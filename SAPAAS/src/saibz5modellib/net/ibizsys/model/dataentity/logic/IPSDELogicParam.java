/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.logic.IPSDELogic;

public interface IPSDELogicParam
extends IPSModelObject {
    public IPSDELogic getPSDELogic();

    public String getCodeName();

    public IPSDataEntity getParamPSDataEntity() throws Exception;

    public boolean isDefault();

    public boolean isSessionParam();

    public boolean isEnvParam();
}

