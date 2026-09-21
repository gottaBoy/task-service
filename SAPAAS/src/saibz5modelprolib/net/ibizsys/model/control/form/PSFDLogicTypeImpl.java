/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFDLogic
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.form.IPSDEFDLogic;
import net.ibizsys.model.control.form.IPSFDLogicType;
import net.ibizsys.model.entity.PSDEFDLogic;
import net.ibizsys.model.entity.PSFDLogicType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFDLogicTypeImpl
extends PSObjectImpl
implements IPSFDLogicType {
    protected PSFDLogicType psFDLogicType = null;
    private static final Log log = LogFactory.getLog(PSFDLogicTypeImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSFDLogicType psFDLogicType) throws Exception {
        this.psFDLogicType = psFDLogicType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psFDLogicType.getPSFDLOGICTYPEID());
        this.setName(psFDLogicType.getPSFDLOGICTYPENAME());
        this.onInit();
    }

    @Override
    public IPSDEFDLogic createPSDEFDLogic(PSDEFDLogic psDEFDLogic) throws Exception {
        return (IPSDEFDLogic)this.getPSModelStorageContext().createObject(this.psFDLogicType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

