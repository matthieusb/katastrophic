export class BowlingGame {
    private readonly _frames: ([string, string] | string[])[];

    constructor(scoreLine: string) {
        this._frames = scoreLine.split(' ').map(frame => {
            if (frame === 'X') {
                return [frame];
            }

            let firstThrow = frame.substr(0, 1);
            let secondThrow = frame.substr(1, 1);

            firstThrow = firstThrow === '-' ? '0' : firstThrow;
            secondThrow = secondThrow === '-' ? '0' : secondThrow;

            return [firstThrow, secondThrow];
        });
    }

    get frames(): ([string, string] | string[])[] {
        return this._frames;
    }

    calculateScore(): number {
        return this.frames
            .map((currentFrame, index, allFrames) => {
                const specialFrame = Boolean(currentFrame[1]) ? currentFrame[1] : currentFrame[0];

                if (specialFrame === '/') {
                    return 10 + parseInt(allFrames[index + 1][0]);
                } else {
                    if (specialFrame === 'X') {
                        const nextThrow = allFrames[index + 1][0];
                        const secondNextThrow = nextThrow === 'X' ? allFrames[index + 2][0] : allFrames[index + 1][1];

                        const nextThrowValue =
                            nextThrow === 'X' ? 10 : secondNextThrow === '/' ? 0 : parseInt(nextThrow);
                        const secondNextThrowValue =
                            secondNextThrow === 'X' ? 10 : secondNextThrow === '/' ? 10 : parseInt(secondNextThrow);

                        return 10 + nextThrowValue + secondNextThrowValue;
                    } else {
                        return parseInt(currentFrame[0]) + parseInt(currentFrame[1]);
                    }
                }
            })
            .reduce((previousValue, currentValue) => {
                return previousValue + currentValue;
            });
    }
}
