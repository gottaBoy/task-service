/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import org.hibernate.SessionFactory;

public interface ICodeListModel
extends ICodeList,
IModelBase3 {
    public void fillFetchResult(MDAjaxActionResult var1, IWebContext var2) throws Exception;

    public void setSessionFactory(SessionFactory var1);

    public SessionFactory getSessionFactory();

    public void refresh() throws Exception;

    public void from(ICodeListModel var1) throws Exception;
}

