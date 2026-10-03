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
import net.ibizsys.pscore.srv.devcenter.dao.PSDevUserObjDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevUserDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserObjBase;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevUserDAO
extends PSCoreSysDAOBase<PSDevUser> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_DEVCENTERRANGE = "DevCenterRange";
    private PSDevUserDEModel pSDevUserDEModel;
    private PSDevUserObjDAO pSDevUserObjDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDevUserDAO";
    }

    public PSDevUserDEModel getPSDevUserDEModel() {
        if (this.pSDevUserDEModel == null) {
            try {
                this.pSDevUserDEModel = (PSDevUserDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevUserDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevUserDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevUserDEModel();
    }

    protected IDAO getInheritDEDAO() {
        if (this.pSDevUserObjDAO == null) {
            try {
                this.pSDevUserObjDAO = (PSDevUserObjDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDevUserObjDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevUserObjDAO;
    }

    protected void fillInheritEntity(PSDevUser pSDevUser) throws Exception {
        super.fillInheritEntity(pSDevUser);
        PSDevUser pSDevUser2 = pSDevUser;
        pSDevUser2.setPSDevUserObjectId(pSDevUser.getPSDevUserId());
        if (pSDevUser.isPSDevUserNameDirty()) {
            pSDevUser2.setPSDevUserObjName(pSDevUser.getPSDevUserName());
        }
        ((PSDevUserObjBase)pSDevUser2).set("PSDEVUSEROBJTYPE", "USER");
    }
}

