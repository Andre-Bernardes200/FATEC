#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct cel {
    int valor;
    struct cel *esq;
    struct cel *dir;
};

typedef struct cel no;

void varreduraErd(no *arvore) {
    if (arvore != NULL) {
        varreduraErd(arvore->esq);
        printf("Valor: %d\n", arvore->valor);
        varreduraErd(arvore->dir);
    }
}

no *busca(no *arvore, int valor) {
    if (arvore == NULL || arvore->valor == valor) {
        return arvore;
    }
    if (valor < arvore->valor) {
        return busca(arvore->esq, valor);
    } else {
        return busca(arvore->dir, valor);
    }
}

no *insere(no *arvore, no *novo) {
    if (arvore == NULL) {
        return novo;
    }
    if (novo->valor < arvore->valor) {
        arvore->esq = insere(arvore->esq, novo);
    } else {
        arvore->dir = insere(arvore->dir, novo);
    }
    return arvore;
}

no *remove_no(no *arvore, int valor) {
    if (arvore == NULL) {
        return NULL;
    }

    if (valor < arvore->valor) {
        arvore->esq = remove_no(arvore->esq, valor);
    } else if (valor > arvore->valor) {
        arvore->dir = remove_no(arvore->dir, valor);
    } else {
        if (arvore->esq == NULL) {
            no *temp = arvore->dir;
            free(arvore);
            return temp;
        } else if (arvore->dir == NULL) {
            no *temp = arvore->esq;
            free(arvore);
            return temp;
        }

        no *pred = arvore->esq;
        while (pred->dir != NULL) {
            pred = pred->dir;
        }

        no *succ = arvore->dir;
        while (succ->esq != NULL) {
            succ = succ->esq;
        }

        if (abs(pred->valor - valor) < abs(succ->valor - valor)) {
            arvore->valor = pred->valor;
            arvore->esq = remove_no(arvore->esq, pred->valor);
        } else {
            arvore->valor = succ->valor;
            arvore->dir = remove_no(arvore->dir, succ->valor);
        }
    }

    return arvore;
}

int main() {
    no *arvore = NULL;
    no *novo;
    int i;

    srand(time(NULL));

    // Inserindo até 20 nós com valores aleatórios na árvore
    for (i = 0; i < 20; i++) {
        novo = (no *)malloc(sizeof(no));
        novo->valor = rand() % 100; // Valor aleatório entre 0 e 99
        novo->esq = novo->dir = NULL;
        arvore = insere(arvore, novo);
    }

    printf("Árvore após inserções aleatórias:\n");
    varreduraErd(arvore);

    // Buscando um nó com valor aleatório
    int valor_busca = rand() % 100;
    no *resultado_busca = busca(arvore, valor_busca);
    if (resultado_busca != NULL) {
        printf("Nó com valor %d encontrado.\n", valor_busca);
    } else {
        printf("Nó com valor %d não encontrado.\n", valor_busca);
    }

    // Removendo um nó com valor aleatório
    int valor_remove = rand() % 100;
    arvore = remove_no(arvore, valor_remove);

    printf("Árvore após remoção do valor %d:\n", valor_remove);
    varreduraErd(arvore);

    // Liberando memória restante
    while (arvore != NULL) {
        arvore = remove_no(arvore, arvore->valor);
    }

    return 0;
}
