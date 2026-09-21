/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.der.IPSDERBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.der;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.der.IPSDERTypeRuntime;
import net.ibizsys.model.entity.PSDER;
import net.ibizsys.model.entity.PSDERType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDERTypeImpl
extends PSObjectImpl
implements IPSDERTypeRuntime {
    protected PSDERType psDERType = null;
    private static final Log log = LogFactory.getLog(PSDERTypeImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSDERType psDERType) throws Exception {
        this.psDERType = psDERType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psDERType.getPSDERTYPEID());
        this.setName(psDERType.getPSDERTYPENAME());
        this.setPSObjectData(this.psDERType);
        this.onInit();
    }

    @Override
    public IPSDERBase createPSDER(PSDER psDER) throws Exception {
        String strObj = this.psDERType.getDEROBJ().replace("SA.SRFDA.PS.Core.DataEntity.DER", "net.ibizsys.model.der");
        IPSDERBase iPSDER = (IPSDERBase)this.getPSModelStorageContext().createObject(strObj);
        return iPSDER;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

