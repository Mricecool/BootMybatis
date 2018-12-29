package com.bootmybatis.batch;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * 校验
 * Created by mr on 2018/12/28.
 */
public class BatchBeanValidator<T> implements Validator<T>, InitializingBean {

    private javax.validation.Validator validator;

    @Override
    public void validate(T value) throws ValidationException {
        //使用validator的validate方法校验数据
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(value);
        //如果有异常信息抛出异常
        if (constraintViolations.size() > 0) {
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                message.append(constraintViolation.getMessage() + "\n");
            }
            throw new ValidationException(message.toString());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //使用JSR-303的Validator校验数据
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }
}
