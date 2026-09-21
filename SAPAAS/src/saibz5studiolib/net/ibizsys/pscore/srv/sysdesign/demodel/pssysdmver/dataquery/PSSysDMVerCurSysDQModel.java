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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdmver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6668035A-1727-4F5A-83A8-371815666AF4", name="CurSys")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ACTIVEFLAG`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DMVER`, t1.`MEMO`, t1.`PSSYSDMVERID`, t1.`PSSYSDMVERNAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSSYSDMVER` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ACTIVEFLAG", expression="t1.`ACTIVEFLAG`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DMVER", expression="t1.`DMVER`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSSYSDMVERID", expression="t1.`PSSYSDMVERID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSDMVERNAME", expression="t1.`PSSYSDMVERNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSYSTEMID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSDMVER\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.ACTIVEFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.DMVER, t1.MEMO, t1.PSSYSDMVERID, t1.PSSYSDMVERNAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSSYSDMVER t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ACTIVEFLAG", expression="t1.ACTIVEFLAG", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DMVER", expression="t1.DMVER", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSSYSDMVERID", expression="t1.PSSYSDMVERID", showorder=5), @DEDataQueryCodeExp(name="PSSYSDMVERNAME", expression="t1.PSSYSDMVERNAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSYSTEMID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSDMVER\"}')} )")})})
public class PSSysDMVerCurSysDQModel
extends DEDataQueryModelBase {
    public PSSysDMVerCurSysDQModel() {
        this.initAnnotation(PSSysDMVerCurSysDQModel.class);
    }
}

