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
package net.ibizsys.pscore.srv.config.demodel.psviewlogictypeparam.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="CF334EE8-46AE-4E4C-8FEC-0D68693C4B3E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENABLESUBKEY`, t1.`MAXCOUNT`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PARAMCAT`, t1.`PARAMDESC`, t1.`PARAMTYPE`, t1.`PARAMVALUE`, t1.`PARAMVALUE2`, t1.`PSVIEWLOGICTYPEID`, t1.`PSVIEWLOGICTYPENAME`, t1.`PSVIEWLOGICTYPEPARAMID`, t1.`PSVIEWLOGICTYPEPARAMNAME`, t1.`REFOBJSCOPE`, t1.`REFOBJTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSVIEWLOGICTYPEPARAM` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ENABLESUBKEY", expression="t1.`ENABLESUBKEY`", showorder=2), @DEDataQueryCodeExp(name="MAXCOUNT", expression="t1.`MAXCOUNT`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=5), @DEDataQueryCodeExp(name="PARAMCAT", expression="t1.`PARAMCAT`", showorder=6), @DEDataQueryCodeExp(name="PARAMDESC", expression="t1.`PARAMDESC`", showorder=7), @DEDataQueryCodeExp(name="PARAMTYPE", expression="t1.`PARAMTYPE`", showorder=8), @DEDataQueryCodeExp(name="PARAMVALUE", expression="t1.`PARAMVALUE`", showorder=9), @DEDataQueryCodeExp(name="PARAMVALUE2", expression="t1.`PARAMVALUE2`", showorder=10), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPEID", expression="t1.`PSVIEWLOGICTYPEID`", showorder=11), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPENAME", expression="t1.`PSVIEWLOGICTYPENAME`", showorder=12), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPEPARAMID", expression="t1.`PSVIEWLOGICTYPEPARAMID`", showorder=13), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPEPARAMNAME", expression="t1.`PSVIEWLOGICTYPEPARAMNAME`", showorder=14), @DEDataQueryCodeExp(name="REFOBJSCOPE", expression="t1.`REFOBJSCOPE`", showorder=15), @DEDataQueryCodeExp(name="REFOBJTYPE", expression="t1.`REFOBJTYPE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLESUBKEY, t1.MAXCOUNT, t1.MEMO, t1.ORDERVALUE, t1.PARAMCAT, t1.PARAMDESC, t1.PARAMTYPE, t1.PARAMVALUE, t1.PARAMVALUE2, t1.PSVIEWLOGICTYPEID, t1.PSVIEWLOGICTYPENAME, t1.PSVIEWLOGICTYPEPARAMID, t1.PSVIEWLOGICTYPEPARAMNAME, t1.REFOBJSCOPE, t1.REFOBJTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSVIEWLOGICTYPEPARAM t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ENABLESUBKEY", expression="t1.ENABLESUBKEY", showorder=2), @DEDataQueryCodeExp(name="MAXCOUNT", expression="t1.MAXCOUNT", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=5), @DEDataQueryCodeExp(name="PARAMCAT", expression="t1.PARAMCAT", showorder=6), @DEDataQueryCodeExp(name="PARAMDESC", expression="t1.PARAMDESC", showorder=7), @DEDataQueryCodeExp(name="PARAMTYPE", expression="t1.PARAMTYPE", showorder=8), @DEDataQueryCodeExp(name="PARAMVALUE", expression="t1.PARAMVALUE", showorder=9), @DEDataQueryCodeExp(name="PARAMVALUE2", expression="t1.PARAMVALUE2", showorder=10), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPEID", expression="t1.PSVIEWLOGICTYPEID", showorder=11), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPENAME", expression="t1.PSVIEWLOGICTYPENAME", showorder=12), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPEPARAMID", expression="t1.PSVIEWLOGICTYPEPARAMID", showorder=13), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPEPARAMNAME", expression="t1.PSVIEWLOGICTYPEPARAMNAME", showorder=14), @DEDataQueryCodeExp(name="REFOBJSCOPE", expression="t1.REFOBJSCOPE", showorder=15), @DEDataQueryCodeExp(name="REFOBJTYPE", expression="t1.REFOBJTYPE", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=19)}, conds={})})
public class PSViewLogicTypeParamDefaultDQModel
extends DEDataQueryModelBase {
    public PSViewLogicTypeParamDefaultDQModel() {
        this.initAnnotation(PSViewLogicTypeParamDefaultDQModel.class);
    }
}

