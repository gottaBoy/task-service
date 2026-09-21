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
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppPortalViewDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppPortalViewDAO
extends PSCoreSysDAOBase<PSAppPortalView> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURMOD = "CurMod";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppPortalViewDEModel pSAppPortalViewDEModel;
    private PSAppViewDAO pSAppViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppPortalViewDAO";
    }

    public PSAppPortalViewDEModel getPSAppPortalViewDEModel() {
        if (this.pSAppPortalViewDEModel == null) {
            try {
                this.pSAppPortalViewDEModel = (PSAppPortalViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppPortalViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppPortalViewDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppPortalViewDEModel();
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

    protected void fillInheritEntity(PSAppPortalView pSAppPortalView) throws Exception {
        super.fillInheritEntity((IEntity)pSAppPortalView);
        PSAppPortalView pSAppPortalView2 = pSAppPortalView;
        pSAppPortalView2.setPSAppViewId(pSAppPortalView.getPSAppPortalViewId());
        if (pSAppPortalView.isPSAppPortalViewNameDirty()) {
            pSAppPortalView2.setPSAppViewName(pSAppPortalView.getPSAppPortalViewName());
        }
        ((PSAppViewBase)pSAppPortalView2).set("PSAPPVIEWTYPE", "APPPORTALVIEW");
    }
}

