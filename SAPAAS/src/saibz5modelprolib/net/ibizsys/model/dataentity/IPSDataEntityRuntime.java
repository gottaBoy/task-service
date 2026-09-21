/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.dataentity.IPSDataEntity
 */
package net.ibizsys.model.dataentity;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.entity.PSDEACMode;
import net.ibizsys.model.entity.PSDEViewBase;
import net.ibizsys.model.entity.PSDataEntity;

public interface IPSDataEntityRuntime
extends IPSDataEntity,
IPSModelObjectRuntime {
    public void setInitParam(IPSModelStorageContext var1, IPSSystem var2, PSDataEntity var3);

    public void init() throws Exception;

    public boolean isInit();

    public boolean preparePSDEFields(boolean var1) throws Exception;

    public Iterator<PSDEViewBase> getAllPSDEViewDatas();

    public PSDEViewBase getPSDEViewDataByPDT(String var1, boolean var2) throws Exception;

    public PSDEViewBase getPSDEViewDataByPDT(String var1, String var2, boolean var3) throws Exception;

    public PSDEViewBase getPSDEViewDataByPDT(String var1, String var2, String var3, boolean var4) throws Exception;

    public Iterator<PSDEViewBase> getPSDEViewDatasByPDT(String var1) throws Exception;

    public PSACHandler getPSAjaxControlHandlerData(String var1) throws Exception;

    public ArrayList<PSDEViewBase> getSDPSDEViewDataList(boolean var1) throws Exception;

    public void checkDataEntity() throws Exception;

    public PSDEACMode getDefaultPSDEACModeData();

    public Iterator<String> getPDTViewNames();
}

