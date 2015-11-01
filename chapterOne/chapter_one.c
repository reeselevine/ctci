#include <stdio.h>
#include <stdlib.h>
#include <string.h>

static int one(char *str) {
    if (str == NULL) return 1;
    for (int i = 0; i < strlen(str); i++) {
        char cur = str[i];
        for (int j = i + 1; j < strlen(str); j++) {
            if (cur == str[j]) {
                return 0;
            }
        }
    }
    return 1;
}

static void two(char *str) {
    if (str == NULL) return;
    for (int i = 0; i < strlen(str) / 2; i++) {
        char temp = str[i];
        str[i] = str[strlen(str) - i - 1];
        str[strlen(str) - i - 1] = temp;
    }
}

int main(int argc, char **argv) {
    if (argc == 0) {
        printf("Usage:\n");
        printf("  chapter_one -q<number> <args>\n");
        exit(0);
    }

    if (strcmp(argv[1], "-q1") == 0) {
        int unique = one(argv[2]);
        unique ? printf("true\n") : printf("false\n");
        exit(0);
    } else if (strcmp(argv[1], "-q2") == 0) {
        two(argv[2]);
        printf("%s\n", argv[2]);
        exit(0);
    }
}
