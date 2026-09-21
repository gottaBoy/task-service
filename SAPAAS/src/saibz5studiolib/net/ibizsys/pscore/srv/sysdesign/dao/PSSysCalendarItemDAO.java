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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysCalendarItemDAO
extends PSCoreSysDAOBase<PSSysCalendarItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysCalendarItemDEModel pSSysCalendarItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysCalendarItemDAO";
    }

    public PSSysCalendarItemDEModel getPSSysCalendarItemDEModel() {
        if (this.pSSysCalendarItemDEModel == null) {
            try {
                this.pSSysCalendarItemDEModel = (PSSysCalendarItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCalendarItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysCalendarItemDEModel();
    }
}

