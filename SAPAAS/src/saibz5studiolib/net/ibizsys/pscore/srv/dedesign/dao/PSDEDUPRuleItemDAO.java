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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDUPRuleItemDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDUPRuleItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEDUPRuleItemDAO
extends PSCoreSysDAOBase<PSDEDUPRuleItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEDUPRuleItemDEModel pSDEDUPRuleItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEDUPRuleItemDAO";
    }

    public PSDEDUPRuleItemDEModel getPSDEDUPRuleItemDEModel() {
        if (this.pSDEDUPRuleItemDEModel == null) {
            try {
                this.pSDEDUPRuleItemDEModel = (PSDEDUPRuleItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDUPRuleItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDUPRuleItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEDUPRuleItemDEModel();
    }
}

