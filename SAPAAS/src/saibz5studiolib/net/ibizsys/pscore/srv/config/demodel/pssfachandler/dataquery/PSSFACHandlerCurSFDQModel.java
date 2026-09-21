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
package net.ibizsys.pscore.srv.config.demodel.pssfachandler.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="262863D8-6C62-426B-A437-00F6BBD01C31", name="CurSF")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CTRLTYPE`, t1.`HANDLEROBJ`, t1.`HANDLEROBJ2`, t1.`HANDLEROBJ3`, t1.`HANDLEROBJ4`, t11.`JITCTRLOBJ`, t11.`JITCTRLOBJ2`, t1.`MEMO`, t1.`PSSFACHANDLERID`, t1.`PSSFACHANDLERNAME`, t1.`PSSFID`, t1.`PSSFNAME`, t1.`PSSYSACHANDLERID`, t11.`PSSYSACHANDLERNAME`, t1.`TEMPMODE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSFACHANDLER` t1  LEFT JOIN T_SRFPSSYSACHANDLER t11 ON t1.PSSYSACHANDLERID = t11.PSSYSACHANDLERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CTRLTYPE", expression="t1.`CTRLTYPE`", showorder=2), @DEDataQueryCodeExp(name="HANDLEROBJ", expression="t1.`HANDLEROBJ`", showorder=3), @DEDataQueryCodeExp(name="HANDLEROBJ2", expression="t1.`HANDLEROBJ2`", showorder=4), @DEDataQueryCodeExp(name="HANDLEROBJ3", expression="t1.`HANDLEROBJ3`", showorder=5), @DEDataQueryCodeExp(name="HANDLEROBJ4", expression="t1.`HANDLEROBJ4`", showorder=6), @DEDataQueryCodeExp(name="JITCTRLOBJ", expression="t11.`JITCTRLOBJ`", showorder=7), @DEDataQueryCodeExp(name="JITCTRLOBJ2", expression="t11.`JITCTRLOBJ2`", showorder=8), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=9), @DEDataQueryCodeExp(name="PSSFACHANDLERID", expression="t1.`PSSFACHANDLERID`", showorder=10), @DEDataQueryCodeExp(name="PSSFACHANDLERNAME", expression="t1.`PSSFACHANDLERNAME`", showorder=11), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=12), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.`PSSFNAME`", showorder=13), @DEDataQueryCodeExp(name="PSSYSACHANDLERID", expression="t1.`PSSYSACHANDLERID`", showorder=14), @DEDataQueryCodeExp(name="PSSYSACHANDLERNAME", expression="t11.`PSSYSACHANDLERNAME`", showorder=15), @DEDataQueryCodeExp(name="TEMPMODE", expression="t1.`TEMPMODE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=18)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSFID` =  ${srfdatacontext('pssfid','{\"defname\":\"PSSFID\",\"dename\":\"PSSFACHANDLER\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CTRLTYPE, t1.HANDLEROBJ, t1.HANDLEROBJ2, t1.HANDLEROBJ3, t1.HANDLEROBJ4, t11.JITCTRLOBJ, t11.JITCTRLOBJ2, t1.MEMO, t1.PSSFACHANDLERID, t1.PSSFACHANDLERNAME, t1.PSSFID, t1.PSSFNAME, t1.PSSYSACHANDLERID, t11.PSSYSACHANDLERNAME, t1.TEMPMODE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSFACHANDLER t1  LEFT JOIN T_SRFPSSYSACHANDLER t11 ON t1.PSSYSACHANDLERID = t11.PSSYSACHANDLERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CTRLTYPE", expression="t1.CTRLTYPE", showorder=2), @DEDataQueryCodeExp(name="HANDLEROBJ", expression="t1.HANDLEROBJ", showorder=3), @DEDataQueryCodeExp(name="HANDLEROBJ2", expression="t1.HANDLEROBJ2", showorder=4), @DEDataQueryCodeExp(name="HANDLEROBJ3", expression="t1.HANDLEROBJ3", showorder=5), @DEDataQueryCodeExp(name="HANDLEROBJ4", expression="t1.HANDLEROBJ4", showorder=6), @DEDataQueryCodeExp(name="JITCTRLOBJ", expression="t11.JITCTRLOBJ", showorder=7), @DEDataQueryCodeExp(name="JITCTRLOBJ2", expression="t11.JITCTRLOBJ2", showorder=8), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=9), @DEDataQueryCodeExp(name="PSSFACHANDLERID", expression="t1.PSSFACHANDLERID", showorder=10), @DEDataQueryCodeExp(name="PSSFACHANDLERNAME", expression="t1.PSSFACHANDLERNAME", showorder=11), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=12), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.PSSFNAME", showorder=13), @DEDataQueryCodeExp(name="PSSYSACHANDLERID", expression="t1.PSSYSACHANDLERID", showorder=14), @DEDataQueryCodeExp(name="PSSYSACHANDLERNAME", expression="t11.PSSYSACHANDLERNAME", showorder=15), @DEDataQueryCodeExp(name="TEMPMODE", expression="t1.TEMPMODE", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=18)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSFID =  ${srfdatacontext('pssfid','{\"defname\":\"PSSFID\",\"dename\":\"PSSFACHANDLER\"}')} )")})})
public class PSSFACHandlerCurSFDQModel
extends DEDataQueryModelBase {
    public PSSFACHandlerCurSFDQModel() {
        this.initAnnotation(PSSFACHandlerCurSFDQModel.class);
    }
}

