// my_map = (array, v => v') => array
export const my_map = (list, f) => {
    const appliedList = [];

    list.forEach(current => appliedList.push(f(current)));

    return appliedList;
}

// my_reduce = (array, (acc, v) => acc', v0) => accFinal
export const my_reduce = (list, f, initial) => {
    let result = initial;

    list.forEach(current => {
        result = f(result, current);
    });

    return result;
}

// e.g. {"A": [3, 5, 6], "B": [5, 8, 19], ...}
export const groupByLetterIncreasingUniqueNumber = (data) => {
    return data.reduce((acc, current) => {
        const currentLetter = current[0];
        const currentNumber = current[1];

        if (!acc[currentLetter]) {
            acc[currentLetter] = [];
            acc[currentLetter].push(currentNumber);
        } else {
            if (acc[currentLetter].findIndex(x => x === currentNumber) === -1) {
                acc[currentLetter].push(currentNumber);
                acc[currentLetter].sort((x, y) => x - y);
            }
        }

        return acc;
    }, {});
}

// e.g. {"1": ["A", "D", "Z"], "2": ["C", "D", "E", "X"], ...}
export const groupByNumberIncreasingUniqueLetter = (data) => {
    return data.reduce((acc, current) => {
        const currentLetter = current[0];
        const currentNumber = current[1];

        if (!acc[currentNumber]) {
            acc[currentNumber] = [];
            acc[currentNumber].push(currentLetter);
        } else {
            if (acc[currentNumber].findIndex(x => x === currentLetter) === -1) {
                acc[currentNumber].push(currentLetter);
                acc[currentNumber].sort();
            }
        }

        return acc;
    }, {});
}

// e.g. {"1": {"A": 1, "B": 5}, "3": {"A": 2, "D": 3, "X": 1}...}
export const letterDistributionPerNumber = (data) => {
    return data.reduce((acc, current) => {
        const currentLetter = current[0];
        const currentNumber = current[1];

        if (!acc[currentNumber]) {
            acc[currentNumber] = {};
            acc[currentNumber][currentLetter] = 1;
        } else {
            if (acc[currentNumber][currentLetter]) {
                acc[currentNumber][currentLetter] += 1;
            } else {
                acc[currentNumber][currentLetter] = 1;
            }
        }

        return acc;
    }, {});
}






