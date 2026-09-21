/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Repository
 */
package net.ibizsys.pscore.srv.appdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSAppViewDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppIndexViewDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppIndexViewDAO
extends PSCoreSysDAOBase<PSAppIndexView> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURMOD = "CurMod";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppIndexViewDEModel pSAppIndexViewDEModel;
    private PSAppViewDAO pSAppViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppIndexViewDAO";
    }

    public PSAppIndexViewDEModel getPSAppIndexViewDEModel() {
        if (this.pSAppIndexViewDEModel == null) {
            try {
                this.pSAppIndexViewDEModel = (PSAppIndexViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppIndexViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppIndexViewDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppIndexViewDEModel();
    }

    protected IDAO getInheritDEDAO() {
        if (this.pSAppViewDAO == null) {
            try {
                this.pSAppViewDAO = (PSAppViewDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppViewDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppViewDAO;
    }

    protected void fillInheritEntity(PSAppIndexView pSAppIndexView) throws Exception {
        super.fillInheritEntity((IEntity)pSAppIndexView);
        PSAppIndexView pSAppIndexView2 = pSAppIndexView;
        pSAppIndexView2.setPSAppViewId(pSAppIndexView.getPSAppIndexViewId());
        if (pSAppIndexView.isPSAppIndexViewNameDirty()) {
            pSAppIndexView2.setPSAppViewName(pSAppIndexView.getPSAppIndexViewName());
        }
        ((PSAppViewBase)pSAppIndexView2).set("PSAPPVIEWTYPE", "APPINDEXVIEW");
    }
}

