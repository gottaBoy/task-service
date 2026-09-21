/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 */
package net.ibizsys.pscore.srv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.pscore.srv.IPSRawSelectWork;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;

public interface IPSCoreSysService<ET extends IEntity>
extends IService<ET> {
    public static final String ACTION_CREATEBATCH = "CREATEBATCH";
    public static final String ACTION_UPDATEBATCH = "UPDATEBATCH";
    public static final String ACTION_SAVEBATCH = "SAVEBATCH";
    public static final String ACTION_REMOVEBATCH = "REMOVEBATCH";
    public static final String ACTION_CREATETEMPBATCH = "CREATETEMPBATCH";
    public static final String ACTION_UPDATETEMPBATCH = "UPDATETEMPBATCH";
    public static final String ACTION_REMOVETEMPBATCH = "REMOVETEMPBATCH";
    public static final String ACTION_EXPORTMODEL = "EXPORTMODEL";
    public static final String ACTION_EXPORTMAJORMODEL = "EXPORTMAJORMODEL";
    public static final String ACTION_EXPORTCURMODEL = "EXPORTCURMODEL";
    public static final String ACTION_EXPORTRELATEDMODEL = "EXPORTRELATEDMODEL";

    public boolean existsData(ET var1) throws Exception;

    public void selectRaw(String var1, SqlParamList var2, IPSRawSelectWork var3) throws Exception;

    public DBCallResult executeBatchCreate(ArrayList<IEntity> var1, int var2) throws Exception;

    public void createBatch(List<ET> var1) throws Exception;

    public void createBatch(List<ET> var1, boolean var2) throws Exception;

    public void updateBatch(List<ET> var1) throws Exception;

    public void updateBatch(List<ET> var1, boolean var2) throws Exception;

    public void removeBatch(List<ET> var1) throws Exception;

    public void createTempBatch(List<ET> var1) throws Exception;

    public void createTempBatch(List<ET> var1, boolean var2) throws Exception;

    public void updateTempBatch(List<ET> var1) throws Exception;

    public void updateTempBatch(List<ET> var1, boolean var2) throws Exception;

    public void removeTempBatch(List<ET> var1) throws Exception;

    public void saveBatch(List<ET> var1) throws Exception;

    public void saveBatch(List<ET> var1, boolean var2) throws Exception;

    public void saveTempBatch(List<ET> var1) throws Exception;

    public void saveTempBatch(List<ET> var1, boolean var2) throws Exception;

    public String getFullDataInfo(ET var1) throws Exception;

    public String getDataInfo(ET var1) throws Exception;

    public void moveOrder(int var1, List<ET> var2) throws Exception;

    public void removeTempMajor(List<ET> var1) throws Exception;

    public void doServiceWork(IServiceWork var1, boolean var2) throws Exception;

    public void translate(Map<String, Object> var1) throws Exception;

    public IPSDataEntityModel<ET> getDEModel();
}

