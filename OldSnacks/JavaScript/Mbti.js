const prompt = require('prompt-sync')({ sigint: true });

function addExtrovertedVsIntrovertedQuestions() {
    return [
        "A. expend energy, enjoy groups", "B. conserve energy, enjoy one-on-one",
        "A. more outgoing, think out loud", "B. more reserved, think to yourself",
        "A. seek many tasks, public activities, interaction with others",
        "B. seek private, solitary activities with quiet to concentrate",
        "A. external, communicative, express yourself", "B. internal, reticent, keep to yourself",
        "A. active, initiate", "B. reflective, deliberate"
    ];
}

function addSensingVsIntuitive() {
    return [
        "A. Interpret, literally", "B. Look for meaning and possibilities",
        "A. practical, realistic, experimental", "B. imaginative, innovative, theoretical",
        "A. standard, usual, conventional", "B. different, novel, unique",
        "A. focus on here and now", "B. look to the future, global perspective, big picture",
        "A. facts, things, what is", "B. ideas, dreams, what could be, philosophical"
    ];
}

function addThinkingVsFeeling() {
    return [
        "A. Logical, thinking, questioning", "B. empathetic, feeling, accommodating",
        "A. candid, straightforward, frank", "B. tactful, kind, encouraging",
        "A. firm, tend to criticize, hold the line", "B. gentle, tend to appreciate, conciliate",
        "A. tough-minded, just", "B. tender-hearted, merciful",
        "A. matter of fact, issue-oriented", "B. sensitive, people-oriented, compassionate"
    ];
}

function addJudgingVsPerceptive() {
    return [
        "A. organized, orderly", "B. flexible, adaptable",
        "A. plan, schedule", "B. unplanned, spontaneous",
        "A. regulated, structured", "B. easy-going, live and let live",
        "A. preparation, plan ahead", "B. go with the flow, adapt as you go",
        "A. control, govern", "B. latitude, freedom"
    ];
}

function getQuestions() {
    return [
        addExtrovertedVsIntrovertedQuestions(),
        addSensingVsIntuitive(),
        addThinkingVsFeeling(),
        addJudgingVsPerceptive()
    ];
}

function printQuestions1() {
    const allQuestions = getQuestions();
    const answers = [];

    for (let i = 0; i < allQuestions.length; i++) {
        answers.push([]);
    }

    let max = 0;
    for (let i = 0; i < allQuestions.length; i++) {
        if (allQuestions[i].length > max) {
            max = allQuestions[i].length;
        }
    }

    for (let round = 0; round < max; round += 2) {
        for (let count = 0; count < allQuestions.length; count++) {
            const currentList = allQuestions[count];
            if (round + 1 < currentList.length) {
                console.log(currentList[round]);
                console.log(currentList[round + 1]);
                const answer = prompt("Your answer: ").toLowerCase();
                answers[count].push(answer);
            }
        }
    }

    return answers;
}

function printOutcome(name, answerGroup) {
    const allQuestions = getQuestions();
    console.log(`\nHello ${name}, you selected:\n`);

    for (let i = 0; i < allQuestions.length; i++) {
        const questionGroup = allQuestions[i];
        const sublist = answerGroup[i];

        for (let j = 0; j < sublist.length; j++) {
            console.log("Q:", questionGroup[j * 2]);
            console.log(questionGroup[j * 2 + 1]);
            console.log("A:", sublist[j]);
        }
        console.log();
    }
}

const name = prompt("Enter your name: ");
const answers = printQuestions1();
printOutcome(name, answers);
