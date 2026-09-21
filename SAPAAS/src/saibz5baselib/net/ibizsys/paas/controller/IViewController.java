/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.controller;

import java.util.Iterator;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.web.IWebContext;
import org.hibernate.SessionFactory;

public interface IViewController {
    public static final String VIEWACTION_LOADMODEL = "loadmodel";
    public static final String VIEWACTION_FETCHMSG = "fetchmsg";
    public static final String VIEWACTION_FETCHWIZARD = "fetchwizard";
    public static final String VIEWACTION_LOADAPPDATA = "loadappdata";
    public static final String VIEWACTION_UIACTION = "uiaction";
    public static final String VIEWACTION_LOADUIACTION = "loaduiaction";

    public String getId();

    public IWebContext getWebContext();

    public void prepareViewController() throws Exception;

    public boolean isPrepareViewController();

    public IApplicationModel getAppModel();

    public ISystemModel getSystemModel();

    public IDataEntityModel getDEModel();

    public void registerCtrlModel(String var1, ICtrlModel var2) throws Exception;

    public void registerCtrlHandler(String var1, ICtrlHandler var2) throws Exception;

    public ICtrlModel getCtrlModel(String var1) throws Exception;

    public ICtrlHandler getCtrlHandler(String var1) throws Exception;

    public IService getService();

    public boolean isPickupView();

    public void setSessionFactory(SessionFactory var1);

    public SessionFactory getSessionFactory();

    public String getCaption();

    public String getCaption(boolean var1);

    public String getTitle();

    public String getSubCaption();

    public String getTitle(boolean var1);

    public String getSubCaption(boolean var1);

    public Object getAttribute(String var1) throws Exception;

    public boolean getAttribute(String var1, boolean var2) throws Exception;

    public String getAttribute(String var1, String var2) throws Exception;

    public int getAttribute(String var1, int var2) throws Exception;

    public double getAttribute(String var1, double var2) throws Exception;

    public void setAttribute(String var1, Object var2) throws Exception;

    public int getAccessUserMode();

    public String getAccessKey();

    public String getMSTag();

    public String getViewMsgGroupId();

    public Iterator<String> getUIActions() throws Exception;

    public Iterator<String> getDEDataAccessActions(String var1);

    public String getViewWizardGroupId();

    public boolean testUserAccess(IWebContext var1, boolean var2) throws Exception;

    public boolean testUserAccess(IWebContext var1) throws Exception;

    public String getCapLanResTag();

    public String getSubCapLanResTag();

    public String getTitleLanResTag();

    public CallResult testDEDataAccessAction(IDataEntityModel var1, Object var2, String var3, boolean var4) throws Exception;
}

