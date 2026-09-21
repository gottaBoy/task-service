/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFLinkCond
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.entity.PSWFLinkCond;
import net.ibizsys.model.entity.PSWFLinkCondType;
import net.ibizsys.model.wf.IPSWFLinkCond;
import net.ibizsys.model.wf.IPSWFLinkCondType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFLinkCondTypeImpl
extends PSObjectImpl
implements IPSWFLinkCondType {
    protected PSWFLinkCondType psWFLinkCondType = null;
    private static final Log log = LogFactory.getLog(PSWFLinkCondTypeImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSWFLinkCondType psWFLinkCondType) throws Exception {
        this.psWFLinkCondType = psWFLinkCondType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psWFLinkCondType.getPSWFLINKCONDTYPEID());
        this.setName(psWFLinkCondType.getPSWFLINKCONDTYPENAME());
        this.setPSObjectData(this.psWFLinkCondType);
        this.onInit();
    }

    @Override
    public IPSWFLinkCond createPSWFLinkCond(PSWFLinkCond psWFLinkCond) throws Exception {
        return (IPSWFLinkCond)this.getPSModelStorageContext().createObject(this.psWFLinkCondType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

