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

no* remove_no(no* remover) {
    if (remover == NULL) {
        return NULL;
    }

    if(remover->esq == NULL){
        return remover->dir;
    }

    no* noMaior;
    noMaior = remover->esq;

    no* noAnt;

    while (noMaior != NULL)
    {
        noAnt = noMaior;
        noMaior = noMaior->dir;
    }
    
    if(noAnt != NULL){
        noAnt->dir = noMaior->esq;
        noMaior->esq = remover->esq;
    }

    noMaior->dir = remover->dir;

    return noMaior;
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

    arvore = remove_no(remover);
    printf("valor removido da árvore\n");

    return 0;
}
