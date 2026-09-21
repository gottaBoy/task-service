/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.logic.IPSDELogicNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.logic.IPSDELogicNode;
import net.ibizsys.model.dataentity.logic.IPSDELogicNodeType;
import net.ibizsys.model.entity.PSDELogicNode;
import net.ibizsys.model.entity.PSDELogicNodeType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicNodeTypeImpl
extends PSObjectImpl
implements IPSDELogicNodeType {
    protected PSDELogicNodeType psFDLogicType = null;
    private static final Log log = LogFactory.getLog(PSDELogicNodeTypeImpl.class);

    public void init(IPSModelStorageContext iPSModelStorageContext, PSDELogicNodeType psFDLogicType) throws Exception {
        this.psFDLogicType = psFDLogicType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psFDLogicType.getPSDELNTYPEID());
        this.setName(psFDLogicType.getPSDELNTYPENAME());
        this.setPSObjectData(this.psFDLogicType);
        this.onInit();
    }

    @Override
    public IPSDELogicNode createPSDELogicNode(PSDELogicNode psDELogicNode) throws Exception {
        return (IPSDELogicNode)this.getPSModelStorageContext().createObject(this.psFDLogicType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

