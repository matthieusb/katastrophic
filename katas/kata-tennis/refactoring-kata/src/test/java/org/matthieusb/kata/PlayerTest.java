package org.matthieusb.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerTest {

    @Test
    void shouldCreateplayerWithNameAndInitialScore() {
        Player player = new Player("Benoit Paire");

        assertThat(player).isNotNull();
        assertThat(player.getName()).isEqualTo("Benoit Paire");
        assertThat(player.getScore()).isEqualTo(0);
    }
    
}
