/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.dao;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBATableModel;
import net.ibizsys.psba.dao.IBADAO;
import net.ibizsys.psba.entity.IBAEntity;
import net.ibizsys.psba.entity.IBAEntityActionHelper;

public class BAEntityActionHelperImpl
implements IBAEntityActionHelper {
    private IBATableModel iBATableModel = null;
    private IBADAO iBADAO = null;
    private IBASchemeModel iBASchemeModel = null;

    public void init(IBADAO iBADAO) throws Exception {
        this.iBADAO = iBADAO;
        this.iBATableModel = this.iBADAO.getBATableModel();
        this.iBASchemeModel = (IBASchemeModel)this.iBATableModel.getBAScheme();
    }

    @Override
    public void create(IEntity iEntity) throws Exception {
        if (!(iEntity instanceof IBAEntity)) {
            throw new Exception("\u53c2\u6570\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iBADAO.executeCreateCmd((IBAEntity)iEntity, null);
    }

    @Override
    public void update(IEntity iEntity) throws Exception {
        if (!(iEntity instanceof IBAEntity)) {
            throw new Exception("\u53c2\u6570\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iBADAO.executeUpdateCmd((IBAEntity)iEntity, null);
    }

    @Override
    public void save(IEntity iEntity) throws Exception {
        if (!(iEntity instanceof IBAEntity)) {
            throw new Exception("\u53c2\u6570\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iBADAO.executeCreateCmd((IBAEntity)iEntity, null);
    }

    @Override
    public void remove(IEntity iEntity) throws Exception {
        if (!(iEntity instanceof IBAEntity)) {
            throw new Exception("\u53c2\u6570\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iBADAO.executeRemoveCmd((IBAEntity)iEntity);
    }

    @Override
    public boolean get(IEntity iEntity, boolean bTryMode) throws Exception {
        if (!(iEntity instanceof IBAEntity)) {
            throw new Exception("\u53c2\u6570\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        try {
            this.iBADAO.executeGetCmd((IBAEntity)iEntity, null);
            return true;
        }
        catch (Exception ex) {
            if (bTryMode) {
                return false;
            }
            throw ex;
        }
    }

    @Override
    public boolean select(IEntity iEntity, boolean bTryMode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void create(IBAEntity iEntity, String[] families) throws Exception {
        this.iBADAO.executeCreateCmd(iEntity, families);
    }

    @Override
    public void update(IBAEntity iEntity, String[] families) throws Exception {
        this.iBADAO.executeUpdateCmd(iEntity, families);
    }

    @Override
    public void save(IBAEntity iEntity, String[] families) throws Exception {
        this.iBADAO.executeCreateCmd(iEntity, families);
    }

    @Override
    public boolean get(IBAEntity iEntity, String[] families, boolean bTryMode) throws Exception {
        try {
            this.iBADAO.executeGetCmd(iEntity, families);
            return true;
        }
        catch (Exception ex) {
            if (bTryMode) {
                return false;
            }
            throw ex;
        }
    }

    @Override
    public IBASchemeModel getBASchemeModel() {
        return this.iBASchemeModel;
    }

    @Override
    public IBATableModel getBATableModel() {
        return this.iBATableModel;
    }
}

