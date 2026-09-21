/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.entity;

import java.util.HashMap;
import net.ibizsys.paas.data.IDataObject;
import org.hibernate.SessionFactory;

public interface IEntity
extends IDataObject {
    public static final String KEY = "srfkey";

    public void fillMap(HashMap<String, Object> var1, boolean var2);

    public void markFullEntity(boolean var1);

    public boolean isFullEntity();

    public void setSessionFactory(SessionFactory var1);

    public SessionFactory getSessionFactory();

    public void setEntityProperty(String var1, Object var2);

    public Object getEntityProperty(String var1);
}

