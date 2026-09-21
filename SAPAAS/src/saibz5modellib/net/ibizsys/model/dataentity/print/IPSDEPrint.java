/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.print;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;

public interface IPSDEPrint
extends IPSDataEntityObject {
    public IPSDEDataSet getPSDEDataSet();

    @Deprecated
    public String getPSDEDataSetId();

    public String getCodeName();

    public boolean isEnableColPriv();

    public boolean isEnableLog();

    public boolean isEnableMulitPrint();

    public IPSDEAction getGetDataPSDEAction();

    public String getGetDataPSDEActionId();

    public String getReportType();

    public String getReportFile();

    public IPSDEOPPriv getGetDataPSDEOPPriv();

    public String getDetailPSDEId();

    public IPSDataEntity getDetailPSDE();

    public IPSDEDataSet getDetailPSDEDataSet();

    public String getDetailActiveDataPSDELogicId();

    public IPSDELogic getDetailActiveDataPSDELogic();
}

