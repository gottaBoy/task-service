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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendar;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysCalendarDAO
extends PSCoreSysDAOBase<PSSysCalendar> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURAPPGANTT = "CurAppGantt";
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURDEGANTT = "CurDEGantt";
    public static final String DATAQUERY_CURMOD = "CurMod";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSGANTT = "CurSysGantt";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysCalendarDEModel pSSysCalendarDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysCalendarDAO";
    }

    public PSSysCalendarDEModel getPSSysCalendarDEModel() {
        if (this.pSSysCalendarDEModel == null) {
            try {
                this.pSSysCalendarDEModel = (PSSysCalendarDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCalendarDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysCalendarDEModel();
    }
}

