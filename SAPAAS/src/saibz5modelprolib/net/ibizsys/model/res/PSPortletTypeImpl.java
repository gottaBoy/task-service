/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 *  net.ibizsys.model.res.IPSSysPortlet
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.entity.PSPortletType;
import net.ibizsys.model.entity.PSSysPortlet;
import net.ibizsys.model.res.IPSPortletTypeRuntime;
import net.ibizsys.model.res.IPSSysPortlet;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPortletTypeImpl
extends PSObjectImpl
implements IPSPortletTypeRuntime {
    protected PSPortletType psPortletType = null;
    private static final Log log = LogFactory.getLog(PSPortletTypeImpl.class);
    private Properties baseClassParams = null;
    private boolean bSysPortlet = true;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSPortletType psPortletType) throws Exception {
        this.psPortletType = psPortletType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psPortletType.getPSPORTLETTYPEID());
        this.setName(psPortletType.getPSPORTLETTYPENAME());
        this.setPSObjectData(this.psPortletType);
        this.baseClassParams = PropertiesHelper.load((String)this.psPortletType.getBASECLSPARAMS());
        this.bSysPortlet = !this.psPortletType.isSYSPORTLETFLAGNull() ? this.psPortletType.getSYSPORTLETFLAG() : !StringHelper.isNullOrEmpty((String)this.psPortletType.getPORTLETOBJ());
        this.onInit();
    }

    @Override
    public IPSSysPortlet createPSSysPortlet(PSSysPortlet psSysPortlet) throws Exception {
        return (IPSSysPortlet)this.getPSModelStorageContext().createObject(this.psPortletType.getSYSPORTLETOBJ());
    }

    @Override
    public IPSDBPortletPart createPSPortlet() throws Exception {
        return (IPSDBPortletPart)this.getPSModelStorageContext().createObject(this.psPortletType.getPORTLETOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    public boolean isSysPortlet() {
        return this.bSysPortlet;
    }
}

