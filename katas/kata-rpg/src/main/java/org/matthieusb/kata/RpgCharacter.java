package org.matthieusb.kata;

import org.matthieusb.kata.exception.RpgCharacterCreationException;

public class RpgCharacter {
    private static Integer CHARACTER_MIN_DAMAGE_AND_NUMBER = 1;
    private static Integer CHARACTER_MAX_DAMAGE = 1337;
    private static Integer CHARACTER_MAX_LUCKY_NUMBER = 6;
    private static Integer CHARACTER_MIN_HEALTH = 0;
    private static Integer CHARACTER_MAX_HEALTH = 1000;
    private static Integer CHARACTER_DEFAULT_HEALTH = 100;

    public static final double CRITICAL_HIT_MULTIPLIER = 1.33;

    private final Integer health;
    private final Integer baseDamage;
    private final Integer luckyNumber;
    private final TimeService timeService;

    public RpgCharacter(Integer health, Integer baseDamage, Integer luckyNumber, TimeService timeService) throws RpgCharacterCreationException {
        this.health = health == null ? CHARACTER_DEFAULT_HEALTH : health;

        if (baseDamage == null || luckyNumber == null || timeService == null || charactersPropertiesAreNotWithinRange(this.health, baseDamage, luckyNumber)) {
            throw new RpgCharacterCreationException("Character not initialized correctly");
        }

        this.baseDamage = baseDamage;
        this.luckyNumber = luckyNumber;
        this.timeService = timeService;
    }

    private boolean charactersPropertiesAreNotWithinRange(Integer health, Integer baseDamage, Integer luckyNumber) {
        return  health < CHARACTER_MIN_HEALTH ||
                health > CHARACTER_MAX_HEALTH ||
                baseDamage < CHARACTER_MIN_DAMAGE_AND_NUMBER ||
                luckyNumber < CHARACTER_MIN_DAMAGE_AND_NUMBER ||
                baseDamage > CHARACTER_MAX_DAMAGE ||
                luckyNumber > CHARACTER_MAX_LUCKY_NUMBER;
    }

    private Double calculateAttackDamage(RpgCharacter attackingCharacter) {
        String currentSeconds = String.valueOf(attackingCharacter.getTimeService().calculateCurrentSeconds());
        Integer currentMinutes = this.getTimeService().calculateCurrentMinutes();

        if (currentSeconds.contains(String.valueOf(attackingCharacter.getLuckyNumber())) && (currentMinutes % this.getLuckyNumber() != 0)) {
            return CRITICAL_HIT_MULTIPLIER * Double.valueOf(attackingCharacter.getBaseDamage());
        }

        return Double.valueOf(attackingCharacter.getBaseDamage());
    }

    public RpgCharacter isAttackedBy(RpgCharacter attackingCharacter) throws RpgCharacterCreationException {
        Integer healthAfterAttack = this.getHealth() - Math.toIntExact(Math.round(this.calculateAttackDamage(attackingCharacter)));

        return new RpgCharacter(healthAfterAttack, this.getBaseDamage(), this.getLuckyNumber(), this.getTimeService());
    }

    public Integer getBaseDamage() {
        return this.baseDamage;
    }

    public Integer getLuckyNumber() {
        return this.luckyNumber;
    }

    public Integer getHealth() {
        return this.health;
    }

    public TimeService getTimeService() {
        return this.timeService;
    }
}
