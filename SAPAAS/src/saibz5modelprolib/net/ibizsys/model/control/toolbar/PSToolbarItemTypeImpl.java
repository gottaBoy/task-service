/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.toolbar.IPSDEToolbarItem
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.control.toolbar.IPSToolbarItemType;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.model.entity.PSToolbarItemType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSToolbarItemTypeImpl
extends PSObjectImpl
implements IPSToolbarItemType {
    protected PSToolbarItemType psToolbarItemType = null;
    private static final Log log = LogFactory.getLog(PSToolbarItemTypeImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSToolbarItemType psToolbarItemType) throws Exception {
        this.psToolbarItemType = psToolbarItemType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psToolbarItemType.getPSTBITEMTYPEID());
        this.setName(psToolbarItemType.getPSTBITEMTYPENAME());
        this.onInit();
    }

    @Override
    public IPSDEToolbarItem createPSDEToolbarItem(PSDEToolbarItem psDEToolbarItem) throws Exception {
        IPSDEToolbarItem iPSToolbarItem = (IPSDEToolbarItem)this.getPSModelStorageContext().createObject(this.psToolbarItemType.getITEMOBJ());
        return iPSToolbarItem;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

