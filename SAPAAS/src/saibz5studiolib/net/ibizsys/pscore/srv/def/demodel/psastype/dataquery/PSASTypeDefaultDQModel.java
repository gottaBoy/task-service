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
package net.ibizsys.pscore.srv.def.demodel.psastype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F06E1BE1-ED5D-4753-B685-B59C46A080DF", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ICONPATH`, t1.`INSTALLPATH`, t1.`MEMO`, t1.`PSASTYPEID`, t1.`PSASTYPENAME`, t1.`STARTCMD`, t1.`STOPCMD`, t1.`TYPEHELPER`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`VALIDFLAG` FROM `T_SRFPSASTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=2), @DEDataQueryCodeExp(name="INSTALLPATH", expression="t1.`INSTALLPATH`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSASTYPEID", expression="t1.`PSASTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSASTYPENAME", expression="t1.`PSASTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="STARTCMD", expression="t1.`STARTCMD`", showorder=7), @DEDataQueryCodeExp(name="STOPCMD", expression="t1.`STOPCMD`", showorder=8), @DEDataQueryCodeExp(name="TYPEHELPER", expression="t1.`TYPEHELPER`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ICONPATH, t1.INSTALLPATH, t1.MEMO, t1.PSASTYPEID, t1.PSASTYPENAME, t1.STARTCMD, t1.STOPCMD, t1.TYPEHELPER, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.VALIDFLAG FROM T_SRFPSASTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=2), @DEDataQueryCodeExp(name="INSTALLPATH", expression="t1.INSTALLPATH", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSASTYPEID", expression="t1.PSASTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSASTYPENAME", expression="t1.PSASTYPENAME", showorder=6), @DEDataQueryCodeExp(name="STARTCMD", expression="t1.STARTCMD", showorder=7), @DEDataQueryCodeExp(name="STOPCMD", expression="t1.STOPCMD", showorder=8), @DEDataQueryCodeExp(name="TYPEHELPER", expression="t1.TYPEHELPER", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=14)}, conds={})})
public class PSASTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSASTypeDefaultDQModel() {
        this.initAnnotation(PSASTypeDefaultDQModel.class);
    }
}

