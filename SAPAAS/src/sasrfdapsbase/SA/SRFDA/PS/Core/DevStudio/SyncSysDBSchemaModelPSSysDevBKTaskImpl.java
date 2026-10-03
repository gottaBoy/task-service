/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBSchemeBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseAction;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeLog;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeSet;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeSets;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseColumn;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseCreateTable;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.DynaModel.PSLiquibaseChangeLogModelImpl;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSSysDynaModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBSchemeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SyncSysDBSchemaModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SyncSysDBSchemaModelPSSysDevBKTaskImpl.class);
    protected static Map<String, Integer> str2intMap = new HashMap<String, Integer>();

    static {
        str2intMap.put("BIGINT", 1);
        str2intMap.put("BINARY", 2);
        str2intMap.put("BIT", 3);
        str2intMap.put("CHAR", 4);
        str2intMap.put("DATETIME", 5);
        str2intMap.put("DECIMAL", 6);
        str2intMap.put("BIGDECIMAL", 29);
        str2intMap.put("FLOAT", 7);
        str2intMap.put("IMAGE", 8);
        str2intMap.put("INT", 9);
        str2intMap.put("MONEY", 10);
        str2intMap.put("NCHAR", 11);
        str2intMap.put("NTEXT", 12);
        str2intMap.put("NVARCHAR", 13);
        str2intMap.put("NUMERIC", 14);
        str2intMap.put("REAL", 15);
        str2intMap.put("SMALLDATETIME", 16);
        str2intMap.put("SMALLINT", 17);
        str2intMap.put("SMALLMONEY", 18);
        str2intMap.put("SQL_VARIANT", 19);
        str2intMap.put("SYSNAME", 20);
        str2intMap.put("TEXT", 21);
        str2intMap.put("TIMESTAMP", 22);
        str2intMap.put("TINYINT", 23);
        str2intMap.put("VARBINARY", 24);
        str2intMap.put("VARCHAR", 25);
        str2intMap.put("UNIQUEIDENTIFIER", 26);
        str2intMap.put("DATE", 27);
        str2intMap.put("TIME", 28);
        str2intMap.put("VARCHAR2", 25);
        str2intMap.put("NUMBER", 6);
        str2intMap.put("BLOB", 24);
        str2intMap.put("CLOB", 21);
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysDevBKTask.getTASKPARAM())) {
            return "\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u6570\u636e\u5e93\u4f53\u7cfb";
        }
        PSSysDBSchemeService psSysDBSchemeService = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSysDBScheme psSysDBScheme2 = new PSSysDBScheme();
        psSysDBScheme2.setPSSysDBSchemeId(this.psSysDevBKTask.getTASKPARAM());
        psSysDBSchemeService.get(psSysDBScheme2);
        PSLiquibaseChangeLogModelImpl iPSLiquibaseChangeLog = null;
        if (psSysDBScheme2.getPSSysDynaModel() != null && StringHelper.compare((String)psSysDBScheme2.getPSSysDynaModel().getDynaModelUsage(), (String)"LIQUIBASECHANGELOG", (boolean)false) == 0) {
            IPSDevSlnSys iPSDevSlnSys = PSObjectFactory.getPSModelStorage().getPSDevSlnSys(this.getPSDevSlnSysId());
            IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
            PSSysDynaModel psSysDynaModel = new PSSysDynaModel();
            psSysDynaModel.setPSSYSDYNAMODELID(psSysDBScheme2.getPSSysDynaModel().getPSSysDynaModelId());
            psSysDynaModel.setPSSYSDYNAMODELNAME(psSysDBScheme2.getPSSysDynaModel().getPSSysDynaModelName());
            psSysDynaModel.setDYNAMODELUSAGE("LIQUIBASECHANGELOG");
            psSysDynaModel.setDYNAMODEL(psSysDBScheme2.getPSSysDynaModel().getDynaModel());
            psSysDynaModel.setDYNAMODEL2(psSysDBScheme2.getPSSysDynaModel().getDynaModel2());
            PSLiquibaseChangeLogModelImpl psLiquibaseChangeLogImpl = new PSLiquibaseChangeLogModelImpl();
            psLiquibaseChangeLogImpl.init(this.getDAGlobalHelper(), iPSSystem, psSysDynaModel);
            iPSLiquibaseChangeLog = psLiquibaseChangeLogImpl;
        }
        try {
            String strRet2;
            PSCoreSysServiceBase.setCurrentPSSystemId((String)psSysDBScheme2.getPSSystemId());
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)this.getPSDevSlnSysId());
            String strRet = "";
            if (iPSLiquibaseChangeLog != null) {
                strRet = this.syncDBTableModel(psSysDBScheme2, iPSLiquibaseChangeLog);
            }
            if (!StringHelper.isNullOrEmpty(strRet2 = null)) {
                strRet = !StringHelper.isNullOrEmpty((String)strRet) ? String.valueOf(strRet) + strRet2 : strRet2;
            }
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            return strRet;
        }
        catch (Exception ex) {
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            throw ex;
        }
    }

    protected String syncDBTableModel(PSSysDBScheme psSysDBScheme, IPSLiquibaseChangeLog iPSLiquibaseChangeLog) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        IPSLiquibaseChangeSets iPSLiquibaseChangeSets = iPSLiquibaseChangeLog.getPSLiquibaseChangeSets();
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
        PSSysDBTableService psSysDBTableService = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, (SessionFactory)sessionFactory);
        ArrayList<PSSysDBTable> psSysDBTableList = psSysDBTableService.selectByPSSysDBScheme((PSSysDBSchemeBase)psSysDBScheme);
        HashMap<String, PSSysDBTable> psSysDBTableMap = new HashMap<String, PSSysDBTable>();
        for (PSSysDBTable psSysDBTable : psSysDBTableList) {
            psSysDBTableMap.put(psSysDBTable.getPSSysDBTableName().toUpperCase(), psSysDBTable);
        }
        PSSysDBColumnService psSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)sessionFactory);
        ArrayList<PSSysDBColumn> psSysDBColumnList = psSysDBColumnService.select((ISelectCond)new SelectCond());
        if (iPSLiquibaseChangeSets.getItems() != null) {
            PSSysDBTable psSysDBTable;
            IPSLiquibaseCreateTable iPSLiquibaseCreateTable;
            IPSLiquibaseAction iPSLiquibaseAction;
            Iterator psLiquibaseActions;
            IPSLiquibaseChangeSet iPSLiquibaseChangeSet;
            Iterator psLiquibaseChangeSets = iPSLiquibaseChangeSets.getItems();
            while (psLiquibaseChangeSets.hasNext()) {
                iPSLiquibaseChangeSet = (IPSLiquibaseChangeSet)psLiquibaseChangeSets.next();
                if (iPSLiquibaseChangeSet.getPSLiquibaseActions() == null || iPSLiquibaseChangeSet.getPSLiquibaseActions().getItems() == null) continue;
                psLiquibaseActions = iPSLiquibaseChangeSet.getPSLiquibaseActions().getItems();
                while (psLiquibaseActions.hasNext()) {
                    iPSLiquibaseAction = (IPSLiquibaseAction)psLiquibaseActions.next();
                    if (!(iPSLiquibaseAction instanceof IPSLiquibaseCreateTable) || StringHelper.isNullOrEmpty((String)(iPSLiquibaseCreateTable = (IPSLiquibaseCreateTable)iPSLiquibaseAction).getTableName()) || (psSysDBTable = (PSSysDBTable)psSysDBTableMap.get(iPSLiquibaseCreateTable.getTableName().toUpperCase())) != null) continue;
                    PSSysModelInstGlobal.active((String)this.getPSSysModelInstId());
                    psSysDBTable = new PSSysDBTable();
                    psSysDBTable.setPSSysDBTableName(iPSLiquibaseCreateTable.getTableName().toUpperCase());
                    psSysDBTable.setCodeName(iPSLiquibaseCreateTable.getTableName());
                    psSysDBTable.setTableType("TABLE");
                    psSysDBTable.setTabDesc(iPSLiquibaseCreateTable.getRemarks());
                    psSysDBTable.setPSSysDBSchemeId(psSysDBScheme.getPSSysDBSchemeId());
                    try {
                        psSysDBTableService.create(psSysDBTable);
                        psSysDBTableMap.put(psSysDBTable.getPSSysDBTableName().toUpperCase(), psSysDBTable);
                        sb.append(StringHelper.format((String)"\u5efa\u7acb\u6570\u636e\u8868[%1$s]\r\n", (Object)iPSLiquibaseCreateTable.getTableName()));
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u5efa\u7acb\u6570\u636e\u8868[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iPSLiquibaseCreateTable.getTableName(), ex.getMessage()), ex);
                    }
                }
            }
            psLiquibaseChangeSets = iPSLiquibaseChangeSets.getItems();
            while (psLiquibaseChangeSets.hasNext()) {
                iPSLiquibaseChangeSet = (IPSLiquibaseChangeSet)psLiquibaseChangeSets.next();
                if (iPSLiquibaseChangeSet.getPSLiquibaseActions() == null || iPSLiquibaseChangeSet.getPSLiquibaseActions().getItems() == null) continue;
                psLiquibaseActions = iPSLiquibaseChangeSet.getPSLiquibaseActions().getItems();
                while (psLiquibaseActions.hasNext()) {
                    iPSLiquibaseAction = (IPSLiquibaseAction)psLiquibaseActions.next();
                    if (!(iPSLiquibaseAction instanceof IPSLiquibaseCreateTable) || StringHelper.isNullOrEmpty((String)(iPSLiquibaseCreateTable = (IPSLiquibaseCreateTable)iPSLiquibaseAction).getTableName()) || (psSysDBTable = (PSSysDBTable)psSysDBTableMap.get(iPSLiquibaseCreateTable.getTableName().toUpperCase())) == null || iPSLiquibaseCreateTable.getPSLiquibaseColumns() == null || iPSLiquibaseCreateTable.getPSLiquibaseColumns().getItems() == null) continue;
                    HashMap<String, PSSysDBColumn> psSysDBColumnMap = new HashMap<String, PSSysDBColumn>();
                    for (PSSysDBColumn psSysDBColumn : psSysDBColumnList) {
                        if (StringHelper.compare((String)psSysDBTable.getPSSysDBTableId(), (String)psSysDBColumn.getPSSysDBTableId(), (boolean)false) != 0) continue;
                        psSysDBColumnMap.put(psSysDBColumn.getPSSysDBColumnName().toUpperCase(), psSysDBColumn);
                    }
                    Iterator psLiquibaseColumns = iPSLiquibaseCreateTable.getPSLiquibaseColumns().getItems();
                    while (psLiquibaseColumns.hasNext()) {
                        PSSysDBColumn psSysDBColumn;
                        IPSLiquibaseColumn iPSLiquibaseColumn = (IPSLiquibaseColumn)psLiquibaseColumns.next();
                        if (StringHelper.isNullOrEmpty((String)iPSLiquibaseColumn.getName()) || (psSysDBColumn = (PSSysDBColumn)psSysDBColumnMap.get(iPSLiquibaseColumn.getName().toUpperCase())) != null) continue;
                        PSSysModelInstGlobal.active((String)this.getPSSysModelInstId());
                        psSysDBColumn = new PSSysDBColumn();
                        psSysDBColumn.setPSSysDBColumnName(iPSLiquibaseColumn.getName().toUpperCase());
                        psSysDBColumn.setCodeName(iPSLiquibaseColumn.getName());
                        psSysDBColumn.setPSSysDBTableId(psSysDBTable.getPSSysDBTableId());
                        psSysDBColumn.setPSSysDBTableName(psSysDBTable.getPSSysDBTableName());
                        psSysDBColumn.setDataType(iPSLiquibaseColumn.getType());
                        psSysDBColumn.setColDesc(iPSLiquibaseColumn.getRemarks());
                        psSysDBColumn.setAllowEmpty(Integer.valueOf(1));
                        if (iPSLiquibaseColumn.getPSLiquibaseConstraints() != null) {
                            if (DataObject.getBoolValue((Object)iPSLiquibaseColumn.getPSLiquibaseConstraints().isPrimaryKey(), (boolean)false)) {
                                psSysDBColumn.setPKey(Integer.valueOf(1));
                                psSysDBColumn.setAllowEmpty(Integer.valueOf(0));
                            } else if (!DataObject.getBoolValue((Object)iPSLiquibaseColumn.getPSLiquibaseConstraints().isNullable(), (boolean)true)) {
                                psSysDBColumn.setAllowEmpty(Integer.valueOf(0));
                            }
                        }
                        try {
                            if (!StringHelper.isNullOrEmpty((String)iPSLiquibaseColumn.getType())) {
                                String strType = iPSLiquibaseColumn.getType();
                                Integer nLength = null;
                                Integer nPrecision = null;
                                int nPos = strType.indexOf("(");
                                if (nPos != -1) {
                                    strType = strType.replace(")", "");
                                    strType = strType.replace("(", "|");
                                    String[] items = strType.split("[|]");
                                    strType = items[0];
                                    String strLength = items[1];
                                    if (!StringHelper.isNullOrEmpty((String)strLength)) {
                                        items = strLength.split("[,]");
                                        nLength = Integer.parseInt(items[0]);
                                        if (items.length == 2) {
                                            nPrecision = Integer.parseInt(items[1]);
                                        }
                                    }
                                    if (nLength != null && nLength < 0) {
                                        nLength = null;
                                    }
                                    if (nLength != null) {
                                        if (nPrecision != null && nPrecision < 0) {
                                            nPrecision = null;
                                        }
                                    } else {
                                        nPrecision = null;
                                    }
                                }
                                if (str2intMap.containsKey(strType.toUpperCase())) {
                                    int nStdDataType = str2intMap.get(strType.toUpperCase());
                                    psSysDBColumn.setStdDataType(Integer.valueOf(nStdDataType));
                                    psSysDBColumn.setLength(nLength);
                                    psSysDBColumn.setPrecision2(nPrecision);
                                }
                            }
                            psSysDBColumnService.create(psSysDBColumn);
                            psSysDBColumnList.add(psSysDBColumn);
                            sb.append(StringHelper.format((String)"\u5efa\u7acb\u6570\u636e\u8868[%1$s]\u5217[%2$s]\r\n", (Object)iPSLiquibaseCreateTable.getTableName(), (Object)iPSLiquibaseColumn.getName()));
                        }
                        catch (Exception ex) {
                            throw new Exception(String.format("\u5efa\u7acb\u6570\u636e\u8868[%1$s]\u5217[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", iPSLiquibaseCreateTable.getTableName(), iPSLiquibaseColumn.getName(), ex.getMessage()), ex);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}
