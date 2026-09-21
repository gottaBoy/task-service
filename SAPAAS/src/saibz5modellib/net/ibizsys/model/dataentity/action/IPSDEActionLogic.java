/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.logic.IPSDELogic;

public interface IPSDEActionLogic
extends IPSModelObject {
    public static final String ATTACHMODE_BEFORE = "BEFORE";
    public static final String ATTACHMODE_AFTER = "AFTER";

    public IPSDEAction getPSDEAction();

    public String getAttachMode();

    public String getPSDELogicId();

    public String getPSDELogicName();

    public IPSDELogic getPSDELogic() throws Exception;

    public boolean isInternalLogic();

    public IPSDataEntity getDstPSDE() throws Exception;

    public IPSDEAction getDstPSDEAction() throws Exception;

    public boolean isValid();

    public boolean isCloneParam();

    public boolean isIgnoreException();
}

