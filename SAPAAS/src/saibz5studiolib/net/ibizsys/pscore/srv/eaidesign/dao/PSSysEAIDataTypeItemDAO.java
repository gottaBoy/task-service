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
package net.ibizsys.pscore.srv.eaidesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDataTypeItemDEModel;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataTypeItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysEAIDataTypeItemDAO
extends PSCoreSysDAOBase<PSSysEAIDataTypeItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysEAIDataTypeItemDEModel pSSysEAIDataTypeItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIDataTypeItemDAO";
    }

    public PSSysEAIDataTypeItemDEModel getPSSysEAIDataTypeItemDEModel() {
        if (this.pSSysEAIDataTypeItemDEModel == null) {
            try {
                this.pSSysEAIDataTypeItemDEModel = (PSSysEAIDataTypeItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDataTypeItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIDataTypeItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysEAIDataTypeItemDEModel();
    }
}

