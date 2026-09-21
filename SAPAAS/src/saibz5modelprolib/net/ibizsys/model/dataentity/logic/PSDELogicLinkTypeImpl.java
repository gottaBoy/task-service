/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLink
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.logic.IPSDELogicLink;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkType;
import net.ibizsys.model.entity.PSDELogicLink;
import net.ibizsys.model.entity.PSDELogicLinkType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicLinkTypeImpl
extends PSObjectImpl
implements IPSDELogicLinkType {
    protected PSDELogicLinkType psFDLogicType = null;
    private static final Log log = LogFactory.getLog(PSDELogicLinkTypeImpl.class);

    public void init(IPSModelStorageContext iPSModelStorageContext, PSDELogicLinkType psFDLogicType) throws Exception {
        this.psFDLogicType = psFDLogicType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psFDLogicType.getPSDELLTYPEID());
        this.setName(psFDLogicType.getPSDELLTYPENAME());
        this.setPSObjectData(this.psFDLogicType);
        this.onInit();
    }

    @Override
    public IPSDELogicLink createPSDELogicLink(PSDELogicLink psDELogicLink) throws Exception {
        return (IPSDELogicLink)this.getPSModelStorageContext().createObject(this.psFDLogicType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

