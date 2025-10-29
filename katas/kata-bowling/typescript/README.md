# kata bowling typescript

Source: http://codingdojo.org/kata/Bowling/

## Rules

The scoring system works as follows:

* Each game, or “line” of bowling, includes ten turns, or “frames” for the bowler.
* In each frame, the bowler gets up to two tries to knock down all the pins.
* If in two tries, he fails to knock them all down, his score for that frame is the total number of pins knocked down in his two tries.
* If in two tries he knocks them all down, this is called a “spare” and his score for the frame is ten plus the number of pins knocked down on his next throw (in his next turn).
* If on his first try in the frame he knocks down all the pins, this is called a “strike”. His turn is over, and his score for the frame is ten plus the simple total of the pins knocked down in his next two rolls.
* If he gets a spare or strike in the last (tenth) frame, the bowler gets to throw one or two more bonus balls, respectively. These bonus throws are taken as part of the same turn. If the bonus throws knock down all the pins, the process does not repeat: the bonus throws are only used to calculate the score of the final frame.
* The game score is the total of all frame scores.

What **does not need to be implemented**:

* We will not check for valid rolls.
* We will not check for correct number of rolls and frames.
* We will not provide scores for intermediate frames.

Simple suggestions for test cases:

* X X X X X X X X X X X X (12 rolls: 12 strikes) = 10 frames * 30 points = 300
* 9- 9- 9- 9- 9- 9- 9- 9- 9- 9- (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90
* 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150

### Examples

![Drag Racing](./examples.png)

### More Help

Detailed bowling score explanation : https://www.topendsports.com/sport/tenpin/scoring.htm
 
Bowling score calculator : https://www.bowlinggenius.com/

Correction in C#: https://ronjeffries.com/xprog/articles/acsbowling/

## Project usage

### Pre-requisites

You need **node** and **npm** installed

### Installation

Simply run:

```bash
npm install
```

### Development

```bash
npm compile

# Watch compile
npm compile:watch
```

Test watch:
```bash
npm test

# Watch compile
npm test:watch
```

Coverage:
```bash
npm coverage
```

See *package.json* scripts for more info.

### Git hooks

There are automatic git hooks triggered before commiting. If you have git hooks already configured. Don't forget to disable them:

```bash
git config --global --unset core.hooksPath
```