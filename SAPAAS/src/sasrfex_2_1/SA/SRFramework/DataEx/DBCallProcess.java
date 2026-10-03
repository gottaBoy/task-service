/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.InsertResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Data.UpdateResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.InsertResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.UpdateResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Workflow.IWFEngineContext;
import SA.SRFramework.Workflow.IWFProcess;
import SA.SRFramework.Workflow.WFProcessConfig;
import java.sql.Connection;

public class DBCallProcess
implements IWFProcess {
    protected WFProcessConfig wfProcessConfig = null;
    public static final String TAG_DBACTION = "DBACTION";
    public static final String DBACTION_UPDATE = "UPDATE";
    public static final String DBACTION_INSERT = "INSERT";
    public static final String DBACTION_SELECT = "SELECT";
    public static final String DBACTION_DELETE = "DELETE";

    @Override
    public boolean Init(WFProcessConfig wfProcessConfig) {
        this.wfProcessConfig = wfProcessConfig;
        return this.wfProcessConfig != null;
    }

    @Override
    public boolean Execute(IWFEngineContext wfEngineContext) {
        String strDBAction;
        block25: {
            SelectResult dbResult;
            block26: {
                BaseDataEntity baseDataEntity;
                Connection connection;
                block23: {
                    SelectResult selectResult;
                    block24: {
                        block21: {
                            UpdateResult updateResult;
                            block22: {
                                block19: {
                                    InsertResult insertResult;
                                    block20: {
                                        if (wfEngineContext == null) {
                                            return false;
                                        }
                                        if (wfEngineContext.getDBCallerHelper() == null) {
                                            return false;
                                        }
                                        if (this.wfProcessConfig == null) {
                                            return false;
                                        }
                                        Object objConnection = wfEngineContext.getUserParam("CONNECTION");
                                        if (objConnection == null) {
                                            wfEngineContext.Log(2, "\u6570\u636e\u5e93\u8fde\u63a5\u65e0\u6548");
                                            return false;
                                        }
                                        connection = null;
                                        if (objConnection instanceof Connection) {
                                            connection = (Connection)objConnection;
                                        }
                                        if (connection == null) {
                                            wfEngineContext.Log(2, "\u6570\u636e\u5e93\u8fde\u63a5\u65e0\u6548");
                                            return false;
                                        }
                                        baseDataEntity = wfEngineContext.getActiveDataEntity();
                                        try {
                                            strDBAction = this.wfProcessConfig.GetExtValue(TAG_DBACTION, "");
                                            if (StringHelper.Compare((String)strDBAction, (String)DBACTION_INSERT, (boolean)true) != 0) break block19;
                                            insertResult = wfEngineContext.getDBCallerHelper().InsertCmd(connection, this.wfProcessConfig.getObject(), baseDataEntity.getTotalParamList(), wfEngineContext.getOpPersonId());
                                            if (insertResult.getRetCode() != 0) break block20;
                                            if (insertResult.getMainTable() != null && insertResult.getMainTable().GetRowCount() > 0) {
                                                baseDataEntity.FromDataRow(insertResult.getMainTable().GetRow(0), false);
                                            }
                                            return true;
                                        }
                                        catch (Exception ex) {
                                            ex.printStackTrace();
                                            return false;
                                        }
                                    }
                                    wfEngineContext.Log(1, StringHelper.Format((String)"DB INSERT[%1$s]\u5931\u8d25\uff0c\u539f\u56e0:%2$s", (Object)this.wfProcessConfig.getObject(), (Object)insertResult.getErrorInfo()));
                                    return false;
                                }
                                if (StringHelper.Compare((String)strDBAction, (String)DBACTION_UPDATE, (boolean)true) != 0) break block21;
                                try {
                                    updateResult = wfEngineContext.getDBCallerHelper().UpdateCmd(connection, this.wfProcessConfig.getObject(), baseDataEntity.getTotalParamList(), wfEngineContext.getOpPersonId());
                                    if (updateResult.getRetCode() != 0) break block22;
                                    if (updateResult.getMainTable() != null && updateResult.getMainTable().GetRowCount() > 0) {
                                        baseDataEntity.FromDataRow(updateResult.getMainTable().GetRow(0), false);
                                    }
                                }
                                catch (Exception ex) {
                                    wfEngineContext.Log(1, StringHelper.Format((String)"DB UPDATE[%1$s]\u5931\u8d25\uff0c\u539f\u56e0:%2$s", (Object)this.wfProcessConfig.getObject(), (Object)ex.getMessage()));
                                    return false;
                                }
                                return true;
                            }
                            wfEngineContext.Log(1, StringHelper.Format((String)"DB UPDATE[%1$s]\u5931\u8d25\uff0c\u539f\u56e0:%2$s", (Object)this.wfProcessConfig.getObject(), (Object)updateResult.getErrorInfo()));
                            return false;
                        }
                        if (StringHelper.Compare((String)strDBAction, (String)DBACTION_SELECT, (boolean)true) != 0) break block23;
                        try {
                            selectResult = wfEngineContext.getDBCallerHelper().SelectCmd(connection, this.wfProcessConfig.getObject(), baseDataEntity.getTotalParamList(), wfEngineContext.getOpPersonId());
                            if (selectResult.getRetCode() != 0) break block24;
                            if (selectResult.getMainTable() != null && selectResult.getMainTable().GetRowCount() > 0) {
                                baseDataEntity.FromDataRow(selectResult.getMainTable().GetRow(0), false);
                            }
                        }
                        catch (Exception ex) {
                            wfEngineContext.Log(1, StringHelper.Format((String)"DB SELECT[%1$s]\u5931\u8d25\uff0c\u539f\u56e0:%2$s", (Object)this.wfProcessConfig.getObject(), (Object)ex.getMessage()));
                            return false;
                        }
                        return true;
                    }
                    wfEngineContext.Log(1, StringHelper.Format((String)"DB SELECT[%1$s]\u5931\u8d25\uff0c\u539f\u56e0:%2$s", (Object)this.wfProcessConfig.getObject(), (Object)selectResult.getErrorInfo()));
                    return false;
                }
                if (StringHelper.Compare((String)strDBAction, (String)DBACTION_DELETE, (boolean)true) != 0) break block25;
                try {
                    dbResult = wfEngineContext.getDBCallerHelper().SelectCmd(connection, this.wfProcessConfig.getObject(), baseDataEntity.getTotalParamList(), wfEngineContext.getOpPersonId());
                    if (dbResult.getRetCode() != 0) break block26;
                }
                catch (Exception ex) {
                    wfEngineContext.Log(1, StringHelper.Format((String)"DB DELETE[%1$s]\u5931\u8d25\uff0c\u539f\u56e0:%2$s", (Object)this.wfProcessConfig.getObject(), (Object)ex.getMessage()));
                    return false;
                }
                return true;
            }
            wfEngineContext.Log(1, StringHelper.Format((String)"DB DELETE[%1$s]\u5931\u8d25\uff0c\u539f\u56e0:%2$s", (Object)this.wfProcessConfig.getObject(), (Object)dbResult.getErrorInfo()));
            return false;
        }
        wfEngineContext.Log(1, StringHelper.Format((String)"DB \u8c03\u7528[%1$s]\u672a\u77e5", (Object)strDBAction));
        return false;
    }

    @Override
    public void Rollback() {
    }

    @Override
    public void Quit() {
        this.wfProcessConfig = null;
    }
}

