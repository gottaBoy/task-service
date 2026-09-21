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
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelrtcfg.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="EE66CC39-C61F-4115-A644-A1DC3B90D78E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSDYNAINSTID`, t1.`PSMODELID`, t1.`PSMODELRTCFGID`, t1.`PSMODELRTCFGNAME`, t1.`PSMODELTYPE`, t1.`PSSYSTEMID`, t1.`RTMODELID`, t1.`RTMODELPATH`, t1.`RTTAG`, t1.`RTTAG2`, t1.`RTTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELRTCFG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="RTMODEL", expression="t1.`RTMODEL`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=4), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.`PSMODELID`", showorder=5), @DEDataQueryCodeExp(name="PSMODELRTCFGID", expression="t1.`PSMODELRTCFGID`", showorder=6), @DEDataQueryCodeExp(name="PSMODELRTCFGNAME", expression="t1.`PSMODELRTCFGNAME`", showorder=7), @DEDataQueryCodeExp(name="PSMODELTYPE", expression="t1.`PSMODELTYPE`", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=9), @DEDataQueryCodeExp(name="RTMODELID", expression="t1.`RTMODELID`", showorder=10), @DEDataQueryCodeExp(name="RTMODELPATH", expression="t1.`RTMODELPATH`", showorder=11), @DEDataQueryCodeExp(name="RTTAG", expression="t1.`RTTAG`", showorder=12), @DEDataQueryCodeExp(name="RTTAG2", expression="t1.`RTTAG2`", showorder=13), @DEDataQueryCodeExp(name="RTTYPE", expression="t1.`RTTYPE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSDYNAINSTID, t1.PSMODELID, t1.PSMODELRTCFGID, t1.PSMODELRTCFGNAME, t1.PSMODELTYPE, t1.PSSYSTEMID, t1.RTMODELID, t1.RTMODELPATH, t1.RTTAG, t1.RTTAG2, t1.RTTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELRTCFG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="RTMODEL", expression="t1.RTMODEL", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=4), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.PSMODELID", showorder=5), @DEDataQueryCodeExp(name="PSMODELRTCFGID", expression="t1.PSMODELRTCFGID", showorder=6), @DEDataQueryCodeExp(name="PSMODELRTCFGNAME", expression="t1.PSMODELRTCFGNAME", showorder=7), @DEDataQueryCodeExp(name="PSMODELTYPE", expression="t1.PSMODELTYPE", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=9), @DEDataQueryCodeExp(name="RTMODELID", expression="t1.RTMODELID", showorder=10), @DEDataQueryCodeExp(name="RTMODELPATH", expression="t1.RTMODELPATH", showorder=11), @DEDataQueryCodeExp(name="RTTAG", expression="t1.RTTAG", showorder=12), @DEDataQueryCodeExp(name="RTTAG2", expression="t1.RTTAG2", showorder=13), @DEDataQueryCodeExp(name="RTTYPE", expression="t1.RTTYPE", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16)}, conds={})})
public class PSModelRTCfgDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelRTCfgDefaultDQModel() {
        this.initAnnotation(PSModelRTCfgDefaultDQModel.class);
    }
}

