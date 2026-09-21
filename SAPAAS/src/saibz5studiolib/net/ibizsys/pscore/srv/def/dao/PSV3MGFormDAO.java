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
package net.ibizsys.pscore.srv.def.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.def.demodel.PSV3MGFormDEModel;
import net.ibizsys.pscore.srv.def.entity.PSV3MGForm;
import org.springframework.stereotype.Repository;

@Repository
public class PSV3MGFormDAO
extends PSCoreSysDAOBase<PSV3MGForm> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSV3MGFormDEModel pSV3MGFormDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.def.dao.PSV3MGFormDAO";
    }

    public PSV3MGFormDEModel getPSV3MGFormDEModel() {
        if (this.pSV3MGFormDEModel == null) {
            try {
                this.pSV3MGFormDEModel = (PSV3MGFormDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSV3MGFormDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSV3MGFormDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSV3MGFormDEModel();
    }
}

