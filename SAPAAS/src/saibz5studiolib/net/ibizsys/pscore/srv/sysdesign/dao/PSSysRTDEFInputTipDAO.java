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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysRTDEFInputTipDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRTDEFInputTip;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysRTDEFInputTipDAO
extends PSCoreSysDAOBase<PSSysRTDEFInputTip> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VALID = "VALID";
    private PSSysRTDEFInputTipDEModel pSSysRTDEFInputTipDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysRTDEFInputTipDAO";
    }

    public PSSysRTDEFInputTipDEModel getPSSysRTDEFInputTipDEModel() {
        if (this.pSSysRTDEFInputTipDEModel == null) {
            try {
                this.pSSysRTDEFInputTipDEModel = (PSSysRTDEFInputTipDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysRTDEFInputTipDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysRTDEFInputTipDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysRTDEFInputTipDEModel();
    }
}

