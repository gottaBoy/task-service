/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.entity;

import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBATableModel;
import net.ibizsys.psba.entity.IBAEntity;

public interface IBAEntityActionHelper
extends IEntityActionHelper {
    public IBASchemeModel getBASchemeModel();

    public IBATableModel getBATableModel();

    public void create(IBAEntity var1, String[] var2) throws Exception;

    public void update(IBAEntity var1, String[] var2) throws Exception;

    public void save(IBAEntity var1, String[] var2) throws Exception;

    public boolean get(IBAEntity var1, String[] var2, boolean var3) throws Exception;
}

