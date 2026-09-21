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
package net.ibizsys.pscore.srv.appdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppEditorTemplDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppEditorTempl;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppEditorTemplDAO
extends PSCoreSysDAOBase<PSAppEditorTempl> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppEditorTemplDEModel pSAppEditorTemplDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppEditorTemplDAO";
    }

    public PSAppEditorTemplDEModel getPSAppEditorTemplDEModel() {
        if (this.pSAppEditorTemplDEModel == null) {
            try {
                this.pSAppEditorTemplDEModel = (PSAppEditorTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppEditorTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppEditorTemplDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppEditorTemplDEModel();
    }
}

