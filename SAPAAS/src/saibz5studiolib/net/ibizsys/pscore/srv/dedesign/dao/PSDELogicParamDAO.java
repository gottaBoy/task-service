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
package net.ibizsys.pscore.srv.dedesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDELogicParamDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import org.springframework.stereotype.Repository;

@Repository
public class PSDELogicParamDAO
extends PSCoreSysDAOBase<PSDELogicParam> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURLOGIC = "CurLogic";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_FILELISTPARAM = "FileListParam";
    public static final String DATAQUERY_FILEPARAM = "FileParam";
    public static final String DATAQUERY_FIREEVENTUIPARAM = "FireEventUIParam";
    public static final String DATAQUERY_UIPARAM = "UIParam";
    private PSDELogicParamDEModel pSDELogicParamDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDELogicParamDAO";
    }

    public PSDELogicParamDEModel getPSDELogicParamDEModel() {
        if (this.pSDELogicParamDEModel == null) {
            try {
                this.pSDELogicParamDEModel = (PSDELogicParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDELogicParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDELogicParamDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDELogicParamDEModel();
    }
}

