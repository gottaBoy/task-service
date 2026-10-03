/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Repository
 */
package net.ibizsys.pscore.srv.paasmgr.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSProductDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSSysProductDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSProductBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysProduct;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysProductDAO
extends PSCoreSysDAOBase<PSSysProduct> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysProductDEModel pSSysProductDEModel;
    private PSProductDAO pSProductDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSSysProductDAO";
    }

    public PSSysProductDEModel getPSSysProductDEModel() {
        if (this.pSSysProductDEModel == null) {
            try {
                this.pSSysProductDEModel = (PSSysProductDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSSysProductDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysProductDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysProductDEModel();
    }

    protected IDAO getInheritDEDAO() {
        if (this.pSProductDAO == null) {
            try {
                this.pSProductDAO = (PSProductDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSProductDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSProductDAO;
    }

    protected void fillInheritEntity(PSSysProduct pSSysProduct) throws Exception {
        super.fillInheritEntity(pSSysProduct);
        PSSysProduct pSSysProduct2 = pSSysProduct;
        pSSysProduct2.setPSProductId(pSSysProduct.getPSSysProductId());
        if (pSSysProduct.isPSSysProductNameDirty()) {
            pSSysProduct2.setPSProductName(pSSysProduct.getPSSysProductName());
        }
        ((PSProductBase)pSSysProduct2).set("PSPRODUCTTYPE", "SYSTEM");
    }
}

