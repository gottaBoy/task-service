/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.paas.util.PropertiesHelper
 */
package net.ibizsys.model.dataentity.action;

import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.action.IPSDEActionType;
import net.ibizsys.model.entity.PSDEAction;
import net.ibizsys.model.entity.PSDEActionType;
import net.ibizsys.paas.util.PropertiesHelper;

public class PSDEActionTypeImpl
extends PSObjectImpl
implements IPSDEActionType {
    protected PSDEActionType psDEActionType = null;
    private Properties typeParams = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, PSDEActionType psDEActionType) throws Exception {
        this.psDEActionType = psDEActionType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psDEActionType.getPSDEACTIONTYPEID());
        this.setName(psDEActionType.getPSDEACTIONTYPENAME());
        this.setPSObjectData(this.psDEActionType);
        this.typeParams = PropertiesHelper.load((String)psDEActionType.getTYPEPARAM());
        this.onInit();
    }

    @Override
    public IPSDEAction createPSDEAction(PSDEAction psDEAction) throws Exception {
        return (IPSDEAction)this.getPSModelStorageContext().createObject(this.psDEActionType.getPROCESSOBJ());
    }

    @Override
    public Properties getTypeParams() {
        return this.typeParams;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

