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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFValueRuleDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEFValueRuleDAO
extends PSCoreSysDAOBase<PSDEFValueRule> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DQ0001 = "DQ0001";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEFValueRuleDEModel pSDEFValueRuleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEFValueRuleDAO";
    }

    public PSDEFValueRuleDEModel getPSDEFValueRuleDEModel() {
        if (this.pSDEFValueRuleDEModel == null) {
            try {
                this.pSDEFValueRuleDEModel = (PSDEFValueRuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFValueRuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFValueRuleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEFValueRuleDEModel();
    }
}

