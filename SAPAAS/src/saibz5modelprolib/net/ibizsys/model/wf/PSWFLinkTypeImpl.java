/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFLink
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.entity.PSWFLink;
import net.ibizsys.model.entity.PSWFLinkType;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFLinkType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFLinkTypeImpl
extends PSObjectImpl
implements IPSWFLinkType {
    protected PSWFLinkType psWFLinkType = null;
    private static final Log log = LogFactory.getLog(PSWFLinkTypeImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSWFLinkType psWFLinkType) throws Exception {
        this.psWFLinkType = psWFLinkType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psWFLinkType.getPSWFLINKTYPEID());
        this.setName(psWFLinkType.getPSWFLINKTYPENAME());
        this.setPSObjectData(this.psWFLinkType);
        this.onInit();
    }

    @Override
    public IPSWFLink createPSWFLink(PSWFLink psWFLink) throws Exception {
        return (IPSWFLink)this.getPSModelStorageContext().createObject(this.psWFLinkType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

