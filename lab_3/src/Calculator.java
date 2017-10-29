import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
    class InToPost     // Преобразование инфиксной записи в постфиксную
    {
        private Stack postfixStack;
        private String input;
        private StringBuilder output;

        //--------------------------------------------------------------
        public InToPost(String in)   // Конструктор
        {
            input = in;
            postfixStack = new Stack();
            output = new StringBuilder();
        }

        public String doTrans()      // Преобразование в постфиксную форму
        {
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                switch (ch) {
                    case '+':
                    case '-':
                        gotOper(ch, 1);
                        break;
                    case '*':
                    case '/':
                        gotOper(ch, 2);
                        break;
                    case '(':
                        postfixStack.push(ch);
                        break;
                    case ')':
                        gotParen(ch);
                        break;
                    default:
                        output.append(ch);
                        break;
                }
            }
            while (!postfixStack.empty())     // Извлечение оставшихся операторов
            {

                output.append(postfixStack.pop()); // write to output
            }

            return output.toString();                   // Возвращение постфиксного выражения
        }

        public void gotOper(char opThis, int prec1) {
            while (!postfixStack.empty()) {
                char opTop = postfixStack.pop();
                if (opTop == '(') {
                    postfixStack.push(opTop);
                    break;
                }
// Чтение оператора из входной строки
// Если это '('
// Вернуть '('
// Оператор
                else {
                    int prec2;
                    if (opTop == '+' || opTop == '-') {
                        prec2 = 1;
                    } else
                        prec2 = 2;
                    if (prec2 < prec1) {
                        postfixStack.push(opTop);
                        break;
                    } else {
                        output += opTop;
                    }
                }
                postfixStack.push(opThis);
            }
        }

        public void gotParen(char ch) {
            while (!postfixStack.isEmpty()) {
                char chx = postfixStack.pop();
                if (chx == '(')
                    break;
                else
// Прочитана закрывающая скобка
// Если извлечен элемент ‘(‘
// Прервать выполнение
// Если извлечен оператор
                    output = output + chx;  // Вывести в постфиксную строку
            }
        }
    }
}
