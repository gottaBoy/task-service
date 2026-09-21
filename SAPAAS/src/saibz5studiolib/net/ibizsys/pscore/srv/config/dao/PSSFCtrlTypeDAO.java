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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSSFCtrlTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFCtrlType;
import org.springframework.stereotype.Repository;

@Repository
public class PSSFCtrlTypeDAO
extends PSCoreSysDAOBase<PSSFCtrlType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSFCtrlTypeDEModel pSSFCtrlTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSFCtrlTypeDAO";
    }

    public PSSFCtrlTypeDEModel getPSSFCtrlTypeDEModel() {
        if (this.pSSFCtrlTypeDEModel == null) {
            try {
                this.pSSFCtrlTypeDEModel = (PSSFCtrlTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFCtrlTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFCtrlTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSFCtrlTypeDEModel();
    }
}

