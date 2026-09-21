/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.menu.IPSAppMenuItem
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.menu;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.model.control.menu.IPSAppMenuItemType;
import net.ibizsys.model.entity.PSAppMenuItem;
import net.ibizsys.model.entity.PSAppMenuItemType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppMenuItemTypeImpl
extends PSObjectImpl
implements IPSAppMenuItemType {
    protected PSAppMenuItemType psAppMenuItemType = null;
    private static final Log log = LogFactory.getLog(PSAppMenuItemTypeImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSAppMenuItemType psAppMenuItemType) throws Exception {
        this.psAppMenuItemType = psAppMenuItemType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psAppMenuItemType.getPSAMITEMTYPEID());
        this.setName(psAppMenuItemType.getPSAMITEMTYPENAME());
        this.onInit();
    }

    @Override
    public IPSAppMenuItem createPSAppMenuItem(PSAppMenuItem psDEAppMenuItem) throws Exception {
        IPSAppMenuItem iPSAppMenuItem = (IPSAppMenuItem)this.getPSModelStorageContext().createObject(this.psAppMenuItemType.getITEMOBJ());
        return iPSAppMenuItem;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

