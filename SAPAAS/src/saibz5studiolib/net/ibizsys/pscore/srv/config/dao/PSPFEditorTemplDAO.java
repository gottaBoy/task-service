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
import net.ibizsys.pscore.srv.config.demodel.PSPFEditorTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFEditorTempl;
import org.springframework.stereotype.Repository;

@Repository
public class PSPFEditorTemplDAO
extends PSCoreSysDAOBase<PSPFEditorTempl> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_NOSTYLE = "NoStyle";
    private PSPFEditorTemplDEModel pSPFEditorTemplDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSPFEditorTemplDAO";
    }

    public PSPFEditorTemplDEModel getPSPFEditorTemplDEModel() {
        if (this.pSPFEditorTemplDEModel == null) {
            try {
                this.pSPFEditorTemplDEModel = (PSPFEditorTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFEditorTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFEditorTemplDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSPFEditorTemplDEModel();
    }
}

