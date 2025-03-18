#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#pragma warning(disable:4996)

typedef struct stack {
    int top, size, sign;
    char str[101];
}stack;

void push(stack* stk, char st);
char pop(stack* stk);
int operand(stack* stk, char ch[], int i);

int main() {
    stack* t = (stack*)malloc(sizeof(stack));
    int N, len, num = 0;
    char* p, ch[101], put[101];


    scanf("%s", &ch);
    getchar();
    p = ch;
        num = 0;
        len = strlen(ch);
        t->size = 101;
        t->top = -1;
        t->sign = 0;
        for (int j = 0; j < len + 1; j++)
            put[j] = '\0';
        for (int j = 0; j < len; j++) {
            if (ch[j] == '(')
                push(t, ch[j]);
            else if (ch[j] == ')') {
                while (t->str[t->top] != '(') {
                    put[num++] = pop(t);
                }
                pop(t);
            }
            else if (operand(t, ch, j) == 6)
                push(t, ch[j]);
            else if (operand(t, ch, j) == 0)
                put[num++] = ch[j];
            else {
                if (t->sign == 1)
                    put[num++] = pop(t);
                else {
                    while ((t->top != -1) && (operand(t, ch, j) <= operand(t, t->str, t->top))) {
                        put[num++] = pop(t);
                    }
                }
                if (operand(t, ch, j) == 1 || operand(t, ch, j) == 2)
                    push(t, ch[j++]);
                push(t, ch[j]);
            }
        }
        while (t->top != -1)
            put[num++] = pop(t);

        printf("%s\n", put);
 

    return 0;
}

void push(stack* stk, char st) {
    if (stk->top >= stk->size) {
        printf("Stack FULL");
        return;
    }

    stk->top++;
    stk->str[(stk->top)] = st;
}

char pop(stack* stk) {

    stk->top -= 1;
    return stk->str[stk->top + 1];
}

int operand(stack* stk, char ch[101], int i) {
    if ((stk->top != i) && (i == 0) && ((ch[i] == '+') || (ch[i] == '-'))) {
        stk->sign = 1;
        return 6;
    }
    else if ((stk->top != -1) && ((ch[i] == '+') || (ch[i] == '-')) && (((ch[i - 1] == '|')) || (ch[i - 1] == '&') || (ch[i - 1] == '<') || (ch[i - 1] == '>') || (ch[i - 1] == '-') || (ch[i - 1] == '+') || (ch[i - 1] == '*') || (ch[i - 1] == '/')))
        return 6;
    else if (ch[i] == '|')
        return 1;
    else if (ch[i] == '&')
        return 2;
    else if (ch[i] == '>' || ch[i] == '<')
        return 3;
    else if (ch[i] == '+' || ch[i] == '-')
        return 4;
    else if (ch[i] == '*' || ch[i] == '/')
        return 5;
    else if (ch[i] == '!')
        return 6;
    else
        return 0;
}