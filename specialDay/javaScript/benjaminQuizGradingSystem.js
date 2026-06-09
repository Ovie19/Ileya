
const prompt = require("prompt-sync")();

let numberOfStudents = Number(prompt("Enter number of students: "));

let numberOfQuizTaken = Number(prompt("Enter number of quizzes: "));

let studentQuiz = [];

let count = 0;

while (count < numberOfStudents) {
    console.log(`\nStudent ${count + 1}`);

    studentScores = [];

    for (let index = 0; index < numberOfQuizTaken; index++) {
        let score;

        do {
            score = Number(prompt(`Score for Quiz ${index + 1}: `));

            if (score < 0 || score > 100) {
                console.log("Invalid score!!!");
                score = Number(prompt(`Score for Quiz ${index + 1}: `));
            }
        } while (score < 0 || score > 100);

        studentScores.push(score);
    }

    studentQuiz.push(studentScores);

    count++;
}

console.log("\n\n======= QUIZ GRADE REPORT =======");
for (let index = 0; index < numberOfStudents; index++) {
    process.stdout.write(`Student ${index + 1}`);

    let scoreTotal = 0;

    for (let scoreIndex = 0; scoreIndex < numberOfQuizTaken; scoreIndex++) {
        process.stdout.write(`  ${studentQuiz[index][scoreIndex]}`);

        scoreTotal += studentQuiz[index][scoreIndex];
    }

    let averageScore = scoreTotal / numberOfQuizTaken;
    console.log(`   ${averageScore}`);
}

let bestQuizIndex = 0;
let bestQuiz = 0;

process.stdout.write("\nQuiz averages: ");
for (let scoreIndex = 0; scoreIndex < numberOfQuizTaken; scoreIndex++) {
    let total = 0;

    for (let index = 0; index < numberOfStudents; index++) {
        total += studentQuiz[index][scoreIndex];
    }

    let averageScore = total / numberOfQuizTaken;
    process.stdout.write(`QZ${scoreIndex + 1}: ${averageScore}  `);

    bestQuizIndex = averageScore > bestQuiz ? scoreIndex : bestQuizIndex;
    bestQuiz = averageScore > bestQuiz ? averageScore : bestQuiz;
}

console.log(`\nBest quiz: Quiz ${bestQuizIndex + 1} (avg ${bestQuiz})`);