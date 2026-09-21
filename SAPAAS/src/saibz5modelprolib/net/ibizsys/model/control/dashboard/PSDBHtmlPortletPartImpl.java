/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.dashboard.IPSDBHtmlPortletPart
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.dashboard.IPSDBHtmlPortletPart;
import net.ibizsys.model.control.dashboard.PSDBSysPortletPartImpl;

public class PSDBHtmlPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBHtmlPortletPart {
    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSControlContainer(iPSControlContainer);
        this.setName(strName);
        super.init(iPSModelStorageContext, iPSControlContainer, strName, iPSControlParam);
    }

    @Override
    public IPSControl getContentPSControl() {
        return null;
    }
}

