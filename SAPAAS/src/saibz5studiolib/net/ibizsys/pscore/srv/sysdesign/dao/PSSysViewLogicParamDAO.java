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
package net.ibizsys.pscore.srv.sysdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewLogicParamDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogicParam;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysViewLogicParamDAO
extends PSCoreSysDAOBase<PSSysViewLogicParam> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysViewLogicParamDEModel pSSysViewLogicParamDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewLogicParamDAO";
    }

    public PSSysViewLogicParamDEModel getPSSysViewLogicParamDEModel() {
        if (this.pSSysViewLogicParamDEModel == null) {
            try {
                this.pSSysViewLogicParamDEModel = (PSSysViewLogicParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewLogicParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewLogicParamDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysViewLogicParamDEModel();
    }
}

