#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct cel {
    int valor;
    struct cel *esq;
    struct cel *dir;
};

typedef struct cel no;

void varreduraErd(no* arvore) {
    if (arvore != NULL) {
        varreduraErd(arvore->esq);
        printf("%d\n", arvore->valor);
        varreduraErd(arvore->dir);
    }
}

no* insere(no* arvore, int valor) {
    if (arvore == NULL) {
        no* novo = (no*)malloc(sizeof(no));
        novo->valor = valor;
        novo->esq = novo->dir = NULL;
        return novo;
    }
    if (valor < arvore->valor) {
        arvore->esq = insere(arvore->esq, valor);
    } else if (valor > arvore->valor) {
        arvore->dir = insere(arvore->dir, valor);
    }
    return arvore;
}

no* encontraMaior(no* arvore) {
    while (arvore->dir != NULL) {
        arvore = arvore->dir;
    }
    return arvore;
}

no* remove_no(no* arvore, int valor) {
    if (arvore == NULL) {
        return NULL;
    }
    if (valor < arvore->valor) {
        arvore->esq = remove_no(arvore->esq, valor);
    } else if (valor > arvore->valor) {
        arvore->dir = remove_no(arvore->dir, valor);
    } else {
        if (arvore->esq == NULL) {
            no* temp = arvore->dir;
            free(arvore);
            return temp;
        } else if (arvore->dir == NULL) {
            no* temp = arvore->esq;
            free(arvore);
            return temp;
        }
        no* maior = encontraMaior(arvore->esq);
        arvore->valor = maior->valor;
        arvore->esq = remove_no(arvore->esq, maior->valor);
    }
    return arvore;
}

int main() {
    no* arvore = NULL;
    int i, valorParaRemover;

    // Inserindo até 20 nós com valores aleatórios na árvore
    for (i = 0; i < 20; i++) {
        int valor = rand() % 100; // Valor aleatório entre 0 e 99
        arvore = insere(arvore, valor);
    }

    printf("Árvore após inserções aleatórias:\n");
    varreduraErd(arvore);

    // Removendo um nó aleatório
    printf("Digite um valor para remover: ");
    scanf("%d", &valorParaRemover);
    arvore = remove_no(arvore, valorParaRemover);

    varreduraErd(arvore);

    return 0;
}
