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
package net.ibizsys.pscore.srv.config.demodel.psdegctype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="40634083-97B9-4313-9625-85340BDCF0F0", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`COLUMNOBJ`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEGCTYPEID`, t1.`PSDEGCTYPENAME`, t1.`TREECOLUMNOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEGCTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="COLUMNOBJ", expression="t1.`COLUMNOBJ`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEGCTYPEID", expression="t1.`PSDEGCTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSDEGCTYPENAME", expression="t1.`PSDEGCTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="TREECOLUMNOBJ", expression="t1.`TREECOLUMNOBJ`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.COLUMNOBJ, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEGCTYPEID, t1.PSDEGCTYPENAME, t1.TREECOLUMNOBJ, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEGCTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="COLUMNOBJ", expression="t1.COLUMNOBJ", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEGCTYPEID", expression="t1.PSDEGCTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSDEGCTYPENAME", expression="t1.PSDEGCTYPENAME", showorder=5), @DEDataQueryCodeExp(name="TREECOLUMNOBJ", expression="t1.TREECOLUMNOBJ", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSDEGCTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEGCTypeDefaultDQModel() {
        this.initAnnotation(PSDEGCTypeDefaultDQModel.class);
    }
}

