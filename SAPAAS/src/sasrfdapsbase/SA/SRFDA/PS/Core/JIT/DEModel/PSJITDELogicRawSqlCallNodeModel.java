/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDERawSqlCallLogic;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDELogicNodeModelBase;
import java.util.Iterator;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import org.hibernate.SessionFactory;

public class PSJITDELogicRawSqlCallNodeModel
extends PSJITDELogicNodeModelBase {
    @Override
    protected void onExecute(IActionContext iActionContext) throws Exception {
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        if (this.getPSDELogicNode() instanceof IPSDERawSqlCallLogic) {
            IPSDERawSqlCallLogic iPSDERawSqlCallLogic = (IPSDERawSqlCallLogic)this.getPSDELogicNode();
            String strSQL = iPSDERawSqlCallLogic.getSql();
            SqlParamList sqlParamList = new SqlParamList();
            Iterator<IPSDELogicNodeParam> psDELogicNodeParams = this.getPSDELogicNode().getPSDELogicNodeParams();
            if (psDELogicNodeParams != null) {
                while (psDELogicNodeParams.hasNext()) {
                    IPSDELogicNodeParam iPSDELogicNodeParam = psDELogicNodeParams.next();
                    if (StringHelper.compare((String)iPSDELogicNodeParam.getLogicNodeParamType(), (String)"SQLPARAM", (boolean)false) != 0) continue;
                    if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"WEBCONTEXT", (boolean)false) == 0) {
                        sqlParamList.addObject((Object)WebContext.getCurrent().getPostValue(iPSDELogicNodeParam.getSrcFieldName()));
                    }
                    if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"SRCDLPARAM", (boolean)false) == 0) {
                        IEntity srcParam = (IEntity)iActionContext.getParam(iPSDELogicNodeParam.getSrcPSDELogicParam().getCodeName());
                        sqlParamList.addObject(srcParam.get(iPSDELogicNodeParam.getSrcFieldName()));
                    }
                    if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"APPDATA", (boolean)false) == 0) {
                        sqlParamList.addObject((Object)WebContext.getCurrent().getAppDataValue(iPSDELogicNodeParam.getSrcFieldName()));
                    }
                    if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"VIEWPARAM", (boolean)false) == 0) {
                        sqlParamList.addObject((Object)WebContext.getCurrent().getViewParamValue(iPSDELogicNodeParam.getSrcFieldName()));
                    }
                    if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"APPLICATION", (boolean)false) == 0) {
                        sqlParamList.addObject(WebContext.getCurrent().getGlobalValue(iPSDELogicNodeParam.getSrcFieldName()));
                    }
                    if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"SESSION", (boolean)false) == 0) {
                        sqlParamList.addObject(WebContext.getCurrent().getSessionValue(iPSDELogicNodeParam.getSrcFieldName()));
                    }
                    if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"NONEVALUE", (boolean)false) == 0) {
                        sqlParamList.addObject(null);
                    }
                    if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"NULLVALUE", (boolean)false) == 0) {
                        sqlParamList.addObject(null);
                    }
                    if (StringHelper.compare((String)iPSDELogicNodeParam.getSrcValueType(), (String)"SRCVALUE", (boolean)false) != 0) continue;
                    sqlParamList.addObject((Object)iPSDELogicNodeParam.getSrcValue());
                }
            }
            DBCallResult dbFetchResult = this.getDAO(iActionContext).executeRawSql(null, strSQL, sqlParamList);
            if (iPSDERawSqlCallLogic.isFillDstLogicParam()) {
                if (dbFetchResult.getDataSet() == null || dbFetchResult.getDataSet().getDataTableCount() == 0) {
                    throw new ErrorException(3);
                }
                dbFetchResult.getDataSet().cacheDataRow();
                IDataTable iDataTable = dbFetchResult.getDataSet().getDataTable(0);
                if (iDataTable.getCachedRowCount() == 0) {
                    throw new ErrorException(3);
                }
                IEntity dstParam = (IEntity)iActionContext.getParam(iPSDERawSqlCallLogic.getDstPSDELogicParam().getCodeName());
                IDataRow iDataRow = iDataTable.getCachedRow(0);
                if (!iPSDERawSqlCallLogic.isIgnoreResetDstLogicParam()) {
                    DataObject.fromDataRow((IDataObject)dstParam, (IDataRow)iDataRow, (boolean)true);
                } else {
                    DataObject.fromDataRow((IDataObject)dstParam, (IDataRow)iDataRow, (boolean)false);
                }
            }
        }
    }
}

