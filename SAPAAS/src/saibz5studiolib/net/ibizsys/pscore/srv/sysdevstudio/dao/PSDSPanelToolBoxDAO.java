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
package net.ibizsys.pscore.srv.sysdevstudio.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDSPanelToolBoxDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDSPanelToolBox;
import org.springframework.stereotype.Repository;

@Repository
public class PSDSPanelToolBoxDAO
extends PSCoreSysDAOBase<PSDSPanelToolBox> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_BUTTON = "Button";
    public static final String DATAQUERY_CONTAINER = "Container";
    public static final String DATAQUERY_CONTROL = "Control";
    public static final String DATAQUERY_CTRLPOS = "CtrlPos";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_FIELD = "Field";
    public static final String DATAQUERY_RAWITEM = "RawItem";
    private PSDSPanelToolBoxDEModel pSDSPanelToolBoxDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSDSPanelToolBoxDAO";
    }

    public PSDSPanelToolBoxDEModel getPSDSPanelToolBoxDEModel() {
        if (this.pSDSPanelToolBoxDEModel == null) {
            try {
                this.pSDSPanelToolBoxDEModel = (PSDSPanelToolBoxDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDSPanelToolBoxDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSPanelToolBoxDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDSPanelToolBoxDEModel();
    }
}

