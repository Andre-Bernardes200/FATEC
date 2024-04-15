#include <stdio.h>
#include <stdlib.h>
	
	struct cel {
	    int conteudo;
	    struct cel *seg; // seguinte
	};
    typedef struct cel celula;

	void insere(celula *lst, int x) {
	    celula *novo;
	    novo = malloc(sizeof(celula));
	    novo->conteudo = x;
	    novo->seg = lst->seg;
	    lst->seg = novo;
	}

	int remove_celula (celula *lst){
		celula *lixo;
		lixo = lst->seg;
		int x = lixo->conteudo;
		lst->seg = lixo->seg;
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
	    celula *lista = malloc(sizeof(celula));
	    lista->seg = NULL;
	
	    for (int i = 0; i < 10; i++) {
	        insere(lista, i);
	    }

		int x = remove_celula(buscar(lista,2));
		printf("%d",x);
}