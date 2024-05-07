#include <stdio.h>
#include <stdlib.h>

struct cel {
    int conteudo;
    struct cel *seg; // seguinte
};
typedef struct cel celula;

void insere(celula **lst, int x) {
    celula *novo = malloc(sizeof(celula));
    novo->conteudo = x;
    novo->seg = NULL;
    if (*lst == NULL) {
        *lst = novo;
    } else {
        novo->seg = *lst;
        *lst = novo;
    }
}

int remove_celula (celula **lst){
        celula *lixo;
        lixo = *lst;
        int x = lixo->conteudo;
        *lst = lixo->seg;
        free(lixo);
		return x;
}

celula* buscar(celula *lst,int x){
		while(lst != NULL) {
			celula *prox_celula = lst->seg;
			if(prox_celula->conteudo == x){
				return lst;
			}
			lst = lst->seg;
		}
		return NULL; 
}

void main() {
    celula *lista;
    lista = NULL;

    for (int i = 0; i < 10; i++) {
        insere(&lista, i);
    }

    int x = remove_celula(&lista);
    printf("%d",x);
}
