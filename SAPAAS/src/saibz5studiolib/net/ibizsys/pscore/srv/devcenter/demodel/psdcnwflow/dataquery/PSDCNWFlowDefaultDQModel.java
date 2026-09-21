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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcnwflow.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B60A84AF-9490-46EF-B11F-A75910FD5505", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ACTIONINFO`, t1.`ACTIONTYPE`, t1.`BEGINTIME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENDTIME`, t1.`FLOW`, t1.`PSDCNWFLOWID`, t1.`PSDCNWFLOWNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2` FROM `T_SRFPSDCNWFLOW` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ACTIONINFO", expression="t1.`ACTIONINFO`", showorder=0), @DEDataQueryCodeExp(name="ACTIONTYPE", expression="t1.`ACTIONTYPE`", showorder=1), @DEDataQueryCodeExp(name="BEGINTIME", expression="t1.`BEGINTIME`", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=4), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.`ENDTIME`", showorder=5), @DEDataQueryCodeExp(name="FLOW", expression="t1.`FLOW`", showorder=6), @DEDataQueryCodeExp(name="PSDCNWFLOWID", expression="t1.`PSDCNWFLOWID`", showorder=7), @DEDataQueryCodeExp(name="PSDCNWFLOWNAME", expression="t1.`PSDCNWFLOWNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ACTIONINFO, t1.ACTIONTYPE, t1.BEGINTIME, t1.CREATEDATE, t1.CREATEMAN, t1.ENDTIME, t1.FLOW, t1.PSDCNWFLOWID, t1.PSDCNWFLOWNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2 FROM T_SRFPSDCNWFLOW t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ACTIONINFO", expression="t1.ACTIONINFO", showorder=0), @DEDataQueryCodeExp(name="ACTIONTYPE", expression="t1.ACTIONTYPE", showorder=1), @DEDataQueryCodeExp(name="BEGINTIME", expression="t1.BEGINTIME", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=4), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.ENDTIME", showorder=5), @DEDataQueryCodeExp(name="FLOW", expression="t1.FLOW", showorder=6), @DEDataQueryCodeExp(name="PSDCNWFLOWID", expression="t1.PSDCNWFLOWID", showorder=7), @DEDataQueryCodeExp(name="PSDCNWFLOWNAME", expression="t1.PSDCNWFLOWNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=9), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=14)}, conds={})})
public class PSDCNWFlowDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCNWFlowDefaultDQModel() {
        this.initAnnotation(PSDCNWFlowDefaultDQModel.class);
    }
}

