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
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppDynaDEViewDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDynaDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppDynaDEViewDAO
extends PSCoreSysDAOBase<PSAppDynaDEView> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppDynaDEViewDEModel pSAppDynaDEViewDEModel;
    private PSAppViewDAO pSAppViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppDynaDEViewDAO";
    }

    public PSAppDynaDEViewDEModel getPSAppDynaDEViewDEModel() {
        if (this.pSAppDynaDEViewDEModel == null) {
            try {
                this.pSAppDynaDEViewDEModel = (PSAppDynaDEViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppDynaDEViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppDynaDEViewDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppDynaDEViewDEModel();
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

    protected void fillInheritEntity(PSAppDynaDEView pSAppDynaDEView) throws Exception {
        super.fillInheritEntity(pSAppDynaDEView);
        PSAppDynaDEView pSAppDynaDEView2 = pSAppDynaDEView;
        pSAppDynaDEView2.setPSAppViewId(pSAppDynaDEView.getPSAppDynaDEViewId());
        if (pSAppDynaDEView.isPSAppDynaDEViewNameDirty()) {
            pSAppDynaDEView2.setPSAppViewName(pSAppDynaDEView.getPSAppDynaDEViewName());
        }
        ((PSAppViewBase)pSAppDynaDEView2).set("PSAPPVIEWTYPE", "APPDYNADEVIEW");
    }
}

