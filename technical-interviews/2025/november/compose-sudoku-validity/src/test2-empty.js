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

var compose = function (functions) {
    return function (x) {
        let composedResult = x;

        for (let i = functions.length - 1; i >= 0 ; i--) {
            composedResult = functions[i](composedResult);
        }

        return composedResult;
    }
};

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
function isValidSudoku(board) {
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

// Tests

// Composition de fonctions
var test_compose = () => {
  const fn1 = compose([x => x + 1, x => 2 * x])

  if (fn1(4) != 9) {
    return false;
  }

  const fn2 = compose([x => x + 1, x => x * x, x => 2 * x])
  if (fn2(4) != 65) {
    return false;
  }

  const fn3 = compose([x => 10 * x, x => 10 * x, x => 10 * x])
  if (fn3(1) != 1000) {
    return false;
  }

  const fn4 = compose([])
  if (fn4(42) != 42) {
    return false;
  }

  return true;
}

// Validité d'une grille de Sudoku

const sudoku_valid_board = [
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

const sudoku_invalid_board = [
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

const test_valid_sudoku = () => {
  if (!isValidSudoku(sudoku_valid_board)) {
    return false;
  }

  if (isValidSudoku(sudoku_invalid_board)) {
    return false;
  }

  return true;
}

const allTests = [
  test_compose,
  test_valid_sudoku
]

// React

// const Pass = () => <span className="pass">Pass</span>;
// const Fail = () => <span className="fail">Fail</span>;
//
// const TestResult = ({testFn}) => {
//   return (
//     <div>* {testFn.name} {testFn() ? <Pass /> : <Fail />} </div>
//   );
// }
//
// const TestRenderer = ({testFns}) => {
//   return (
//     <div>
//       Tests
//       <div>
//         {testFns.map((t, idx) => <TestResult key={idx} testFn={t} />)}
//       </div>
//     </div>
//   );
// }
//
// const App = () =>
//   <div>
//     BIENVENUE !
//
//     <TestRenderer testFns={allTests}/>
//   </div>;
//
// ReactDOM.render(<App/>, document.getElementById('root'));

// Vanilla
class Test {
    test(title, l, r) {
        const titlePad = title.padEnd(70, ".");

        // On compare la "stringification" pour simuler la comparaison
        // de valeur de Python (ex: pour les tableaux et objets).
        const l_str = JSON.stringify(l);
        const r_str = JSON.stringify(r);

        const result = (l_str === r_str)
            ? this.test_pass(titlePad) 
            : this.test_fail(titlePad);

        console.log(result);
    }

    test_pass(text) {
        // \x1b[1;32m = Bold Green, \x1b[0m = Reset
        return `\x1b[1;32m ${text} PASS\x1b[0m`;
    }

    test_fail(text) {
        // \x1b[1;31m = Bold Red, \x1b[0m = Reset
        return `\x1b[1;31m ${text} FAIL\x1b[0m`;
    }
}


// --- EXEMPLE D'UTILISATION ---

// Pour utiliser cette classe :
const t = new Test();

t.test("Composition de fonctions (succès)", true, test_compose());
t.test("Validité d'une grille de Sudoku (succès)", true, test_valid_sudoku());
