/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psba.dao.BASelectContext;
import net.ibizsys.psba.entity.IBAColumnHistory;
import net.ibizsys.psba.entity.IBAEntityActionSupporter;

public interface IBAEntity
extends IEntity,
IBAEntityActionSupporter {
    public String getRowKey();

    public void setRowKey(String var1);

    public Timestamp getCreateDate();

    public void setCreateDate(Timestamp var1);

    public Timestamp getUpdateDate();

    public void setUpdateDate(Timestamp var1);

    public ISimpleDataObject getFamily(String var1) throws Exception;

    public ISimpleDataObject getFamily(String var1, boolean var2) throws Exception;

    public void setFamily(String var1, ISimpleDataObject var2);

    public Iterator<String> getFamilyNames();

    public ArrayList<IBAEntity> children(String var1) throws Exception;

    public ArrayList<IBAEntity> children(String var1, BASelectContext var2) throws Exception;

    public void set(String var1, String var2, Object var3) throws Exception;

    public void set(String var1, String var2, Object var3, long var4) throws Exception;

    public Object get(String var1, String var2) throws Exception;

    public boolean isNull(String var1, String var2) throws Exception;

    public boolean contains(String var1, String var2) throws Exception;

    public IBAColumnHistory getBAColumnHistory(String var1, String var2) throws Exception;
}

