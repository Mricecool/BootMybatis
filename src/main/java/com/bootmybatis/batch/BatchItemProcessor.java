package com.bootmybatis.batch;

import com.bootmybatis.model.BatchBean;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * 处理
 * Created by mr on 2018/12/28.
 */
public class BatchItemProcessor extends ValidatingItemProcessor<BatchBean> {

    @Override
    public BatchBean process(BatchBean item) throws ValidationException {
        super.process(item);//必须调用此方法，才会执行自定义校验器
        if (Double.parseDouble(item.getDataCust()) > 200) {
            item.setDataResult("通过");
        } else {
            item.setDataResult("不通过");
        }
        return item;
    }
}
