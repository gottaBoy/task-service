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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwdemainstate.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="38921567-FE28-4146-B9BD-0A93D64461FF", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEID`, t1.`PSDYNAINSTID`, t1.`PSUWDEMAINSTATEID`, t1.`PSUWDEMAINSTATENAME`, t1.`STATE2PSDEFID`, t1.`STATE2PSDEFNAME`, t1.`STATE3PSDEFID`, t1.`STATE3PSDEFNAME`, t1.`STATEPSDEFID`, t1.`STATEPSDEFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSUWDEMAINSTATE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=2), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=3), @DEDataQueryCodeExp(name="PSUWDEMAINSTATEID", expression="t1.`PSUWDEMAINSTATEID`", showorder=4), @DEDataQueryCodeExp(name="PSUWDEMAINSTATENAME", expression="t1.`PSUWDEMAINSTATENAME`", showorder=5), @DEDataQueryCodeExp(name="STATE2PSDEFID", expression="t1.`STATE2PSDEFID`", showorder=6), @DEDataQueryCodeExp(name="STATE2PSDEFNAME", expression="t1.`STATE2PSDEFNAME`", showorder=7), @DEDataQueryCodeExp(name="STATE3PSDEFID", expression="t1.`STATE3PSDEFID`", showorder=8), @DEDataQueryCodeExp(name="STATE3PSDEFNAME", expression="t1.`STATE3PSDEFNAME`", showorder=9), @DEDataQueryCodeExp(name="STATEPSDEFID", expression="t1.`STATEPSDEFID`", showorder=10), @DEDataQueryCodeExp(name="STATEPSDEFNAME", expression="t1.`STATEPSDEFNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEID, t1.PSDYNAINSTID, t1.PSUWDEMAINSTATEID, t1.PSUWDEMAINSTATENAME, t1.STATE2PSDEFID, t1.STATE2PSDEFNAME, t1.STATE3PSDEFID, t1.STATE3PSDEFNAME, t1.STATEPSDEFID, t1.STATEPSDEFNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSUWDEMAINSTATE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=2), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=3), @DEDataQueryCodeExp(name="PSUWDEMAINSTATEID", expression="t1.PSUWDEMAINSTATEID", showorder=4), @DEDataQueryCodeExp(name="PSUWDEMAINSTATENAME", expression="t1.PSUWDEMAINSTATENAME", showorder=5), @DEDataQueryCodeExp(name="STATE2PSDEFID", expression="t1.STATE2PSDEFID", showorder=6), @DEDataQueryCodeExp(name="STATE2PSDEFNAME", expression="t1.STATE2PSDEFNAME", showorder=7), @DEDataQueryCodeExp(name="STATE3PSDEFID", expression="t1.STATE3PSDEFID", showorder=8), @DEDataQueryCodeExp(name="STATE3PSDEFNAME", expression="t1.STATE3PSDEFNAME", showorder=9), @DEDataQueryCodeExp(name="STATEPSDEFID", expression="t1.STATEPSDEFID", showorder=10), @DEDataQueryCodeExp(name="STATEPSDEFNAME", expression="t1.STATEPSDEFNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSUWDEMainStateDefaultDQModel
extends DEDataQueryModelBase {
    public PSUWDEMainStateDefaultDQModel() {
        this.initAnnotation(PSUWDEMainStateDefaultDQModel.class);
    }
}

