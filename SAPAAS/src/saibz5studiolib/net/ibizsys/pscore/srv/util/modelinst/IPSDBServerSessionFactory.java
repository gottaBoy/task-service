/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.util.modelinst;

import org.hibernate.SessionFactory;

public interface IPSDBServerSessionFactory
extends SessionFactory {
    public SessionFactory getRealSessionFactory();

    public String getRealDBName();
}

