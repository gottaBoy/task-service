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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEVRGroupDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGroup;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEVRGroupDAO
extends PSCoreSysDAOBase<PSDEVRGroup> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEVRGroupDEModel pSDEVRGroupDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEVRGroupDAO";
    }

    public PSDEVRGroupDEModel getPSDEVRGroupDEModel() {
        if (this.pSDEVRGroupDEModel == null) {
            try {
                this.pSDEVRGroupDEModel = (PSDEVRGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEVRGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEVRGroupDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEVRGroupDEModel();
    }
}

