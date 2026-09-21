/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import java.util.HashMap;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataRange;
import net.ibizsys.paas.core.IDEFDBValueFunc;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.db.ProcParamList;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DBDialectImpl
implements IDBDialect {
    private static final Log log = LogFactory.getLog(DBDialectImpl.class);
    private boolean bUnicodeChar = false;
    private HashMap<String, IDBFunction> dbFunctionMap = new HashMap();

    @Override
    public String getCountSQL(String strSQL) {
        return StringHelper.format("select count(*) as TOTALROW from (%1$s) m1", strSQL);
    }

    @Override
    public int getJDBCType(int dataType) {
        if (dataType == 1) {
            return -5;
        }
        if (dataType == 2) {
            return -2;
        }
        if (dataType == 3) {
            return -7;
        }
        if (dataType == 4 || dataType == 11 || dataType == 26) {
            return 1;
        }
        if (dataType == 28 || dataType == 5 || dataType == 16 || dataType == 22) {
            return 93;
        }
        if (dataType == 6 || dataType == 29 || dataType == 10 || dataType == 18) {
            return 3;
        }
        if (dataType == 7) {
            return 6;
        }
        if (dataType == 8) {
            return -4;
        }
        if (dataType == 9) {
            return 4;
        }
        if (dataType == 12 || dataType == 21) {
            return -1;
        }
        if (dataType == 14) {
            return 2;
        }
        if (dataType == 13 || dataType == 19 || dataType == 20 || dataType == 25) {
            return 12;
        }
        if (dataType == 15) {
            return 7;
        }
        if (dataType == 17) {
            return 5;
        }
        if (dataType == 23) {
            return -6;
        }
        if (dataType == 24) {
            return -3;
        }
        return 12;
    }

    @Override
    public String getTopRowSQL(String strSQL, int nTopCount) {
        return strSQL;
    }

    @Override
    public String getFuncSQL(String strFuncType, String[] args) throws Exception {
        return this.getFuncSQL(strFuncType, false, args);
    }

    @Override
    public String getFuncSQL(String strFuncType, boolean bInsert, String[] args) throws Exception {
        IDBFunction iDBFunction = this.dbFunctionMap.get(strFuncType.toUpperCase());
        if (iDBFunction != null) {
            return iDBFunction.getFuncSQL(bInsert, args);
        }
        if (StringHelper.compare(strFuncType, "INSTR", true) == 0) {
            if (args == null || args.length < 2) {
                throw new Exception(StringHelper.format("\u6570\u636e\u5e93\u51fd\u6570\u7c7b\u578b[%1$s]\u53c2\u6570\u4e0d\u6b63\u786e", strFuncType));
            }
            return StringHelper.format("INSTR(%1$s,%2$s)", args[0], args[1]);
        }
        if (StringHelper.compare(strFuncType, "VERSION", true) == 0) {
            if (bInsert) {
                return "1";
            }
            if (args == null || args.length != 1) {
                throw new Exception(StringHelper.format("\u6570\u636e\u5e93\u51fd\u6570\u7c7b\u578b[%1$s]\u53c2\u6570\u4e0d\u6b63\u786e", strFuncType));
            }
            return StringHelper.format("%1$s+1", args[0]);
        }
        if (StringHelper.compare(strFuncType, "MAX", true) == 0) {
            if (args == null || args.length != 1) {
                throw new Exception(StringHelper.format("\u6570\u636e\u5e93\u51fd\u6570\u7c7b\u578b[%1$s]\u53c2\u6570\u4e0d\u6b63\u786e", strFuncType));
            }
            return StringHelper.format("MAX(%1$s)", args[0]);
        }
        if (StringHelper.compare(strFuncType, "AVG", true) == 0) {
            if (args == null || args.length != 1) {
                throw new Exception(StringHelper.format("\u6570\u636e\u5e93\u51fd\u6570\u7c7b\u578b[%1$s]\u53c2\u6570\u4e0d\u6b63\u786e", strFuncType));
            }
            return StringHelper.format("AVG(%1$s)", args[0]);
        }
        if (StringHelper.compare(strFuncType, "MIN", true) == 0) {
            if (args == null || args.length != 1) {
                throw new Exception(StringHelper.format("\u6570\u636e\u5e93\u51fd\u6570\u7c7b\u578b[%1$s]\u53c2\u6570\u4e0d\u6b63\u786e", strFuncType));
            }
            return StringHelper.format("MIN(%1$s)", args[0]);
        }
        if (StringHelper.compare(strFuncType, "SUM", true) == 0) {
            if (args == null || args.length != 1) {
                throw new Exception(StringHelper.format("\u6570\u636e\u5e93\u51fd\u6570\u7c7b\u578b[%1$s]\u53c2\u6570\u4e0d\u6b63\u786e", strFuncType));
            }
            return StringHelper.format("SUM(%1$s)", args[0]);
        }
        if (StringHelper.compare(strFuncType, "COUNT", true) == 0) {
            return StringHelper.format("COUNT(1)");
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u5e93\u51fd\u6570[%1$s]", strFuncType));
    }

    @Override
    public String getOrgDRCond(UserRoleData userRoleData, Org curOrg, String strAlias) throws Exception {
        boolean bFirst = true;
        StringBuilderEx orgCondSb = new StringBuilderEx();
        long nOrgDR = 0L;
        if (userRoleData.getOrgDR() != null) {
            nOrgDR = userRoleData.getOrgDR().intValue();
        }
        if ((nOrgDR & 1L) > 0L) {
            if (bFirst) {
                bFirst = false;
            } else {
                orgCondSb.append(" OR ");
            }
            orgCondSb.append(" o1.ORGID = '%1$s' ", curOrg.getOrgId());
        }
        if ((nOrgDR & 2L) > 0L) {
            if (bFirst) {
                bFirst = false;
            } else {
                orgCondSb.append(" OR ");
            }
            orgCondSb.append(" %1$s = 1 ", this.getFuncSQL("INSTR", new String[]{StringHelper.format("'%1$s'", curOrg.getLevelCode()), "o1.LEVELCODE"}));
        }
        if ((nOrgDR & 4L) > 0L) {
            if (bFirst) {
                bFirst = false;
            } else {
                orgCondSb.append(" OR ");
            }
            orgCondSb.append(" %1$s = 1 ", this.getFuncSQL("INSTR", new String[]{"o1.LEVELCODE", StringHelper.format("'%1$s'", curOrg.getLevelCode())}));
        }
        return orgCondSb.toString();
    }

    @Override
    public String getOrgSecDRCond(UserRoleData userRoleData, OrgSector curOrgSector, String strAlias) throws Exception {
        boolean bFirst = true;
        StringBuilderEx orgSecCondSb = new StringBuilderEx();
        long nSecDR = 0L;
        if (userRoleData.getSecDR() != null) {
            nSecDR = userRoleData.getSecDR().intValue();
        }
        if ((nSecDR & 1L) > 0L) {
            if (bFirst) {
                bFirst = false;
            } else {
                orgSecCondSb.append(" OR ");
            }
            orgSecCondSb.append(" o2.ORGSECTORID = '%1$s' ", curOrgSector.getOrgSectorId());
        }
        if ((nSecDR & 2L) > 0L) {
            if (bFirst) {
                bFirst = false;
            } else {
                orgSecCondSb.append(" OR ");
            }
            orgSecCondSb.append(" %1$s = 1 ", this.getFuncSQL("INSTR", new String[]{StringHelper.format("'%1$s'", curOrgSector.getLevelCode()), "o2.LEVELCODE"}));
        }
        if ((nSecDR & 4L) > 0L) {
            if (bFirst) {
                bFirst = false;
            } else {
                orgSecCondSb.append(" OR ");
            }
            orgSecCondSb.append(" %1$s = 1 ", this.getFuncSQL("INSTR", new String[]{"o2.LEVELCODE", StringHelper.format("'%1$s'", curOrgSector.getLevelCode())}));
        }
        return orgSecCondSb.toString();
    }

    @Override
    public String getOrgDRCond(IDEDataRange iDEDDataRange, Org curOrg, String strAlias) throws Exception {
        boolean bFirst = true;
        StringBuilderEx orgCondSb = new StringBuilderEx();
        if ((iDEDDataRange.getOrgDR() & 1L) > 0L) {
            if (bFirst) {
                bFirst = false;
            } else {
                orgCondSb.append(" OR ");
            }
            orgCondSb.append(" o1.ORGID = '%1$s' ", curOrg.getOrgId());
        }
        if ((iDEDDataRange.getOrgDR() & 2L) > 0L) {
            if (bFirst) {
                bFirst = false;
            } else {
                orgCondSb.append(" OR ");
            }
            orgCondSb.append(" %1$s = 1 ", this.getFuncSQL("INSTR", new String[]{StringHelper.format("'%1$s'", curOrg.getLevelCode()), "o1.LEVELCODE"}));
        }
        if ((iDEDDataRange.getOrgDR() & 4L) > 0L) {
            if (bFirst) {
                bFirst = false;
            } else {
                orgCondSb.append(" OR ");
            }
            orgCondSb.append(" %1$s = 1 ", this.getFuncSQL("INSTR", new String[]{"o1.LEVELCODE", StringHelper.format("'%1$s'", curOrg.getLevelCode())}));
        }
        return orgCondSb.toString();
    }

    @Override
    public String getOrgSecDRCond(IDEDataRange iDEDDataRange, OrgSector curOrgSector, String strAlias) throws Exception {
        boolean bFirst = true;
        StringBuilderEx orgSecCondSb = new StringBuilderEx();
        if ((iDEDDataRange.getSecDR() & 1L) > 0L) {
            if (bFirst) {
                bFirst = false;
            } else {
                orgSecCondSb.append(" OR ");
            }
            orgSecCondSb.append(" o2.ORGSECTORID = '%1$s' ", curOrgSector.getOrgSectorId());
        }
        if ((iDEDDataRange.getSecDR() & 2L) > 0L) {
            if (bFirst) {
                bFirst = false;
            } else {
                orgSecCondSb.append(" OR ");
            }
            orgSecCondSb.append(" %1$s = 1 ", this.getFuncSQL("INSTR", new String[]{StringHelper.format("'%1$s'", curOrgSector.getLevelCode()), "o2.LEVELCODE"}));
        }
        if ((iDEDDataRange.getSecDR() & 4L) > 0L) {
            if (bFirst) {
                bFirst = false;
            } else {
                orgSecCondSb.append(" OR ");
            }
            orgSecCondSb.append(" %1$s = 1 ", this.getFuncSQL("INSTR", new String[]{"o2.LEVELCODE", StringHelper.format("'%1$s'", curOrgSector.getLevelCode())}));
        }
        return orgSecCondSb.toString();
    }

    public boolean isUnicodeChar() {
        return this.bUnicodeChar;
    }

    public void setUnicodeChar(boolean bUnicodeChar) {
        this.bUnicodeChar = bUnicodeChar;
    }

    @Override
    public String getDBObjStandardName(String strOriginName) {
        return strOriginName;
    }

    @Override
    public String getMergeSQL(IDataEntity iDataEntity, ProcParamList procParamList) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public DBCallResult callSqlBatch(Connection connection, String[] commands, SqlParamList[] lists, int nBatchSize, int nTimeOut) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IDBFunction getDBFunction(String strFuncType) throws Exception {
        IDBFunction iDBFunction = this.dbFunctionMap.get(strFuncType);
        if (iDBFunction != null) {
            return iDBFunction;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u5e93\u51fd\u6570[%1$s]", strFuncType));
    }

    protected void registerDBFunction(IDBFunction iDBFunction) {
        this.dbFunctionMap.put(iDBFunction.getName().toUpperCase(), iDBFunction);
    }

    @Override
    public String getDEFieldValueSQL(IDEField iDEField, IEntity iEntity, boolean bInsert, boolean bTempMode) throws Exception {
        if (bInsert) {
            if (iDEField.isEnableDBAutoValue()) {
                if (iDEField.isEnableDBValueInsertUpdateMode() && !StringHelper.isNullOrEmpty(iDEField.getDBValueInsertMode())) {
                    if (StringHelper.compare(iDEField.getDBValueInsertMode(), "IGNORE", true) == 0) {
                        return null;
                    }
                    if (StringHelper.compare(iDEField.getDBValueInsertMode(), "VALUEFUNC", true) == 0) {
                        IDEFDBValueFunc iDEFDBValueFunc = iDEField.getDEFDBValueFunc(this.getDBType(), true);
                        return StringHelper.format(iDEFDBValueFunc.getCodeFormat(), iDEFDBValueFunc.getFields());
                    }
                    return this.getFuncSQL(iDEField.getDBValueInsertMode(), true, new String[]{iDEField.getName()});
                }
                return "NULL";
            }
            if (iDEField.isEnableDBValueInsertUpdateMode()) {
                if (!StringHelper.isNullOrEmpty(iDEField.getDBValueInsertMode())) {
                    if (StringHelper.compare(iDEField.getDBValueInsertMode(), "IGNORE", true) == 0) {
                        return null;
                    }
                    if (StringHelper.compare(iDEField.getDBValueInsertMode(), "VALUEFUNC", true) == 0) {
                        IDEFDBValueFunc iDEFDBValueFunc = iDEField.getDEFDBValueFunc(this.getDBType(), true);
                        return StringHelper.format(iDEFDBValueFunc.getCodeFormat(), iDEFDBValueFunc.getFields());
                    }
                    return this.getFuncSQL(iDEField.getDBValueInsertMode(), true, new String[]{iDEField.getName()});
                }
            } else if (!StringHelper.isNullOrEmpty(iDEField.getDBValueFunc())) {
                return this.getFuncSQL(iDEField.getDBValueFunc(), true, new String[]{iDEField.getName()});
            }
        } else if (iDEField.isEnableDBValueInsertUpdateMode()) {
            if (!StringHelper.isNullOrEmpty(iDEField.getDBValueUpdateMode())) {
                if (StringHelper.compare(iDEField.getDBValueUpdateMode(), "IGNORE", true) == 0) {
                    return null;
                }
                if (StringHelper.compare(iDEField.getDBValueUpdateMode(), "VALUEFUNC", true) == 0) {
                    IDEFDBValueFunc iDEFDBValueFunc = iDEField.getDEFDBValueFunc(this.getDBType(), false);
                    return StringHelper.format(iDEFDBValueFunc.getCodeFormat(), iDEFDBValueFunc.getFields());
                }
                return this.getFuncSQL(iDEField.getDBValueUpdateMode(), false, new String[]{iDEField.getName()});
            }
        } else if (!StringHelper.isNullOrEmpty(iDEField.getDBValueFunc())) {
            return this.getFuncSQL(iDEField.getDBValueFunc(), false, new String[]{iDEField.getName()});
        }
        return null;
    }

    @Override
    public DBCallResult getLastInsertId(Connection connection) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u83b7\u53d6\u6700\u540e\u63d2\u5165\u7684\u6807\u8bc6\u529f\u80fd");
    }

    @Override
    public String getPagingSQL(String strSQL, int nStartPos, int nPageSize, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection, IDEDataQueryCode iDEDataQueryCode) {
        return this.getPagingSQL(strSQL, nStartPos, nPageSize, strMajor, strMajorDirection, strMinor, strMinorDirection);
    }
}

