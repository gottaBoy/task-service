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
package net.ibizsys.pscore.srv.config.demodel.psbookingrestype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E0215835-564B-44C7-B9AD-7B68C25B07D4", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSBOOKINGRESTYPEID`, t1.`PSBOOKINGRESTYPENAME`, t1.`RESCAT`, t1.`TYPEHELPER`, t1.`TYPEPARAM`, t1.`TYPEPARAM2`, t1.`TYPEPARAM3`, t1.`TYPEPARAM4`, t1.`TYPEPARAM5`, t1.`TYPEPARAM6`, t1.`TYPEPARAM7`, t1.`TYPEPARAM8`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`VALIDFLAG` FROM `T_SRFPSBOOKINGRESTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSBOOKINGRESTYPEID", expression="t1.`PSBOOKINGRESTYPEID`", showorder=3), @DEDataQueryCodeExp(name="PSBOOKINGRESTYPENAME", expression="t1.`PSBOOKINGRESTYPENAME`", showorder=4), @DEDataQueryCodeExp(name="RESCAT", expression="t1.`RESCAT`", showorder=5), @DEDataQueryCodeExp(name="TYPEHELPER", expression="t1.`TYPEHELPER`", showorder=6), @DEDataQueryCodeExp(name="TYPEPARAM", expression="t1.`TYPEPARAM`", showorder=7), @DEDataQueryCodeExp(name="TYPEPARAM2", expression="t1.`TYPEPARAM2`", showorder=8), @DEDataQueryCodeExp(name="TYPEPARAM3", expression="t1.`TYPEPARAM3`", showorder=9), @DEDataQueryCodeExp(name="TYPEPARAM4", expression="t1.`TYPEPARAM4`", showorder=10), @DEDataQueryCodeExp(name="TYPEPARAM5", expression="t1.`TYPEPARAM5`", showorder=11), @DEDataQueryCodeExp(name="TYPEPARAM6", expression="t1.`TYPEPARAM6`", showorder=12), @DEDataQueryCodeExp(name="TYPEPARAM7", expression="t1.`TYPEPARAM7`", showorder=13), @DEDataQueryCodeExp(name="TYPEPARAM8", expression="t1.`TYPEPARAM8`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=17), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSBOOKINGRESTYPEID, t1.PSBOOKINGRESTYPENAME, t1.RESCAT, t1.TYPEHELPER, t1.TYPEPARAM, t1.TYPEPARAM2, t1.TYPEPARAM3, t1.TYPEPARAM4, t1.TYPEPARAM5, t1.TYPEPARAM6, t1.TYPEPARAM7, t1.TYPEPARAM8, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.VALIDFLAG FROM T_SRFPSBOOKINGRESTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSBOOKINGRESTYPEID", expression="t1.PSBOOKINGRESTYPEID", showorder=3), @DEDataQueryCodeExp(name="PSBOOKINGRESTYPENAME", expression="t1.PSBOOKINGRESTYPENAME", showorder=4), @DEDataQueryCodeExp(name="RESCAT", expression="t1.RESCAT", showorder=5), @DEDataQueryCodeExp(name="TYPEHELPER", expression="t1.TYPEHELPER", showorder=6), @DEDataQueryCodeExp(name="TYPEPARAM", expression="t1.TYPEPARAM", showorder=7), @DEDataQueryCodeExp(name="TYPEPARAM2", expression="t1.TYPEPARAM2", showorder=8), @DEDataQueryCodeExp(name="TYPEPARAM3", expression="t1.TYPEPARAM3", showorder=9), @DEDataQueryCodeExp(name="TYPEPARAM4", expression="t1.TYPEPARAM4", showorder=10), @DEDataQueryCodeExp(name="TYPEPARAM5", expression="t1.TYPEPARAM5", showorder=11), @DEDataQueryCodeExp(name="TYPEPARAM6", expression="t1.TYPEPARAM6", showorder=12), @DEDataQueryCodeExp(name="TYPEPARAM7", expression="t1.TYPEPARAM7", showorder=13), @DEDataQueryCodeExp(name="TYPEPARAM8", expression="t1.TYPEPARAM8", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=17), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=19)}, conds={})})
public class PSBookingResTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSBookingResTypeDefaultDQModel() {
        this.initAnnotation(PSBookingResTypeDefaultDQModel.class);
    }
}

