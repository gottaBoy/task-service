/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysoutypers.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="BA7BC829-5C00-4F2E-9FF7-469BF5FC288E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CPSSYSOUTYPEID`, t11.`PSSYSOUTYPENAME` AS `CPSSYSOUTYPENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ORDERVALUE`, t1.`PPSSYSOUTYPEID`, t21.`PSSYSOUTYPENAME` AS `PPSSYSOUTYPENAME`, t1.`PSSYSOUTYPERSID`, t1.`PSSYSOUTYPERSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSSYSOUTYPERS` t1  LEFT JOIN T_SRFPSSYSOUTYPE t11 ON t1.CPSSYSOUTYPEID = t11.PSSYSOUTYPEID  LEFT JOIN T_SRFPSSYSOUTYPE t21 ON t1.PPSSYSOUTYPEID = t21.PSSYSOUTYPEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CPSSYSOUTYPEID", expression="t1.`CPSSYSOUTYPEID`", showorder=0), @DEDataQueryCodeExp(name="CPSSYSOUTYPENAME", expression="t11.`PSSYSOUTYPENAME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=4), @DEDataQueryCodeExp(name="PPSSYSOUTYPEID", expression="t1.`PPSSYSOUTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PPSSYSOUTYPENAME", expression="t21.`PSSYSOUTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSOUTYPERSID", expression="t1.`PSSYSOUTYPERSID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSOUTYPERSNAME", expression="t1.`PSSYSOUTYPERSNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CPSSYSOUTYPEID, t11.PSSYSOUTYPENAME AS CPSSYSOUTYPENAME, t1.CREATEDATE, t1.CREATEMAN, t1.ORDERVALUE, t1.PPSSYSOUTYPEID, t21.PSSYSOUTYPENAME AS PPSSYSOUTYPENAME, t1.PSSYSOUTYPERSID, t1.PSSYSOUTYPERSNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSSYSOUTYPERS t1  LEFT JOIN T_SRFPSSYSOUTYPE t11 ON t1.CPSSYSOUTYPEID = t11.PSSYSOUTYPEID  LEFT JOIN T_SRFPSSYSOUTYPE t21 ON t1.PPSSYSOUTYPEID = t21.PSSYSOUTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CPSSYSOUTYPEID", expression="t1.CPSSYSOUTYPEID", showorder=0), @DEDataQueryCodeExp(name="CPSSYSOUTYPENAME", expression="t11.PSSYSOUTYPENAME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=4), @DEDataQueryCodeExp(name="PPSSYSOUTYPEID", expression="t1.PPSSYSOUTYPEID", showorder=5), @DEDataQueryCodeExp(name="PPSSYSOUTYPENAME", expression="t21.PSSYSOUTYPENAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSOUTYPERSID", expression="t1.PSSYSOUTYPERSID", showorder=7), @DEDataQueryCodeExp(name="PSSYSOUTYPERSNAME", expression="t1.PSSYSOUTYPERSNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=16)}, conds={})})
public class PSSysOUTypeRSDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysOUTypeRSDefaultDQModel() {
        this.initAnnotation(PSSysOUTypeRSDefaultDQModel.class);
    }
}

