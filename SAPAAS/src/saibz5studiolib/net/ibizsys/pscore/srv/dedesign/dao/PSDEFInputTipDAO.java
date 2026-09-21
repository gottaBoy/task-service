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
package net.ibizsys.pscore.srv.dedesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFInputTipDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTip;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEFInputTipDAO
extends PSCoreSysDAOBase<PSDEFInputTip> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDEF = "CurDEF";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYS2 = "CurSys2";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEFInputTipDEModel pSDEFInputTipDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEFInputTipDAO";
    }

    public PSDEFInputTipDEModel getPSDEFInputTipDEModel() {
        if (this.pSDEFInputTipDEModel == null) {
            try {
                this.pSDEFInputTipDEModel = (PSDEFInputTipDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFInputTipDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFInputTipDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEFInputTipDEModel();
    }
}

