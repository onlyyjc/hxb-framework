package com.hxb.core.ensure.extensions;


import com.hxb.core.ensure.EnsureParam;
import com.hxb.core.exceptions.HxbExceptionFactory;

/**
 * Created by yangjiachang on 2017/12/25.
 */
public class EnsureParamNumberExtension extends EnsureParam<Number> {
    private Double number;

    public EnsureParamNumberExtension(Number number) {
        super(number);
        this.number = number.doubleValue();
    }

    /**
     * 大于
     *
     * @param comparedNumber
     * @param errorCode
     * @return
     */
    public EnsureParamNumberExtension isGt(Number comparedNumber, String errorCode) {
        if (number <= comparedNumber.doubleValue()) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    /**
     * 不大于（小于等于）
     *
     * @param comparedNumber
     * @param errorCode
     * @return
     */
    public EnsureParamNumberExtension isNotGt(Number comparedNumber, String errorCode) {
        if (number > comparedNumber.doubleValue()) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    /**
     * 小于
     *
     * @param comparedNumber
     * @param errorCode
     * @return
     */
    public EnsureParamNumberExtension isLt(Number comparedNumber, String errorCode) {
        if (number >= comparedNumber.doubleValue()) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    /**
     * 不小于
     *
     * @param comparedNumber
     * @param errorCode
     * @return
     */
    public EnsureParamNumberExtension isNotLt(Number comparedNumber, String errorCode) {
        if (number < comparedNumber.doubleValue()) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    /**
     * 等于
     *
     * @param comparedNumber
     * @param errorCode
     * @return
     */
    public EnsureParamNumberExtension isEqual(Number comparedNumber, String errorCode) {
        if (number != comparedNumber.doubleValue()) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    /**
     * 不等于
     *
     * @param comparedNumber
     * @param errorCode
     * @return
     */
    public EnsureParamNumberExtension isNotEqual(Number comparedNumber, String errorCode) {
        if (number == comparedNumber.doubleValue()) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    public EnsureParamNumberExtension isNotNull(String errorCode) {
        if (number == null) {
            throw HxbExceptionFactory.create(errorCode);
        }
        return this;
    }

    public EnsureParamNumberExtension isEqualTo(Number obj, String errorCode) {
        return isEqual(obj, errorCode);
    }

    public EnsureParamNumberExtension isNotEqualTo(Number obj, String errorCode) {
        return isNotEqual(obj, errorCode);
    }
}
