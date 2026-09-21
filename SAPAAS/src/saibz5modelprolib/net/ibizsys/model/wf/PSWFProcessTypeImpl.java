/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFProcess
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.entity.PSWFProcess;
import net.ibizsys.model.entity.PSWFProcessType;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFProcessTypeImpl
extends PSObjectImpl
implements IPSWFProcessType {
    protected PSWFProcessType psWFProcessType = null;
    private static final Log log = LogFactory.getLog(PSWFProcessTypeImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSWFProcessType psWFProcessType) throws Exception {
        this.psWFProcessType = psWFProcessType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psWFProcessType.getPSWFPROCESSTYPEID());
        this.setName(psWFProcessType.getPSWFPROCESSTYPENAME());
        this.setPSObjectData(this.psWFProcessType);
        this.onInit();
    }

    @Override
    public IPSWFProcess createPSWFProcess(PSWFProcess psWFProcess) throws Exception {
        return (IPSWFProcess)this.getPSModelStorageContext().createObject(this.psWFProcessType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

