#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

struct cel {
    char conteudo[20]; // 20 é o tamanho máximo da string de frutas
    struct cel *seg; // seguinte
};
typedef struct cel celula;

void insere(celula *lst, char *x) {
    celula *novo;
    novo = malloc(sizeof(celula));
    strcpy(novo->conteudo, x);
    novo->seg = lst->seg;
    lst->seg = novo;
    printf("Fruta empilhada: %s\n", x);
}

char *remove_celula(celula *lst) {
    celula *lixo;
    lixo = lst->seg;
    char *x = strdup(lixo->conteudo);
    lst->seg = lixo->seg;
    free(lixo);
    return x;
}

void print_pilha(celula *lista) {
    if (lista->seg == NULL) {
        printf("Pilha vazia.\n");
        return;
    }
    celula *atual = lista->seg;
    printf("Frutas na pilha: ");
    while (atual != NULL) {
        printf("%s ", atual->conteudo);
        atual = atual->seg;
    }
    printf("\n");
}

int certo(celula *lista, char *listaSting[], int tamanho) {
    for (int i = 0; i < tamanho; i++) {
        char *prox = listaSting[i];

        if (lista->seg == NULL) {
            insere(lista, prox);
        } else if (strcmp(prox, lista->seg->conteudo) == 0) { // Fruta igual à anterior
            char *removida = remove_celula(lista);
            printf("Fruta desempilhada: %s\n", removida);
            free(removida);
        } else {
            insere(lista, prox);
        }
        print_pilha(lista);
    }
    if (lista->seg == NULL) {
        return 1; // Pilha vazia, indica que todas as frutas foram desempilhadas
    } else {
        return 0; // Ainda há frutas na pilha
    }
}

int main() {
    celula *lista = malloc(sizeof(celula));
    lista->seg = NULL;

    char *listaSting[] = {"maça", "banana", "abacaxi", "abacaxi", "uva", "banana"};
    int tamanho = sizeof(listaSting) / sizeof(listaSting[0]);

    int valor = certo(lista, listaSting, tamanho);

    if (valor == 1) {
        printf("Todas as frutas foram desempilhadas!\n");
    } else {
        printf("Ainda há frutas na pilha!\n");
        print_pilha(lista);
    }

    return 0;
}
