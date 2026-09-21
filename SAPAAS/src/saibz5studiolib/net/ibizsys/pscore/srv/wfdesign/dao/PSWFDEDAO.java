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
package net.ibizsys.pscore.srv.wfdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFDEDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import org.springframework.stereotype.Repository;

@Repository
public class PSWFDEDAO
extends PSCoreSysDAOBase<PSWFDE> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURWF = "CurWF";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWFDEDEModel pSWFDEDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfdesign.dao.PSWFDEDAO";
    }

    public PSWFDEDEModel getPSWFDEDEModel() {
        if (this.pSWFDEDEModel == null) {
            try {
                this.pSWFDEDEModel = (PSWFDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFDEDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWFDEDEModel();
    }
}

