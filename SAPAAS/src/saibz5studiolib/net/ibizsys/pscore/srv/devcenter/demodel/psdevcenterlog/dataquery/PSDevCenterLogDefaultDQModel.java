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
package net.ibizsys.pscore.srv.devcenter.demodel.psdevcenterlog.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3C9F0D20-46F4-4E89-8441-EBA26CC7AB1C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGINFO`, t1.`LOGLEVEL`, t1.`LOGLEVEL2`, t1.`LOGTYPE`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERLOGID`, t1.`PSDEVCENTERLOGNAME`, t1.`PSDEVCENTERNAME`, t1.`REMOTEADDR`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVCENTERLOG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="LOGINFO2", expression="t1.`LOGINFO2`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGINFO", expression="t1.`LOGINFO`", showorder=2), @DEDataQueryCodeExp(name="LOGLEVEL", expression="t1.`LOGLEVEL`", showorder=3), @DEDataQueryCodeExp(name="LOGLEVEL2", expression="t1.`LOGLEVEL2`", showorder=4), @DEDataQueryCodeExp(name="LOGTYPE", expression="t1.`LOGTYPE`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERLOGID", expression="t1.`PSDEVCENTERLOGID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERLOGNAME", expression="t1.`PSDEVCENTERLOGNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=9), @DEDataQueryCodeExp(name="REMOTEADDR", expression="t1.`REMOTEADDR`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGINFO, t1.LOGLEVEL, t1.LOGLEVEL2, t1.LOGTYPE, t1.PSDEVCENTERID, t1.PSDEVCENTERLOGID, t1.PSDEVCENTERLOGNAME, t1.PSDEVCENTERNAME, t1.REMOTEADDR, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVCENTERLOG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="LOGINFO2", expression="t1.LOGINFO2", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGINFO", expression="t1.LOGINFO", showorder=2), @DEDataQueryCodeExp(name="LOGLEVEL", expression="t1.LOGLEVEL", showorder=3), @DEDataQueryCodeExp(name="LOGLEVEL2", expression="t1.LOGLEVEL2", showorder=4), @DEDataQueryCodeExp(name="LOGTYPE", expression="t1.LOGTYPE", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERLOGID", expression="t1.PSDEVCENTERLOGID", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERLOGNAME", expression="t1.PSDEVCENTERLOGNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=9), @DEDataQueryCodeExp(name="REMOTEADDR", expression="t1.REMOTEADDR", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDevCenterLogDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevCenterLogDefaultDQModel() {
        this.initAnnotation(PSDevCenterLogDefaultDQModel.class);
    }
}

