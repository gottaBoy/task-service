/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.org.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="e3e158d75b7bc6f589686b6e1beb966c",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="115ED535-A663-4F0C-AFD6-174808F1144E",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class OrgDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgDefaultDSModelBase() {
        super();

        this.initAnnotation(OrgDefaultDSModelBase.class);
    }




}