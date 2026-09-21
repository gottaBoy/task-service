/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.dao;

import java.util.ArrayList;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psba.core.IBADialect;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBATableModel;
import net.ibizsys.psba.dao.IBAAsyncSelectHandler;
import net.ibizsys.psba.dao.IBASelectContext;
import net.ibizsys.psba.entity.IBAEntity;
import net.ibizsys.psba.entity.IBAEntityActionHelper;

public interface IBADAO<ET extends IBAEntity> {
    public IWebContext getWebContext();

    public IBASchemeModel getBASchemeModel();

    public IBATableModel getBATableModel();

    public IBADialect getRealBADialect();

    public void executeCreateCmd(IBAEntity var1, String[] var2) throws Exception;

    public void executeUpdateCmd(IBAEntity var1, String[] var2) throws Exception;

    public void executeGetCmd(IBAEntity var1, String[] var2) throws Exception;

    public void executeRemoveCmd(IBAEntity var1) throws Exception;

    public ArrayList<IBAEntity> executeSelectCmd(IBASelectContext var1) throws Exception;

    public void executeSelectCmdAsync(IBASelectContext var1, IBAAsyncSelectHandler var2) throws Exception;

    public void executeSelectCmd(IBASelectContext var1, IBAAsyncSelectHandler var2) throws Exception;

    public IBAEntityActionHelper getBAEntityActionHelper() throws Exception;

    public void executeBatchCreateCmd(IBAEntity[] var1, String[] var2) throws Exception;
}

