#include <stdio.h>
#include <stdlib.h>
#include <string.h>

static int is_unique(char *str) {
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

static void reverse(char *str) {
    if (str == NULL) return;
    for (int i = 0; i < strlen(str) / 2; i++) {
        char temp = str[i];
        str[i] = str[strlen(str) - i - 1];
        str[strlen(str) - i - 1] = temp;
    }
}

static void remove_duplicates(char *str) {
    if (str == NULL) return;
    char *cur = str;
    for (cur = str; *cur != '\0'; cur++) {
        char *next = cur + 1;
        for ( ; *next != '\0'; next++) {
            if (*cur == *next) {
                char *src = next + 1;
                char *dst = next;
                while (*src != '\0') {
                    *dst = *src;
                    src++; dst++;
                }
                *dst = '\0';
                next--;
            }
        }
    }
}

static int anagram(char *first, char *second) {
    if (first == NULL || second == NULL) return 0;
    while (*first != '\0') {
        if (*second == '\0') return 0;
        int found = 0;
        for (char *finder = second; *finder != '\0'; finder++) {
            if (*finder == *first) {
                char temp = *finder;
                *finder = *second;
                *second = temp;
                found = 1;
            }
        }
        if (!found) return 0;
        first++;
        second++;
    }
    if (*second != '\0') return 0;
    return 1;
}

static char* replace_spaces(char *str) {
    if (str == NULL) return str;
    char *replaced = malloc(strlen(str) * 3);
    char *orig = replaced;
    while (*str != '\0') {
        if (*str == ' ') {
            *replaced = '%';
            replaced ++;
            *replaced = '2';
            replaced++;
            *replaced = '0';
        } else {
            *replaced = *str;
        }
        replaced++;
        str++;
    }
    return orig;
}

int main(int argc, char **argv) {
    if (argc == 0) {
        printf("Usage:\n");
        printf("  chapter_one -q<number> <args>\n");
        exit(0);
    }

    if (strcmp(argv[1], "-q1") == 0) {
        is_unique(argv[2]) ? printf("true\n") : printf("false\n");
        exit(0);
    } else if (strcmp(argv[1], "-q2") == 0) {
        reverse(argv[2]);
        printf("%s\n", argv[2]);
        exit(0);
    } else if (strcmp(argv[1], "-q3") == 0) {
        remove_duplicates(argv[2]);
        printf("%s\n", argv[2]);
        exit(0);
    } else if (strcmp(argv[1], "-q4") == 0) {
        anagram(argv[2], argv[3]) ? printf("true\n") : printf("false\n");
    } else if (strcmp(argv[1], "-q5") == 0) {
        printf("%s\n", replace_spaces(argv[2]));
        exit(0);
    }
}
