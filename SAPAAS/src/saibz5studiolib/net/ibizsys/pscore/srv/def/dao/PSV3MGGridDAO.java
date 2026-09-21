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
import net.ibizsys.pscore.srv.def.demodel.PSV3MGGridDEModel;
import net.ibizsys.pscore.srv.def.entity.PSV3MGGrid;
import org.springframework.stereotype.Repository;

@Repository
public class PSV3MGGridDAO
extends PSCoreSysDAOBase<PSV3MGGrid> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSV3MGGridDEModel pSV3MGGridDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.def.dao.PSV3MGGridDAO";
    }

    public PSV3MGGridDEModel getPSV3MGGridDEModel() {
        if (this.pSV3MGGridDEModel == null) {
            try {
                this.pSV3MGGridDEModel = (PSV3MGGridDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSV3MGGridDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSV3MGGridDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSV3MGGridDEModel();
    }
}

