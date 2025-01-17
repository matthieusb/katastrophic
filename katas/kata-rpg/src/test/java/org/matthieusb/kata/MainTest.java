package org.matthieusb.kata;

import org.junit.jupiter.api.Test;
import org.matthieusb.kata.exception.RpgCharacterCreationException;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    @Test
    public void character_should_not_be_created_when_baseDamage_or_luckyNumber_are_incorrect() {
        Clock clock = Clock.fixed(Instant.parse("2018-04-29T10:15:30.00Z"), ZoneId.of("Europe/Paris"));
        TimeService timeService = new TimeService(clock);

        // THEN
        assertAll("RpgCharacter should throw exceptions when values aren't within bounds",
                () -> assertThrows(RpgCharacterCreationException.class, () -> new RpgCharacter(null, 0, 0, timeService)),
                () -> assertThrows(RpgCharacterCreationException.class, () -> new RpgCharacter(null, 2, 0, timeService)),
                () -> assertThrows(RpgCharacterCreationException.class, () -> new RpgCharacter(null, 13319, 2, timeService)),
                () -> assertThrows(RpgCharacterCreationException.class, () -> new RpgCharacter(null, 22, 13, timeService)),
                () -> assertThrows(RpgCharacterCreationException.class, () -> new RpgCharacter(null, null, null, timeService)),
                () -> assertThrows(RpgCharacterCreationException.class, () -> new RpgCharacter(null, 42, 2, null)),
                () -> assertThrows(RpgCharacterCreationException.class, () -> new RpgCharacter(10023, 2, 3, timeService))
        );
    }

    /**
     * This test could be disabled because it is not relevant: it is just testing a constructor normal cases.
     * HOWEVER, it was used during a TDD loop to drive the constructor's implementation through baby steps.
     *
     * In real life, you could just delete this test, as it is not needed anymore.
     * It is just left here as an illustration of TDD usage.
     */
    @Test
    public void character_should_be_created_with_correct_properties() throws RpgCharacterCreationException {
        // GIVEN
        // NOTE: Could add junit-jupiter-params here to ease tests, but not necessary for this kata
        Clock clock = Clock.fixed(Instant.parse("2018-04-29T10:15:30.00Z"), ZoneId.of("Europe/Paris"));
        TimeService timeService = new TimeService(clock);

        RpgCharacter characterLimitCase1 = new RpgCharacter(null, 1, 1, timeService);
        RpgCharacter characterLimitCase2 = new RpgCharacter(null, 1337, 5, timeService);
        RpgCharacter character1 = new RpgCharacter(null, 22, 4, timeService);
        RpgCharacter character2 = new RpgCharacter(null, 42, 3, timeService);
        RpgCharacter chracterWithHealth = new RpgCharacter(88, 42, 3, timeService);

        // THEN
        assertAll("RpgCharacter is created correctly",
                () -> assertThat(characterLimitCase1.getHealth()).isEqualTo(100),
                () -> assertThat(characterLimitCase1.getBaseDamage()).isEqualTo(1),
                () -> assertThat(characterLimitCase1.getLuckyNumber()).isEqualTo(1),
                () -> assertThat(characterLimitCase2.getHealth()).isEqualTo(100),
                () -> assertThat(characterLimitCase2.getBaseDamage()).isEqualTo(1337),
                () -> assertThat(characterLimitCase2.getLuckyNumber()).isEqualTo(5),
                () -> assertThat(character1.getHealth()).isEqualTo(100),
                () -> assertThat(character1.getBaseDamage()).isEqualTo(22),
                () -> assertThat(character1.getLuckyNumber()).isEqualTo(4),
                () -> assertThat(character2.getHealth()).isEqualTo(100),
                () -> assertThat(character2.getBaseDamage()).isEqualTo(42),
                () -> assertThat(character2.getLuckyNumber()).isEqualTo(3),
                () -> assertThat(chracterWithHealth.getHealth()).isEqualTo(88),
                () -> assertThat(chracterWithHealth.getBaseDamage()).isEqualTo(42),
                () -> assertThat(chracterWithHealth.getLuckyNumber()).isEqualTo(3)
        );
    }

    /**
     * The two following tests can be deleted since we changed visibilty of the attack method and renamed it.
     * @throws RpgCharacterCreationException when values not in defined bounds or null
     */
/*    @Test
    public void character_should_deal_base_damage_when_attacking_on_non_lucky_number_time() throws RpgCharacterCreationException {
        // GIVEN
        Clock clock = Clock.fixed(Instant.parse("2018-04-29T10:15:30.00Z"), ZoneId.of("Europe/Paris"));
        TimeService timeService = new TimeService(clock);

        RpgCharacter character = new RpgCharacter(2, 5, timeService);

        // WHEN
        Double damageDealt = character.attack();

        // THEN
        assertThat(damageDealt).isEqualTo(Double.valueOf(2));
    }
    @Test
    public void character_should_deal_critical_damage_when_attacking_on_lucky_number_time() throws RpgCharacterCreationException {
        // GIVEN
        Clock clock = Clock.fixed(Instant.parse("2018-04-29T10:15:30.00Z"), ZoneId.of("Europe/Paris"));
        TimeService timeService = new TimeService(clock);

        RpgCharacter character = new RpgCharacter(2, 3, timeService);


        // WHEN
        Double damageDealt = character.attack();

        // THEN
        assertThat(damageDealt).isEqualTo(2.66);
    }*/

    @Test
    public void character_normal_attack_should_deal_damage_to_opponent_and_reduce_its_health() throws RpgCharacterCreationException {
        // GIVEN
        Clock clock = Clock.fixed(Instant.parse("2018-04-29T10:15:30.00Z"), ZoneId.of("Europe/Paris"));
        TimeService timeService = new TimeService(clock);

        RpgCharacter attackingCharacter = new RpgCharacter(null, 23, 1, timeService);
        RpgCharacter attackedCharacter = new RpgCharacter(130,12, 5, timeService);

        // WHEN
        attackedCharacter = attackedCharacter.isAttackedBy(attackingCharacter);

        // THEN
        assertThat(attackedCharacter.getHealth()).isEqualTo(107);
    }

    @Test
    public void character_criticial_hit_attack_should_deal_damage_to_opponent_and_reduce_its_health() throws RpgCharacterCreationException {
        // GIVEN
        Clock clock = Clock.fixed(Instant.parse("2018-04-29T10:15:30.00Z"), ZoneId.of("Europe/Paris"));
        TimeService timeService = new TimeService(clock);

        RpgCharacter attackingCharacter = new RpgCharacter(null, 23, 3, timeService);
        RpgCharacter attackedCharacter = new RpgCharacter(130,12, 2, timeService);

        // WHEN
        attackedCharacter = attackedCharacter.isAttackedBy(attackingCharacter);

        // THEN
        assertThat(attackedCharacter.getHealth()).isEqualTo(99);
    }

    @Test
    public void character_criticial_hit_attack_should_deal_normal_damage_on_critical_hit_pary() throws RpgCharacterCreationException {
        // GIVEN
        Clock clock = Clock.fixed(Instant.parse("2018-04-29T10:15:30.00Z"), ZoneId.of("Europe/Paris"));
        TimeService timeService = new TimeService(clock);

        RpgCharacter attackingCharacter = new RpgCharacter(null, 23, 3, timeService);
        RpgCharacter attackedCharacter = new RpgCharacter(130,12, 5, timeService);

        // WHEN
        attackedCharacter = attackedCharacter.isAttackedBy(attackingCharacter);

        // THEN
        assertThat(attackedCharacter.getHealth()).isEqualTo(107);
    }

    // FIXME: tests could be added
}
