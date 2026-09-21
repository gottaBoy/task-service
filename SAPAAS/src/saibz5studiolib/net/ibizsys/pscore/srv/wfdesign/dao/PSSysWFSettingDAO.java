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
import net.ibizsys.pscore.srv.wfdesign.demodel.PSSysWFSettingDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFSetting;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysWFSettingDAO
extends PSCoreSysDAOBase<PSSysWFSetting> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysWFSettingDEModel pSSysWFSettingDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfdesign.dao.PSSysWFSettingDAO";
    }

    public PSSysWFSettingDEModel getPSSysWFSettingDEModel() {
        if (this.pSSysWFSettingDEModel == null) {
            try {
                this.pSSysWFSettingDEModel = (PSSysWFSettingDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSSysWFSettingDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysWFSettingDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysWFSettingDEModel();
    }
}

