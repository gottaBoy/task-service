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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDERTAWDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERTAW;
import org.springframework.stereotype.Repository;

@Repository
public class PSDERTAWDAO
extends PSCoreSysDAOBase<PSDERTAW> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURFORM = "CurForm";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_PSDATAENTITY = "PSDATAENTITY";
    private PSDERTAWDEModel pSDERTAWDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDERTAWDAO";
    }

    public PSDERTAWDEModel getPSDERTAWDEModel() {
        if (this.pSDERTAWDEModel == null) {
            try {
                this.pSDERTAWDEModel = (PSDERTAWDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDERTAWDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERTAWDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDERTAWDEModel();
    }
}

