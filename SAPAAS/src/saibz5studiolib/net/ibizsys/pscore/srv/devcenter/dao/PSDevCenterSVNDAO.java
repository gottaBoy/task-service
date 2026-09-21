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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterSVNDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevCenterSVNDAO
extends PSCoreSysDAOBase<PSDevCenterSVN> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_CURDC2 = "CurDC2";
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_CURSLN2 = "CurSln2";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevCenterSVNDEModel pSDevCenterSVNDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterSVNDAO";
    }

    public PSDevCenterSVNDEModel getPSDevCenterSVNDEModel() {
        if (this.pSDevCenterSVNDEModel == null) {
            try {
                this.pSDevCenterSVNDEModel = (PSDevCenterSVNDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterSVNDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterSVNDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevCenterSVNDEModel();
    }
}

