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
package net.ibizsys.pscore.srv.config.demodel.psfdlogictype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="7189E96A-B275-4F52-9060-38ECC2ACF17A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ITEMOBJ`, t1.`MEMO`, t1.`PSFDLOGICTYPEID`, t1.`PSFDLOGICTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSFDLOGICTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ITEMOBJ", expression="t1.`ITEMOBJ`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSFDLOGICTYPEID", expression="t1.`PSFDLOGICTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSFDLOGICTYPENAME", expression="t1.`PSFDLOGICTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ITEMOBJ, t1.MEMO, t1.PSFDLOGICTYPEID, t1.PSFDLOGICTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSFDLOGICTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ITEMOBJ", expression="t1.ITEMOBJ", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSFDLOGICTYPEID", expression="t1.PSFDLOGICTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSFDLOGICTYPENAME", expression="t1.PSFDLOGICTYPENAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSFDLogicTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSFDLogicTypeDefaultDQModel() {
        this.initAnnotation(PSFDLogicTypeDefaultDQModel.class);
    }
}

