/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  org.springframework.stereotype.Repository
 */
package net.ibizsys.pscore.srv.devcenter.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevUserSqlDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserSql;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevUserSqlDAO
extends PSCoreSysDAOBase<PSDevUserSql> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURUSERSQL = "CurUserSQL";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevUserSqlDEModel pSDevUserSqlDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDevUserSqlDAO";
    }

    public PSDevUserSqlDEModel getPSDevUserSqlDEModel() {
        if (this.pSDevUserSqlDEModel == null) {
            try {
                this.pSDevUserSqlDEModel = (PSDevUserSqlDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevUserSqlDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevUserSqlDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevUserSqlDEModel();
    }
}

