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
package net.ibizsys.pscore.srv.wfdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFVersionDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import org.springframework.stereotype.Repository;

@Repository
public class PSWFVersionDAO
extends PSCoreSysDAOBase<PSWFVersion> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURINST = "CurInst";
    public static final String DATAQUERY_CURWF = "CurWF";
    public static final String DATAQUERY_CURWFPART = "CurWFPart";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_DYNAWFVERCNT = "DynaWFVerCnt";
    private PSWFVersionDEModel pSWFVersionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfdesign.dao.PSWFVersionDAO";
    }

    public PSWFVersionDEModel getPSWFVersionDEModel() {
        if (this.pSWFVersionDEModel == null) {
            try {
                this.pSWFVersionDEModel = (PSWFVersionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFVersionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFVersionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWFVersionDEModel();
    }
}

