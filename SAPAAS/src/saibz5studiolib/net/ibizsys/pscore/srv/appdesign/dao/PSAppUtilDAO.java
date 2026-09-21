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
package net.ibizsys.pscore.srv.appdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppUtilDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtil;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppUtilDAO
extends PSCoreSysDAOBase<PSAppUtil> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppUtilDEModel pSAppUtilDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppUtilDAO";
    }

    public PSAppUtilDEModel getPSAppUtilDEModel() {
        if (this.pSAppUtilDEModel == null) {
            try {
                this.pSAppUtilDEModel = (PSAppUtilDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppUtilDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppUtilDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppUtilDEModel();
    }
}

