/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevuserrecent.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F44B14AA-0A99-4139-99EA-3C313E1E7E81", name="CurUserDE")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`OBJID`, t1.`OBJNAME`, t1.`OBJTYPE`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSDEVUSERID`, t1.`PSDEVUSERNAME`, t1.`PSDEVUSERRECENTID`, t1.`PSDEVUSERRECENTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVUSERRECENT` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="OBJID", expression="t1.`OBJID`", showorder=2), @DEDataQueryCodeExp(name="OBJNAME", expression="t1.`OBJNAME`", showorder=3), @DEDataQueryCodeExp(name="OBJTYPE", expression="t1.`OBJTYPE`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.`PSDEVUSERID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVUSERNAME", expression="t1.`PSDEVUSERNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVUSERRECENTID", expression="t1.`PSDEVUSERRECENTID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVUSERRECENTNAME", expression="t1.`PSDEVUSERRECENTNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEVUSERID` =  ${srfsessioncontext('SRFPERSONID','{\"defname\":\"PSDEVUSERID\",\"dename\":\"PSDEVUSERRECENT\"}')}  AND  t1.`OBJTYPE` = 'PSDATAENTITY' )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.OBJID, t1.OBJNAME, t1.OBJTYPE, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSDEVUSERID, t1.PSDEVUSERNAME, t1.PSDEVUSERRECENTID, t1.PSDEVUSERRECENTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVUSERRECENT t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="OBJID", expression="t1.OBJID", showorder=2), @DEDataQueryCodeExp(name="OBJNAME", expression="t1.OBJNAME", showorder=3), @DEDataQueryCodeExp(name="OBJTYPE", expression="t1.OBJTYPE", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.PSDEVUSERID", showorder=7), @DEDataQueryCodeExp(name="PSDEVUSERNAME", expression="t1.PSDEVUSERNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVUSERRECENTID", expression="t1.PSDEVUSERRECENTID", showorder=9), @DEDataQueryCodeExp(name="PSDEVUSERRECENTNAME", expression="t1.PSDEVUSERRECENTNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEVUSERID =  ${srfsessioncontext('SRFPERSONID','{\"defname\":\"PSDEVUSERID\",\"dename\":\"PSDEVUSERRECENT\"}')}  AND  t1.OBJTYPE = 'PSDATAENTITY' )")})})
public class PSDevUserRecentCurUserDEDQModel
extends DEDataQueryModelBase {
    public PSDevUserRecentCurUserDEDQModel() {
        this.initAnnotation(PSDevUserRecentCurUserDEDQModel.class);
    }
}

