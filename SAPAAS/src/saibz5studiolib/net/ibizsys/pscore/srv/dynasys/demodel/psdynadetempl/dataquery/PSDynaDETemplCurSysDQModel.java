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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynadetempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6A8A9329-2B21-4E81-B685-369F740F9B51", name="CurSys")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDYNADETEMPLID`, t1.`PSDYNADETEMPLNAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`TEMPLPSDEID`, t1.`TEMPLPSDENAME`, t1.`TYPEPSDEFID`, t1.`TYPEPSDEFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSDYNADETEMPL` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDYNADETEMPLID", expression="t1.`PSDYNADETEMPLID`", showorder=3), @DEDataQueryCodeExp(name="PSDYNADETEMPLNAME", expression="t1.`PSDYNADETEMPLNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=6), @DEDataQueryCodeExp(name="TEMPLPSDEID", expression="t1.`TEMPLPSDEID`", showorder=7), @DEDataQueryCodeExp(name="TEMPLPSDENAME", expression="t1.`TEMPLPSDENAME`", showorder=8), @DEDataQueryCodeExp(name="TYPEPSDEFID", expression="t1.`TYPEPSDEFID`", showorder=9), @DEDataQueryCodeExp(name="TYPEPSDEFNAME", expression="t1.`TYPEPSDEFNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSYSTEMID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSDYNADETEMPL\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDYNADETEMPLID, t1.PSDYNADETEMPLNAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.TEMPLPSDEID, t1.TEMPLPSDENAME, t1.TYPEPSDEFID, t1.TYPEPSDEFNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSDYNADETEMPL t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDYNADETEMPLID", expression="t1.PSDYNADETEMPLID", showorder=3), @DEDataQueryCodeExp(name="PSDYNADETEMPLNAME", expression="t1.PSDYNADETEMPLNAME", showorder=4), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=6), @DEDataQueryCodeExp(name="TEMPLPSDEID", expression="t1.TEMPLPSDEID", showorder=7), @DEDataQueryCodeExp(name="TEMPLPSDENAME", expression="t1.TEMPLPSDENAME", showorder=8), @DEDataQueryCodeExp(name="TYPEPSDEFID", expression="t1.TYPEPSDEFID", showorder=9), @DEDataQueryCodeExp(name="TYPEPSDEFNAME", expression="t1.TYPEPSDEFNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSYSTEMID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSDYNADETEMPL\"}')} )")})})
public class PSDynaDETemplCurSysDQModel
extends DEDataQueryModelBase {
    public PSDynaDETemplCurSysDQModel() {
        this.initAnnotation(PSDynaDETemplCurSysDQModel.class);
    }
}

