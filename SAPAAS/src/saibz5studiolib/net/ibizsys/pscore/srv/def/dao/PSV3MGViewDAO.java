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
import net.ibizsys.pscore.srv.def.demodel.PSV3MGViewDEModel;
import net.ibizsys.pscore.srv.def.entity.PSV3MGView;
import org.springframework.stereotype.Repository;

@Repository
public class PSV3MGViewDAO
extends PSCoreSysDAOBase<PSV3MGView> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSV3MGViewDEModel pSV3MGViewDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.def.dao.PSV3MGViewDAO";
    }

    public PSV3MGViewDEModel getPSV3MGViewDEModel() {
        if (this.pSV3MGViewDEModel == null) {
            try {
                this.pSV3MGViewDEModel = (PSV3MGViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSV3MGViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSV3MGViewDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSV3MGViewDEModel();
    }
}

