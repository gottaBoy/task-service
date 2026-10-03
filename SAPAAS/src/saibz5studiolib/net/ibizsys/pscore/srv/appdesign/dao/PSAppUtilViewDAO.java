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
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppUtilViewDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppUtilViewDAO
extends PSCoreSysDAOBase<PSAppUtilView> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURAPPFUNC = "CurAppFunc";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppUtilViewDEModel pSAppUtilViewDEModel;
    private PSAppViewDAO pSAppViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppUtilViewDAO";
    }

    public PSAppUtilViewDEModel getPSAppUtilViewDEModel() {
        if (this.pSAppUtilViewDEModel == null) {
            try {
                this.pSAppUtilViewDEModel = (PSAppUtilViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppUtilViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppUtilViewDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppUtilViewDEModel();
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

    protected void fillInheritEntity(PSAppUtilView pSAppUtilView) throws Exception {
        super.fillInheritEntity(pSAppUtilView);
        PSAppUtilView pSAppUtilView2 = pSAppUtilView;
        pSAppUtilView2.setPSAppViewId(pSAppUtilView.getPSAppUtilViewId());
        if (pSAppUtilView.isPSAppUtilViewNameDirty()) {
            pSAppUtilView2.setPSAppViewName(pSAppUtilView.getPSAppUtilViewName());
        }
        ((PSAppViewBase)pSAppUtilView2).set("PSAPPVIEWTYPE", "APPUTILVIEW");
    }
}

