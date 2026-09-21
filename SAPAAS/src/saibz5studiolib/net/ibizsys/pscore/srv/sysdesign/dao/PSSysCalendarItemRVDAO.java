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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarItemRVDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItemRV;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysCalendarItemRVDAO
extends PSCoreSysDAOBase<PSSysCalendarItemRV> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysCalendarItemRVDEModel pSSysCalendarItemRVDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysCalendarItemRVDAO";
    }

    public PSSysCalendarItemRVDEModel getPSSysCalendarItemRVDEModel() {
        if (this.pSSysCalendarItemRVDEModel == null) {
            try {
                this.pSSysCalendarItemRVDEModel = (PSSysCalendarItemRVDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarItemRVDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCalendarItemRVDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysCalendarItemRVDEModel();
    }
}

