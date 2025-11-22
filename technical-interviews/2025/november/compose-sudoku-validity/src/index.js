/* Composition de fonctions
 * Écrire une fonction qui prend en paramètre plusieurs fonctions tel que :
 * l'output de la 1ère fonction devient l'input de la 2nde, l'output de la 2nde devient l'input de la 3ème,
 * et ainsi de suite.
 * L'ordre des fonctions s'applique de la droite vers la gauche.
 *
 * Exemple:
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */

export function compose(functions) {
    return function (x) {
        let composedResult = x;

        for (let i = functions.length - 1; i >= 0 ; i--) {
            composedResult = functions[i](composedResult);
        }

        return composedResult;
    }
}

/*
 *
 *  Validité d'une grille sudoku
 *
 *   A 9x9 sudoku grid is valid (but not necessarily solvable) if :
 *   - each line contains the digits {1..9} without duplicate
 *   - each column contains the digits {1..9} without duplicate
 *   - each 3x3 box contains the digits {1..9} without duplicate
 *   Empty cases are marked with a "."
 */

/**
 *
 * Valide une grille de Sudoku 9x9.
 * @param {string[][]} board - La grille représentée par un tableau 2D.
 * @returns {boolean} - true si la grille est valide, false sinon.
 */
export function isValidSudoku(board) {
    // TODO
    for (let i = 0; i < board.length; i++) {
        let currentLine = i;

        for (let j = 0; j < board.length ; j++) {
            if (i !== j && board[i][j] === currentLine[j]) {
                return false;
            }
        }

        let currentColumn = testCurrentColumn(board, i);

        // testBox
        for (let i = 0 ; i < board.length ; i+=2) {

        }
    }
}

function testCurrentColumn(board, columnNumber) {
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board.length ; j++) {
            if (j === columnNumber) {

            }
        }
    }
}



