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
package net.ibizsys.pscore.srv.config.demodel.pslistitemtype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="23A976AC-2B71-49C9-94D6-95014150ED46", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENABLE`, t1.`ITEMTOBJ`, t1.`MEMO`, t1.`PSLISTITEMTYPEID`, t1.`PSLISTITEMTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSLISTITEMTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ENABLE", expression="t1.`ENABLE`", showorder=2), @DEDataQueryCodeExp(name="ITEMTOBJ", expression="t1.`ITEMTOBJ`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSLISTITEMTYPEID", expression="t1.`PSLISTITEMTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSLISTITEMTYPENAME", expression="t1.`PSLISTITEMTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.ITEMTOBJ, t1.MEMO, t1.PSLISTITEMTYPEID, t1.PSLISTITEMTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSLISTITEMTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ENABLE", expression="t1.ENABLE", showorder=2), @DEDataQueryCodeExp(name="ITEMTOBJ", expression="t1.ITEMTOBJ", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSLISTITEMTYPEID", expression="t1.PSLISTITEMTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSLISTITEMTYPENAME", expression="t1.PSLISTITEMTYPENAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1")})})
public class PSListItemTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSListItemTypeDefaultDQModel() {
        this.initAnnotation(PSListItemTypeDefaultDQModel.class);
    }
}

