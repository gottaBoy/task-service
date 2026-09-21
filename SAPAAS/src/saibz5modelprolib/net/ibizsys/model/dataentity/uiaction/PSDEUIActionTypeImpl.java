/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionType;
import net.ibizsys.model.entity.PSDEUIActionType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUIActionTypeImpl
extends PSObjectImpl
implements IPSDEUIActionType {
    protected PSDEUIActionType psDEUIActionType = null;
    private static final Log log = LogFactory.getLog(PSDEUIActionTypeImpl.class);

    public void init(IPSModelStorageContext iPSModelStorageContext, PSDEUIActionType psDEUIActionType) throws Exception {
        this.psDEUIActionType = psDEUIActionType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psDEUIActionType.getPSDEUIACTIONTYPEID());
        this.setName(psDEUIActionType.getPSDEUIACTIONTYPENAME());
        this.setPSObjectData(this.psDEUIActionType);
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

