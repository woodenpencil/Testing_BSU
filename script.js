let test_size = 15;
let curr_test_index = 0;
let test_blocks = new Array(test_size);

let correct_answers = ["Да",
             "Нет",
             "Налить жидкость внутрь, пить",
             "Да",
             "Один раз",
             "Да",
             "Нет",
             "Да",
             "Специальная бумага",
             "Нет",
             "Да",
             "Нет",
             "Да",
             "Может",
             "3 мм",
]

let questions = [["Удобно ли держать в руке?","Да", "Нет"],
                 ["Жидкость будет обжигать руки?","Да","Нет"],
                 ["Как пользоваться?","Налить жидкость внутрь, пить","Использовать как строительный материал"],
                 ["Ветром сдует пустой стаканчик?","Да","Нет"],
                 ["Сколько раз можно повторно использовать?","Один раз","Несколько раз"],
                 ["Выдержит ли 100 градусов по цельсию","Да","Нет"],
                 ["Может ли материал химически реагировать с жидкостью?","Да","Нет"],
                 ["Годен ли после 3 часов использования","Да","Нет"],
                 ["Матеиал изготовления","Специальная бумага","Керамика"],
                 ["Можно ли порезаться стаканчиком?","Да","Нет"],
                 ["Удобно ли пить из него?","Да","Нет"],
                 ["Обязательно ли должны быть экологичные материалы?","Да","Нет"],
                 ["Можно ли ипользовать для распития чая","Да","Нет"],
                 ["Может ли деформироваться?","Может","Не может"],
                 ["Толщина стенки","3 мм","3 м"]
]

function shuffle() {
    for (let i = test_size - 1; i > 0; i--) {
        let j = Math.floor(Math.random() * (i + 1));
        [correct_answers[i], correct_answers[j]] = [correct_answers[j], correct_answers[i]];
        [questions[i], questions[j]] = [questions[j], questions[i]];
    }
}

function test_init() {
    shuffle();
    for (let i = 0; i < test_size; i++) {
        test_blocks[i] = document.createElement("div");
        test_blocks[i].className = "test-block";

        if (i === 0) {
            test_blocks[i].setAttribute("style", "display: block;");
        }

        let submit_button = (i === test_size - 1) ?
            '<input class="submit-button" type="submit" value="Завершить тест" onclick="check()">' :
            '<input class="submit-button" type="submit" value="Следующий вопрос" onclick="next_test()">';

        test_blocks[i].innerHTML =
            '<h3 class="test-caption">Вопрос '+(i+1)+'</h3>\n' +
            '    <div class="test-content">\n' +
            '        <p class="question">'+ questions[i][0] +'</p>\n' +
            '        <form action="" class="answer-options">\n' +
            '            <input id="q' + i + '-o1" type="radio" name="question' + i + '" value="' + questions[i][1] + '" checked>\n' +
            '            <label for="q' + i + '-o1">' + questions[i][1] + '</label>\n' +
            '            <input id="q' + i + '-o2" type="radio" name="question' + i + '" value="' + questions[i][2] + '">\n' +
            '            <label for="q' + i + '-o2">' + questions[i][2] + '</label>\n' +
            '        </form>\n' +
            '    </div>\n' +
                submit_button;

        document.body.appendChild(test_blocks[i]);
    }
}

function show_test_result(percent) {
    let progress_bar = document.getElementById('correct-answers-percent');
    progress_bar.setAttribute('value', percent);
    let test_success_percent = document.getElementById('test-success-percent');
    test_success_percent.innerHTML = 'Задания выполнены на ' + percent + '%.';
    test_blocks[test_size - 1].setAttribute("style", "display: none;");
    document.getElementById('test-result').setAttribute("style", "display: block;");
}

function next_test() {
    test_blocks[curr_test_index].setAttribute("style", "display: none;");
    test_blocks[++curr_test_index].setAttribute("style", "display: block;");
}

function is_correct(test_index, value) {
    return correct_answers[test_index] === value;
}

function push_test_result(test_index, value, correct) {
    let table_test_result = document.getElementById('table-test-result');
    let row = document.createElement('tr');
    let background = correct ? "#c3e6cb" : "#f5c6cb";
    row.setAttribute('style', 'background-color: ' + background);
    let answer = correct ? 'Вы ответили правильно' : 'Вы ответили неверно. Ваш ответ: ' + value;
    row.innerHTML = '<td>' + (test_index + 1) + '</td>' +
                    '<td>' + questions[test_index][0] + '</td>' +
                    '<td>' + answer + '</td>';
    table_test_result.appendChild(row);
}

function check() {
    let correct_answers_count = 0;

    for (let i = 0; i < test_size; ++i) {
        let radios = document.getElementsByName('question' + i);
        for (let j = 0; j < radios.length; ++j) {
            if (radios[j].checked) {
                let correct = is_correct(i, radios[j].value);
                if (correct) {
                    ++correct_answers_count;
                }
                push_test_result(i, radios[j].value, correct);
                break;
            }
        }
    }

    let percent = Math.round(correct_answers_count / test_size * 100);
    show_test_result(percent);
    document.getElementById('test-success-percent').innerHTML = "Задания выполнены верно на " + percent + "%.";
}

test_init();