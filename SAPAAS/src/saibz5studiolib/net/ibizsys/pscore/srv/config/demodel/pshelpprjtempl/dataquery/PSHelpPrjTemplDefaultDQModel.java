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
package net.ibizsys.pscore.srv.config.demodel.pshelpprjtempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B8A46B04-B302-49DD-8802-6E0485E584B5", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFAULTFLAG`, t1.`MEMO`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSHELPPRJTEMPLID`, t1.`PSHELPPRJTEMPLNAME`, t1.`PUBMODE`, t1.`PUBOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSHELPPRJTEMPL` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.`TEMPLCODE`", showorder=-1), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.`TEMPLCODE2`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.`DEFAULTFLAG`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=5), @DEDataQueryCodeExp(name="PSHELPPRJTEMPLID", expression="t1.`PSHELPPRJTEMPLID`", showorder=6), @DEDataQueryCodeExp(name="PSHELPPRJTEMPLNAME", expression="t1.`PSHELPPRJTEMPLNAME`", showorder=7), @DEDataQueryCodeExp(name="PUBMODE", expression="t1.`PUBMODE`", showorder=8), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.`PUBOBJ`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEFAULTFLAG, t1.MEMO, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSHELPPRJTEMPLID, t1.PSHELPPRJTEMPLNAME, t1.PUBMODE, t1.PUBOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSHELPPRJTEMPL t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.TEMPLCODE", showorder=-1), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.TEMPLCODE2", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.DEFAULTFLAG", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=5), @DEDataQueryCodeExp(name="PSHELPPRJTEMPLID", expression="t1.PSHELPPRJTEMPLID", showorder=6), @DEDataQueryCodeExp(name="PSHELPPRJTEMPLNAME", expression="t1.PSHELPPRJTEMPLNAME", showorder=7), @DEDataQueryCodeExp(name="PUBMODE", expression="t1.PUBMODE", showorder=8), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.PUBOBJ", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSHelpPrjTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSHelpPrjTemplDefaultDQModel() {
        this.initAnnotation(PSHelpPrjTemplDefaultDQModel.class);
    }
}

