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
package net.ibizsys.pscore.srv.config.demodel.psimagetempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="DC529F84-370F-4279-B2AD-A4551BCA597B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CSSCLASS`, t1.`GLYPH`, t1.`HEIGHT`, t1.`IMAGEPATH`, t1.`IMAGESRC`, t1.`IMAGETYPE`, t1.`MEMO`, t1.`PSIMAGETEMPLID`, t1.`PSIMAGETEMPLNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`WIDTH` FROM `T_SRFPSIMAGETEMPL` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CSSCLASS", expression="t1.`CSSCLASS`", showorder=2), @DEDataQueryCodeExp(name="GLYPH", expression="t1.`GLYPH`", showorder=3), @DEDataQueryCodeExp(name="HEIGHT", expression="t1.`HEIGHT`", showorder=4), @DEDataQueryCodeExp(name="IMAGEPATH", expression="t1.`IMAGEPATH`", showorder=5), @DEDataQueryCodeExp(name="IMAGESRC", expression="t1.`IMAGESRC`", showorder=6), @DEDataQueryCodeExp(name="IMAGETYPE", expression="t1.`IMAGETYPE`", showorder=7), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=8), @DEDataQueryCodeExp(name="PSIMAGETEMPLID", expression="t1.`PSIMAGETEMPLID`", showorder=9), @DEDataQueryCodeExp(name="PSIMAGETEMPLNAME", expression="t1.`PSIMAGETEMPLNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="WIDTH", expression="t1.`WIDTH`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CSSCLASS, t1.GLYPH, t1.HEIGHT, t1.IMAGEPATH, t1.IMAGESRC, t1.IMAGETYPE, t1.MEMO, t1.PSIMAGETEMPLID, t1.PSIMAGETEMPLNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.WIDTH FROM T_SRFPSIMAGETEMPL t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CSSCLASS", expression="t1.CSSCLASS", showorder=2), @DEDataQueryCodeExp(name="GLYPH", expression="t1.GLYPH", showorder=3), @DEDataQueryCodeExp(name="HEIGHT", expression="t1.HEIGHT", showorder=4), @DEDataQueryCodeExp(name="IMAGEPATH", expression="t1.IMAGEPATH", showorder=5), @DEDataQueryCodeExp(name="IMAGESRC", expression="t1.IMAGESRC", showorder=6), @DEDataQueryCodeExp(name="IMAGETYPE", expression="t1.IMAGETYPE", showorder=7), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=8), @DEDataQueryCodeExp(name="PSIMAGETEMPLID", expression="t1.PSIMAGETEMPLID", showorder=9), @DEDataQueryCodeExp(name="PSIMAGETEMPLNAME", expression="t1.PSIMAGETEMPLNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="WIDTH", expression="t1.WIDTH", showorder=13)}, conds={})})
public class PSImageTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSImageTemplDefaultDQModel() {
        this.initAnnotation(PSImageTemplDefaultDQModel.class);
    }
}

