/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.dr.IPSDEDRItem
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.dataentity.dr.IPSDRItemTypeRuntime;
import net.ibizsys.model.entity.PSDEDRItem;
import net.ibizsys.model.entity.PSDRItemType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDRItemTypeImpl
extends PSObjectImpl
implements IPSDRItemTypeRuntime {
    protected PSDRItemType psDRItemType = null;
    private static final Log log = LogFactory.getLog(PSDRItemTypeImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSDRItemType psDRItemType) throws Exception {
        this.psDRItemType = psDRItemType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psDRItemType.getPSDRITEMTYPEID());
        this.setName(psDRItemType.getPSDRITEMTYPENAME());
        this.setPSObjectData(this.psDRItemType);
        this.onInit();
    }

    @Override
    public IPSDEDRItem createPSDEDRItem(PSDEDRItem psDEDRItem) throws Exception {
        IPSDEDRItem iPSDRItem = (IPSDEDRItem)this.getPSModelStorageContext().createObject(this.psDRItemType.getITEMOBJ());
        return iPSDRItem;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

