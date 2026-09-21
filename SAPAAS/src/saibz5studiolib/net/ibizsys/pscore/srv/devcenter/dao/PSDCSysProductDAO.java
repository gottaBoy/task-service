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
package net.ibizsys.pscore.srv.devcenter.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCProductDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSysProductDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCProductBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysProduct;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCSysProductDAO
extends PSCoreSysDAOBase<PSDCSysProduct> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCSysProductDEModel pSDCSysProductDEModel;
    private PSDCProductDAO pSDCProductDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCSysProductDAO";
    }

    public PSDCSysProductDEModel getPSDCSysProductDEModel() {
        if (this.pSDCSysProductDEModel == null) {
            try {
                this.pSDCSysProductDEModel = (PSDCSysProductDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSysProductDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSysProductDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCSysProductDEModel();
    }

    protected IDAO getInheritDEDAO() {
        if (this.pSDCProductDAO == null) {
            try {
                this.pSDCProductDAO = (PSDCProductDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCProductDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCProductDAO;
    }

    protected void fillInheritEntity(PSDCSysProduct pSDCSysProduct) throws Exception {
        super.fillInheritEntity((IEntity)pSDCSysProduct);
        PSDCSysProduct pSDCSysProduct2 = pSDCSysProduct;
        pSDCSysProduct2.setPSDCProductId(pSDCSysProduct.getPSDCSysProductId());
        if (pSDCSysProduct.isPSDCSysProductNameDirty()) {
            pSDCSysProduct2.setPSDCProductName(pSDCSysProduct.getPSDCSysProductName());
        }
        ((PSDCProductBase)pSDCSysProduct2).set("PSDCPRODUCTTYPE", "SYSTEM");
    }
}

