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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSPFStyleDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import org.springframework.stereotype.Repository;

@Repository
public class PSPFStyleDAO
extends PSCoreSysDAOBase<PSPFStyle> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_CURDC2 = "CurDC2";
    public static final String DATAQUERY_CURDCPF = "CurDCPF";
    public static final String DATAQUERY_CURDCPF2 = "CurDCPF2";
    public static final String DATAQUERY_CURDCPF3 = "CurDCPF3";
    public static final String DATAQUERY_CURPF = "CurPF";
    public static final String DATAQUERY_CURPF2 = "CurPF2";
    public static final String DATAQUERY_CURPF3 = "CurPF3";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VIEW = "View";
    private PSPFStyleDEModel pSPFStyleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSPFStyleDAO";
    }

    public PSPFStyleDEModel getPSPFStyleDEModel() {
        if (this.pSPFStyleDEModel == null) {
            try {
                this.pSPFStyleDEModel = (PSPFStyleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFStyleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFStyleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSPFStyleDEModel();
    }
}

