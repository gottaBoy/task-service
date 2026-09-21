/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 *  net.ibizsys.model.res.IPSPortletType
 *  net.ibizsys.model.res.IPSSysPortlet
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.entity.PSPortletType;
import net.ibizsys.model.entity.PSSysPortlet;
import net.ibizsys.model.res.IPSPortletType;
import net.ibizsys.model.res.IPSSysPortlet;

public interface IPSPortletTypeRuntime
extends IPSPortletType {
    public void init(IPSModelStorageContext var1, PSPortletType var2) throws Exception;

    public IPSSysPortlet createPSSysPortlet(PSSysPortlet var1) throws Exception;

    public IPSDBPortletPart createPSPortlet() throws Exception;
}

