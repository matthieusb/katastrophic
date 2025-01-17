import { BowlingGame } from './index';

test('bowling game with numbers and gutters (no spares/strikes) is initialized correctly', (): void => {
    // Given
    const frames = '-9 2- -8 81 23 -- 2- 11 -5 --';
    const bowlingGame = new BowlingGame(frames);

    // When then
    const expectedFrames: [string, string][] = [
        ['0', '9'],
        ['2', '0'],
        ['0', '8'],
        ['8', '1'],
        ['2', '3'],
        ['0', '0'],
        ['2', '0'],
        ['1', '1'],
        ['0', '5'],
        ['0', '0'],
    ];

    expect(bowlingGame.frames).toStrictEqual(expectedFrames);
});

test('only frames with both 1 pin knocked down return a 20 score', (): void => {
    // Given
    const frames = '11 11 11 11 11 11 11 11 11 11';
    const bowlingGame = new BowlingGame(frames);

    // When then
    expect(bowlingGame.calculateScore()).toBe(20);
});

test('only frames with both 2 pin knocked down return a 40 score', (): void => {
    // Given
    const frames = '22 22 22 22 22 22 22 22 22 22';
    const bowlingGame = new BowlingGame(frames);

    // When then
    expect(bowlingGame.calculateScore()).toBe(40);
});

test('only frames with gutters return a 0 score', (): void => {
    // Given
    const frames = '-- -- -- -- -- -- -- -- -- --';
    const bowlingGame = new BowlingGame(frames);

    // When then
    expect(bowlingGame.calculateScore()).toBe(0);
});

test('frames with gutters + no spares/strikes return a 42 score', (): void => {
    // Given
    const frames = '-9 2- -8 81 23 -- 2- 11 -5 --';
    const bowlingGame = new BowlingGame(frames);

    // When then
    expect(bowlingGame.calculateScore()).toBe(42);
});

test('bowling game with numbers and gutters and spares (no strikes) is initialized correctly', (): void => {
    // Given
    const frames = '0/ 2- -8 81 2/ -- 2- 11 -5 --';
    const bowlingGame = new BowlingGame(frames);

    // When then
    const expectedFrames: [string, string][] = [
        ['0', '/'],
        ['2', '0'],
        ['0', '8'],
        ['8', '1'],
        ['2', '/'],
        ['0', '0'],
        ['2', '0'],
        ['1', '1'],
        ['0', '5'],
        ['0', '0'],
    ];

    expect(bowlingGame.frames).toStrictEqual(expectedFrames);
});

test('frames with only one spare at beginning followed by only gutters should return a 10 score', (): void => {
    // Given
    const frames = '9/ -- -- -- -- -- -- -- -- --';
    const bowlingGame = new BowlingGame(frames);

    // When then
    expect(bowlingGame.calculateScore()).toBe(10);
});

test('frames with multiple successives spares and normal scores should return a 59 score', (): void => {
    // Given
    const frames = '9/ 8/ -8 81 23 -- 2- 11 -5 --';
    const bowlingGame = new BowlingGame(frames);

    // When then
    expect(bowlingGame.calculateScore()).toBe(59);
});

test('bowling game with numbers and gutters (no spares/strikes) is initialized correctly', (): void => {
    // Given
    const frames = '0/ 2- -8 81 2/ X 2- 11 -5 --';
    const bowlingGame = new BowlingGame(frames);

    // When then
    const expectedFrames: ([string, string] | string[])[] = [
        ['0', '/'],
        ['2', '0'],
        ['0', '8'],
        ['8', '1'],
        ['2', '/'],
        ['X'],
        ['2', '0'],
        ['1', '1'],
        ['0', '5'],
        ['0', '0'],
    ];

    expect(bowlingGame.frames).toStrictEqual(expectedFrames);
});

test('frames with multiple successives strikes and spares and normal scores should return a 111 score', (): void => {
    // Given
    const frames = 'X X 4/ 33 33 33 X 81 22 22';
    const bowlingGame = new BowlingGame(frames);

    // When then
    expect(bowlingGame.calculateScore()).toBe(111);
});
