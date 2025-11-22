import { describe, it, expect } from "vitest";

import { compose, isValidSudoku } from "./index";

describe("composition function", () => {
    it("x => x + 1, x => 2 * x", () => {
        const fn = compose([x => x + 1, x => 2 * x]);

        expect(fn(4)).toBe(9);
    });

    it("x => x + 1, x => x * x, x => 2 * x", () => {
        const fn = compose([x => x + 1, x => x * x, x => 2 * x])

        expect(fn(4)).toBe(65);
    });

    it("x => 10 * x, x => 10 * x, x => 10 * x", () => {
        const fn = compose([x => 10 * x, x => 10 * x, x => 10 * x])

        expect(fn(1)).toBe(1000);
    });

    it("empty function, equivalent to identity", () => {
        const fn = compose([])

        expect(fn(42)).toBe(42);
    });
});

describe("sudoku validity", () => {
    it("valid sudoku board", () => {
        const board = [
            ["5","3",".",".","7",".",".",".","."],
            ["6",".",".","1","9","5",".",".","."],
            [".","9","8",".",".",".",".","6","."],
            ["8",".",".",".","6",".",".",".","3"],
            ["4",".",".","8",".","3",".",".","1"],
            ["7",".",".",".","2",".",".",".","6"],
            [".","6",".",".",".",".","2","8","."],
            [".",".",".","4","1","9",".",".","5"],
            [".",".",".",".","8",".",".","7","9"]
        ];

        expect(isValidSudoku(board)).toBeTruthy();
    });

    it("invalid sudoku board", () => {
        const board = [
            ["8","3",".",".","7",".",".",".","."],
            ["6",".",".","1","9","5",".",".","."],
            [".","9","8",".",".",".",".","6","."],
            ["8",".",".",".","6",".",".",".","3"], // '8' est en double dans la première colonne
            ["4",".",".","8",".","3",".",".","1"],
            ["7",".",".",".","2",".",".",".","6"],
            [".","6",".",".",".",".","2","8","."],
            [".",".",".","4","1","9",".",".","5"],
            [".",".",".",".","8",".",".","7","9"]
        ];

        expect(isValidSudoku(board)).toBeFalsy();
    });
});