/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.ajax.IPSAjaxControlHandler
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.IPSControlRuntime;
import net.ibizsys.model.control.IPSControlTypeRuntime;
import net.ibizsys.model.control.ajax.IPSAjaxControlHandler;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.entity.PSControlType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSControlTypeImpl
extends PSObjectImpl
implements IPSControlTypeRuntime {
    protected PSControlType psControlType = null;
    private static final Log log = LogFactory.getLog(PSControlTypeImpl.class);
    private boolean bAjaxControl = false;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSControlType psControlType) throws Exception {
        this.psControlType = psControlType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psControlType.getPSCTRLTYPEID());
        this.setName(psControlType.getPSCTRLTYPENAME());
        this.setPSObjectData(this.psControlType);
        this.bAjaxControl = this.psControlType.getAJAXCTRL();
        this.onInit();
    }

    public boolean isAjaxControl() {
        return this.bAjaxControl;
    }

    @Override
    public IPSControl createPSControl(IPSControlParam iPSControlParam) throws Exception {
        IPSControl iPSControl = (IPSControl)this.getPSModelStorageContext().createObject(this.psControlType.getCTRLOBJ());
        ((IPSControlRuntime)iPSControl).setPSControlType(this);
        return iPSControl;
    }

    @Override
    public IPSControlParam createPSControlParam(BaseDataEntity dataEntity) throws Exception {
        IPSControlParam iPSControlParam = (IPSControlParam)this.getPSModelStorageContext().createObject(this.psControlType.getPARAMOBJ());
        return iPSControlParam;
    }

    @Override
    public IPSAjaxControlHandler createPSAjaxControlHandler(PSACHandler psACHandler) throws Exception {
        IPSAjaxControlHandler iPSAjaxControlHandler = (IPSAjaxControlHandler)this.getPSModelStorageContext().createObject(this.psControlType.getHANDLEROBJ());
        return iPSAjaxControlHandler;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

