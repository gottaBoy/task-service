/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxentapp.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="aeb4861b6d65eff3ef2098ddd7a0d4f5",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="6ECB5AD7-F77A-48F8-AD7A-66E06251E321",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WXEntAppDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WXEntAppDefaultDSModelBase() {
        super();

        this.initAnnotation(WXEntAppDefaultDSModelBase.class);
    }




}