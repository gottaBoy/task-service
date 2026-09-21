/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.sysmodel;

import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import org.hibernate.SessionFactory;

public interface ICodeListGlobalPlugin {
    public void registerCodeList(String var1, ICodeListModel var2);

    public ICodeList getCodeList(Class var1) throws Exception;

    public ICodeList getCodeList(String var1) throws Exception;

    public ICodeList getCodeList(Class var1, SessionFactory var2) throws Exception;

    public ICodeList getCodeList(String var1, SessionFactory var2) throws Exception;

    public Iterator<ICodeList> getAllCodelists();

    public ICodeList getCodeList(Class var1, boolean var2) throws Exception;

    public ICodeList getCodeList(String var1, boolean var2) throws Exception;

    public ICodeList getCodeList(Class var1, SessionFactory var2, boolean var3) throws Exception;

    public ICodeList getCodeList(String var1, SessionFactory var2, boolean var3) throws Exception;
}

