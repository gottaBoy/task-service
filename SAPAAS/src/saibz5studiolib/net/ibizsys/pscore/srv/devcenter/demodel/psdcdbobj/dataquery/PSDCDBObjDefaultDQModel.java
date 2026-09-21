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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbobj.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3A70E782-6F11-494B-AABF-022101D25161", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DBOBJTYPE`, t1.`PSDCDBINSTID`, t11.`PSDEVCENTERDBINSTNAME` AS `PSDCDBINSTNAME`, t1.`PSDCDBOBJID`, t1.`PSDCDBOBJNAME`, t1.`PSDEVUSERID`, t1.`PSDEVUSERNAME`, t1.`SQL`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCDBOBJ` t1  LEFT JOIN T_SRFPSDEVCENTERDBINST t11 ON t1.PSDCDBINSTID = t11.PSDEVCENTERDBINSTID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="DBOBJCODE", expression="t1.`DBOBJCODE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DBOBJTYPE", expression="t1.`DBOBJTYPE`", showorder=2), @DEDataQueryCodeExp(name="PSDCDBINSTID", expression="t1.`PSDCDBINSTID`", showorder=3), @DEDataQueryCodeExp(name="PSDCDBINSTNAME", expression="t11.`PSDEVCENTERDBINSTNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDCDBOBJID", expression="t1.`PSDCDBOBJID`", showorder=5), @DEDataQueryCodeExp(name="PSDCDBOBJNAME", expression="t1.`PSDCDBOBJNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.`PSDEVUSERID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVUSERNAME", expression="t1.`PSDEVUSERNAME`", showorder=8), @DEDataQueryCodeExp(name="SQL", expression="t1.`SQL`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DBOBJTYPE, t1.PSDCDBINSTID, t11.PSDEVCENTERDBINSTNAME AS PSDCDBINSTNAME, t1.PSDCDBOBJID, t1.PSDCDBOBJNAME, t1.PSDEVUSERID, t1.PSDEVUSERNAME, t1.SQL, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCDBOBJ t1  LEFT JOIN T_SRFPSDEVCENTERDBINST t11 ON t1.PSDCDBINSTID = t11.PSDEVCENTERDBINSTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="DBOBJCODE", expression="t1.DBOBJCODE", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DBOBJTYPE", expression="t1.DBOBJTYPE", showorder=2), @DEDataQueryCodeExp(name="PSDCDBINSTID", expression="t1.PSDCDBINSTID", showorder=3), @DEDataQueryCodeExp(name="PSDCDBINSTNAME", expression="t11.PSDEVCENTERDBINSTNAME", showorder=4), @DEDataQueryCodeExp(name="PSDCDBOBJID", expression="t1.PSDCDBOBJID", showorder=5), @DEDataQueryCodeExp(name="PSDCDBOBJNAME", expression="t1.PSDCDBOBJNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.PSDEVUSERID", showorder=7), @DEDataQueryCodeExp(name="PSDEVUSERNAME", expression="t1.PSDEVUSERNAME", showorder=8), @DEDataQueryCodeExp(name="SQL", expression="t1.SQL", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSDCDBObjDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCDBObjDefaultDQModel() {
        this.initAnnotation(PSDCDBObjDefaultDQModel.class);
    }
}

