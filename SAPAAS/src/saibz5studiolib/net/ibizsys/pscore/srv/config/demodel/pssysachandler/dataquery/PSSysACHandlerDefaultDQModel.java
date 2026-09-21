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
package net.ibizsys.pscore.srv.config.demodel.pssysachandler.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9B58B7BB-64F8-4A06-B041-F84C0EE2CE5A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CTRLTYPE`, t1.`FUNCMODE`, t1.`JITCTRLOBJ`, t1.`JITCTRLOBJ2`, t1.`MEMO`, t1.`PSSYSACHANDLERID`, t1.`PSSYSACHANDLERNAME`, t1.`TEMPMODE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSACHANDLER` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CTRLTYPE", expression="t1.`CTRLTYPE`", showorder=2), @DEDataQueryCodeExp(name="FUNCMODE", expression="t1.`FUNCMODE`", showorder=3), @DEDataQueryCodeExp(name="JITCTRLOBJ", expression="t1.`JITCTRLOBJ`", showorder=4), @DEDataQueryCodeExp(name="JITCTRLOBJ2", expression="t1.`JITCTRLOBJ2`", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=6), @DEDataQueryCodeExp(name="PSSYSACHANDLERID", expression="t1.`PSSYSACHANDLERID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSACHANDLERNAME", expression="t1.`PSSYSACHANDLERNAME`", showorder=8), @DEDataQueryCodeExp(name="TEMPMODE", expression="t1.`TEMPMODE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CTRLTYPE, t1.FUNCMODE, t1.JITCTRLOBJ, t1.JITCTRLOBJ2, t1.MEMO, t1.PSSYSACHANDLERID, t1.PSSYSACHANDLERNAME, t1.TEMPMODE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSACHANDLER t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CTRLTYPE", expression="t1.CTRLTYPE", showorder=2), @DEDataQueryCodeExp(name="FUNCMODE", expression="t1.FUNCMODE", showorder=3), @DEDataQueryCodeExp(name="JITCTRLOBJ", expression="t1.JITCTRLOBJ", showorder=4), @DEDataQueryCodeExp(name="JITCTRLOBJ2", expression="t1.JITCTRLOBJ2", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=6), @DEDataQueryCodeExp(name="PSSYSACHANDLERID", expression="t1.PSSYSACHANDLERID", showorder=7), @DEDataQueryCodeExp(name="PSSYSACHANDLERNAME", expression="t1.PSSYSACHANDLERNAME", showorder=8), @DEDataQueryCodeExp(name="TEMPMODE", expression="t1.TEMPMODE", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSSysACHandlerDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysACHandlerDefaultDQModel() {
        this.initAnnotation(PSSysACHandlerDefaultDQModel.class);
    }
}

