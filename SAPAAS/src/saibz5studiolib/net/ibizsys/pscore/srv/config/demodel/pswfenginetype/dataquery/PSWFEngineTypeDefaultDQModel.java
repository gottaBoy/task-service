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
package net.ibizsys.pscore.srv.config.demodel.pswfenginetype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6B72CF12-59C2-4400-A4DE-F318D8674273", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSWFENGINETYPEID`, t1.`PSWFENGINETYPENAME`, t1.`TYPETAG`, t1.`TYPETAG2`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSWFENGINETYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSWFENGINETYPEID", expression="t1.`PSWFENGINETYPEID`", showorder=3), @DEDataQueryCodeExp(name="PSWFENGINETYPENAME", expression="t1.`PSWFENGINETYPENAME`", showorder=4), @DEDataQueryCodeExp(name="TYPETAG", expression="t1.`TYPETAG`", showorder=5), @DEDataQueryCodeExp(name="TYPETAG2", expression="t1.`TYPETAG2`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSWFENGINETYPEID, t1.PSWFENGINETYPENAME, t1.TYPETAG, t1.TYPETAG2, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSWFENGINETYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSWFENGINETYPEID", expression="t1.PSWFENGINETYPEID", showorder=3), @DEDataQueryCodeExp(name="PSWFENGINETYPENAME", expression="t1.PSWFENGINETYPENAME", showorder=4), @DEDataQueryCodeExp(name="TYPETAG", expression="t1.TYPETAG", showorder=5), @DEDataQueryCodeExp(name="TYPETAG2", expression="t1.TYPETAG2", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=9)}, conds={})})
public class PSWFEngineTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSWFEngineTypeDefaultDQModel() {
        this.initAnnotation(PSWFEngineTypeDefaultDQModel.class);
    }
}

