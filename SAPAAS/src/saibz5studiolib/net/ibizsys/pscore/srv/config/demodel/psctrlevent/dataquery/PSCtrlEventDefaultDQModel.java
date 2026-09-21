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
package net.ibizsys.pscore.srv.config.demodel.psctrlevent.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="FD493899-0027-4F3A-A7ED-E0CBA215EDFD", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CTRLCODENAMEFMT`, t1.`EVENTARG`, t1.`EVENTARG2`, t1.`EVENTARG3`, t1.`EVENTARG4`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PSCTRLEVENTID`, t1.`PSCTRLEVENTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VIEWCODENAMEFMT` FROM `T_SRFPSCTRLEVENT` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="CTRLCODENAMEFMT", expression="t1.`CTRLCODENAMEFMT`", showorder=3), @DEDataQueryCodeExp(name="EVENTARG", expression="t1.`EVENTARG`", showorder=4), @DEDataQueryCodeExp(name="EVENTARG2", expression="t1.`EVENTARG2`", showorder=5), @DEDataQueryCodeExp(name="EVENTARG3", expression="t1.`EVENTARG3`", showorder=6), @DEDataQueryCodeExp(name="EVENTARG4", expression="t1.`EVENTARG4`", showorder=7), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=8), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=9), @DEDataQueryCodeExp(name="PSCTRLEVENTID", expression="t1.`PSCTRLEVENTID`", showorder=10), @DEDataQueryCodeExp(name="PSCTRLEVENTNAME", expression="t1.`PSCTRLEVENTNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="VIEWCODENAMEFMT", expression="t1.`VIEWCODENAMEFMT`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.CTRLCODENAMEFMT, t1.EVENTARG, t1.EVENTARG2, t1.EVENTARG3, t1.EVENTARG4, t1.LOGICNAME, t1.MEMO, t1.PSCTRLEVENTID, t1.PSCTRLEVENTNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VIEWCODENAMEFMT FROM T_SRFPSCTRLEVENT t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="CTRLCODENAMEFMT", expression="t1.CTRLCODENAMEFMT", showorder=3), @DEDataQueryCodeExp(name="EVENTARG", expression="t1.EVENTARG", showorder=4), @DEDataQueryCodeExp(name="EVENTARG2", expression="t1.EVENTARG2", showorder=5), @DEDataQueryCodeExp(name="EVENTARG3", expression="t1.EVENTARG3", showorder=6), @DEDataQueryCodeExp(name="EVENTARG4", expression="t1.EVENTARG4", showorder=7), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=8), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=9), @DEDataQueryCodeExp(name="PSCTRLEVENTID", expression="t1.PSCTRLEVENTID", showorder=10), @DEDataQueryCodeExp(name="PSCTRLEVENTNAME", expression="t1.PSCTRLEVENTNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="VIEWCODENAMEFMT", expression="t1.VIEWCODENAMEFMT", showorder=14)}, conds={})})
public class PSCtrlEventDefaultDQModel
extends DEDataQueryModelBase {
    public PSCtrlEventDefaultDQModel() {
        this.initAnnotation(PSCtrlEventDefaultDQModel.class);
    }
}

