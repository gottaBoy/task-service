/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 */
package net.ibizsys.model.dataentity.action;

import java.util.Properties;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.entity.PSDEAction;

public interface IPSDEActionType
extends IPSModelObject {
    public IPSDEAction createPSDEAction(PSDEAction var1) throws Exception;

    public Properties getTypeParams();
}

