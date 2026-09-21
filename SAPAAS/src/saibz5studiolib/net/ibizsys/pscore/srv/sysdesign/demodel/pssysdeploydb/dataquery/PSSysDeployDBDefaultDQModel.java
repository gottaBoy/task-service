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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeploydb.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C35FA72E-682F-4FBE-B1F2-5881248C9FEE", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONNSTR`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DBNAME`, t1.`DBTYPE`, t1.`MEMO`, t1.`PASSWD`, t1.`PSDEVCENTERDBINSTID`, t11.`PSDEVCENTERDBINSTNAME`, t1.`PSSYSDEPLOYDBID`, t1.`PSSYSDEPLOYDBNAME`, t1.`PSSYSDEPLOYID`, t21.`PSSYSDEPLOYNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERNAME`, t1.`USERPARAMS` FROM `T_SRFPSSYSDEPLOYDB` t1  LEFT JOIN `T_SRFPSDEVCENTERDBINST` t11 ON t1.`PSDEVCENTERDBINSTID` = t11.`PSDEVCENTERDBINSTID`  LEFT JOIN `T_SRFPSSYSDEPLOY` t21 ON t1.`PSSYSDEPLOYID` = t21.`PSSYSDEPLOYID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONNSTR", expression="t1.`CONNSTR`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DBNAME", expression="t1.`DBNAME`", showorder=3), @DEDataQueryCodeExp(name="DBTYPE", expression="t1.`DBTYPE`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PASSWD", expression="t1.`PASSWD`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERDBINSTID", expression="t1.`PSDEVCENTERDBINSTID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERDBINSTNAME", expression="t11.`PSDEVCENTERDBINSTNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSYSDEPLOYDBID", expression="t1.`PSSYSDEPLOYDBID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSDEPLOYDBNAME", expression="t1.`PSSYSDEPLOYDBNAME`", showorder=10), @DEDataQueryCodeExp(name="PSSYSDEPLOYID", expression="t1.`PSSYSDEPLOYID`", showorder=11), @DEDataQueryCodeExp(name="PSSYSDEPLOYNAME", expression="t21.`PSSYSDEPLOYNAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="USERNAME", expression="t1.`USERNAME`", showorder=15), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.`USERPARAMS`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONNSTR, t1.CREATEDATE, t1.CREATEMAN, t1.DBNAME, t1.DBTYPE, t1.MEMO, t1.PASSWD, t1.PSDEVCENTERDBINSTID, t11.PSDEVCENTERDBINSTNAME, t1.PSSYSDEPLOYDBID, t1.PSSYSDEPLOYDBNAME, t1.PSSYSDEPLOYID, t21.PSSYSDEPLOYNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERNAME, t1.USERPARAMS FROM T_SRFPSSYSDEPLOYDB t1  LEFT JOIN T_SRFPSDEVCENTERDBINST t11 ON t1.PSDEVCENTERDBINSTID = t11.PSDEVCENTERDBINSTID  LEFT JOIN T_SRFPSSYSDEPLOY t21 ON t1.PSSYSDEPLOYID = t21.PSSYSDEPLOYID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONNSTR", expression="t1.CONNSTR", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DBNAME", expression="t1.DBNAME", showorder=3), @DEDataQueryCodeExp(name="DBTYPE", expression="t1.DBTYPE", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PASSWD", expression="t1.PASSWD", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERDBINSTID", expression="t1.PSDEVCENTERDBINSTID", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERDBINSTNAME", expression="t11.PSDEVCENTERDBINSTNAME", showorder=8), @DEDataQueryCodeExp(name="PSSYSDEPLOYDBID", expression="t1.PSSYSDEPLOYDBID", showorder=9), @DEDataQueryCodeExp(name="PSSYSDEPLOYDBNAME", expression="t1.PSSYSDEPLOYDBNAME", showorder=10), @DEDataQueryCodeExp(name="PSSYSDEPLOYID", expression="t1.PSSYSDEPLOYID", showorder=11), @DEDataQueryCodeExp(name="PSSYSDEPLOYNAME", expression="t21.PSSYSDEPLOYNAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="USERNAME", expression="t1.USERNAME", showorder=15), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.USERPARAMS", showorder=16)}, conds={})})
public class PSSysDeployDBDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysDeployDBDefaultDQModel() {
        this.initAnnotation(PSSysDeployDBDefaultDQModel.class);
    }
}

