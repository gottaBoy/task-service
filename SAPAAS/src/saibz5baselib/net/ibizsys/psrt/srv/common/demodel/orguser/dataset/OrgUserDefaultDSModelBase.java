/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orguser.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="1f9576cdcc6a949230c7669182c73648",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="D2073767-B9E5-423A-8A27-65844044FD86",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class OrgUserDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgUserDefaultDSModelBase() {
        super();

        this.initAnnotation(OrgUserDefaultDSModelBase.class);
    }




}