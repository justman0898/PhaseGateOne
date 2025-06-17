def add_extroverted_vs_introverted_questions():
    return [
        "A. expend energy, enjoy groups", "B. conserve energy, enjoy one-on-one",
        "A. more outgoing, think out loud", "B. more reserved, think to yourself",
        "A. seek many tasks, public activities, interaction with others",
        "B. seek private, solitary activities with quiet to concentrate",
        "A. external, communicative, express yourself", "B. internal, reticent, keep to yourself",
        "A. active, initiate", "B. reflective, deliberate"
    ]

def add_sensing_vs_intuitive():
    return [
        "A. Interpret, literally", "B. Look for meaning and possibilities",
        "A. practical, realistic, experimental", "B. imaginative, innovative, theoretical",
        "A. standard, usual, conventional", "B. different, novel, unique",
        "A. focus on here and now", "B. look to the future, global perspective, big picture",
        "A. facts, things, what is", "B. ideas, dreams, what could be, philosophical"
    ]

def add_thinking_vs_feeling():
    return [
        "A. Logical, thinking, questioning", "B. empathetic, feeling, accommodating",
        "A. candid, straightforward, frank", "B. tactful, kind, encouraging",
        "A. firm, tend to criticize, hold the line", "B. gentle, tend to appreciate, conciliate",
        "A. tough-minded, just", "B. tender-hearted, merciful",
        "A. matter of fact, issue-oriented", "B. sensitive, people-oriented, compassionate"
    ]

def add_judging_vs_perceptive():
    return [
        "A. organized, orderly", "B. flexible, adaptable",
        "A. plan, schedule", "B. unplanned, spontaneous",
        "A. regulated, structured", "B. easy-going, live and let live",
        "A. preparation, plan ahead", "B. go with the flow, adapt as you go",
        "A. control, govern", "B. latitude, freedom"
    ]

def get_questions():
    introvert_vs_extroverts = add_extroverted_vs_introverted_questions()
    sensing_vs_intuitive = add_sensing_vs_intuitive()
    thinking_vs_feeling = add_thinking_vs_feeling()
    judging_vs_perceptive = add_judging_vs_perceptive()
    return [
        introvert_vs_extroverts,
        sensing_vs_intuitive,
        thinking_vs_feeling,
        judging_vs_perceptive
    ]

def print_questions_1():
    all_questions = get_questions()
    answers = []
    for i in range(len(all_questions)):
        answers.append([])

    max_len = 0
    for question_group in all_questions:
        if len(question_group) > max_len:
            max_len = len(question_group)

    for round in range(0, max_len, 2):
        for count in range(len(all_questions)):
            current_list = all_questions[count]
            try:
                print(current_list[round])
                print(current_list[round + 1])
                answer = input("Your answer: ").lower()
                answers[count].append(answer)
            except IndexError:
                pass
    return answers

def print_outcome(name, answer_group):
    print("Hello " + name + ", you selected:")
    all_questions = get_questions()

    for i in range(len(all_questions)):
        question_group = all_questions[i]
        sublist = answer_group[i]

        for j in range(len(sublist)):
            print("Q:", question_group[j * 2])
            print(question_group[j * 2 + 1])
            print("A:", sublist[j])
        print()

name = input("Enter your name: ")
answers = print_questions_1()
print_outcome(name, answers)
