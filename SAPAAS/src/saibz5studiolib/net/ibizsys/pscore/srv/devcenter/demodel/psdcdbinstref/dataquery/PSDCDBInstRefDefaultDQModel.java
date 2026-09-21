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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbinstref.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="53C8A5D1-D5ED-40DC-BECB-C9B28E9609C7", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDCDBINSTREFID`, t1.`PSDCDBINSTREFNAME`, t1.`PSDEVCENTERDBINSTID`, t1.`PSDEVCENTERDBINSTNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`REFOBJID`, t1.`REFOBJNAME`, t1.`REFOBJTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCDBINSTREF` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDCDBINSTREFID", expression="t1.`PSDCDBINSTREFID`", showorder=2), @DEDataQueryCodeExp(name="PSDCDBINSTREFNAME", expression="t1.`PSDCDBINSTREFNAME`", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERDBINSTID", expression="t1.`PSDEVCENTERDBINSTID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERDBINSTNAME", expression="t1.`PSDEVCENTERDBINSTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=7), @DEDataQueryCodeExp(name="REFOBJID", expression="t1.`REFOBJID`", showorder=8), @DEDataQueryCodeExp(name="REFOBJNAME", expression="t1.`REFOBJNAME`", showorder=9), @DEDataQueryCodeExp(name="REFOBJTYPE", expression="t1.`REFOBJTYPE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDCDBINSTREFID, t1.PSDCDBINSTREFNAME, t1.PSDEVCENTERDBINSTID, t1.PSDEVCENTERDBINSTNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.REFOBJID, t1.REFOBJNAME, t1.REFOBJTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCDBINSTREF t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDCDBINSTREFID", expression="t1.PSDCDBINSTREFID", showorder=2), @DEDataQueryCodeExp(name="PSDCDBINSTREFNAME", expression="t1.PSDCDBINSTREFNAME", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERDBINSTID", expression="t1.PSDEVCENTERDBINSTID", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERDBINSTNAME", expression="t1.PSDEVCENTERDBINSTNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=7), @DEDataQueryCodeExp(name="REFOBJID", expression="t1.REFOBJID", showorder=8), @DEDataQueryCodeExp(name="REFOBJNAME", expression="t1.REFOBJNAME", showorder=9), @DEDataQueryCodeExp(name="REFOBJTYPE", expression="t1.REFOBJTYPE", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDCDBInstRefDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCDBInstRefDefaultDQModel() {
        this.initAnnotation(PSDCDBInstRefDefaultDQModel.class);
    }
}

