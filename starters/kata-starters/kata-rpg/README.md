# Rpg Kata

This is a custom kata designed to work on TDD, dependency injection and feature envy. This repository's is sufficient, you should not have to add anything more to complete the kata (No mockito, for example). It's not forbidden though.

You can add an **immutability constraint** to spice things up.

## Pre-requisites

* Java 8
* Maven 3.*

## Quick start

Build it:
```
mvn clean install
```

Test it:
```
mvn test
```

## Solution commits and tags

If you want to see the solution step by step, there are several tags available which begin with **kata-rpg**.

## Stories

You are asked to design an rpg character's behavior. A character has two simple properties:

* _base damage_: between **1** and **1337** included
* _lucky number_: between **1** and **5** included

Your character has the ability to _attack_.

### Story 1: attacking

The character should be able to attack.
An attack work as follows

* **Base attack**: damages dealt = character's base damage
* **Critical hit attack**: damages dealt = deals 1,33 * base damage **only** if the character's lucky number is in the seconds of the current time

Example:

Character(base_damage : 12, lucky_number: 2)
* Attacks at 12h02min11s => base attack
* Attacks at 12h02min12s => critical hit attack

### Story 2: attacking an opponent

A character's attack should be pointed towards another character and reduce its health:

* _health_: between **0** and **10000** included, **100 by default**
* the damage dealt is equal to the damage calculated in the previous story

### Story 3: critical damage pary

A character will be dealt normal damages rather than critical damages if the minutes of the current time are divisble by its lucky number.

Example:

Character_Attacker(base_damage : 12, lucky_number: 3)
Character_Defender(base_damage : x, lucky_number: 2)

 * Is attacked at 12h06min04s => damages received = Character_Attacker's base damage _(normal attack)_
 * Is attacked at 12h23min23s => damages received = _critical damage (critical attack, no pary)_
 * Is attacked at 12h06min12s => damages received = base damage _(critical attack pary)_
