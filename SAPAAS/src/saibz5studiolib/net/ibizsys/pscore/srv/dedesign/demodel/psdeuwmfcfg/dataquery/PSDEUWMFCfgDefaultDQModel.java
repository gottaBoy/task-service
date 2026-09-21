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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuwmfcfg.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="AA69984B-84A0-4890-B797-8388E220C7DB", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ENAMULTIFORM`, t1.`PSDATAENTITYID`, t1.`PSDATAENTITYNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG` FROM `T_SRFPSDATAENTITY` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ENAMULTIFORM", expression="t1.`ENAMULTIFORM`", showorder=0), @DEDataQueryCodeExp(name="PSDATAENTITYID", expression="t1.`PSDATAENTITYID`", showorder=1), @DEDataQueryCodeExp(name="PSDATAENTITYNAME", expression="t1.`PSDATAENTITYNAME`", showorder=2), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=3), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=4), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=5)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ENAMULTIFORM, t1.PSDATAENTITYID, t1.PSDATAENTITYNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG FROM T_SRFPSDATAENTITY t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ENAMULTIFORM", expression="t1.ENAMULTIFORM", showorder=0), @DEDataQueryCodeExp(name="PSDATAENTITYID", expression="t1.PSDATAENTITYID", showorder=1), @DEDataQueryCodeExp(name="PSDATAENTITYNAME", expression="t1.PSDATAENTITYNAME", showorder=2), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=3), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=4), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=5)}, conds={})})
public class PSDEUWMFCfgDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEUWMFCfgDefaultDQModel() {
        this.initAnnotation(PSDEUWMFCfgDefaultDQModel.class);
    }
}

