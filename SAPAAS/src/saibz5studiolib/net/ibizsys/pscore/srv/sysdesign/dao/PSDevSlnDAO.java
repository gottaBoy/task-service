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
package net.ibizsys.pscore.srv.sysdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnDAO
extends PSCoreSysDAOBase<PSDevSln> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_CURDCADMIN = "CurDCAdmin";
    public static final String DATAQUERY_CURDCSLNADMIN = "CurDCSLNAdmin";
    public static final String DATAQUERY_CURDCSLNUSER = "CurDCSLNUser";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_FROMDCSLNUSER = "FromDCSLNUser";
    private PSDevSlnDEModel pSDevSlnDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnDAO";
    }

    public PSDevSlnDEModel getPSDevSlnDEModel() {
        if (this.pSDevSlnDEModel == null) {
            try {
                this.pSDevSlnDEModel = (PSDevSlnDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnDEModel();
    }
}

