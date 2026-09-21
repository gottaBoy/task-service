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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysFileDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysFile;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysFileDAO
extends PSCoreSysDAOBase<PSSysFile> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysFileDEModel pSSysFileDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysFileDAO";
    }

    public PSSysFileDEModel getPSSysFileDEModel() {
        if (this.pSSysFileDEModel == null) {
            try {
                this.pSSysFileDEModel = (PSSysFileDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysFileDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysFileDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysFileDEModel();
    }
}

