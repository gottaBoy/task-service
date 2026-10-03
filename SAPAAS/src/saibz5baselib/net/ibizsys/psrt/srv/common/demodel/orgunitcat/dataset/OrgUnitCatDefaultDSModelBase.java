/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orgunitcat.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="37c7b65732fb7013db7c970d1262e849",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="95FABD7E-C74B-4504-956B-7EF965727A24",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class OrgUnitCatDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgUnitCatDefaultDSModelBase() {
        super();

        this.initAnnotation(OrgUnitCatDefaultDSModelBase.class);
    }




}