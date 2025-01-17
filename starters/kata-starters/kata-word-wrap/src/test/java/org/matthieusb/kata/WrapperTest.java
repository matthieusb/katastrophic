package org.matthieusb.kata;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WrapperTest {
    @Test
    void trueIsTrue() {
        assertThat(true).isTrue();
    }
}
