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
package net.ibizsys.pscore.srv.config.demodel.pssfstylelog.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="81415D9C-2BDF-4B12-AF92-2874E15755D6", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSSFSTYLEID`, t1.`PSSFSTYLELOGID`, t1.`PSSFSTYLELOGNAME`, t1.`PSSFSTYLENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSFSTYLELOG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CHANGELOG", expression="t1.`CHANGELOG`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.`PSSFSTYLEID`", showorder=2), @DEDataQueryCodeExp(name="PSSFSTYLELOGID", expression="t1.`PSSFSTYLELOGID`", showorder=3), @DEDataQueryCodeExp(name="PSSFSTYLELOGNAME", expression="t1.`PSSFSTYLELOGNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t1.`PSSFSTYLENAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSSFSTYLEID, t1.PSSFSTYLELOGID, t1.PSSFSTYLELOGNAME, t1.PSSFSTYLENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSFSTYLELOG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CHANGELOG", expression="t1.CHANGELOG", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.PSSFSTYLEID", showorder=2), @DEDataQueryCodeExp(name="PSSFSTYLELOGID", expression="t1.PSSFSTYLELOGID", showorder=3), @DEDataQueryCodeExp(name="PSSFSTYLELOGNAME", expression="t1.PSSFSTYLELOGNAME", showorder=4), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t1.PSSFSTYLENAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSSFStyleLogDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFStyleLogDefaultDQModel() {
        this.initAnnotation(PSSFStyleLogDefaultDQModel.class);
    }
}

