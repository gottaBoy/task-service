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
package net.ibizsys.pscore.srv.config.demodel.pswflinkcondtype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5E89CCDB-0BEF-4B79-9D92-D3070BE03A32", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ITEMOBJ`, t1.`MEMO`, t1.`PSWFLINKCONDTYPEID`, t1.`PSWFLINKCONDTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSWFLINKCONDTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ITEMOBJ", expression="t1.`ITEMOBJ`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSWFLINKCONDTYPEID", expression="t1.`PSWFLINKCONDTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSWFLINKCONDTYPENAME", expression="t1.`PSWFLINKCONDTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ITEMOBJ, t1.MEMO, t1.PSWFLINKCONDTYPEID, t1.PSWFLINKCONDTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSWFLINKCONDTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ITEMOBJ", expression="t1.ITEMOBJ", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSWFLINKCONDTYPEID", expression="t1.PSWFLINKCONDTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSWFLINKCONDTYPENAME", expression="t1.PSWFLINKCONDTYPENAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSWFLinkCondTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSWFLinkCondTypeDefaultDQModel() {
        this.initAnnotation(PSWFLinkCondTypeDefaultDQModel.class);
    }
}

