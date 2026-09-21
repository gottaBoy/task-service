/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.pswf.core.IDynaWFSetting;
import org.hibernate.SessionFactory;

public interface IDynaSystemSetting {
    public String getDynaInstId();

    public SessionFactory getSessionFactory();

    public IDynaViewControllerInst createDynaViewControllerInst(IDynaViewController var1, String var2) throws Exception;

    public IDynaViewSetting getDynaViewSetting();

    public IDynaWFSetting getDynaWFSetting();

    public void installAll() throws Exception;

    public void syncAll() throws Exception;
}

