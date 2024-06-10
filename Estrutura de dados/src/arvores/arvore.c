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

no* remove_no(no* arvore, no* remover) {
    if (arvore == NULL) {
        return NULL;
    }

    if (arvore == remover) {
        if (arvore->esq == NULL) {
            return arvore->dir;
        }

        no* maiorEsquerda = arvore->esq;
        no* paiMaiorEsquerda = NULL;

        while (maiorEsquerda->dir != NULL) {
            paiMaiorEsquerda = maiorEsquerda;
            maiorEsquerda = maiorEsquerda->dir;
        }

        if (paiMaiorEsquerda != NULL) {
            paiMaiorEsquerda->dir = maiorEsquerda->esq;
            maiorEsquerda->esq = arvore->esq;
        }

        maiorEsquerda->dir = arvore->dir;
        return maiorEsquerda;
    }

    arvore->esq = remove_no(arvore->esq, remover);
    arvore->dir = remove_no(arvore->dir, remover);

    return arvore;
}

no* encontrar_no(no* arvore, int valor) {
    if (arvore == NULL || arvore->valor == valor) {
        return arvore;
    }

    if (valor < arvore->valor) {
        return encontrar_no(arvore->esq, valor);
    } else {
        return encontrar_no(arvore->dir, valor);
    }
}

int main() {
    no* arvore = NULL;
    int i, valorParaRemover;
    srand(time(NULL));

    // Inserindo até 20 nós com valores aleatórios na árvore
    for (i = 0; i < 20; i++) {
        int valor = rand() % 100; // Valor aleatório entre 0 e 99
        arvore = insere(arvore, valor);
    }

    printf("Árvore após inserções aleatórias:\n");
    varreduraErd(arvore);

    // Removendo um nó especificado pelo usuário
    printf("Digite um valor para remover: ");
    scanf("%d", &valorParaRemover);
    no* remover = encontrar_no(arvore, valorParaRemover);

    if (remover != NULL) {
        arvore = remove_no(arvore, remover);
        printf("Árvore após remoção:\n");
        varreduraErd(arvore);
    } else {
        printf("Valor não encontrado na árvore.\n");
    }

    return 0;
}
