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
package net.ibizsys.pscore.srv.config.demodel.psmodelhotcode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="EDB018AE-E270-4242-AE46-F922D6462EA2", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`EVENTTYPE`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSMODELHOTCODEID`, t1.`PSMODELHOTCODENAME`, t1.`PSMODELID`, t1.`PSMODELNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSMODELHOTCODE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="JSCODE", expression="t1.`JSCODE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="EVENTTYPE", expression="t1.`EVENTTYPE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=4), @DEDataQueryCodeExp(name="PSMODELHOTCODEID", expression="t1.`PSMODELHOTCODEID`", showorder=5), @DEDataQueryCodeExp(name="PSMODELHOTCODENAME", expression="t1.`PSMODELHOTCODENAME`", showorder=6), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.`PSMODELID`", showorder=7), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t1.`PSMODELNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.EVENTTYPE, t1.MEMO, t1.ORDERVALUE, t1.PSMODELHOTCODEID, t1.PSMODELHOTCODENAME, t1.PSMODELID, t1.PSMODELNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSMODELHOTCODE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="JSCODE", expression="t1.JSCODE", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="EVENTTYPE", expression="t1.EVENTTYPE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=4), @DEDataQueryCodeExp(name="PSMODELHOTCODEID", expression="t1.PSMODELHOTCODEID", showorder=5), @DEDataQueryCodeExp(name="PSMODELHOTCODENAME", expression="t1.PSMODELHOTCODENAME", showorder=6), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.PSMODELID", showorder=7), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t1.PSMODELNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={})})
public class PSModelHotCodeDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelHotCodeDefaultDQModel() {
        this.initAnnotation(PSModelHotCodeDefaultDQModel.class);
    }
}

