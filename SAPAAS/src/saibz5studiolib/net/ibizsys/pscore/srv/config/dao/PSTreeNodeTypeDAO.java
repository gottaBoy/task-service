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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSTreeNodeTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSTreeNodeType;
import org.springframework.stereotype.Repository;

@Repository
public class PSTreeNodeTypeDAO
extends PSCoreSysDAOBase<PSTreeNodeType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSTreeNodeTypeDEModel pSTreeNodeTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSTreeNodeTypeDAO";
    }

    public PSTreeNodeTypeDEModel getPSTreeNodeTypeDEModel() {
        if (this.pSTreeNodeTypeDEModel == null) {
            try {
                this.pSTreeNodeTypeDEModel = (PSTreeNodeTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSTreeNodeTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSTreeNodeTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSTreeNodeTypeDEModel();
    }
}

