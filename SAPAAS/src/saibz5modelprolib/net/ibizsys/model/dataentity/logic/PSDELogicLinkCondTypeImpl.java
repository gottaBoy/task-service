/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCondType;
import net.ibizsys.model.entity.PSDELogicLinkCond;
import net.ibizsys.model.entity.PSDELogicLinkCondType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicLinkCondTypeImpl
extends PSObjectImpl
implements IPSDELogicLinkCondType {
    protected PSDELogicLinkCondType psFDLogicType = null;
    private static final Log log = LogFactory.getLog(PSDELogicLinkCondTypeImpl.class);

    public void init(IPSModelStorageContext iPSModelStorageContext, PSDELogicLinkCondType psFDLogicType) throws Exception {
        this.psFDLogicType = psFDLogicType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psFDLogicType.getPSDELLCONDTYPEID());
        this.setName(psFDLogicType.getPSDELLCONDTYPENAME());
        this.setPSObjectData(this.psFDLogicType);
        this.onInit();
    }

    @Override
    public IPSDELogicLinkCond createPSDELogicLinkCond(PSDELogicLinkCond psDELogicLinkCond) throws Exception {
        return (IPSDELogicLinkCond)this.getPSModelStorageContext().createObject(this.psFDLogicType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

