package com.tngtech.archunit.core;

import org.junit.Test;

import static com.tngtech.archunit.core.TestUtils.javaMethod;
import static org.assertj.core.api.Assertions.assertThat;

public class JavaCallTest {
    @Test
    public void get_target() {
        JavaMethodCall call = TestUtils.simulateCall().from(javaMethod(getClass(), "toString"), 5)
                .to(javaMethod(getClass(), "hashCode"));

        assertThat(JavaCall.GET_TARGET.apply(call)).isEqualTo(call.getTarget());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}