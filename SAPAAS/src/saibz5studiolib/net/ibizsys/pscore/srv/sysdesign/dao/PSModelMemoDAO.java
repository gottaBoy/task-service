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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSModelMemoDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelMemo;
import org.springframework.stereotype.Repository;

@Repository
public class PSModelMemoDAO
extends PSCoreSysDAOBase<PSModelMemo> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSModelMemoDEModel pSModelMemoDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSModelMemoDAO";
    }

    public PSModelMemoDEModel getPSModelMemoDEModel() {
        if (this.pSModelMemoDEModel == null) {
            try {
                this.pSModelMemoDEModel = (PSModelMemoDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSModelMemoDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelMemoDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSModelMemoDEModel();
    }
}

