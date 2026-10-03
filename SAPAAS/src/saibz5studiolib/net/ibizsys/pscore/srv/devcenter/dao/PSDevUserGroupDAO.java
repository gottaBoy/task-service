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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevUserGroupDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserGroup;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserObjBase;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevUserGroupDAO
extends PSCoreSysDAOBase<PSDevUserGroup> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevUserGroupDEModel pSDevUserGroupDEModel;
    private PSDevUserObjDAO pSDevUserObjDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDevUserGroupDAO";
    }

    public PSDevUserGroupDEModel getPSDevUserGroupDEModel() {
        if (this.pSDevUserGroupDEModel == null) {
            try {
                this.pSDevUserGroupDEModel = (PSDevUserGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevUserGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevUserGroupDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevUserGroupDEModel();
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

    protected void fillInheritEntity(PSDevUserGroup pSDevUserGroup) throws Exception {
        super.fillInheritEntity(pSDevUserGroup);
        PSDevUserGroup pSDevUserGroup2 = pSDevUserGroup;
        pSDevUserGroup2.setPSDevUserObjectId(pSDevUserGroup.getPSDevUserGroupId());
        if (pSDevUserGroup.isPSDevUserGroupNameDirty()) {
            pSDevUserGroup2.setPSDevUserObjName(pSDevUserGroup.getPSDevUserGroupName());
        }
        ((PSDevUserObjBase)pSDevUserGroup2).set("PSDEVUSEROBJTYPE", "USERGROUP");
    }
}

