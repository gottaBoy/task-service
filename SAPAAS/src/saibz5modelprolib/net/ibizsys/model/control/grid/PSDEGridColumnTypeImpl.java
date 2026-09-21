/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridColumnType;
import net.ibizsys.model.entity.PSDEGridColumn;
import net.ibizsys.model.entity.PSDEGridColumnType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGridColumnTypeImpl
extends PSObjectImpl
implements IPSDEGridColumnType {
    protected PSDEGridColumnType psDEGridColumnType = null;
    private static final Log log = LogFactory.getLog(PSDEGridColumnTypeImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSDEGridColumnType psDEGridColumnType) throws Exception {
        this.psDEGridColumnType = psDEGridColumnType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psDEGridColumnType.getPSDEGCTYPEID());
        this.setName(psDEGridColumnType.getPSDEGCTYPENAME());
        this.onInit();
    }

    @Override
    public IPSDEGridColumn createPSDEGridColumn(PSDEGridColumn psDEGridColumn) throws Exception {
        return (IPSDEGridColumn)this.getPSModelStorageContext().createObject(this.psDEGridColumnType.getCOLUMNOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

