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
package net.ibizsys.pscore.srv.def.demodel.psformtype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="696F267B-0A6F-44AF-BC19-9D0268D94506", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FORMOBJ`, t1.`ICONPATH`, t1.`MEMO`, t1.`PSFORMTYPEID`, t1.`PSFORMTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSFORMTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FORMOBJ", expression="t1.`FORMOBJ`", showorder=2), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSFORMTYPEID", expression="t1.`PSFORMTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSFORMTYPENAME", expression="t1.`PSFORMTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FORMOBJ, t1.ICONPATH, t1.MEMO, t1.PSFORMTYPEID, t1.PSFORMTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSFORMTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FORMOBJ", expression="t1.FORMOBJ", showorder=2), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSFORMTYPEID", expression="t1.PSFORMTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSFORMTYPENAME", expression="t1.PSFORMTYPENAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSFormTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSFormTypeDefaultDQModel() {
        this.initAnnotation(PSFormTypeDefaultDQModel.class);
    }
}

