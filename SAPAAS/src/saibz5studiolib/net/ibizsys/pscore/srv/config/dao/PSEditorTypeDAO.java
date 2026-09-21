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
import net.ibizsys.pscore.srv.config.demodel.PSEditorTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSEditorType;
import org.springframework.stereotype.Repository;

@Repository
public class PSEditorTypeDAO
extends PSCoreSysDAOBase<PSEditorType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_MOB = "Mob";
    public static final String DATAQUERY_SB = "SB";
    public static final String DATAQUERY_VALID = "Valid";
    public static final String DATAQUERY_VALIDMOB = "ValidMob";
    public static final String DATAQUERY_VALIDWEB = "ValidWeb";
    public static final String DATAQUERY_WEB = "Web";
    private PSEditorTypeDEModel pSEditorTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSEditorTypeDAO";
    }

    public PSEditorTypeDEModel getPSEditorTypeDEModel() {
        if (this.pSEditorTypeDEModel == null) {
            try {
                this.pSEditorTypeDEModel = (PSEditorTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSEditorTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSEditorTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSEditorTypeDEModel();
    }
}

