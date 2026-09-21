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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCDETemplFieldDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDETemplField;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCDETemplFieldDAO
extends PSCoreSysDAOBase<PSDCDETemplField> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCDETemplFieldDEModel pSDCDETemplFieldDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCDETemplFieldDAO";
    }

    public PSDCDETemplFieldDEModel getPSDCDETemplFieldDEModel() {
        if (this.pSDCDETemplFieldDEModel == null) {
            try {
                this.pSDCDETemplFieldDEModel = (PSDCDETemplFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCDETemplFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDETemplFieldDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCDETemplFieldDEModel();
    }
}

